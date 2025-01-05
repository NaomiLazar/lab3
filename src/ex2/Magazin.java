package ex2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Magazin {
    private List<Produs> produse = new ArrayList<>();

    // Metoda pentru citirea datelor din fisier
    public void citesteProduseDinFisier(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] campuri = linie.split(",");
                String denumire = campuri[0].trim();
                double pret = Double.parseDouble(campuri[1].trim());
                int cantitate = Integer.parseInt(campuri[2].trim());
                LocalDate dataExpirarii = LocalDate.parse(campuri[3].trim());

                Produs produs = new Produs(denumire, pret, cantitate, dataExpirarii);
                produse.add(produs);
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        }
    }

    // a) Afișarea tuturor produselor
    public void afiseazaToateProdusele() {
        if (produse.isEmpty()) {
            System.out.println("Nu există produse în listă.");
        } else {
            for (Produs produs : produse) {
                System.out.println(produs);
            }
        }
    }

    // b) Afișarea produselor expirate
    public void afiseazaProduseExpirate() {
        boolean existaProduseExpirate = false;
        for (Produs produs : produse) {
            if (produs.esteExpirat()) {
                System.out.println(produs);
                existaProduseExpirate = true;
            }
        }
        if (!existaProduseExpirate) {
            System.out.println("Nu există produse expirate.");
        }
    }


    // c) Vânzarea unui produs
    public void vindeProdus(String denumire, int cantitateVanduta) {
        Optional<Produs> produsGasit = produse.stream()
                .filter(produs -> produs.getDenumire().equalsIgnoreCase(denumire))
                .findFirst();

        if (produsGasit.isPresent()) {
            Produs produs = produsGasit.get();
            if (produs.getCantitate() >= cantitateVanduta) {
                // Calculăm încasarea pentru această vânzare și actualizăm încasările totale
                double incasare = produs.getPret() * cantitateVanduta;
                Produs.adaugaIncasari(incasare);

                // Reducem cantitatea și verificăm dacă produsul trebuie eliminat
                produs.setCantitate(produs.getCantitate() - cantitateVanduta);
                if (produs.getCantitate() == 0) {
                    produse.remove(produs);
                    System.out.println("Produsul " + denumire + " a fost vândut complet și eliminat din listă.");
                } else {
                    System.out.println("Produsul " + denumire + " a fost vândut. Cantitate rămasă: " + produs.getCantitate());
                }
            } else {
                System.out.println("Cantitate insuficientă pe stoc pentru " + denumire + ".");
            }
        } else {
            System.out.println("Produsul " + denumire + " nu există în stoc.");
        }
    }

    // d) Afișarea produselor cu prețul minim
    public void afiseazaProduseCuPretMinim() {
        if (produse.isEmpty()) {
            System.out.println("Nu există produse în listă.");
            return;
        }

        // Găsim prețul minim
        double pretMinim = produse.stream()
                .mapToDouble(Produs::getPret)
                .min()
                .orElse(Double.MAX_VALUE);

        // Afișăm produsele care au acest preț minim
        produse.stream()
                .filter(produs -> produs.getPret() == pretMinim)
                .forEach(System.out::println);
    }
}

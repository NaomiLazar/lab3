package ex2;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Magazin magazin = new Magazin();
        magazin.citesteProduseDinFisier("src/produse.csv");

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișează toate produsele");
            System.out.println("2. Afișează produsele expirate");
            System.out.println("3. Vinde un produs");
            System.out.println("4. Afișează produsele cu prețul minim");
            System.out.println("5. Afișează total încasări");
            System.out.println("0. Ieșire");
            System.out.print("Alege o opțiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine(); // consumă linia de după int

            switch (optiune) {
                case 1:
                    magazin.afiseazaToateProdusele();
                    break;
                case 2:
                    magazin.afiseazaProduseExpirate();
                    break;
                case 3:
                    System.out.print("Introdu denumirea produsului: ");
                    String denumire = scanner.nextLine();
                    System.out.print("Introdu cantitatea de vândut: ");
                    int cantitate = scanner.nextInt();
                    magazin.vindeProdus(denumire, cantitate);
                    break;
                case 4:
                    magazin.afiseazaProduseCuPretMinim();
                    break;
                case 5:
                    System.out.println("Total încasări: " + Produs.getIncasari());
                    break;
                case 0:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Opțiune invalidă. Încercați din nou.");
            }
        } while (optiune != 0);

        scanner.close();
    }
}

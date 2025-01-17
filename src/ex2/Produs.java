package ex2;
import java.time.LocalDate;

public class Produs {
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirarii;

    // Variabilă statică pentru încasări
    private static double incasari = 0.0;


    // Constructor
    public Produs(String denumire, double pret, int cantitate, LocalDate dataExpirarii) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirarii = dataExpirarii;
    }

    // Gettere
    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDataExpirarii() {
        return dataExpirarii;
    }


    // Metodă pentru verificarea dacă produsul este expirat
    public boolean esteExpirat() {
        return dataExpirarii.isBefore(LocalDate.now());
    }
    // Metoda pentru a adăuga la încasări
    public static void adaugaIncasari(double suma) {
        incasari += suma;
    }

    // Getter pentru incasari
    public static double getIncasari() {
        return incasari;
    }

    // Suprascrierea metodei toString()
    @Override
    public String toString() {
        return "Produs{" +
                "denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", cantitate=" + cantitate +
                ", dataExpirarii=" + dataExpirarii +
                '}';
        }

}

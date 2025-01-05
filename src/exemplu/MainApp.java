package exemplu;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Punct> puncte=new ArrayList<Punct>();
        puncte.add(new Punct(1,2));
        puncte.add(new Punct(3,4));
        puncte.add(new Punct(5,6));

        System.out.println("Lista contine punctele:");
        for(Punct p:puncte) {
            System.out.println(p);
        }

        puncte.remove(0);

        System.out.println("Dupa stergerea primului element "
                +"lista contine punctele:");
        for (int i=0;i<puncte.size();i++)
            System.out.println(puncte.get(i));
    }
}

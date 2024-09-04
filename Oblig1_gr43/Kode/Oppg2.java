import java.util.List;
import java.util.Arrays;
import java.util.function.*;



public class Oppg2 {
   public static void main(String[] args) {

    List<Ansatt> ansatte = Arrays.asList(
        new Ansatt("Rolf","Danielsen", Kjonn.MANN, "Sjef", 1000000),
        new Ansatt("Maria","Hansen", Kjonn.KVINNE, "Kokk", 500000),
        new Ansatt("Kåre","Kåresen", Kjonn.MANN, "Selger", 600000),
        new Ansatt("Mina","Jansen", Kjonn.KVINNE, "Utvikler", 700000),
        new Ansatt("Sven","Larsen", Kjonn.MANN, "UX-designer", 650000));

        System.out.println("Ansatte før lønnsberegning: ");
        skrivUtAlle(ansatte);

        System.out.println();
        // i
        lonnsoppgjor(ansatte, a -> a.getAarslonn() + 20000);
        System.out.println("Ansatte etter fast kronetilegg: ");
        skrivUtAlle(ansatte);

        System.out.println();
        //ii 
        lonnsoppgjor(ansatte, a -> (int) (a.getAarslonn() * 1.08));
        System.out.println("Ansatte etter fast prosenttillegg: ");
        skrivUtAlle(ansatte);

        System.out.println();
        //iii
        lonnsoppgjor(ansatte, a -> a.getAarslonn() < 680000 ? 10000 + a.getAarslonn() : a.getAarslonn());
        System.out.println("Ansatte etter lavtlønnet tillegg: ");
        skrivUtAlle(ansatte);

        System.out.println();
        //iiii
        lonnsoppgjor(ansatte, a -> a.getKjonn().equals(Kjonn.MANN) ? (int) (a.getAarslonn() * 1.20) : a.getAarslonn());
        System.out.println("Ansatt etter tillegg som mann: ");
        skrivUtAlle(ansatte);

        System.out.println();
        System.out.println("Ansatte etter samlet lønnsberegning: ");
        skrivUtAlle(ansatte);

   }  
   private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt,Integer> function) {
    ansatte.forEach(a -> a.setAarslonn(function.apply(a)));
   }

private static void skrivUtAlle(List<Ansatt> ansatte) {
    ansatte.forEach(System.out::println);
}

}

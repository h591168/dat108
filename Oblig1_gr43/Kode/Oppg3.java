import java.util.List;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Oppg3 {

    public static void main(String[] args) {

        List<Ansatt> ansatte = Arrays.asList(
            new Ansatt("Rolf","Danielsen", Kjonn.MANN, "Sjef", 1000000),
            new Ansatt("Maria","Hansen", Kjonn.KVINNE, "Kokk", 500000),
            new Ansatt("Kåre","Kåresen", Kjonn.MANN, "Selger", 600000),
            new Ansatt("Mina","Jansen", Kjonn.KVINNE, "Utvikler", 700000),
            new Ansatt("Sven","Larsen", Kjonn.MANN, "UX-designer", 650000));

        //a
        List<String> etternavn = ansatte.stream()
                                .map(Ansatt::getEtternavn)
                                .collect(Collectors.toList());  
            etternavn.forEach(System.out::println);
            System.out.println();

        //b
            int antallKvinner = (int) ansatte.stream()
                                .filter( a -> a.getKjonn().equals(Kjonn.KVINNE)).count();
            System.out.println("Antall kvinner: " + antallKvinner);
            System.out.println();


        //c

        OptionalDouble gjsnittKvinner = ansatte.stream()
                                        .filter(a -> a.getKjonn().equals(Kjonn.KVINNE))
                                        .mapToInt(Ansatt::getAarslonn).average();

        if (gjsnittKvinner.isPresent()) {
            System.out.println("Gjennomsnittslønn for kvinner: " + gjsnittKvinner.getAsDouble());
        } else {
            System.out.println("Ingen kvinner funnet.");
        }
        System.out.println();


        //d 
        System.out.println("Lønn før lønnsøkning for sjefen: ");
        skrivUtAnstatte(ansatte);
        System.out.println();

        ansatte.stream().filter(a -> a.getStilling().equals("Sjef"))
                .forEach(a -> a.setAarslonn((int) (a.getAarslonn() * 1.07)));
        skrivUtAnstatte(ansatte);
        System.out.println();

        //e
            boolean tjenerMerEnn800000 = ansatte.stream()
                                            .anyMatch(a -> a.getAarslonn() > 800000);
            System.out.println("Tjener mer enn 800000: " + tjenerMerEnn800000);
            System.out.println();

        //f
            ansatte.stream().forEach(System.out::println);
            System.out.println();

        //g
        int lavLonn = ansatte.stream()
                    .mapToInt(Ansatt::getAarslonn)
                    .min()
                    .orElseThrow();

        List<Ansatt> lavLonnet = ansatte.stream()
                                .filter(a -> a.getAarslonn() == lavLonn)
                                .collect(Collectors.toList());
        System.out.println("Ansatt med lavest lønn: " + lavLonnet);
        System.out.println();

        //h
        int sum = IntStream.range(1,1000)
        .filter(a -> a % 5 == 0  || a % 3 == 0)
        .sum();

        System.out.println("Summen av heltall i [1,1000] som er delelig med 3 eller 5 " + sum);
                         
    }
    private static void skrivUtAnstatte(List<Ansatt> ansatte) {
        ansatte.forEach(System.out::println);
}
}
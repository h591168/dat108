import java.util.function.BiFunction;

public class Oppg1b {

    public static void main(String[] args) {

 // i
 BiFunction<Integer, Integer, Integer> summerFunksjon = (a, b) -> a + b;
 int sum = beregn(12, 13, summerFunksjon);
 System.out.println("Sum: " + sum);
// ii
    BiFunction<Integer,Integer,Integer> sumStorst = (a,b) -> Math.max(a, b);
    int maks = beregn(-5,3, sumStorst);
    System.out.println("Maks: " + maks);

//iii
BiFunction<Integer,Integer,Integer> avstand = (a,b) -> Math.abs(a-b);
int avstanden = beregn(54,45, avstand);
System.out.println("Avstand: " + avstanden);

}

public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> beregningsFunksjon) {
    return beregningsFunksjon.apply(a, b);
}
}

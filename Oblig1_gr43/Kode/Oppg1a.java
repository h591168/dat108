import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Oppg1a {
    
    public static void main(String[] args) {

List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

Collections.sort(listen, (l1,l2) -> Integer.compare(Integer.parseInt(l1), Integer.parseInt(l2)));

    for (String a :listen) {
    System.out.println(a);
        }
    }
}
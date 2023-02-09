import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class d {
    static boolean solution(String s) {
        String[] k = s.split("");
        Map<String, String> m = new HashMap<>();
        m.put(")","(");
        m.put("}", "{");
        m.put("]", "[");
        for(int i = 0; i < k.length - 1; i+=2) {
            if(!k[i].equals(m.get(k[i + 1]))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(solution("(){}"));

    }
}

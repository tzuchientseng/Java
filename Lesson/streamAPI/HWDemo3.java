import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class HWDemo3 {
    public static void main(String[] args) throws Exception {
        var list = getDisc();
        var sum = list.stream()
                      .map(Disc::price)
                      .filter(p->p>=500)
                      .reduce(0, Integer::sum);
        System.out.println(sum);
    }
    
    private static List<Disc> getDisc() throws Exception {
        // 1. read file
        // 2. parse file format
        // 3. file to list
        try (var lines = Files.lines(Paths.get("./disc.csv"))) {
            return lines.skip(1)
                        .map(HWDemo3::buildDisc)
                        .collect(Collectors.toList());
        } catch(Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
    
    private static Disc buildDisc(String s) {
        var ss = s.split(",");
        var id = Integer.parseInt(getContent(ss[0]));
        var name = getContent(ss[1]);
        var price = Integer.parseInt(getContent(ss[2]));
        var rep = Arrays.stream(getContent(ss[3]).split(";"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        return new Disc(id, name, price, rep);
    }
    
    private static String getContent(String s) {
        return s.trim().replaceAll("^\"|\"$", "");
    }
}

record Disc (int id, String name, int price, List<Integer> rep) {}

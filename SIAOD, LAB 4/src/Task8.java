import java.io.*;
import java.util.*;
public class Task8 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir")+"\\src\\Task8.txt");
        Scanner scanner = new Scanner(file);

        Stack temp = new Stack();

        while (scanner.hasNext()) {
            temp.add(scanner.nextLine());
        }

        try (PrintWriter pw = new PrintWriter(System.getProperty("user.dir")+"\\src\\Task8_ans.txt")) {
                for (int i=0;i<=temp.size();++i) {
                    String s;
                    s = (String) temp.pop();
                    pw.println(s);
                }
                pw.println(temp.pop());

                temp.remove(temp);
        }
        catch (IOException exc) {
            System.out.println(exc);
        }
    }

}

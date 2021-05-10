import java.io.*;
import java.util.*;

public class Task7 {

    public static void main(String[] args) throws IOException {
        Deque temp = new ArrayDeque();
        Stack s = new Stack();

        File file = new File(System.getProperty("user.dir")+"\\src\\Task7.txt");
        Scanner scanner = new Scanner(file);

        String str = scanner.nextLine();
        String [] str1 = str.split(" ");

        for (int i = 0; i < str1.length; i++) {
            s.push(Integer.valueOf(str1[i]));
        }

        Iterator iterator = s.iterator();
        Iterator iterator1 = s.iterator();

        while (iterator1.hasNext()) {
            int r  = (int) iterator1.next();

            if (r<0){
                temp.add(r);
            }
        }

        while (iterator.hasNext()) {
            int r  = (int) iterator.next();

            if (r>0){
                temp.add(r);
            }
        }
        System.out.println(temp);
    }
}
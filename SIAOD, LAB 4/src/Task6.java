import java.io.*;
import java.util.*;

public class Task6 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"\\src\\Task6.txt")));

        Stack st = new Stack();
        Stack num = new Stack();
        Stack letter = new Stack();
        Stack symbols = new Stack();

        int i = 0;

        while ((i = reader.read()) != -1) {
            char ch = (char) i;
            st.add(ch);
        }

        Iterator iterator = st.iterator();

        while (iterator.hasNext()) {
            char r=(char) iterator.next();
            if(Character.isDigit(r)){
               num.push(r);
           }
        }

        Iterator iterator1 = st.iterator();

        while (iterator1.hasNext()) {
            char r=(char) iterator1.next();
            if(Character.isAlphabetic(r)){
                letter.push(r);
            }
        }

        Iterator iterator2 = st.iterator();

        while (iterator2.hasNext()) {
            char r=(char) iterator2.next();
            if(!(Character.isDigit(r)||Character.isAlphabetic(r))){
                symbols.push(r);
            }
        }

        System.out.println("Числа:");
        System.out.println(num);
        System.out.println("Буквы:");
        System.out.println(letter);
        System.out.println("Символы:");
        System.out.println(symbols);
        System.out.println("Изначальный стек:");
        System.out.println(st);
    }
}
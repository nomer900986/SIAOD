import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Task2 {

    private final static char[] DEK = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir")+"\\src\\Task2_info.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir")+"\\src\\Task2.txt")));

        int i = 0;

        while((i = reader.read()) != -1) {
            char ch = (char) i;
            writer.append(switchLetter(ch));
            writer.flush();
        }

        reader.close();
        writer.close();

        File f = new File(System.getProperty("user.dir")+"\\src\\Task2_info.txt");
        System.out.println("Зашифрованное сообщение:");
        out(f);

        f=new File(System.getProperty("user.dir")+"\\src\\Task2.txt");
        System.out.println("Расшифрованное сообщение:");
        out(f);
    }

    private static char switchLetter(char ch) {
        char outchar = '0';

        for(int i = 2; i < DEK.length; i++) {
            char c = DEK[i];
            if(Character.compare(c, ch) == 0) {
                outchar = DEK[i-2];
                break;
            }
        }

        if(Character.compare(outchar, '0') == 0)
            outchar = ch;
        return outchar;
    }

    public static void out (File f) throws FileNotFoundException {
        File file = new File(String.valueOf(f));
        LinkedList<String> answer = new LinkedList<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            answer.add(scanner.nextLine());
        }

        System.out.println(answer);
    }
}
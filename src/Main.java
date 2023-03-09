import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
public class Main {

    public static void reader(Vector<Integer> v, String input){

        StringTokenizer tokenizer = new StringTokenizer(input);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if(token.matches("[1-9]+")){
                v.add(Integer.parseInt(token));
            }
        }

    }
    public static Vector<Integer> addVectors(Vector<Integer> v1, Vector<Integer> v2) throws WektoryRoznejDlugosciException{
        if(v1.size() != v2.size())
            throw new WektoryRoznejDlugosciException(v1.size(),v2.size());
        Vector<Integer> vOutput = new Vector<>();
        for (int i=0;i<v1.size();++i){
            int sum = v1.get(i) + v2.get(i);
            vOutput.add(sum);
        }
        return vOutput;
    }
    public static void saveVector(Vector<Integer> v) throws IOException {
        FileWriter writer = new FileWriter("wynik.txt",false);
        writer.write("Zsumowany wektor: ");
        for(int i=0;i<v.size();++i){
            writer.write(v.get(i)+" ");
        }
        System.out.println("Zsumowany wektor zapisano do pliku wynik.txt");
        writer.close();
    }
    public static void printVector(Vector<Integer> v){
        System.out.print("Zsumowany wektor: ");
        for(int i=0;i<v.size();++i){
            System.out.print(v.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> v, v2, vOutput;
        String input;
        while (true){
            try{
                System.out.print("Podaj 1 wektor: ");
                input = scanner.nextLine();
                v = new Vector<>();
                reader(v,input);

                System.out.print("Podaj 2 wektor: ");
                input = scanner.nextLine();
                v2 = new Vector<>();
                reader(v2,input);
                vOutput = addVectors(v,v2);
                saveVector(vOutput);
                printVector(vOutput);
                break;
            } catch (WektoryRoznejDlugosciException e){
                System.out.println(e.getMessage());
            } catch (IOException e){
                System.out.println("Problem podczas zapisu do pliku!");
                scanner.close();
                System.exit(1);
            }
        }



        scanner.close();
    }
}
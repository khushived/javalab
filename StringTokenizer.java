import java.util.StringTokenizer;
import java.util.Scanner;
public class StringTokenizer {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("eneter a line of strings seperated by spaces");
        String str=input.nextLine();
        StringTokenizer st=new StringTokenizer();
        int sum=0;
        System.out.println("individual integers");
        while(st.hasMoreTokens()){
            String token=st.nextToken();
            int currentInteger=Integer.parseInt(token);
            System.out.println(currentInteger);
            sum+=currentInteger;
        }
        System.out.println("sum of integers"+sum);
    }
}

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by TJ on 8/23/16.
 */
public class Attributes {

    Scanner kb = new Scanner(System.in);

    public Attributes() {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.print("How many paramaters will you enter (1-20): ");
        int numatt = kb.nextInt();
        System.out.println("Enter " + numatt + " attributes: ");
        for (int i = 0; i < numatt; i++) {
            arrayList.add(kb.nextLine());

        }
        System.out.println("---------------------------");
        System.out.println("Finished adding attributes.");
        System.out.println("---------------------------");
    }

}
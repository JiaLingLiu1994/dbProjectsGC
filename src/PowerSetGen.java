import java.util.*;

/**
 * Created by TJ on 8/25/16.
 */
public class PowerSetGen {

    public static void main(String[] args) {
        PowerSetGen gen = new PowerSetGen();
        Set<String> elements = new HashSet<String>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many elements will you add? (1-20): ");
        int loopnum = Integer.parseInt(sc.nextLine());
        System.out.println("Enter " + loopnum + " elements.");
        for (int i = 0; i < loopnum; i++) {
            elements.add(sc.nextLine());
        }
        System.out.println("Finished adding elements... Calculating result...");
        System.out.println("-------------------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Set<String> set : gen.getPowerSet(elements)) {
            System.out.println(set);
        }
        System.out.println("-------------------------------------------------");
    }

    //This method will return the set of sets of Srings.
    public Set<Set<String>> getPowerSet(Set<String> elements) {
        int size = elements.size();
        int subsets = (int) Math.pow(2, size);
        Set<Set<String>> toreturn = new HashSet<Set<String>>();
        ArrayList<String> list = new ArrayList<String>(elements);

        for (int i = 0; i < subsets; i++) {
            String binary = binaryRepresentation(i, size);
            Set<String> set = getSubset(binary, list);
            toreturn.add(set);
        }
        return toreturn;
    }

    //This compares the binary string with the correct location in the original string list
    public Set<String> getSubset(String binary, List<String> list) {
        Set<String> result = new HashSet<String>();
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                String value = list.get(i);
                result.add(value);
            }
        }
        return result;
    }


    public String binaryRepresentation(int num, int size) {
        String bin = Integer.toBinaryString(num);
        bin = String.format("%0" + size + "d", Integer.parseInt(bin));
        return bin;
    }
}

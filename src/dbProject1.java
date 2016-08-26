import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class dbProject1 {

	public static void main (String[] args) {
        
        Set<String> elements = new HashSet<String>();
        String[] each_elements;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many elements will you add? (1-20):");
        int elements_num = scanner.nextInt();
        
        System.out.println("Enter " + elements_num + " elements: ");
        for (int i = 1; i <= elements_num; i++ ) {
            elements.add(scanner.next());
        }
        
        each_elements = new String[elements.size()];
        System.out.print("S = { ");
        for (int x = 0; x < elements.size(); x++) {
            each_elements[x] = elements.toArray()[x].toString();
            if (x != elements.size()-1)
                System.out.print(each_elements[x] + ",");
            else
                System.out.print(each_elements[x] + " }");
        }
        
        System.out.println("Finished adding elements. Now calculating result......");
        System.out.println("------------------------------------------------------");
        
        int columns = elements.size();                                              //remove empty set
        int rows = (int) Math.pow(2, columns);
        
        boolean[][] binary_matrix = new boolean[rows][columns];
        String[] powerSet = new String[rows-1];
        
        for(int i = 0 ; i< powerSet.length ; i++){
			 powerSet[i] = "";
        }
        
        for(int i = 1 ; i < binary_matrix.length; i++){
            for(int j = 0; j < binary_matrix[i].length; j++){
                int val = binary_matrix.length * j + i;
                int ret = (1 & (val >>> j));

                binary_matrix[i][j] = ret != 0;

                if(binary_matrix[i][j]==true){
                    powerSet[i-1] += "," + each_elements[j];
                }

            }
		      
        }
		 
        Arrays.sort(powerSet,new comp());
        
        for(int i = 0 ; i< powerSet.length ; i++){
            System.out.println("{" + powerSet[i].substring(1, powerSet[i].length()) + "}");
            }
		    
    }
		
	

}
class comp implements Comparator<String> {
	  public int compare(String o1, String o2) {
	    return Integer.compare(o1.length(), o2.length());
	  }
	}
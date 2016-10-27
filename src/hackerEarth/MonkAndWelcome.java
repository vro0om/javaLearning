package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 //imports for BufferedReader
 import java.io.BufferedReader;
 import java.io.InputStreamReader;

 //import for Scanner and other utility  classes
 import java.util.*;
 */

public class MonkAndWelcome
{
    
    public static void main(String args[]) throws Exception
    {
        
//         * Read input from stdin and provide input before running
//         * Use either of these methods for input

//        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);

        //Scanner
//        Scanner s = new Scanner(System.in);
//        
//        int  num = s.nextInt();
        s.nextLine();
        String[] array1 = s.nextLine().split(" ");
        String[] array2 = s.nextLine().split(" ");
        
        int [] a = new int[num];
        int [] b =  new int [num];
        for (int i = 0; i < num; i++) {
            System.out.print(Integer.parseInt(array1[i])+Integer.parseInt(array2[i])+" "); 
        }
     
        s.close();
        
        
    }
    
        
    
    }


class TestClass
{
  
}

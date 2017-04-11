
package example;

import java.io.*;
import org.apache.commons.lang.WordUtils;
import java.util.*;
import com.opencsv.*;

public class Hello {
    public static void main(String[] args) {
        String message = "hello ivy !";
        System.out.println("standard message : " + message);
        System.out.println("capitalized by " + WordUtils.class.getName() 
                                + " : " + WordUtils.capitalizeFully(message));
        int monmax=0;
        try {
        	CSVReader reader =  new CSVReader(new FileReader("data.csv"));
        	try {
        		List<String[]> myEntries = reader.readAll();
        		for (String[] s : myEntries) {
        			
        			System.out.println(Arrays.toString(s));
					for(String nb : s){
						System.out.println("Nombre lu : "+ nb);
                		monmax = max(monmax, Integer.parseInt(nb));
					}
        		}
        		System.out.println("Mon max : " + monmax);
        		
        	}
        	catch (IOException e) {
        		System.out.println("standard message: IOE");
        	}
        }
        catch(FileNotFoundException e) {
        	System.out.println("standard message: FNFE");
        }
    }

    public static int max(int a, int b)
    {
    	return a > b ? a : b;
    	//return a;
    }
}

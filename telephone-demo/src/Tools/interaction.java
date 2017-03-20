package Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class interaction {
	public static String get_a_string_from_keyboard(){

		/*
		 * the first method
		 */
		//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		//	        String str = null; 
		//	        System.out.println("Enter your value:"); 
		//	        try {
		//				str = br.readLine();
		//			} catch (IOException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			} 
		//	        return str;
		
		/*
		 * the second method
		 */
		Scanner sc = new Scanner(System.in); 
		String name = sc.nextLine(); 
		return name;
	}
}

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;


public class HandleText {

	public static int[] HandleText(Scanner x, int[] b) throws IOException 
	{
		for(int t=0; t<b.length; t++)
		{
			b[t] = 0; 
		}

		//Read the First Line  
		String line = x.nextLine();  

		while (x.hasNext())
		{
			
			int y = line.length();

			//Increment Counters for Frequency of Characters
			for(int i=0; i<y; i++)
			{
				char ch1; 
				ch1 = line.charAt(i); 
				int index; 
				index = (int) ch1;
				b[index] ++; 
			}
			line = x.nextLine(); 
		}
		
		return b; 

	}

}

import java.io.*;
import java.net.*;
import java.util.*;

public class WinningNumbers {
	public static void main(String[] args) throws MalformedURLException, IOException {
		String url;
		//url = "https://data.ny.gov/api/views/5xaw-6ayf/rows.csv?accessType=DOWNLOAD";
		//url = "https://data.ny.gov/api/views/dg63-4siq/rows.csv?accessType=DOWNLOAD";
		//url = "https://data.ny.gov/api/views/bycu-cw7c/rows.csv?accessType=DOWNLOAD";
		url = "https://data.ny.gov/api/views/d6yy-54nr/rows.csv?accessType=DOWNLOAD";
		Scanner scanner = new Scanner(new URL(url).openStream());
		String line = scanner.nextLine();
		System.out.println("Read line: " +line);
		
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			System.out.println("\nRead line: "+line);

			// The line is comma delimited, but replace with tabs instead. 
			line = line.replaceAll(",", "\t");
			System.out.println("Line with tabs: "+line+"\n");
			
			// Process the line (date, 6 numbers, powerball#)
			Scanner lineScanner = new Scanner(line);
			String date = lineScanner.next();
			System.out.print("DATE: "+date+"  ");
			for (int i=0;i<6;i++) {
				int number = lineScanner.nextInt();
				System.out.print(number+",");
			}
			if (lineScanner.hasNextInt()) {
			   int powerBall = lineScanner.nextInt();
			   System.out.println("PowerBall: "+powerBall);
			} else {
				System.out.println("NO PowerBall???");
			}
			
			// Done with the line scanner.
			lineScanner.close();
		}
		
		// Done with the file scanner
		scanner.close();
	}
}

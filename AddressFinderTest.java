import java.net.URL;
import java.util.Scanner;
import java.io.*;

public class AddressFinderTest {
	
	public static void main (String[] args){

	try{
		
		AddressFinder myFinder = new AddressFinder();
		
		System.out.println("Enter website URL to search: ");
		Scanner input = new Scanner(System.in);
		String url = input.nextLine();

		myFinder.urlBrancher(url);
		
		if (!(myFinder.getURLList().size()==0)){
			System.out.println("More URLs were found on this page:");
			System.out.println(myFinder.convertURLListToString());
		}
		else{
			System.out.println("This page did not contain more URLs");
		}
		
		if (!(myFinder.getEmailList().size()==0)){
			System.out.println("Email addresses were found.");
			System.out.println("Please see the textfile.");
			String allEmails = myFinder.convertEmailListToString();
			Scanner in = new Scanner(allEmails);
			String email;
			PrintWriter output = new PrintWriter(args[0]);	
			while(in.hasNext()){
				email = in.next();
				output.println(email);
			}
			output.close();
		}
		
		else{
			System.out.println("No email addresses found.");
		}
		
	}
		
		
		catch (IOException e){
			
			System.out.println("Please check your URL format.");
			
		}
		
			
	}

}

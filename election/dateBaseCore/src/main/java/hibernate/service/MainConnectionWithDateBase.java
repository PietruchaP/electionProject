package hibernate.service;


import hibernate.Operation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainConnectionWithDateBase {

	static int id;
	static int secondWindowChoice;
	boolean menuControlNumberFlag;
	static Scanner scan = new Scanner(System.in);
	
	
	public MainConnectionWithDateBase(){
		connectWithDatebase();
	}
	public void connectWithDatebase(){
		int mainWindowChoice;
		
		System.out.println("Menu :");
		System.out.println("1. zip code\n2. voters\n3. candidates\n4. elections\n5. exit");
		System.out.println("Enter your choice: ");
		mainWindowChoice = scan.nextInt();
		
		switch(mainWindowChoice){
		case 1:
				zipCodeChoice();
			break;		
		case 2:		
				voterChoice();
			break;		
		case 3:
				candidateChoice();
			break;
		case 4:
				electionChoice();
			break;
		case 5:
			System.exit(0);
		default:
			break;
		}
	}
	
	private void zipCodeChoice(){
		Zip_CodesOperation zipCodeOperation = new Zip_CodesOperation();
		
		System.out.println("1. Insert zipCode\n2. Retrieve zipCode\n3. Update zipCode\n4. Delete zipCode\n5. back");
		System.out.println("Enter your choice: ");
		secondWindowChoice = scan.nextInt();
		String zip_Code;
		
		switch(secondWindowChoice){
		case 1:
			System.out.println("Inserting zipCode\n");
			zip_Code = scan.next();
			zipCodeOperation.insertZipCode(zip_Code);
			break;
		case 2:
			System.out.println("Enter id:");
			id = scan.nextInt();
			zipCodeOperation.retrieveZipCode(id);
			break;
		case 3:
			System.out.println("Updating zipCode\n");
			System.out.println("Enter id:");
			id = scan.nextInt();
			System.out.println("Enter zipCode");
			zip_Code = scan.next();
			zipCodeOperation.updateZipCode(id, zip_Code);
			break;
		case 4:
			System.out.println("Delete zipCode\n");
			System.out.println("Enter id:");
			id = scan.nextInt();
			zipCodeOperation.deleteZipCode(id);
			break;
		case 5:
			
		default:
				break;
		}
		
	}
	private void voterChoice(){
	VotersOperation voterOperation = new VotersOperation();
		
	String pesel;
	int zipId;
	
		System.out.println("1. Insert voter\n2. Retrieve voter\n3. Update voter\n4. Delete voter");
		System.out.println("Enter your choice: ");
		secondWindowChoice = scan.nextInt();
		
		switch(secondWindowChoice){
		case 1:
			System.out.println("Inserting voter\n");
			System.out.println("Write pesel\n");
			pesel = scan.next();
			System.out.println("Insert zipId");
			zipId = scan.nextInt();
			voterOperation.insertVoter(pesel, zipId);
			break;
		case 2:
			System.out.println("Enter id:");
			id = scan.nextInt();
			voterOperation.retrieveVoter(id);
			break;
		case 3:
			System.out.println("Updating voter\n");
			System.out.println("Enter id:");
			id = scan.nextInt();
			System.out.println("Enter pesel");
			pesel = scan.next();
			System.out.println("Enter ");
			zipId = scan.nextInt();
			voterOperation.updateVoter(id, pesel, zipId);
			break;
		case 4:
			System.out.println("Delete voter\n");
			System.out.println("Enter id:");
			id = scan.nextInt();
			voterOperation.deleteVoter(id);
			break;
			
		default:
				break;
		}
		
	}
	private void candidateChoice(){
		CandidateOperation candidateOperation = new CandidateOperation();
		
		String firstname;
		String surname;
		int zipId;
		
			System.out.println("1. Insert candidate\n2. Retrieve candidate\n3. Update candidate\n4. Delete candidate");
			System.out.println("Enter your choice: ");
			secondWindowChoice = scan.nextInt();
			
			switch(secondWindowChoice){
			case 1:
				System.out.println("Inserting candidate\n");
				System.out.println("Write firstname\n");
				firstname = scan.next();
				System.out.println("Write surname");
				surname = scan.next();
				System.out.println("Insert zipId");
				zipId = scan.nextInt();
				candidateOperation.insertCandidate(firstname, surname, zipId);
				break;
			case 2:
				System.out.println("Enter id:");
				id = scan.nextInt();
				candidateOperation.retrieveCandidate(id);
				break;
			case 3:
				System.out.println("Updating candidate\n");
				System.out.println("Enter id:");
				id = scan.nextInt();
				System.out.println("Write firstname");
				firstname = scan.next();
				System.out.println("Write surname");
				surname = scan.next();
				System.out.println("zip Id ");
				zipId = scan.nextInt();
				candidateOperation.updateCandidate(id, firstname, surname, zipId);
				break;
			case 4:
				System.out.println("Delete candidate\n");
				System.out.println("Enter id:");
				id = scan.nextInt();
				candidateOperation.deleteCandidate(id);
				break;
				
			default:
					break;
			}
			
	}
	private void electionChoice(){
		ElectionsOperation electionOperation = new ElectionsOperation();
		
		Date electionDate = null;
		String date = null;
		int electionDateDay, electionDateMonth, electionDateYear;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String electionType;
		
			System.out.println("1. Insert election\n2. Retrieve election\n3. Update election\n4. Delete election");
			System.out.println("Enter your choice: ");
			secondWindowChoice = scan.nextInt();
			
			switch(secondWindowChoice){
			case 1:
				System.out.println("Inserting election\n");
				System.out.println("Add election day\n"); // not done
				electionDateDay = scan.nextInt();
				System.out.println("Add election month\n"); // not done
				electionDateMonth = scan.nextInt();
				System.out.println("Add full election year (for example: 2016\n"); // not done
				electionDateYear = scan.nextInt();
				date =  Integer.toString(electionDateYear)+"-"+Integer.toString(electionDateMonth)+"-"+Integer.toString(electionDateDay);
				try {
					 electionDate = fmt.parse(date);
					 
					} catch (ParseException e) {
						e.printStackTrace();
					} 
				
				System.out.println("Write type of election");
				electionType = scan.next();
				electionOperation.insertElection(electionDate, electionType);
				break;
			case 2:
				System.out.println("Enter id:");
				id = scan.nextInt();
				electionOperation.retrieveElection(id);
				break;
			case 3:
				System.out.println("Updating election\n");
				System.out.println("Enter id:");
				id = scan.nextInt();
				System.out.println("Add election day\n"); // not done
				electionDateDay = scan.nextInt();
				System.out.println("Add election month\n"); // not done
				electionDateMonth = scan.nextInt();
				System.out.println("Add full election year (for example: 2016\n"); // not done
				electionDateYear = scan.nextInt();
				date =  Integer.toString(electionDateYear)+"-"+Integer.toString(electionDateMonth)+"-"+Integer.toString(electionDateDay);
				try {
					 electionDate = fmt.parse(date);
					 
					} catch (ParseException e) {
						e.printStackTrace();
					} 
				
				System.out.println("Write type of election");
				electionType = scan.next();
				electionOperation.updateElection(id, electionDate, electionType);
				break;
			case 4:
				System.out.println("Delete election\n");
				System.out.println("Enter id:");
				id = scan.nextInt();
				electionOperation.deleteElection(id);
				break;
				
			default:
					break;
			}
	}
}


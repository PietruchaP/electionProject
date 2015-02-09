package hibernate.service;

import hibernate.dao.ZipCodesDAO;
import hibernate.model.ZipCodes;
import hibernate.service.interfaces.ManagerZipCode;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConnectionWithBase {

	ClassPathXmlApplicationContext context;
	static Scanner scan = new Scanner(System.in);
	
	
	public SpringConnectionWithBase (ClassPathXmlApplicationContext context){
		this.context = context;
	}
	
	public void dateBaseMenu(){
		
		int mainWindowChoice;
		
		System.out.println("Menu :");
		System.out.println("1. zip code\n2. exit");
		System.out.println("Enter your choice: ");
		mainWindowChoice = scan.nextInt();
		switch(mainWindowChoice){
		case 1:
				createZipCode();
			break;		
		case 2:		
				System.exit(0);
			break;		
		default:
			break;
		}
	}
	
	private void createZipCode(){
		ManagerZipCode manager = context.getBean(ManagerZipCodeImpl.class);		  
		ZipCodesDAO zipCodeDAO = context.getBean(ZipCodesDAO.class);		
		ZipCodes zipcode = new ZipCodes();
		zipcode.setZipCodes("60-777");
		manager.insertZipCode(zipcode);
		context.close();
	}
}

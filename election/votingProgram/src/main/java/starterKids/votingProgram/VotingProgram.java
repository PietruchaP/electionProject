package starterKids.votingProgram;

import hibernate.service.SpringConnectionWithBase;

import java.awt.EventQueue;
import java.util.Scanner;

import starterKids.votingProgram.Class.MyFrame;


public class VotingProgram
{	
	static MyFrame window;
	static Scanner scan = new Scanner(System.in);
	static int choice;
	
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("1. Work with Datebase\n2. Work with Gui\n3. Exit");
					choice = scan.nextInt();
					switch(choice){
					case 1:
						connectWithDatebase();
						break;
					case 2:
						createAndShowGui();
						break;
					case 3:
						System.exit(0);
						break;
					default: 
						System.out.println("blednie wybrana opcja");
						System.exit(0);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	});
    } 
	private static void createAndShowGui() {
		window = new MyFrame("Login");
	}
	
	private static void connectWithDatebase(){
		SpringConnectionWithBase connectBase = new SpringConnectionWithBase();
		connectBase.connectWithDateBase();
	}
	
    public VotingProgram() {
	}
}


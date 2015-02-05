package starterKids.votingProgram.Class;

import hibernate.model.Voters;
import hibernate.model.ZipCodes;

import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.springframework.web.client.RestTemplate;

import restURls.RestURs;

public class LoginPanel extends JPanel {

	public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel loginPanel = new JPanel();
	private JPanel zipPanel = new JPanel();
	private JPanel peselPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();	
	
	private JButton loginButton;

	private JTextField peselField;
	private JComboBox<String> zipCodeBox;	

    private ActionListener loginButtonListener; 
    
	private List<Voters> voters = null;
	private List<Voters> actualVoters = new ArrayList<Voters>();
	private List<ZipCodes> zips = new ArrayList<ZipCodes>();
	private ZipCodes zipek = new ZipCodes();
	
	public ZipCodes getZipek() {
		return zipek;
	}

	LoginPanel(ActionListener mlistener){
		loginButtonListener = mlistener;
		createElementsForPanels();
		addElementsToSubPanels();
		addElementToLoginPanel();
		// TEMPORARY This under that line//
		RestTemplate restTemplate = new RestTemplate();
		voters = Arrays.asList(restTemplate.getForObject(SERVER_URI+RestURs.GET_ALL_PESEL, Voters[].class));
	    
	}
	
		private void createElementsForPanels(){
			createLoginButton();
			createZipCodeBox();	
			createPeselField();		 
		}		
			private void createLoginButton(){
				loginButton = new JButton("Login");
				loginButton.addActionListener(loginButtonListener);
				loginButton.setEnabled(false);	
			}
			private void createZipCodeBox() {

				zipCodeBox = new JComboBox<String>();
				
				RestTemplate restTemplate = new RestTemplate();

				zips = Arrays.asList(restTemplate.getForObject(SERVER_URI+RestURs.GET_ALL_ZIPCODES, ZipCodes[].class));
			       
				zipCodeBox.addItem("");
				for(int i=0;i<zips.size();i++){
					zipCodeBox.addItem(zips.get(i).getZipCodes());
				}

				addListenerToZipCodeBox();
			}
			
			private void createPeselField() {
				peselField = new JTextField();
				peselField.setBounds(217, 5, 106, 228);
				peselField.setColumns(10);
				peselField.setTransferHandler(null);
				addListenersToPeselField();			
			}
			
		private void addElementsToSubPanels(){
			addToButtonPanel();
			addToZipPanel();
			addToPeselPanel();
		}
			private void addToButtonPanel(){
				buttonPanel.add(loginButton); 				
			}			
			private void addToZipPanel() {
				zipPanel.add(new Label("Kod pocztowy:"));
				zipPanel.add(zipCodeBox);
				zipPanel.setAlignmentX(Component.CENTER_ALIGNMENT);		
			}
			private void addToPeselPanel() {		
				peselPanel.add(new Label("Pesel:"));			
				peselPanel.add(peselField);
			}
			
		private void addElementToLoginPanel(){			
			loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
			loginPanel.add(Box.createVerticalStrut(20));
			loginPanel.add(zipPanel);
			loginPanel.add(Box.createVerticalGlue());
			loginPanel.add(peselPanel);
			loginPanel.add(Box.createVerticalGlue());
			loginPanel.add(buttonPanel);
			loginPanel.add(Box.createVerticalGlue());			
		}
	
	public JPanel getPanel() {
		return loginPanel;
	}
	public JComboBox<String> getZipCodeBox() {
		return zipCodeBox;
	}
    public JTextField getPeselField() {
		return peselField;
	}
    
	public void addListenersToPeselField(){ 
		 peselField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					checkIfCorrectKey(e);				
				}			
				@Override
				public void keyReleased(KeyEvent e) {}			
				@Override
				public void keyPressed(KeyEvent e) {}
				
				 public void checkIfCorrectKey(KeyEvent e){
					 if(!(e.getKeyChar()>='0' && e.getKeyChar()<='9')){
						 e.consume();
					 }	
					 if(peselField.getText().length()>=11){
						 e.consume();
					 }
				 }
			});
		 
		peselField.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    changed();
			  }
			  public void changed() {
				  if(ifPeselLenghtCorrect()==true){
					  loginButton.setEnabled(checkIfLoginButtonAvailable());
				  }
				  else{
					 loginButton.setEnabled(false);
				  }
			  } 
		});		 
	}
	
	public void addListenerToZipCodeBox(){
		 zipCodeBox.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				saveCorrectZipCode();
				loadNewPeselsFromBase();
				loginButton.setEnabled(checkIfLoginButtonAvailable());
			}

			private void saveCorrectZipCode() {
				
				for(int i =0; i< zips.size();i++){
					if(zips.get(i).getZipCodes().equals(zipCodeBox.getSelectedItem().toString())){
						zipek = zips.get(i);
					}
				}
				
			}

			private void loadNewPeselsFromBase() {
				actualVoters.clear();
				System.out.println(zipek.getId());
				for(int i =0; i< voters.size();i++){
					if(voters.get(i).getZipCode().getId()==(zipek.getId())){
						actualVoters.add(voters.get(i));
					}
				}
				
			}
		});
	}   
		public boolean checkIfLoginButtonAvailable() {	
			 boolean peselLenghtCorrection = ifPeselLenghtCorrect();
			 boolean comboBoxIsTaken = ifComboBoxCorrect();
			 boolean peselIsInBase = false;
			 if (peselLenghtCorrection==true){
				 peselIsInBase = ifPeselInBase();
			 }
					 if (peselLenghtCorrection && comboBoxIsTaken && peselIsInBase){
				       return true;
				     }
				     else {
				       return false;
				    }
		}	
			private boolean ifPeselInBase() {		
			for(int i = 0;i<actualVoters.size();i++){
				if(getPeselField().getText().equals(actualVoters.get(i).getPesel())){
					return true;
				}
			}
			return false;
		}

			public boolean ifPeselLenghtCorrect(){
				boolean isPeselCorrect = (peselField.getText().length()==11) ? true: false;
				return isPeselCorrect;
			}	
			public boolean ifComboBoxCorrect() {	
				String value=zipCodeBox.getSelectedItem().toString();
				boolean isComboBoxCorrect = (value.equals("")) ? false : true;
				return isComboBoxCorrect;
			}
		
}

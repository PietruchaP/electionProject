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
    
	private List<ZipCodes> zips = new ArrayList<ZipCodes>();
	private ZipCodes zipek = new ZipCodes();
	private Voters voter = new Voters();
	
	public Voters getVoter() {
		return voter;
	}

	public ZipCodes getZipek() {
		return zipek;
	}

	LoginPanel(ActionListener mlistener){
		loginButtonListener = mlistener;
		createElementsForPanels();
		addElementsToSubPanels();
		addElementToLoginPanel();
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
				loginButton.setEnabled(checkIfLoginButtonAvailable());
			}

			private void saveCorrectZipCode() {
				RestTemplate restTemplate = new RestTemplate();
				
				zipek = (ZipCodes) restTemplate.getForObject(SERVER_URI+RestURs.GET_ZIPCODE_BY_STRING_ZIP, ZipCodes.class, zipCodeBox.getSelectedItem().toString() );
			}

		});
	}   
		public boolean checkIfLoginButtonAvailable() {	
			 boolean peselLenghtCorrection = ifPeselLenghtCorrect();
			 boolean comboBoxIsTaken = ifComboBoxCorrect();

					 if (peselLenghtCorrection && comboBoxIsTaken){
				       return true;
				     }
				     else {
				       return false;
				    }
		}	
		public boolean isPeselInBase() {		

				RestTemplate restTemplate = new RestTemplate();

				voter = (Voters) restTemplate.getForObject(SERVER_URI+RestURs.GET_CORRECT_PESELS, Voters.class, getPeselField().getText());

				if(zipek.getId() == voter.getZipCode().getId())
					return true;
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

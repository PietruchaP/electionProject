package starterKids.votingProgram.Class;


import hibernate.Operation.Zip_CodesOperation;
import hibernate.service.MainConnectionWithDateBase;

import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LoginPanel extends JPanel {

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
	//static final String gapList[] = {"","45-234", "73-410", "73-215", "43-420"};
    final static int maxGap = 20;
    private ActionListener loginButtonListener; 
    
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
			//	zipCodeBox = new JComboBox<String>(gapList);
				zipCodeBox = new JComboBox<String>();
				//MainConnectionWithDateBase hibernateConnection = new MainConnectionWithDateBase(); // tutaj!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				
				Zip_CodesOperation crudOperation = new Zip_CodesOperation();
				String loadZipCode;
				for(int i = 0;i<9;i++){
					loadZipCode = crudOperation.retrieveZip(i);
					zipCodeBox.addItem(loadZipCode);
					
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
				  loginButton.setEnabled(checkIfLoginButtonAvailable());
			  }
			  
		});		 
	}
	
	public void addListenerToZipCodeBox(){
		 zipCodeBox.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {	
				loginButton.setEnabled(checkIfLoginButtonAvailable());
			}
		});
	}   
		public boolean checkIfLoginButtonAvailable() {	
			 boolean peselNumberIsNumeric = ifPeselCorrect();
			 boolean comboBoxIsTaken = ifComboBoxCorrect();
					 if (peselNumberIsNumeric && comboBoxIsTaken){
				       return true;
				     }
				     else {
				       return false;
				    }
		}	
			public boolean ifPeselCorrect(){
				boolean isPeselCorrect = (peselField.getText().length()==11) ? true: false;
				return isPeselCorrect;
			}	
			public boolean ifComboBoxCorrect() {	
				String value=zipCodeBox.getSelectedItem().toString();
				boolean isComboBoxCorrect = (value.equals("")) ? false : true;
				return isComboBoxCorrect;
			}
		
}

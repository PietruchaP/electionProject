package starterKids.votingProgram.Class;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MyFrame{
	
	private JFrame frame;
	
	private LoginPanel loginPanel;
	private CandidatePanel myCandidatePanel;
	private ResultPanel replyPanel;

	ActionListener acceptButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			GroupButtonCheckSelected test = new GroupButtonCheckSelected();
			String selectedCandidate = test.getSelectedButtonText(myCandidatePanel.getOptions());
			
			replyPanel = new ResultPanel(selectedCandidate);
			changePanel(replyPanel.getPanel());
			// JOptionPane.showMessageDialog(null, selectedCandidate);
		}
	};
	
	ActionListener loginButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			PeselVerify peselVerification = new PeselVerify(loginPanel.getPeselField().getText());
	    	if(peselVerification.isPeselCorrect()){
			    frame.setTitle("Okręg wyborczy:"+ loginPanel.getPeselField().getText());
				changePanel(myCandidatePanel.getPanel());
	    	}
	    	else
	    		JOptionPane.showMessageDialog(null, "Błedny Pesel, wprowadz poprawny");
		}
	};
	
    public MyFrame(String name) {		
    	createFrame(name);	
    	createPanels();
		addFirstComponentsToPane(); 
    }
		private void createFrame(String name) {
			Dimension minimalsize = new Dimension(400,300);
			frame = new JFrame(name);
			frame.setMinimumSize(minimalsize);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			frame.setVisible(true);		
		}
		private void createPanels(){
	    	createLoginPanel();
	    	createCandidatePanel();		
		}
			private void createLoginPanel(){
				loginPanel = new LoginPanel(loginButtonListener);
			}
			private void createCandidatePanel(){
				myCandidatePanel = new CandidatePanel(acceptButtonListener);
			}
	
	private void changePanel(JPanel newPanel) {
		getContentPane().removeAll();	
		getContentPane().add(newPanel);
		getContentPane().revalidate();
	}
		public Container getContentPane(){
			return frame.getContentPane();
		}
		
	public void addFirstComponentsToPane() {
//------- LOAD FIRST PANEL ---------//
		 frame.getContentPane().add(loginPanel.getPanel());
	} 		
}

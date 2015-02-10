package starterKids.votingProgram.Class;

import hibernate.model.Candidates;
import hibernate.model.Voters;
import hibernate.model.ZipCodes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.springframework.web.client.RestTemplate;

import restURls.RestURs;

public class CandidatePanel extends JPanel {
	public static final String SERVER_URI = "http://localhost:8080/SpringRestExample";
	private static final long serialVersionUID = 1L;
	private JPanel candidatePanel = new JPanel();
	private JPanel candidateButtonsPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();	

	
	
	private ButtonGroup possibleOptionChoice = new ButtonGroup();
	private JButton acceptButton = new JButton("Zatwierdz");
	private ActionListener acceptButtonListener;
	
	private List<Candidates> actualCandidates = new ArrayList<Candidates>();
	private Candidates selectedCandidate = new Candidates();
	
	public ButtonGroup getPossibleOptionChoice() {
		return possibleOptionChoice;
	}

	ActionListener candidateButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			acceptButton.setEnabled(true);
			setSelectedCandidate();
			
		}

		private void setSelectedCandidate() {
			GroupButtonCheckSelected test = new GroupButtonCheckSelected();
			
			String selectedFromButtonGroup = test.getSelectedButtonText(getPossibleOptionChoice());
			
			for(int i = 0;i<actualCandidates.size();i++){
				String checkString = new String(actualCandidates.get(i).getFirstname()+" "+actualCandidates.get(i).getSurname());
				if(checkString.equals(selectedFromButtonGroup)){
					selectedCandidate = actualCandidates.get(i);
				}
			}
		}
	};
	
	CandidatePanel(ActionListener mlistener) {
		acceptButtonListener = mlistener;
		setCandidatePanel();
		setCandidateButtonsPanel(); 
		setLoginButton();
		addElementsToButtonPanel();

		addElementsToCandidatePanel();
		
	}
		
		public void setCandidateList(ZipCodes actualZip){
			RestTemplate restTemplate = new RestTemplate();
			actualCandidates = Arrays.asList(restTemplate.getForObject(SERVER_URI+RestURs.GET_CANDIDATE_BY_ZIPCODE, Candidates[].class, actualZip.getId()));	
		}
	
		public void setCandidatePanel() {
			candidatePanel.setLayout(new BoxLayout(candidatePanel, BoxLayout.Y_AXIS));
		}
		
		private void setLoginButton(){
			acceptButton.addActionListener(acceptButtonListener);
			acceptButton.setEnabled(false);	
		}
		private void addElementsToButtonPanel(){
			buttonPanel.add(acceptButton); 				
		}
		
		public void setCandidateButtonsPanel(){
			candidateButtonsPanel.setLayout(new BoxLayout(candidateButtonsPanel, BoxLayout.Y_AXIS));
		}			
		public void createCandidateAndAddToCandidatePanel() {
			System.out.println(actualCandidates.size());
			for (int i = 0; i < actualCandidates.size(); i++) {
				JRadioButton candidateOption = new JRadioButton(actualCandidates.get(i).getFirstname()+" "+actualCandidates.get(i).getSurname());
				candidateButtonsPanel.add(candidateOption);
				candidateButtonsPanel.add(Box.createVerticalGlue());
				candidateOption.addActionListener(candidateButtonListener);
				candidateOption.setAlignmentX(CENTER_ALIGNMENT);
				possibleOptionChoice.add(candidateOption);
			}
		}
		
	public void addElementsToCandidatePanel() {
		candidatePanel.add(Box.createVerticalGlue());
		candidatePanel.add(candidateButtonsPanel);
		candidatePanel.add(Box.createVerticalGlue());
		candidatePanel.add(buttonPanel);
		candidatePanel.add(Box.createVerticalGlue());
	}

	public JPanel getPanel() {
		return candidatePanel;
	}

	public Candidates getSelectedCandidate() {
		return selectedCandidate;
	}

	public void setSelectedCandidate(Candidates selectedCandidate) {
		this.selectedCandidate = selectedCandidate;
	}
}

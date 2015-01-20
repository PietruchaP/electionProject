package starterKids.votingProgram.Class;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CandidatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel candidatePanel = new JPanel();
	private JPanel candidateButtonsPanel = new JPanel(); //zmienic nazwe
	private JPanel buttonPanel = new JPanel();	

	private ButtonGroup options = new ButtonGroup();
	private JButton acceptButton = new JButton("Zatwierdz");
	private ActionListener acceptButtonListener;
	
	public ButtonGroup getOptions() {
		return options;
	}

	ActionListener candidateButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			acceptButton.setEnabled(true);
		}
	};
	
	CandidatePanel(ActionListener mlistener) {
		acceptButtonListener = mlistener;
		setCandidatePanel();
		setCandidateButtonsPanel(); 
		setLoginButton();
		addElementsToButtonPanel();
		loadAndAddCandidateToCandidatePanel();
		addElementsToCandidatePanel();
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
		
		public void loadAndAddCandidateToCandidatePanel(){
			createCandidateAndAddToCandidatePanel(3);
		}
			public void setCandidateButtonsPanel(){
				candidateButtonsPanel.setLayout(new BoxLayout(candidateButtonsPanel, BoxLayout.Y_AXIS));
			}			
			public void createCandidateAndAddToCandidatePanel(int number) {
				for (int i = 0; i < number; i++) {
					JRadioButton candidateOption = new JRadioButton("kandydat " + i);
					candidateButtonsPanel.add(candidateOption);
					candidateButtonsPanel.add(Box.createVerticalGlue());
					candidateOption.addActionListener(candidateButtonListener);
					candidateOption.setAlignmentX(CENTER_ALIGNMENT);
					options.add(candidateOption);
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
}

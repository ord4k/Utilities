import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class JFrameMain {
	JFrame mainFrame;
	JButton buttonStart;
	JLabel labelWelcome;
	JPanel mainPanel;
	String screenDir;
	
	public JFrameMain(String screenDir) {
		this.screenDir = screenDir;
	}

	public void makeGui() {
		mainFrame = new JFrame("Add new waypoints");
		
		buttonStart = new JButton("Select new waypoint");
		buttonStart.addActionListener(new ButtonStartListener());
		
		labelWelcome = new JLabel("What do you want to do?");
		
		mainPanel = new JPanel();
		mainPanel.setSize(300,500);
		mainPanel.add(labelWelcome);
		mainPanel.add(buttonStart);
		
		
		
		mainFrame.setContentPane(mainPanel);
		mainFrame.setSize(200,100);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
	}
	
	public class ButtonStartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
			new JFramePixelColor(screenDir).makeGui();
				
		}
		
	}
	
	

}

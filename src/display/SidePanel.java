package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import display.buttons.StartButton;

public class SidePanel extends JPanel
{
	private StartButton startButton;
	private JLabel stepsLabel;
	private JLabel stepsCounter;
	private int stepCount = 0;
	private final String STEP_LABEL_NAME = "Steps";
	
	public SidePanel(PatternPanel patternPanel, AppFrame appFrame)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setPreferredSize(new Dimension(300,0));
		
		stepsLabel = new JLabel(STEP_LABEL_NAME);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(stepsLabel, gbc);
		
		stepsCounter = new JLabel(""+stepCount);
		gbc.gridx = 1;
		add(stepsCounter, gbc);
		
		startButton = new StartButton(patternPanel, appFrame);
		gbc.insets = new Insets(20,5,5,5);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(startButton, gbc);
	}
	
	public void setEnabledStartButton(boolean enable)
	{
		startButton.setEnabled(enable);
	}
	
	public void iterateStepCounter()
	{
		stepCount++;
		stepsCounter.setText(""+stepCount);
		repaint();
	}
}

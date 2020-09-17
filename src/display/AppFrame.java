package display;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AppFrame extends JFrame
{
	private PatternPanel patternPanel;
	private SidePanel sidePanel;
	
	public AppFrame()
	{
		//Initialise Frame
		setLayout(new BorderLayout());
		setBounds(100,100,1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//Populate Frame
		patternPanel = new PatternPanel(this);
		sidePanel = new SidePanel(patternPanel, this);
		add(patternPanel, BorderLayout.CENTER);
		add(sidePanel, BorderLayout.WEST);
	}
	
	public void setEnabledStartButton(boolean enable)
	{
		sidePanel.setEnabledStartButton(enable);
	}
	
	public void iterateStepCounter()
	{
		sidePanel.iterateStepCounter();
	}
}

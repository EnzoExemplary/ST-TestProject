package display.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import display.AppFrame;
import display.PatternPanel;

public class StartButton extends JButton 
{
	public StartButton(PatternPanel patternPanel, AppFrame appFrame)
	{
		super("Start");
		
		addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			    new Thread() {
			    	@Override
			        public void run() 
			        {
			    		appFrame.setEnabledStartButton(false);
			    		for(int i = 0; i < 1000000; i++)
			    		{
				    		if(!patternPanel.updateGrid())
				    		{
				    			break;
				    		}
				    		appFrame.iterateStepCounter();
			    		}
			    		appFrame.setEnabledStartButton(true);
			    		patternPanel.resetXY();
			        }
			    }.start();
			}
		});
	}
}

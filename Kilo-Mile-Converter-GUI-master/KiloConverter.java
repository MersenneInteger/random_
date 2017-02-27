import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

//This program converts kilometers to miles
public class KiloConverter extends JFrame
{
	private JPanel panel;
	private JLabel messageLabel;
	private JTextField kiloTextField;
	private JButton calcButton;
	private final int WINDOW_WIDTH = 310;
	private final int WINDOW_HEIGHT = 100;
	
	public KiloConverter()
	{
		//contains methods from JFrame to build window
		setTitle("Kilometer Converter"); // sets window title
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // sets window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what happens when close button clicked
		buildPanel(); // builds pannel and adds it to frame
		add(panel); //add panel to frame content pane
		setVisible(true); //display window
	}
    	private void buildPanel() 
	{
		messageLabel = new JLabel("Enter a distance in kilometers"); //creates JLabel obj assigns it to messageLabel
		kiloTextField = new JTextField(10); //create text field 10 chars wide
		calcButton = new JButton("Calculate!"); // creates calculate button
		
		calcButton.addActionListener(new CalcButtonListener()); //adds action listener to button
		calcButton.setBackground(Color.BLUE);
		calcButton.setForeground(Color.YELLOW);
		
		panel = new JPanel(); // create panel and let panel field reference it
		
		//add label, text field, button components to panel
		panel.add(messageLabel);
		panel.add(kiloTextField);
		panel.add(calcButton);	
	}
    	private class CalcButtonListener implements ActionListener
	{
		//method executes when button is clicked, e is the ActionEvent object which is passed into method
		public void actionPerformed(ActionEvent e) 
		{
			final double CONVERSION = 0.6214;
			String input; 
			double miles; 
			
			
			input = kiloTextField.getText(); 
			miles = Double.parseDouble(input) * CONVERSION; 
			JOptionPane.showMessageDialog(null, input + " kilometers is " + miles
					+ " miles.");
		}
	}
	
}

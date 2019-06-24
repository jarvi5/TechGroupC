import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JLabel firstnameLabel;
	private JLabel lastnameLabel;
	private JLabel showLabel;
	private JTextField firstnameTextfield;
	private JTextField lastnameTextfield;
	private JButton saveButton;
	private JButton searchButton;
	private JButton nextButton;
	private JButton previousButton;
	
	
	public View() {
		super("MVC - app");
		init();	
	}
	
	public JButton getSaveButton(){
		return saveButton;
	}
	
	public JTextField getTextFieldFirstName() {
		return firstnameTextfield;
	}
	
	public JTextField getTextFieldLastName() {
		return lastnameTextfield;
	}
	
	public JLabel getShowLabel() {
		return showLabel;
	}
	
	public JButton getSearchButton() {
		return searchButton;
	}
	
	public JButton getNextButton() {
		return nextButton;
	}
	
	public JButton getPreviousButton() {
		return previousButton;
	}
	
	private void init() {
		this.setLayout(null);
		this.setBounds(0, 0, 300, 300);
		
		showLabel = new JLabel();
		showLabel.setText("Fistname Lastname");
		showLabel.setBounds(10,170,200,25);
		
		firstnameLabel = new JLabel();
		firstnameLabel.setText("first name");
		firstnameLabel.setBounds(10,10,150,25);
		
		lastnameLabel = new JLabel();
		lastnameLabel.setText("last name");
		lastnameLabel.setBounds(10,70,150,25);
		
		firstnameTextfield = new JTextField();
		firstnameTextfield.setText("");
		firstnameTextfield.setBounds(10,40,150,25);
		
		
		lastnameTextfield = new JTextField();
		lastnameTextfield.setText("");
		lastnameTextfield.setBounds(10,100,150,25);
		
		saveButton = new JButton();
		saveButton.setText("Save");
		saveButton.setBounds(200,80,80,25);
		
		nextButton = new JButton();
		nextButton.setText("Next");
		nextButton.setBounds(10,135,60,25);
		
		previousButton = new JButton();
		previousButton.setText("Previus");
		previousButton.setBounds(75,135,80,25);
		
		searchButton = new JButton();
		searchButton.setText("Search");
		searchButton.setBounds(200,110,80,25);
		
		this.add(firstnameLabel);
		this.add(firstnameTextfield);
		this.add(lastnameLabel);
		this.add(saveButton);
		this.add(lastnameTextfield);
		this.add(nextButton);
		this.add(previousButton);
		this.add(searchButton);
		this.add(showLabel);
		this.setLocationRelativeTo(this);
	}
	
	public static void main(String arg[]) {
		View v = new View();
		v.setVisible(true);
	}
	
	
}

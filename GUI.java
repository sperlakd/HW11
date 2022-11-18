/*Author: Doug Sperlak
 * Assignment: 11
 * 
 * 
 */

package hw11;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GUI extends JFrame{
	private JPanel contentPane;
	private JTextField fName;
	private JTextField fPhoneNum;
	private JTextField fBirthDay;
	private JTextField fEmailAddress;
	private static JTextArea output;
	String firstName;
	ArrayList<Person> p = new ArrayList<Person>();

	public GUI() {																			// create contents of panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 580);														// Set window size
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name = new JLabel("Name: ");
		name.setBounds(48, 38, 40, 14);
		contentPane.add(name);																// Create prompt at location
			
		fName = new JTextField();															// text fields for first name
		fName.setBounds(90, 38, 200, 20);
		contentPane.add(fName);																// Create input textbox at location
		fName.setColumns(10);
		
		JLabel phoneNum = new JLabel("Phone number: ");
		phoneNum.setBounds(48, 65, 100, 14);
		contentPane.add(phoneNum);																// Create prompt at location
			
		fPhoneNum = new JTextField();															// text fields for first name
		fPhoneNum.setBounds(145, 65, 200, 20);
		contentPane.add(fPhoneNum);																// Create input textbox at location
		fPhoneNum.setColumns(10);
		
		JLabel birthDay = new JLabel("Birth day: ");
		birthDay.setBounds(48, 92, 100, 14);
		contentPane.add(birthDay);																// Create prompt at location
			
		fBirthDay = new JTextField();															// text fields for first name
		fBirthDay.setBounds(115, 92, 200, 20);
		contentPane.add(fBirthDay);																// Create input textbox at location
		fBirthDay.setColumns(10);
		
		JLabel emailAddress = new JLabel("Email address: ");
		emailAddress.setBounds(48, 119, 100, 14);
		contentPane.add(emailAddress);																// Create prompt at location
			
		fEmailAddress = new JTextField();															// text fields for first name
		fEmailAddress.setBounds(145, 119, 200, 20);
		contentPane.add(fEmailAddress);																// Create input textbox at location
		fEmailAddress.setColumns(10);
		
		JButton btnDisplay = new JButton("Add User");										// Display button
		SwingAction action = new SwingAction();
		btnDisplay.setAction(action);
		btnDisplay.setBounds(48, 145, 169, 38);
		contentPane.add(btnDisplay);														// Create the display button at specified location
		
		JButton btn2Display = new JButton("Display Results");										// Display button
		SwingAction2 action2 = new SwingAction2();
		btn2Display.setAction(action2);
		btn2Display.setBounds(250, 145, 169, 38);
		contentPane.add(btn2Display);														// Create the display button at specified location
		
		output = new JTextArea();															// display area
		output.setBounds(50, 200, 750, 300);
		contentPane.add(output);															// Create output display area
		output.setColumns(10);
		
		JButton btn3Display = new JButton("Display Results");										// Display button
		SwingAction3 action3 = new SwingAction3();
		btn3Display.setAction(action3);
		btn3Display.setBounds(450, 145, 169, 38);
		contentPane.add(btn3Display);														// Create the display button at specified location
		
		output = new JTextArea();															// display area
		output.setBounds(50, 200, 750, 300);
		contentPane.add(output);															// Create output display area
		output.setColumns(10);
	}

public class SwingAction extends AbstractAction {
	public SwingAction() {
		putValue(NAME, "Submit new person");	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {											// Action to perform on button push
		String f_Name = fName.getText();
		String f_PhoneNum = fPhoneNum.getText();
		String f_BirthDay = fBirthDay.getText();
		String f_EmailAddress = fEmailAddress.getText();
		
		Person newPerson = new Person(f_Name, f_PhoneNum, f_BirthDay, f_EmailAddress);

		p.add(newPerson);
		
		try {
			writeToFile(p);																	// perform write to file method
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
	}
}

public class SwingAction2 extends AbstractAction {											// perform read from file method
	public SwingAction2() {
		putValue(NAME, "Display Results");	
	}

	@Override
	public void actionPerformed(ActionEvent arg1) {
		try {
			readFile();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	}

public static void writeToFile (ArrayList<Person> p) throws IOException{											// method to write to file
	ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("People.bin"));
	
	objectOutputStream.writeObject(p);
}
public static void readFile() throws IOException, ClassNotFoundException{											//method to read from file
	ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("People.bin"));
	ArrayList<Person> q = new ArrayList<Person>();
	q = (ArrayList<Person>) objectInputStream.readObject();

	String msg = "";
	for (Person p : q) {
		msg = msg + p.toString() + "\n";
	}
	
	output.setText(msg);
}

public class SwingAction3 extends AbstractAction {																	// method that overwrites file contents with an empty array
	public SwingAction3() {
		putValue(NAME, "Erase Data");	
	}

	@Override
	public void actionPerformed(ActionEvent arg2) {
		
		p.removeAll(p);
		
		try {
			writeToFile(p);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		
	}
}

}

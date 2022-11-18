/*
 * Author: Doug Sperlak
 * Assignment: 11
 * 
 * This program takes user inputs, saves it to a file and reads back from a file when prompted.  It will also delete the contents of the file.
 */


package hw11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {
	String name;
	String phoneNum;
	String birthDay;
	String emailAddress;
	
	public Person(String name, String phoneNum, String birthDay, String emailAddress) {										// generate Person object with specific variables
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.birthDay = birthDay;
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", phoneNum=" + phoneNum + ", birthDay=" + birthDay + ", emailAddress="
				+ emailAddress + "]";
	}
	
}



public class driver {

	public static void main(String[] args) {
		
		GUI frame = new GUI();														// create the frame to display
		frame.setVisible(true);														// display the frame

	}

	
}

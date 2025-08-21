package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String Department;
	private String password;
	private String email;
	private int mailBoxCapacity=500;
	private int defaultPasswordLength= 10;
	private String alternateEmail;
	private String companySuffix = "ayecompany.com";
	
	//make constructors to fetch the values
	
	public Email(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//we called the method to return the department.
		this.Department = setDepartment();
		
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is :" +this.password);
		
		//combine the elements to generate email
		email = firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@"  + Department +  "." +"companySuffix";
		
	}
	
	
	
	private String setDepartment() {
		System.out.print("Departement code:\n1 Sales \n2 Development \n3 Accounting\n0 none\nEnter the departemnt code: " );
		Scanner sc = new Scanner(System.in);
		int deptChoice=	sc.nextInt();
		if(deptChoice==1) {return "sales";}
		else if(deptChoice==2) {return "Dev" ;}
		else if(deptChoice == 3) {return "Acct" ;}
		else {return "";}
		
	}
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%^&*";
		char[] password = new char[length];
		for(int i=0; i<length;i++) {
			int rand = (int) (Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity=capacity;
	}
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	public void changePassword(String password) {
		this.password = password;
	}
	public int getMailBoxCapacity() {return mailBoxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showDetails() {
		return "Name: "+ firstName + " " +lastName +
				"\nCompany Email: "+ email +
				"\nMailBoxCapacity: "+mailBoxCapacity + "mb";
				
	}
}

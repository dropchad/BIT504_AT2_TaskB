
public class Student {
	//Attributes
	private int id;
	private String firstName;
	private String lastName;
	public AssessmentMarks mathMarks;
	public AssessmentMarks englishMarks;
	
	//Constructor
	public Student(int id, String firstName, String lastName) {
		//constructor that sets the fields id, firstName, and lastName using the parameters provided
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//Getter and setter methods
	public String getFullName() {
		//Returns the full name of the student (first name and last name with a space in-between)
		return (firstName + " " + lastName);
	}
	
	public int getID() {
		//Returns ID
		return id;
	}
	
	public String getFirstName() {
		//Returns firstName
		return firstName;
	}
	
	public String getLastName() {
		//Returns lastName
		return lastName;
	}
}

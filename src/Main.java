import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class Main {

	// Declare the “students” list using  abstract data type LinkedList as a class field.
	public static LinkedList<Student> allStudents;
	
	//Main method
	public static void main(String[] args) {
		//Initialize the “students” list correctly
		allStudents = new LinkedList<Student>();
		
		//Call the readFile() method and provide an error message if this method returns false
		if(readFile("/Users/Jenniphoneupdate/Desktop/Assignmnet 1/studentdata.txt")) {
			//execute program
			
			while (true) {
				int choiceEntry = -1;
				//Display the menu to the user
				displayMenu();
				
				//Ask the user for input and display option based on choice selected
				choiceEntry =  selectMenuOption();
				
				switch(choiceEntry) {
				case 1:
					displayReportByMarks();
					break;
					
				case 2:
					displayReportByGrades();
					break;
					
				case 3:
					addNewStudent();
					displayReportByMarks();
					break;
					
				case 4:
					removeStudent();
					break;
					
				case 5:
					System.exit(0);
					return;
					
				default:
					System.out.println("Enter a values between 1 and 5.");
					
			}
						
			}
			
			
		}
		
	}
	
	
	public static boolean readFile(String fileName) {
		//read data file
		File file = new File(fileName);
	
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String[] words =scanner.nextLine().split(",");
				
				int id = Integer.parseInt(words[0]);
				String firstName = words[1];
				String lastName = words[2];
				int mathMark1 = Integer.parseInt(words[3]);
				int mathMark2 = Integer.parseInt(words[4]);
				int mathMark3 = Integer.parseInt(words[5]);
				int englishMark1 = Integer.parseInt(words[6]);
				int englishMark2 = Integer.parseInt(words[7]);
				int englishMark3 = Integer.parseInt(words[8]);
				
				addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
				
			}
			
			scanner.close();
		
		} 
		catch (FileNotFoundException e) { 
			System.out.println("Failed to read file");
		}
		
		return true;
		
	}
	
	private static void addStudent(int id, String firstName, String lastName,int mathMark1, int mathMark2, int mathMark3, int englishMark1, int englishMark2, int englishMark3) {
		//Creates a new Student object and call values
		Student aStudent = new Student(id, firstName, lastName);
		
		//Creates AssessmentMarks objects for Mathematics
		AssessmentMarks mathSubject = new AssessmentMarks("Math",mathMark1, mathMark2, mathMark3);
		
		//Creates AssessmentMarks objects for English
		AssessmentMarks englishSubject = new AssessmentMarks("English", englishMark1, englishMark2, englishMark3);
		
		//Assign the values to math and English marks
		aStudent.mathMarks = mathSubject;
		aStudent.englishMarks = englishSubject;
		
		//add the Student to the list of students
		allStudents.add(aStudent);
	}
	
	
	private static void displayReportByMarks() {
		//Displays a list of all the students with the student mark
		System.out.println("ID"+ "\t" + "Name"+ "\t" + ""+ "\t" + "Maths"+ "\t" + "Avg" + "\t" + "A1"+ "\t" + "A2"+ "\t" + "A3"+ "\t" + "English"+ "\t" + "Avg" + "\t" + "A1"+ "\t" + "A2"+ "\t" + "A3");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Student studentsByMark : allStudents) {
			
			
			System.out.println(studentsByMark.getID() + "\t" + studentsByMark.getFirstName() + "\t" + studentsByMark.getLastName() + "\t" + 
					studentsByMark.mathMarks.getCourseName() + "\t" + studentsByMark.mathMarks.getAverageMark() + "\t" + studentsByMark.mathMarks.getAssessment1() + "\t" + studentsByMark.mathMarks.getAssessment2() + "\t" + studentsByMark.mathMarks.getAssessment3() + "\t" + 
					studentsByMark.englishMarks.getCourseName() + "\t" + studentsByMark.englishMarks.getAverageMark() + "\t" + studentsByMark.englishMarks.getAssessment1() + "\t" + studentsByMark.englishMarks.getAssessment2() + "\t" + studentsByMark.englishMarks.getAssessment3());
		}
	}
	
	private static void displayReportByGrades() {
		//Displays a list of all the students with the student letter grades.
		System.out.println("ID"+ "\t" + "Name"+ "\t" + ""+ "\t" + "Maths"+ "\t" + "Avg" + "\t" + "A1"+ "\t" + "A2"+ "\t" + "A3"+ "\t" + "English"+ "\t" + "Avg" + "\t" + "A1"+ "\t" + "A2"+ "\t" + "A3");
		System.out.println("-----------------------------------------------------------------------------------");
		for (Student studentsByGrades : allStudents) {
			
			System.out.println(studentsByGrades.getID() + "\t" + studentsByGrades.getFirstName() + "\t" + studentsByGrades.getLastName() + "\t" + 
					studentsByGrades.mathMarks.getCourseName() + "\t" + studentsByGrades.mathMarks.getAverageGrade() + "\t" + studentsByGrades.mathMarks.getGrade(1) + "\t" + studentsByGrades.mathMarks.getGrade(2) + "\t" + studentsByGrades.mathMarks.getGrade(3) +  "\t" + 
					studentsByGrades.englishMarks.getCourseName() + "\t" + studentsByGrades.englishMarks.getAverageGrade() +  "\t" + studentsByGrades.englishMarks.getGrade(1) + "\t" + studentsByGrades.englishMarks.getGrade(2) + "\t" + studentsByGrades.englishMarks.getGrade(3));
			
		}
	}
	
	
	private static void displayMenu() {
		//Displays the menu to the user
		System.out.println("Student Report System");
		System.out.println("---------------------");
		System.out.println("1) Display student marks");
		System.out.println("2) Display student grades");
		System.out.println("3) Add a new student");
		System.out.println("4) Remove student");
		System.out.println("5) Exit");
		System.out.println();
	}
	
	private static int selectMenuOption() {
		Scanner menuScanner = new Scanner(System.in);
		int menuOptionEntered;
		
		//prompts user to enter menu option
		System.out.println("Select a menu option");
		
		    while (true) {
		       try {
		    	   menuOptionEntered = menuScanner.nextInt();
		          if(menuOptionEntered >= 1 && menuOptionEntered <= 5){
		        	//returns selected menu option
		      		return menuOptionEntered;
		           } //error message if number is outside of range
		           System.out.println("Enter a menu option betwen 1 and 5");
		 
		        } catch (InputMismatchException e) {
		        	//error message if integer not entered
		           System.out.println("You did not enter an integer. Enter a menu option betwen 1 and 5");
		           menuScanner.nextLine(); 
		        }
		       
	      }
		  
	}
	
	
	private static void addNewStudent() {
		//add a new student
		System.out.println("Add a new student");
		System.out.println("---------------------");
		Scanner scanner = new Scanner(System.in);
		
		//Asks the user to enter an ID
		System.out.println("What is the student ID?");
		int id = scanner.nextInt();
		
		//Asks the user to enter the student's first name
		System.out.println("What is the student first name?");
		String firstName = scanner.next();
		
		//Asks the user to enter the student's last name
		System.out.println("What is the student last name?");
		String lastName = scanner.next();
		
		//Asks the user to enter an Math mark 
		int mathMark1 = 0;
		System.out.print("What is the number grade for Math assignment 1?");
	      while (true) {
	         try {
	            mathMark1 = scanner.nextInt();
	            if(mathMark1 >= 0 && mathMark1 <= 100){
	              break;
	            }
	            System.out.println("Enter a grade betwen 0 and 100.");
	 
	         } catch (InputMismatchException e) {
	            System.out.println("You did not enter an integer. Enter a grade betwen 0 and 100");
	            scanner.nextLine(); 
	         }
	      }
	
	      //Asks the user to enter an Math mark 2
	      int mathMark2 = 0;
			System.out.print("What is the number grade for Math assignment 2?");
		      while (true) {
		         try {
		            mathMark2 = scanner.nextInt();
		            if(mathMark2 >= 0 && mathMark2 <= 100){
		              break;
		            }
		            System.out.println("Enter a grade betwen 0 and 100.");
		 
		         } catch (InputMismatchException e) {
		            System.out.println("You did not enter an integer. Enter a grade betwen 0 and 100");
		            scanner.nextLine(); 
		         }
		      }
		
		  //Asks the user to enter an Math mark 3
		  int mathMark3 = 0;
			System.out.print("What is the number grade for Math assignment 3?");
			    while (true) {
			       try {
			    	  mathMark3 = scanner.nextInt();
			          if(mathMark3 >= 0 && mathMark3 <= 100){
			             break;
			           }
			           System.out.println("Enter a grade betwen 0 and 100.");
			 
			        } catch (InputMismatchException e) {
			           System.out.println("You did not enter an integer. Enter a grade betwen 0 and 100");
			           scanner.nextLine(); 
			        }
		      }
		
			//Asks the user to enter an English mark 1
			int englishMark1 = 0;
				System.out.print("What is the number grade for English assignment 1?");
			      while (true) {
			         try {
			        	 englishMark1 = scanner.nextInt();
			            if(englishMark1 >= 0 && englishMark1 <= 100){
			              break;
			            }
			            System.out.println("Enter a grade betwen 0 and 100.");
				 
			         } catch (InputMismatchException e) {
			            System.out.println("You did not enter an integer. Enter a grade betwen 0 and 100");
			            scanner.nextLine(); 
			         }
		      }
		
		
			 //Asks the user to enter an English mark 2
			int englishMark2 = 0;
				System.out.print("What is the number grade for English assignment 2?");
			      while (true) {
			         try {
			        	 englishMark2 = scanner.nextInt();
			            if(englishMark2 >= 0 && englishMark2 <= 100){
			              break;
			            }
			    System.out.println("Enter a grade betwen 0 and 100.");
						 
			         } catch (InputMismatchException e) {
			            System.out.println("You did not enter an integer. Enter a grade betwen 0 and 100");
			            scanner.nextLine(); 
				     }
		      }
		
			//Asks the user to enter an English mark 3
			int englishMark3 = 0;
				System.out.print("What is the number grade for English assignment 3?");
			      while (true) {
			         try {
			        	 englishMark3 = scanner.nextInt();
				         if(englishMark3 >= 0 && englishMark3 <= 100){
				           break;
				         }
			    System.out.println("Enter a grade betwen 0 and 100.");
							 
			        } catch (InputMismatchException e) {
			        	System.out.println("You did not enter an integer. Enter a grade betwen 0 and 100");
			        	scanner.nextLine(); 
			        }
			 }
		
		//creates the appropriate objects and adds the student to the student list.
		addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
		
		
	}
	
	private static void removeStudent() {
		//removes a student based on student ID
		System.out.println("Remove student");
		System.out.println("---------------------");
		
		Scanner scanner = new Scanner(System.in);
		
		boolean testLoop = true;
		while(testLoop) {
			//Asks the user to enter an ID
			System.out.println("What is the student ID?");
			int studentId = scanner.nextInt();
			
			//removes the student with that ID in the LinkedList
			for (Student removeStudent : allStudents) {
				if(removeStudent.getID() == studentId) {
					allStudents.remove(removeStudent);
					System.out.println("User removed");
					testLoop = false;
					break;
				}
				
			}
		}
		//prints updated student list
		System.out.println("Updated List: ");
		for (Student updatedStudentList : allStudents) {
			System.out.println(updatedStudentList.getID() + "\t" + updatedStudentList.getFirstName() + "\t" + updatedStudentList.getLastName());
			}
		
		
		
	}

}

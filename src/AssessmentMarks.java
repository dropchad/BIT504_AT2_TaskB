
public class AssessmentMarks {
	//Attributes
	private String courseName;
	private int assessment1, assessment2, assessment3;
	
	//Constructor
	public AssessmentMarks(String name, int mark1, int mark2, int mark3) {
		//constructor that assigns values to name, mark1, mark2, mark3
		this.courseName = name;
		this.assessment1 = mark1;
		this.assessment2 = mark2;
		this.assessment3 = mark3;
	}
	
	//Getter and Setter
	//-----------------------------------------------------
	public void setCourseName(String name) {
		//Sets the value of courseName
		this.courseName = name;
	}
	
	public String getCourseName() {
		//Returns the value of courseName
		return courseName;
	}
	
	public int getAssessment1() {
		return assessment1;
	}
	
	public int getAssessment2() {
		return assessment2;
	}
	
	public int getAssessment3() {
		return assessment3;
	}
	
	//other methods
	//-----------------------------------------------------
	public void setMark(int assessmentNumber, int mark) {
		//set value for assessments
		
		if (assessmentNumber == 1) {
			this.assessment1 = mark;
		} else if (assessmentNumber == 2) {
			this.assessment2 = mark;
		} else {
			this.assessment3 = mark;
		}
		
	}
	
	
	public int getMark(int assessmentNumber) {
		//Returns the mark for the assessment
		if (assessmentNumber == 1) {
			return assessment1;
		} else if (assessmentNumber == 2) {
			return assessment2;
		} else {
			return assessment3;
		} 
	}
	
	
	public int getAverageMark() {
		//Returns the average mark for the course (the average of all 3 assessment marks)
		return ((assessment1 + assessment2 + assessment3)/3);
	}
	
	
	public String markToGrade(int mark) {
		//Returns the grade (A, B, C, and so on) based on the mark given
		if(mark >= 95 && mark <= 100) {
			return "A+";
		} else if (mark >= 90 && mark <= 94) {
			return "A";
		} else if (mark >= 85 && mark <= 89) {
			return "A-";
		} else if (mark >= 80 && mark <= 84) {
			return "B+";
		} else if (mark >= 75 && mark <= 79) {
			return "B";
		} else if (mark >= 70 && mark <= 74) {
			return "B-";
		} else if (mark >= 60 && mark <= 69) {
			return "C+";
		} else if (mark >= 50 && mark <= 59) {
			return "C";
		} else if (mark >= 41 && mark <= 49) {
			return "C-";
		} else {
			return "D";
		}
	}
	
	
	public String getGrade(int assessmentNumber) {
		//Returns the grade (such as A, B, C) for the assessment.
		return markToGrade(getMark(assessmentNumber));
	}
	
	
	public String getAverageGrade() {
		//Returns the average grade for the course.
		return markToGrade(getAverageMark());
	}
	
	
}


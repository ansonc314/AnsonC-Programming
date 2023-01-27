import java.util.Random;

// Teacher Class: This defines the class for storing student information
public class Student {

    String firstname; // Student First Name
    String lastname;  // Student Last Name
    String grade;  // Student Grade
    int student_number;  // Unique Student number

   static int  student_id_count = 1001;  // Next ID

    // Constructor
    Student(String first_name, String last_name, String grade) {
        this.firstname = first_name;
        this.lastname = last_name;
        this.grade = grade;
        this.student_number = student_id_count;
        student_id_count++ ;
    }

    // Setter
    public void setStudent(String first_name, String last_name, String grade) {
        this.firstname = first_name;
        this.lastname = last_name;
        this.grade = grade;
    }

    // set StudentFirstname
    public void setStudentFirstname(String first_name) {
        this.firstname = first_name;
    }

    // set StudentLastname
    public void setStudentLastname(String last_name) {
        this.lastname = last_name;
    }

    // set StudentGrade
    public void setStudentGrade(String grade) {
        this.grade = grade;
    }



    // getter - get student's first name
    public String getStudentFirstName(){
        return this.firstname;
    }

    // getter - get student's last name
    public String getStudentLastName(){
        return this.lastname;
    }

    // getter - get student's grade
    public String getStudentGrade(){
        return this.grade;
    }

    // getter - get student's ID
    public int getStudentID(){
        return this.student_number;
    }

    public String toString(){
        return "Name: "+ this.firstname + " " + this.lastname + " \tGrade: " +this.grade + "\t  Student Number: " +this.student_number;
    }


}


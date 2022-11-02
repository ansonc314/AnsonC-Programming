import java.util.ArrayList;

// Teacher Class: This defines the class for storing teacher information
public class Teacher {

    // Fields
    String firstname; // Teacher First Name
    String lastname; // Teacher Last Name
    String subject; // Teacher Subject

    // Constructor
    Teacher(){
        this.firstname = "Teacher's First Name";
        this.lastname = "Teacher's Last Name";
        this.subject = "Teacher's Subject";
    }

    Teacher(String first_name, String last_name, String subject) {
        this.firstname = first_name;
        this.lastname = last_name;
        this.subject = subject;
    }

    // setter  - set the teacher's info
    public void setTeacher(String firstname, String lastname, String subject) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.subject = subject;
    }

    // set teacher's first name
    public void setTeacherFirstName(String firstname){
        this.firstname = firstname;
    }
    // set teacher's last name
    public void setTeacherLastName(String lastname){
        this.lastname = lastname;
    }
    // set teacher's subject
    public void setTeacherSubject(String subject){
        this.subject = subject;
    }



    // getter - get teacher's first name
    public String getTeacherFirstName(){
        return this.firstname;
    }
    // get teacher's last name
    public String getTeacherLastName(){
        return this.lastname;
    }
    // get teacher's subject
    public String getTeacherSubject(){
        return this.subject;
    }


    public String toString(){
        return "Teacher: "+ this.firstname + " " + this.lastname + "\tSubject: " +this.subject;
    }





}


import java.util.ArrayList;

public class School {

    int SchoolIndex;
    String Location;
    String SchoolName;

    ArrayList<Teacher> Teacher_list= new ArrayList<>();
    ArrayList<Student> Student_list= new ArrayList<>();
    ArrayList<String> course_list= new ArrayList<>();

    // Constructor
    School(){
        this.SchoolIndex = 0;
        this.SchoolName = "My School";
        this.Location = "Vancouver";
    }
    School(int  School_index, String school_Name, String school_location){
        this.SchoolIndex = School_index;
        this.SchoolName = school_Name;
        this.Location = school_location;

    }

    // setter  - set school info
    public void set_School (int  School_index, String school_Name, String school_location) {
        this.SchoolIndex = School_index;
        this.SchoolName = school_Name;
        this.Location = school_location;
    }


    // setter  - set schoolIndex
    public void set_SchoolIndex (int  School_index ) {
        this.SchoolIndex = School_index;
    }
    // setter  - set school name
    public void set_SchoolName ( String school_Name ) {
        this.SchoolName = school_Name;
    }
    // setter  - set school location
    public void set_SchoolLocation ( String school_location) {
        this.Location = school_location;
    }


    // getter - get SchoolIndex
    public int getSchoolIndex(){
        return this.SchoolIndex;
    }

    // getter - get School name
    public String getSchoolName(){
        return this.SchoolName;
    }

    // getter - get School Location
    public String getSchoolLocation(){
        return this.Location;
    }





// Methods for Teacher List

    public void add_teacher_to_list(Teacher newTeacher) {  // Add a new teacher
        this.Teacher_list.add(newTeacher);
    }

    public void delete_teacher_from_list() {  // Delete the last teacher
        this.Teacher_list.remove(Teacher_list.size()-1);
    }

    public void displayTeacherList() {   //  Display all teacher information
        int n = this.Teacher_list.size();
        Teacher temp_teacher;
        for (int ii = 0 ;  ii <  n ; ii++  ){
            temp_teacher = this.Teacher_list.get(ii) ;
            System.out.println(temp_teacher);
        }

    }


    // Methods for Student List
    public void add_student_to_list(Student newStudent){  // add a student
        this.Student_list.add(newStudent);
    }


    public void delete_student_from_list() {  // delete the last student
        this.Student_list.remove(Student_list.size()-1);
    }



    public void displayStudentlist() {  // display student information
        int k = this.Student_list.size();
        Student temp_student;
        for (int ii = 0 ;  ii <  k ; ii++  ){
            temp_student = this.Student_list.get(ii) ;
            System.out.println(temp_student);

        }
    }



// Methods for Course List

    public void add_course_to_list(String newCourse) {  // Add a new Course
        this.course_list.add(newCourse);
    }

    public void delete_course_from_list(String newCourse) {  // Remove a course
        this.course_list.remove(course_list.size()-1);
    }

    public void displayCourseList() {   //  Display all courses information
        int n = this.course_list.size();
        String temp_course;
        for (int ii = 0 ;  ii <  n ; ii++  ){
            temp_course = this.course_list.get(ii) ;
            System.out.println(temp_course);
        }

    }





}






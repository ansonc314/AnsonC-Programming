

public class Main {
    public static void main (String[] args) {
    // Create 10 students
        Student s1  = new Student("Adam","Anka","A");
        Student s2  = new Student("Billy","Ben","B");
        Student s3  = new Student("Carol","Cat","C");
        Student s4  = new Student("Don","Denver","D");
        Student s5  = new Student("Elise","Elza","E");
        Student s6  = new Student("Fred","Frank","F");
        Student s7  = new Student("George","Guy","A");
        Student s8  = new Student("Hy","Horton","B");
        Student s9  = new Student("Icy","Ipsman","C");
        Student s10  = new Student("Jane","Joana","D");


    //  Create 3 teachers
        Teacher t1 = new Teacher("Key", "King", "Maths");
        Teacher t2 = new Teacher("Low", "Lever", "Physics");
        Teacher t3 = new Teacher("Mandy", "Ming", "Music");

    // Create a new school
        School sch = new School(1, "VLN" , "Vancouver");
    // Add 10 students to list
        sch.add_student_to_list(s1);
        sch.add_student_to_list(s2);
        sch.add_student_to_list(s3);
        sch.add_student_to_list(s4);
        sch.add_student_to_list(s5);
        sch.add_student_to_list(s6);
        sch.add_student_to_list(s7);
        sch.add_student_to_list(s8);
        sch.add_student_to_list(s9);
        sch.add_student_to_list(s10);


    // Add 3 teachers to list;
        sch.add_teacher_to_list(t1);
        sch.add_teacher_to_list(t2);
        sch.add_teacher_to_list(t3);


    // Display Student List
        sch.displayStudentlist();
    // Display Teacher List
        sch.displayTeacherList();

    // Delete two last students
        sch.delete_student_from_list();
        sch.delete_student_from_list();

    // Delete last teacher
        sch.delete_teacher_from_list();

    // Display Student List
        sch.displayStudentlist();
    // Display Teacher List
        sch.displayTeacherList();

    }

}


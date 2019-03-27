package testing;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Student;
import Model.Teacher;

import bll.StudentBll;
import bll.TeacherBll;
import Presentation.Begin;


public class testng {
    protected static final Logger LOGGER = Logger.getLogger(testng.class.getName());
    public static void main (String[] args) {

       // Student st = new Student("student", "nume", "adressa", "testStudent@yahoo.com", 25);
       // StudentBll stu = new StudentBll();
       // int ids = stu.insertStudent(st);

        //System.out.print(ids);


     //   Teacher st2 = new Teacher("nume", "student", "adressa", "testStudent@yahoo.com", 25);
      //  TeacherBll stu2 = new TeacherBll();
       // int ids2 = stu2.insertStudent(st2);

        //System.out.print(ids2);
        Begin presentation= new Begin();
    }
}
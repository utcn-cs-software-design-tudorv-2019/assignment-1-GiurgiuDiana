package Presentation;

import Model.Course;
import Model.Grades;
import Model.Student;
import bll.CourseBll;
import bll.GradesBll;
import bll.StudentBll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class TeacherStudents extends JFrame {
    public TeacherStudents(int id) {
        List<Course> st = new CourseBll().findCourseByTeacherId(id);
        ArrayList<ArrayList<Grades>> nn= new ArrayList<ArrayList<Grades>>();
        ArrayList<Course> mo = new ArrayList<Course>();
        for (Model.Course gr : st) {
            int idCourse = gr.getId();
            nn.add(new GradesBll().findStudentsByCourseId(gr.getId()));
        }
        ArrayList<Student> stu= new ArrayList<Student>();
        for (ArrayList<Model.Grades> lala : nn) {
             for (Model.Grades mod : lala) {
                 stu.add(new StudentBll().findStudentById(mod.getStudentID()));
             }
        }
        JTable t = new JTable();
        t.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID","Name", "Age", "Email"}));
        addToTable(stu, t);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(t);
        panel.add(scrollPane);
        scrollPane.setViewportView(t);
        panel.add(scrollPane);

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }


    public static void addToTable(List<Student> messags, JTable jTable) {
        for (Student message : messags) {
            ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{
                    message.getId(),message.getName(), message.getAge(), message.getEmail()});
        }

    }
}

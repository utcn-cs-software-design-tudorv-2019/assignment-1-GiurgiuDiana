package Presentation;

import Model.Course;
import Model.Grades;
import bll.CourseBll;
import bll.GradesBll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class TeacherCourses extends JFrame {

    public TeacherCourses(int id) {
       // List<Grades> st = new GradesBll().findGradesByTeacherIdAllCourses(id);

        ArrayList<Course> mo = new CourseBll().findCourseByTeacherId(id);
        JTable t = new JTable();
        t.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Class", "classID"}));
        addToTable(mo, t);
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


    public static void addToTable(List<Course> messags, JTable jTable) {
        for (Course message : messags) {
            ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{
                    message.getName(),  message.getId()});
        }

    }
}

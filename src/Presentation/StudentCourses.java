package Presentation;

import Model.Course;
import Model.Grades;
import bll.CourseBll;
import bll.GradesBll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentCourses {

    public StudentCourses(int id) {
        List<Grades> st = new GradesBll().findGradesByStudentIdAllCourses(id);

        ArrayList<Course> mo = new ArrayList<Course>();
        for (Model.Grades gr : st) {
            int idCurs = gr.getCoursesID();
            mo.add(new CourseBll().findCourseById(idCurs));
        }
        JTable t = new JTable();
        t.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Class", "TecaherID", "classID"}));
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
                    message.getName(), message.getTeacherID(), message.getId()});
        }

    }
}
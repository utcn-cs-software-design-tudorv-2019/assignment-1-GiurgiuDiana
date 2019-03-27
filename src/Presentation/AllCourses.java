package Presentation;

import Model.Course;
import Model.Teacher;
import bll.CourseBll;
import bll.TeacherBll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AllCourses extends JFrame {
    public AllCourses()
    {
        List<Course> st = new CourseBll().allCourses();

        JTable t = new JTable();
        t.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Name", "TeacherID"}));
        addToTable(st, t);
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(t);
        panel.add(scrollPane);
        scrollPane.setViewportView(t);
        panel.add(scrollPane);

        JFrame frame = new JFrame("Courses");
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }


    public static void addToTable(List<Course> messags, JTable jTable) {
        for (Course message : messags) {
            ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{
                    message.getId(),message.getName(),message.getTeacherID()});
        }


    }
}


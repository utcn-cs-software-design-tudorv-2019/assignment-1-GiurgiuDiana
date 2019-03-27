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

public class AllStudent extends JFrame {
    public AllStudent()
    {

    List<Student> st = new StudentBll().allStudents();

    JTable t = new JTable();
        t.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
            new String[]{"ID", "Name", "Age",
            "Password","email","Address"}));
    addToTable(st, t);
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
                    message.getId(),message.getName(),
                    message.getAge(),message.getPassword(),
                    message.getEmail(),message.getAddress() });
        }

    }
}

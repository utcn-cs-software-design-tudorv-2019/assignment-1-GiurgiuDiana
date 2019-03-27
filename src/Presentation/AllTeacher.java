package Presentation;

import Model.Student;
import Model.Teacher;
import bll.TeacherBll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AllTeacher extends JFrame {
        public AllTeacher(){
            List<Teacher> st = new TeacherBll().allTeacher();

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

            JFrame frame = new JFrame("all teachers");
            frame.add(panel);
            frame.setSize(500, 500);
            frame.setVisible(true);
        }


    public static void addToTable(List<Teacher> messags, JTable jTable) {
        for (Teacher message : messags) {
            ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{
                    message.getId(),message.getName(),
                    message.getAge(),message.getPassword(),
                    message.getEmail(),message.getAddress() });
        }

    }
}


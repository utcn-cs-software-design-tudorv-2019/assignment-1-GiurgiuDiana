package Presentation;

import Model.Grades;
import Model.Student;
import bll.GradesBll;
import bll.StudentBll;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AllGrades extends JFrame {
    public AllGrades()
    {
        List<Grades> st = new GradesBll().allGrades();

        JTable t = new JTable();
        t.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"idCourses", "idStudent", "Grade",
                        "Exam","Midterm","examDate","midtermDate"}));
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


    public static void addToTable(List<Grades> messags, JTable jTable) {
        for (Grades message : messags) {
            ((DefaultTableModel) jTable.getModel()).addRow(new Object[]{
                    message.getCoursesID(),message.getStudentID(),
                    message.getGrade(),message.getExam(),
                    message.getMidtermGrade(),message.getExamDate(),message.getMidtermDate() });
        }

    }

}

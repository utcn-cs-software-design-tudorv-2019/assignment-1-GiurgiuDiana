package Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Grades;
import bll.GradesBll;

public class StudentGrades extends JTable {
    JFrame frm = new JFrame("Student Courses");
    JPanel pane = new JPanel();
    //JButton viewCourses= new JButton("Student Profile");
    // JButton studentGrades= new JButton("Grades");
    //  JButton studentCourses= new JButton("Courses enrolled in");
    JButton logOut = new JButton("Logout");

    public StudentGrades(int StudentID) {
        ResultSet gr = new GradesBll().findByStudentIdRS(1);
        // System.out.println( gr);
        List<Grades> st = new GradesBll().findGradesByStudentIdAllCourses(StudentID);
        //JTable table = null;
        //try {
        //   table = new JTable(buildTableModel(gr));
        //} catch (SQLException e) {

        //e.printStackTrace();
        //}

        JTable t = new JTable();
        t.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Grade", "examDate", "MidtermDate",
                        "midtermGrade", "exam", "studentID", "coursesId"}));
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
            ((DefaultTableModel) jTable.getModel()).addRow(new Object[] {
                    message.getGrade(), message.getExamDate(),
                    message.getMidtermDate(),message.getMidtermGrade(), message.getExam(), message.getStudentID(), message.getCoursesID() });
        }

    }


}



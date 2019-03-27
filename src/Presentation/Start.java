package Presentation;

import javax.swing.*;
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
import javax.swing.table.DefaultTableModel;

public class Start extends JFrame {

    private static final long serialVersionUID = 1L;
    static JPanel pane = new JPanel();
    static JButton button_student= new JButton("student");
    static JButton button_teacher = new JButton("teacher");
    public Start()
    {
        JFrame frm= new JFrame("SINU");
        pane.setLayout(null);
        frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
        frm.setBounds(20, 20, 300,200);
       ///setting the bounds to the buttons
        button_student.setBounds(30,50,100,50);
        button_teacher.setBounds(150,50,100,50);
        ///adding button listeners
        button_student.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                logIn log= new logIn(1);
            }});
        button_teacher.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                logIn log= new logIn(0);
            }});
        ///adding to the pane
        pane.add(button_student);
        pane.add(button_teacher);
        frm.add(pane);
        frm.setVisible(true);



    }
}

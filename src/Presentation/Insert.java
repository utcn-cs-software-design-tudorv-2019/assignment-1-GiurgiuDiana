package Presentation;

import bll.StudentBll;
import bll.TeacherBll;

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

public class Insert extends JFrame  {

    JFrame frm= new JFrame("Sign up");
    JPanel pane= new JPanel();
    JButton Inserare= new JButton("Insert ");
    JButton exista= new JButton("Log in");

    public Insert()
    {
        pane.setLayout(null);
        Inserare.setBounds(300, 400,100,30);
        JLabel nume= new JLabel("Nume :");
        nume.setBounds(10,0,150,30);
        JLabel adress= new JLabel("Adresa :");
        adress.setBounds(10,170,150,30);
        JLabel email= new JLabel("Email :");
        email.setBounds(10,100,150,30);
        JLabel password=new JLabel("Password :");
        password.setBounds(10,50,150,30);
        JLabel age= new JLabel("Age :");
        age.setBounds(10,230,150,30);

        JTextField newName= new JTextField();
        newName.setBounds(10,30,100,30);
        JTextField newPass= new JTextField();
        newPass.setBounds(10,75,100,30);
        JTextField newEmail= new JTextField();
        newEmail.setBounds(10,130,100,30);
        JTextField newAdress= new JTextField();
        newAdress.setBounds(10,200,100,30);
        JTextField newAge= new JTextField();
        newAge.setBounds(10,270,100,30);
        JRadioButton tech= new JRadioButton("Teahcher");
        tech.setBounds(200,80,100,30);
        JRadioButton stu= new JRadioButton("student");
        stu.setBounds(300,80,100,30);
        ButtonGroup gr= new ButtonGroup();
        gr.add(tech);
        gr.add(stu);

        Inserare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            if(stu.isSelected()) {
                if (newAge.getText().isEmpty() && newAdress.getText().isEmpty() && newName.getText().isEmpty() && newEmail.getText().isEmpty() && newPass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Camp necompletat");
                } else {
                    Model.Student st = new Model.Student(newPass.getText(),newAdress.getText() , newName.getText(), newEmail.getText(), Integer.parseInt(newAge.getText()));
                    StudentBll ster= new StudentBll();
                    int idStudent=ster.insertStudent(st);
                    JOptionPane.showMessageDialog(null, "Idul tau este: "+idStudent);

                }
            }


            else if(tech.isSelected())
            {
                if (newAge.getText().isEmpty() && newAdress.getText().isEmpty() && newName.getText().isEmpty() && newEmail.getText().isEmpty() && newPass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Camp necompletat");
                } else {
                    Model.Teacher st = new Model.Teacher( newName.getText(),newPass.getText(), newAdress.getText(), newEmail.getText(), Integer.parseInt(newAge.getText()));
                    TeacherBll th= new TeacherBll();
                    int idTeacher= th.insertTeacher(st);
                    JOptionPane.showMessageDialog(null, "Idul tau este: "+idTeacher);

                }
            }
                frm.dispose();
            }
        });



        pane.add(tech);
       pane.add(stu);
        frm.setBounds(10,10,500,500);
        pane.add(Inserare);
        pane.add(newName);
        pane.add(newEmail);
        pane.add(newAge);
        pane.add(newAdress);
        pane.add(newPass);
        pane.add(nume);
        pane.add(adress);
        pane.add(age);
        pane.add(password);
        pane.add(email);

        frm.add(pane);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

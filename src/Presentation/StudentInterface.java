package Presentation;

import bll.TeacherBll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInterface extends JFrame{
    JFrame frame= new JFrame("Student");
    JPanel pane= new JPanel();
    JButton studentProfile= new JButton("Student Profile");
    JButton studentGrades= new JButton("Grades");
    JButton studentCourses= new JButton("Courses enrolled in");
    JButton logOut= new JButton("Logout");


    public StudentInterface(int id)
    {
        pane.setLayout(null);
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,500,400);
        Model.Student st= new bll.StudentBll().findStudentById(id);
        JLabel nume= new JLabel("Nume:"+st.getName());
        nume.setBounds(250,10,150,30);
        JLabel adress= new JLabel("Adresa:"+st.getAddress());
        adress.setBounds(250,50,150,30);
        JLabel email= new JLabel("Email:"+st.getEmail());
        email.setBounds(250,100,150,30);
        studentProfile.setBounds(10,10, 150,50);
        studentProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            StudentProfile profile= new StudentProfile(id);
        }});
        studentCourses.setBounds(10,100,150,50);
        studentCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentCourses profile = new StudentCourses(id);
            }});
        studentGrades.setBounds(10,200,150,50);
        studentGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                StudentGrades profile = new StudentGrades(id);
            }});
        logOut.setBounds(300,300,80,30);
        logOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                // Begin newB= new Begin();

            }

        });




        pane.add(nume);
        pane.add(adress);
        pane.add(email);
        pane.add(studentCourses);
        pane.add(studentGrades);
        pane.add(studentProfile);
        pane.add(logOut);
        frame.add(pane);
        frame.setVisible(true);


    }

}

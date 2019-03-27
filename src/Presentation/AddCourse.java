package Presentation;

import bll.CourseBll;
import bll.TeacherBll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourse extends JFrame {
    JFrame frm=new JFrame("Add Course");
    JPanel pane= new JPanel();
    JButton updateProfile=new JButton("Add");
    JButton logOut= new JButton("Logout");
    public AddCourse()
    {
        frm.setBounds(10,10,300,300);
        pane.setLayout(null);
        JTextField nume= new JTextField();
        JTextField teacherID= new JTextField();
       // JTextField IDcourse= new JTextField();
        JLabel numeL= new JLabel("Name");
        JLabel teacherIDL= new JLabel("TeacherID");
     //   JLabel IDcourseL= new JLabel("");
        numeL.setBounds(10,10,100,30);
        teacherIDL.setBounds(100,10,100,30);
        nume.setBounds(10,50,100,30);
        teacherID.setBounds(150,50,100,30);
        updateProfile.setBounds(150,150,100,30);
        updateProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            if(teacherID.getText().isEmpty()&& nume.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Camp necompletat");
            }
            else
            {
                TeacherBll th= new TeacherBll();
                if((th.findTeacherById(Integer.parseInt(teacherID.getText()))==null))
                {
                    JOptionPane.showMessageDialog(null, "Teacher id doesn't exist ");

                }
                else {
                    Model.Course cs = new Model.Course(nume.getText(), Integer.parseInt(teacherID.getText()));
                    CourseBll csd = new CourseBll();
                    int idCourse = csd.insertCourse(cs);
                    JOptionPane.showMessageDialog(null, "Course: " + idCourse);
                }
            }

            }});
        logOut.setBounds(200,200,100,30);
        pane.add(updateProfile);
        pane.add(logOut);
        pane.add(nume);
        pane.add(numeL);
        pane.add(teacherID);
        pane.add(teacherIDL);
        frm.add(pane);
        frm.setVisible(true);



    }

}

package Presentation;

import Model.Student;
import bll.StudentBll;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStudent extends JFrame {
    protected static final Logger LOGGER = Logger.getLogger(Begin.class.getName());

    JFrame frm=new JFrame("Student deletion");
    JPanel pane= new JPanel();
    JButton updateProfile=new JButton("delete");
    //JButton logOut= new JButton("Logout");
    public DeleteStudent()
    {

        pane.setLayout(null);
        frm.setBounds(50,50,200,200);
        JLabel student= new JLabel("Student id");
        student.setBounds(10,10,100,30);
        JTextField studentID= new JTextField();
        studentID.setBounds(10,50,100,30);
        updateProfile.setBounds(50,100,100,30);
        updateProfile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
               // Model.Student todelete= new StudentBll().findStudentById(Integer.parseInt(studentID.getText()));
                if(studentID.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"NO INPUT");
                }
                else {
                    Student cli2=new Student();
                    StudentBll std2=new StudentBll();

                    try{
                        cli2=std2.findStudentById(Integer.parseInt(studentID.getText()));
                        System.out.println(cli2);
                       int gg= new bll.GradesBll().deleteGradesStudent(Integer.parseInt(studentID.getText()));
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "id wrong");
                        LOGGER.log(Level.INFO, ex.getMessage());
                    }
                    try
                    {
                        std2.deleteStudent(cli2);
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Nu am putut sterge idul");
                        LOGGER.log(Level.INFO, ex.getMessage());
                    }
                   // int stu = new StudentBll().deleteStudent(new StudentBll().findStudentById(Integer.parseInt(studentID.getText())));
                    JOptionPane.showMessageDialog(null,"succesfully deleted student with id"+Integer.parseInt(studentID.getText()));
                    frm.dispose();
                }
            }});
                pane.add(studentID);
                pane.add(student);
                pane.add(updateProfile);
                frm.add(pane);
                frm.setVisible(true);


    }


}

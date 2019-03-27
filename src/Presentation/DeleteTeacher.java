package Presentation;

import Model.Student;
import Model.Teacher;
import bll.StudentBll;
import bll.TeacherBll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteTeacher extends JFrame {
    protected static final Logger LOGGER = Logger.getLogger(Begin.class.getName());

    JFrame frm=new JFrame("Student deletion");
    JPanel pane= new JPanel();
    JButton updateProfile=new JButton("delete");
    //JButton logOut= new JButton("Logout");
    public DeleteTeacher()
    {
        pane.setLayout(null);
        frm.setBounds(50,50,200,200);
        JLabel student= new JLabel("teacher id");
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
                    Teacher cli2=new Teacher();
                    TeacherBll std2=new TeacherBll();

                    try{
                        cli2=std2.findTeacherById(Integer.parseInt(studentID.getText()));
                        System.out.println(cli2);
                        int gg= new bll.GradesBll().deleteGradesCourse(Integer.parseInt(studentID.getText()));
                        int del= new bll.CourseBll().deleteCourseByTeacherid(Integer.parseInt(studentID.getText()));
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "id wrong");
                        LOGGER.log(Level.INFO, ex.getMessage());
                    }
                    try
                    {
                        std2.deleteTeacher(cli2);
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


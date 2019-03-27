package Presentation;

import bll.CourseBll;
import bll.StudentBll;
import bll.TeacherBll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyCourse {

        JFrame frm=new JFrame("Add Course");
        JPanel pane= new JPanel();
        JButton updateProfile=new JButton("Add");
        JButton logOut= new JButton("Logout");
        public ModifyCourse()
        {
            frm.setBounds(10,10,300,300);
            pane.setLayout(null);
            JTextField nume= new JTextField();
            JTextField teacherID= new JTextField();
            JTextField IDcourse= new JTextField();
            JLabel numeL= new JLabel("Name");
            JLabel teacherIDL= new JLabel("TeacherID");
            JLabel IDcourseL= new JLabel("IDcourse");
            numeL.setBounds(10,10,100,30);
            IDcourseL.setBounds(80,10,100,30);
            IDcourse.setBounds(100,10,100,30);
            teacherIDL.setBounds(100,10,100,30);
            nume.setBounds(10,50,100,30);
            teacherID.setBounds(150,50,100,30);
            updateProfile.setBounds(150,150,100,30);
            updateProfile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(teacherID.getText().isEmpty()&& nume.getText().isEmpty()&&IDcourse.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Camp necompletat");
                    }
                    else
                    {
                        if(!nume.getText().isEmpty())
                        {
                            int success=new CourseBll().updateCourse(Integer.parseInt(IDcourse.getText()), "name", nume.getText());
                            if (success==1)
                            {
                                JOptionPane.showMessageDialog(null,"Operatie executata cu succes");
                            }
                            else if(success==-1)
                            {
                                JOptionPane.showMessageDialog(null,"EROARE: UPDATE");

                            }
                        }
                        if(!teacherID.getText().isEmpty())
                        {
                            int success=new CourseBll().updateCourse(Integer.parseInt(IDcourse.getText()), "Teacher_idTeacher", teacherID.getText());
                            if (success==1)
                            {
                                JOptionPane.showMessageDialog(null,"Operatie executata cu succes");
                            }
                            else if(success==-1)
                            {
                                JOptionPane.showMessageDialog(null,"EROARE: UPDATE");

                            }
                        }
                    }

                }});
            logOut.setBounds(200,200,100,30);
            pane.add(updateProfile);
            pane.add(logOut);
            pane.add(nume);
            pane.add(IDcourse);
            pane.add(numeL);
            pane.add(teacherID);
            pane.add(teacherIDL);
            frm.add(pane);
            frm.setVisible(true);



        }

    }



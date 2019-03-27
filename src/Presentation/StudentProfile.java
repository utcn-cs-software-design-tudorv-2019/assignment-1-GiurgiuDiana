package Presentation;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bll.StudentBll;

public class StudentProfile {
    JFrame frm=new JFrame("Student Profile");
    JPanel pane= new JPanel();
    JButton updateProfile=new JButton("Update");
    JButton logOut= new JButton("Logout");

    public StudentProfile(int id)
    {
        pane.setLayout(null);
      //  frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
        frm.setBounds(50,50,500,400);
        Model.Student st= new bll.StudentBll().findStudentById(id);
        JLabel nume= new JLabel("Nume :"+st.getName());
        nume.setBounds(10,10,150,30);
        JLabel adress= new JLabel("Adresa :"+st.getAddress());
        adress.setBounds(10,50,150,30);
        JLabel email= new JLabel("Email :"+st.getEmail());
        email.setBounds(10,100,150,30);
        JLabel password=new JLabel("password :"+st.getPassword());
        password.setBounds(10,150,150,30);
        JLabel age= new JLabel("Age :"+st.getAge());
        age.setBounds(10,200,150,30);
        JTextField newName= new JTextField();
        newName.setBounds(200,10,150,30);
        JTextField newPass= new JTextField();
        JTextField newEmail= new JTextField();
        newEmail.setBounds(200,100,150,30);
        JTextField newAge= new JTextField();
        newAge.setBounds(200,200,150,30);
        JTextField newAdress= new JTextField();
        newAdress.setBounds(200,50,150,30);
        newPass.setBounds(200,150,150,30);
        logOut.setBounds(150,300,110,50);
        logOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                frm.dispose();
               // Begin newB= new Begin();

            }

        });
        updateProfile.setBounds(300,300,150,50);
        updateProfile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {

                if(newEmail.getText().isEmpty()&& newName.getText().isEmpty()&& newPass.getText().isEmpty()&& newAdress.getText().isEmpty()&&newAge.getText().isEmpty())
                {

                    JOptionPane.showMessageDialog(null, "Nu doresti sa modifici unul dintre campuri?");

                }
                else
                {
                    if(!newName.getText().isEmpty())
                    {
                           int success=new StudentBll().updateStudent(1, "name", newName.getText());
                           if (success==1)
                           {
                               JOptionPane.showMessageDialog(null,"Operatie executata cu succes");
                           }
                           else if(success==-1)
                           {
                               JOptionPane.showMessageDialog(null,"EROARE: UPDATE");

                           }
                    }
                    if(!newPass.getText().isEmpty())
                    {
                        int success=new StudentBll().updateStudent(1, "password", newPass.getText());
                        if (success==1)
                        {
                            JOptionPane.showMessageDialog(null,"Operatie executata cu succes");
                        }
                        else if(success==-1)
                        {
                            JOptionPane.showMessageDialog(null,"EROARE: UPDATE");

                        }
                    }
                     if(!newAdress.getText().isEmpty())
                    {
                        int success= new StudentBll().updateStudent(id, "address", newAdress.getText());
                        if (success==1)
                        {
                            JOptionPane.showMessageDialog(null,"Operatie executata cu succes");
                        }
                        else if(success==-1)
                        {
                            JOptionPane.showMessageDialog(null,"EROARE: UPDATE");

                        }
                    }
                     if(!newEmail.getText().isEmpty())
                    {
                       int st= new StudentBll().updateStudent(id, "email", newEmail.getText());
                        if (st==1)
                        {
                            JOptionPane.showMessageDialog(null,"Operatie executata cu succes");
                        }
                        else if(st==-1)
                        {
                            JOptionPane.showMessageDialog(null,"EROARE: UPDATE");

                        }
                    }

                     if(!newAge.getText().isEmpty())
                    {
                        int st= new StudentBll().updateStudent(id, "age", newAge.getText());
                        if (st==1)
                        {
                            JOptionPane.showMessageDialog(null,"Operatie executata cu succes");
                        }
                        else if(st==-1)
                        {
                            JOptionPane.showMessageDialog(null,"EROARE: UPDATE");

                        }
                    }

                }

            }});




        pane.add(logOut);
        pane.add(updateProfile);
        pane.add(nume);
        pane.add(adress);
        pane.add(email);
        pane.add(age);
        pane.add(password);
        pane.add(newName);
        pane.add(newPass);
        pane.add(newAdress);
        pane.add(newEmail);
        pane.add(newAge);
        frm.add(pane);
        frm.setVisible(true);
    }
}

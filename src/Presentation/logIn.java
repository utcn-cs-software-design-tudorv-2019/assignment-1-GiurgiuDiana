package Presentation;

import bll.StudentBll;
import bll.TeacherBll;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class logIn extends JFrame{
    static JButton logIn = new JButton("LOGIN");
    public logIn(int whoIsTryingToLogIn)
    {
        JFrame LogIn= new JFrame("Login");
        JPanel pane= new JPanel();
        pane.setLayout(null);
        logIn.setBounds(100,150,80,30);
        LogIn.setDefaultCloseOperation(LogIn.DISPOSE_ON_CLOSE);
        LogIn.setBounds(200,100,300,250);
        final JTextField userId=new JTextField("");
        userId.setBounds(100,20,120,30);
        final JTextField password= new JTextField("");
        password.setBounds(100,100,120,30);
        JLabel user= new JLabel("User ID");
        user.setBounds(10,15,50,50);
        JLabel pass= new JLabel("Password");
        pass.setBounds(10,85,80,50);

        if(whoIsTryingToLogIn==1) {
            logIn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int idul = Integer.parseInt(userId.getText());
                    String passul = password.getText();
                    int neww = new StudentBll().checkPassword(idul, passul);
                    if (neww == 0) {
                        JOptionPane.showMessageDialog(null,"Successfully logged in!");
                        StudentInterface st= new StudentInterface(idul);

                    } else if (neww == 1) {
                        JOptionPane.showMessageDialog(null,"The password is incorrect");
                    }
                }
            });
        }
        else
        {
            logIn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    int idul = Integer.parseInt(userId.getText());
                    String passul = password.getText();
                    int neww = new TeacherBll().checkPassword(idul, passul);
                    if (neww == 0) {
                        JOptionPane.showMessageDialog(null,"Successfully logged in!");
                        TeacherInterface th= new TeacherInterface(idul);

                    } else if (neww == 1) {
                        JOptionPane.showMessageDialog(null,"The password is incorrect");
                    }
                }
            });
        }


        pane.add(logIn);
        pane.add(userId);
        pane.add(user);
        pane.add(pass);
        pane.add(password);
        LogIn.add(pane);
        LogIn.setVisible(true);



    }

}

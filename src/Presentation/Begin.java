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
public class Begin extends JFrame{

    JFrame frm= new JFrame("Welcome");
    JPanel pane= new JPanel();
    JButton Inserare= new JButton("Sign up");
    public Begin() {
    JButton exista= new JButton("Log in");
        pane.setLayout(null);
        Inserare.setBounds(10, 35,100,30);
        Inserare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Insert st= new Insert();

            }});
        exista.setBounds(150, 35,100,30);
        exista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Start st= new Start();

            }});
        frm.setBounds(10,10,300,300);
        pane.add(Inserare);
        pane.add(exista);
        frm.add(pane);
        frm.setVisible(true);
    }

}

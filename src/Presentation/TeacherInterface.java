package Presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherInterface {

    JFrame frame= new JFrame("Teacher");
    JPanel pane= new JPanel();
    JButton teacherProfile= new JButton("Teacher Profile");
    JButton teacherStudents= new JButton("My Students");
    JButton teacherCourses= new JButton("My Courses");
    JButton allCourses= new JButton("All Courses");
    JButton allGrades= new JButton("All Grades");
    JButton allTeachers= new JButton("All Teachers");
    JButton allStudents= new JButton("All Students");
    JButton addCourse= new JButton("Add Course");
    JButton modCourse= new JButton("Modify Course");
    JButton deleteStudent= new JButton("Delete Student");
    JButton deleteCourse= new JButton("Delete Course");
    JButton deleteTeacher= new JButton("Delete Teacher");
    JButton deleteGradesByStudentAndCourseid= new JButton("Delete by Sudent and Course id");
    JButton addGradeOfStudent= new JButton("Add Grade of a student");
    JButton logOut= new JButton("LogOut");


    public TeacherInterface(int id)
    {
        pane.setLayout(null);
       // frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(50,50,800,700);
        Model.Teacher st= new bll.TeacherBll().findTeacherById(id);
        JLabel nume= new JLabel("Nume:"+st.getName());
        nume.setBounds(550,10,200,30);
        JLabel adress= new JLabel("Adresa:"+st.getAddress());
        adress.setBounds(550,50,200,30);
        JLabel email= new JLabel("Email:"+st.getEmail());
        email.setBounds(550,100,200,30);
        teacherProfile.setBounds(10,10, 150,50);
        teacherProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TeacherProfile profile = new TeacherProfile(id);
            }});
        teacherStudents.setBounds(10,100,150,50);
        teacherStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TeacherStudents profile = new TeacherStudents(id);
            }});
        teacherCourses.setBounds(10,200,150,50);
        teacherCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                TeacherCourses profile = new TeacherCourses(id);
            }});
        allCourses.setBounds(10,300,150,50);
        allCourses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AllCourses profile = new AllCourses();
            }});
        allTeachers.setBounds(10,400,150,50);
        allTeachers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AllTeacher profile = new AllTeacher();
            }});
        allStudents.setBounds(10,500,150,50);
        allStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AllStudent profile = new AllStudent();
            }});
        allGrades.setBounds(10,600,150,50);
        allGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AllGrades profile = new AllGrades();
            }});
        deleteStudent.setBounds(200,500,150,50);
        deleteStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DeleteStudent profile = new DeleteStudent();
            }});
        deleteCourse.setBounds(200,400,150,50);
        deleteGradesByStudentAndCourseid.setBounds(200,300,150,50);
        deleteTeacher.setBounds(370,600,150,50);
        deleteTeacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DeleteTeacher profile = new DeleteTeacher();
            }});
        addCourse.setBounds(200,600,150,50);
        addCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AddCourse profile = new AddCourse();
            }});
        logOut.setBounds(550,600,150,50);
        logOut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                // Begin newB= new Begin();
            }
        });
        modCourse.setBounds(200,200,150,50);
        modCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ModifyCourse profile = new ModifyCourse();
            }});



        pane.add(deleteStudent);
        pane.add(deleteTeacher);
        pane.add(deleteCourse);
        pane.add(deleteGradesByStudentAndCourseid);
        pane.add(addCourse);
        pane.add(modCourse);
        pane.add(nume);
        pane.add(adress);
        pane.add(email);
        pane.add(allGrades);
        pane.add(teacherProfile);
        pane.add(teacherStudents);
        pane.add(teacherCourses);
        pane.add(allCourses);
        pane.add(allStudents);
        pane.add(allTeachers);
        pane.add(logOut);
        frame.add(pane);
        frame.setVisible(true);


    }
}

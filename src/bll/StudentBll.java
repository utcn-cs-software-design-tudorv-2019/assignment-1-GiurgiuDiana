package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import DAO.GradesDAO;
import Model.Grades;
import Model.Student;
import validator.EmailValidatorStudent;
import validator.Validator;
import DAO.StudentDAO;

import javax.swing.*;

public class StudentBll {

    private List<Validator<Model.Student>> validators;

    public StudentBll() {
        validators = new ArrayList<Validator<Model.Student>>();
        validators.add(new EmailValidatorStudent());
    }

    public Model.Student findStudentById(int id) {
        Model.Student st = StudentDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return st;
    }
    public int checkPassword(int id,String password) {
        Model.Student st = StudentDAO.findById(id);
        if (st == null) {
            JOptionPane.showMessageDialog(null,"The user id doesn't exist");
            throw new NoSuchElementException("The student with id =" + id + " was not found!");

        }else
        {
            if(password.equals(st.getPassword()))
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }

    }
    public int insertStudent(Model.Student student) {
        for (Validator<Model.Student> v : validators) {
            v.validate(student);
        }
        return StudentDAO.insert(student);
    }
    public int updateStudent(int id,String whatWeWantToUpdate,String WhatValue) {
        Model.Student st = StudentDAO.findById(id);
        if (st == null) {
            JOptionPane.showMessageDialog(null,"The user id doesn't exist");
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        else
        {
            return StudentDAO.update(st, whatWeWantToUpdate, WhatValue,id);

        }
    }
    public ArrayList<Model.Student> allStudents() {
        //Model.Grades st = GradesDAO.findByStudentId(id);
        ArrayList<Student> ste= StudentDAO.allstudents();
        if (ste == null) {
            throw new NoSuchElementException("The grade with student id =" + " was not found!");
        }
        return ste;
    }
    public int deleteStudent(Model.Student ord) {

        return StudentDAO.delete(ord);
    }

}

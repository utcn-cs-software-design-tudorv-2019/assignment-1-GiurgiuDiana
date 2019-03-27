package bll;

import DAO.StudentDAO;
import DAO.TeacherDAO;
import Model.Student;
import Model.Teacher;
import validator.EmailValidatorTeacher;
import validator.Validator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TeacherBll {

    private List<Validator<Teacher>> validators;

    public TeacherBll() {
        validators = new ArrayList<Validator<Teacher>>();
        validators.add(new EmailValidatorTeacher());
    }

    public Model.Teacher findTeacherById(int id) {
        Model.Teacher st = TeacherDAO.findById(id);
        if (st == null) {
            JOptionPane.showMessageDialog(null, "Teacher id doesn't exist ");
            throw new NoSuchElementException("The teacher with id =" + id + " was not found!");
        }
        return st;
    }
    public int updateTeacher(int id,String whatWeWantToUpdate,String WhatValue) {
        Model.Teacher st = TeacherDAO.findById(id);
        if (st == null) {
            JOptionPane.showMessageDialog(null,"The user id doesn't exist");
            throw new NoSuchElementException("The teacher with id =" + id + " was not found!");
        }
        else
        {
            return TeacherDAO.updateTeacher(st, whatWeWantToUpdate, WhatValue,id);
        }
    }
    public int checkPassword(int id,String password) {
        Model.Teacher st = TeacherDAO.findById(id);
        if (st == null) {
            JOptionPane.showInputDialog("The user id doesn't exist");
            throw new NoSuchElementException("The student with id =" + id + " was not found!");

        } else {
            if (password.equals(st.getPassword())) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    public ArrayList<Model.Teacher> allTeacher() {
        //Model.Grades st = GradesDAO.findByStudentId(id);
        ArrayList<Teacher> ste= TeacherDAO.allteacher();
        if (ste == null) {
            throw new NoSuchElementException("The teacher list was not found" + " was not found!");
        }
        return ste;
    }

    public int insertTeacher(Model.Teacher student) {
        for (Validator<Model.Teacher> v : validators) {
            v.validate(student);
        }
        return TeacherDAO.insert(student);
    }
    public int deleteTeacher(Teacher ord) {
        for (Validator<Teacher> v : validators) {
            v.validate(ord);
        }
        return TeacherDAO.delete(ord);
    }
}

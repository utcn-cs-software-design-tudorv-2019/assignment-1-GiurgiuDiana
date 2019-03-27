package bll;

import DAO.CourseDAO;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import Model.Course;
import Model.Student;
import Model.Teacher;
import validator.EmailValidatorStudent;
import validator.Validator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseBll {

    private List<Validator<Course>> validators;

    public CourseBll() {
        validators = new ArrayList<Validator<Course>>();
    }

    public Model.Course findCourseById(int id) {
        Model.Course st = CourseDAO.findById(id);
        if (st == null) {
            throw new NoSuchElementException("The course with id =" + id + " was not found!");
        }
        return st;
    }
    public ArrayList<Model.Course> findCourseByTeacherId(int id) {
        ArrayList<Model.Course> st  = CourseDAO.findByTeacherId(id);
        if (st == null) {
            throw new NoSuchElementException("The course with id =" + id + " was not found!");
        }
        return st;
    }


    public int updateCourse(int id,String whatWeWantToUpdate,String WhatValue) {
        Model.Course st = CourseDAO.findById(id);
        if (st == null) {
            JOptionPane.showMessageDialog(null,"The course id doesn't exist");
            throw new NoSuchElementException("The course with id =" + id + " was not found!");
        }
        else
        {
            return CourseDAO.update(st, whatWeWantToUpdate, WhatValue,id);

        }
    }
    public int deleteCourse(Course ord) {
        for (Validator<Course> v : validators) {
            v.validate(ord);
        }
        return CourseDAO.delete(ord);
    }

    public int deleteCourseByTeacherid(int ord) {

        return CourseDAO.deleteTeacherid(ord);
    }


    public int insertCourse(Model.Course student) {
        for (Validator<Model.Course> v : validators) {
            v.validate(student);
        }
        return CourseDAO.insert(student);
    }
    public ArrayList<Model.Course> allCourses() {
        //Model.Grades st = GradesDAO.findByStudentId(id);
        ArrayList<Course> ste= CourseDAO.allcourses();
        if (ste == null) {
            throw new NoSuchElementException("The teacher list was not found" + " was not found!");
        }
        return ste;
    }

}

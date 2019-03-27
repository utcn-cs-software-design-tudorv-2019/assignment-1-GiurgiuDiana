package bll;

import DAO.GradesDAO;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import Model.Grades;
import Model.Student;
import Model.Teacher;
import validator.EmailValidatorTeacher;
import validator.Validator;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GradesBll {
    private List<Validator<Grades>> validators;

    public GradesBll() {
        validators = new ArrayList<Validator<Grades>>();
    }

    public Model.Grades findGradesByCourseId(int id) {
        Model.Grades st = GradesDAO.findByCoursesId(id);
        if (st == null) {
            throw new NoSuchElementException("The grade with course id =" + id + " was not found!");
        }
        return st;
    }

    public ArrayList<Model.Grades> allGrades() {
        //Model.Grades st = GradesDAO.findByStudentId(id);
        ArrayList<Grades> ste= GradesDAO.allgrades();
        if (ste == null) {
            throw new NoSuchElementException("The grades list was not found" + " was not found!");
        }
        return ste;
    }
    public ArrayList<Model.Grades> findStudentsByCourseId(int id) {
        //Model.Grades st = GradesDAO.findByStudentId(id);
        ArrayList<Model.Grades> ste= GradesDAO.findStudentsbyCourseid(id);
        if (ste == null) {
            throw new NoSuchElementException("The students list was not found" + " was not found!");
        }
        return ste;
    }

    public Model.Grades findGradesByStudentId(int id) {
        Model.Grades st = GradesDAO.findByStudentId(id);
        ArrayList<Grades> ste= GradesDAO.findByStudentIdAllCourses(id);
        if (st == null) {
            throw new NoSuchElementException("The grade with student id =" + id + " was not found!");
        }
        return st;
    }
    public ResultSet findByStudentIdRS(int id) {
       ResultSet st = GradesDAO.findByStudentIdRS(id);
        ArrayList<Grades> ste= GradesDAO.findByStudentIdAllCourses(id);
        if (st == null) {
            throw new NoSuchElementException("The grade with student id =" + id + " was not found!");
        }
        return st;
    }
    public ArrayList<Model.Grades> findGradesByStudentIdAllCourses(int id) {
        //Model.Grades st = GradesDAO.findByStudentId(id);
        ArrayList<Grades> ste= GradesDAO.findByStudentIdAllCourses(id);
        if (ste == null) {
            throw new NoSuchElementException("The grade with student id =" + id + " was not found!");
        }
        return ste;
    }


    public int insertGrades(Model.Grades grade) {
        for (Validator<Grades> v : validators) {
            v.validate(grade);
        }
        return GradesDAO.insert(grade);
    }
    public int deleteGrades(int course, int student) {
        return GradesDAO.delete(course,student);
    }
    public int deleteGradesStudent(int student)
    {
        return GradesDAO.deleteStudent(student);
    }
    public int deleteGradesCourse(int student) {
        return GradesDAO.deleteCourse(student);
    }


}

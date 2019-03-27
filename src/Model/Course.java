package Model;

import javax.swing.*;
import java.util.Date;

public class Course {
    private int id;
    private String name;
    private int teacherID;

    public Course(int id, String name, int teacherID) {
        this.id = id;
        this.name = name;
        this.teacherID = teacherID;
    }

    public Course( String nume,int  teacherID) {
        this.name = nume;
        this.teacherID = teacherID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherID=" + teacherID +
                '}';
    }
}
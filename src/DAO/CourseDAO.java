package DAO;
import ConnectionFactory.ConnectionFactory;
import Model.Course;
import Model.Student;
import Model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CourseDAO {
    protected static final Logger LOGGER = Logger.getLogger(CourseDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO courses ( name,Teacher_idTeacher)"
            + " VALUES (?,?)";
    private final static String findStatementString = "SELECT * FROM courses where idCourses= ?";
    private final static String findStatementStringTeacher = "SELECT * FROM courses where Teacher_idTeacher= ?";
    private final static String operationStatementString="UPDATE";
    private final static String tableStatementString="Courses";
    private final static String setStatementString="set";
    private static String whatWeUpdateStatementString="";
    private final static String equalStatementString="=";
    private static String ValueOFUpdateStatementString="";
    private final static String whereStatementString="where";
    private final static String idStatementString="idCourses=";
    private static String IDvalueStatementString="";
    private static final String deleteStatementString = "DELETE FROM Courses WHERE idCourses =?";
    private static final String deleteStatementStringTeacherid="DELETE FROM Courses WHERE Teacher_idTeacher =?";
    public static Model.Course findById(int courseId) {
        Model.Course toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, courseId);
            rs = findStatement.executeQuery();
            rs.next();

            // String idStudent=rs.getString(1,"idStudent");
            String name = rs.getString("name");
            int teacherID = rs.getInt("Teacher_idTeacher");
            toReturn = new Model.Course(courseId,name,teacherID);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"CourseDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }


    public static ArrayList<Model.Course> findByTeacherId(int courseId) {
        Model.Course toReturn = null;
        ArrayList<Model.Course> lista= new ArrayList<Course>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringTeacher);
            findStatement.setLong(1, courseId);
            rs = findStatement.executeQuery();
          while(rs.next()) {

              // String idStudent=rs.getString(1,"idStudent");
              String name = rs.getString("name");
              int Courseid = rs.getInt("idCourses");
              toReturn = new Model.Course(Courseid, name, courseId);
              lista.add(toReturn);
          }
            System.out.println(lista);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"CourseDAO:findByTeaxherId " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return lista;
    }

    public static int update(Model.Course client,String whatWeWantToUpdate, String WhatValue,int id)
    {
        PreparedStatement  updateSales =null;
        Connection dbConnection = ConnectionFactory.getConnection();
        whatWeUpdateStatementString=whatWeWantToUpdate;
        ValueOFUpdateStatementString=WhatValue;
        // IDvalueStatementString"=client.getId();
        String updateStatementString =operationStatementString+" "+tableStatementString+" "+setStatementString+" "+whatWeUpdateStatementString+" "+equalStatementString
                +" "+"?"+" "+whereStatementString+" "+idStatementString+"?"+";";

        PreparedStatement insertStatement = null;
        System.out.println(updateStatementString);
        System.out.println(updateSales);
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
            if(whatWeWantToUpdate=="name")
            {
                System.out.println(client.getName()+ client.getId());
                client.setName(WhatValue);
                insertStatement.setString(1, client.getName());
                insertStatement.setInt(2,id);
                insertedId=1;
            }
            else if(whatWeWantToUpdate=="Teacher_idTeacher")
            {
                client.setTeacherID(Integer.parseInt(WhatValue));
                insertStatement.setInt(1, client.getTeacherID());
                insertStatement.setInt(2,id);
                insertedId=1;

            }

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "CourseDAO:UPDATE" + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;

    }

    public static int insert(Model.Course COURSE) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, COURSE.getName());
            insertStatement.setInt(2, COURSE.getTeacherID());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "CourseDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }


    public static ArrayList<Course> allcourses() {
        Model.Course toReturn = null;
        ArrayList<Model.Course> lista= new ArrayList<Course>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement("SELECT * FROM Courses");
            // findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            while(rs.next()) {

                int idStudent=rs.getInt("idCourses");
                //String password=rs.getString("password");
                String name = rs.getString("name");
               // String address = rs.getString("address");
             //   String email = rs.getString("email");
                int Teacher_idTeacher = rs.getInt("Teacher_idTeacher");
                toReturn = new Model.Course(idStudent,name,Teacher_idTeacher);
                lista.add(toReturn);

            }
            System.out.println(lista);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"courses dao:all courses " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return lista;
    }
    public static int delete(Course client) {
        Connection dbConnection = ConnectionFactory.getConnection();
        System.out.println(deleteStatementString);
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client.getId());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "CourseDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    public static int deleteTeacherid(int client) {
        Connection dbConnection = ConnectionFactory.getConnection();
        System.out.println(deleteStatementStringTeacherid);
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(deleteStatementStringTeacherid, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, client);
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "CourseDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

}

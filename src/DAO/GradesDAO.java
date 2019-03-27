package DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Grades;
import Model.Student;
import Model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GradesDAO {
    protected static final Logger LOGGER = Logger.getLogger(GradesDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO grades (idCourses,idStudent, grade,exam,midterm,examdate ,midtermdate)"
            + " VALUES (?,?,?,?,?,?,?)";
    private final static String findStatementStringStudent = "SELECT * FROM grades where idStudent = ?";
    private final static String findStatementStringCourses = "SELECT * FROM grades where idCourses = ?";
    private final static String deleteStatementString="DELETE FROM GRADES WHERE  idCourses=? AND idStudent=?";
    private final static String deleteStatementStringStudent="DELETE FROM GRADES WHERE idStudent=?";
    private final static String deleteStatementStringCourse="DELETE FROM GRADES WHERE idCourses=?";

    public static Model.Grades findByStudentId(int studentId) {
        Model.Grades toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringStudent);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            rs.next();

            // String idStudent=rs.getString(1,"idStudent");
            int idCourse=rs.getInt("idCourses");
            int grade = rs.getInt("Grade");
            int exam = rs.getInt("Exam");
            int midterm = rs.getInt("Midterm");
            Date midtermdate = rs.getDate("midtermDate");
            Date examdate = rs.getDate("examDate");
            toReturn = new Model.Grades(grade,examdate,midtermdate,midterm,exam,studentId,idCourse);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"GradesDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }
    public static ResultSet findByStudentIdRS(int studentId) {
        Model.Grades toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringStudent);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            rs.next();

            // String idStudent=rs.getString(1,"idStudent");
            int idCourse=rs.getInt("idCourses");
            int grade = rs.getInt("Grade");
            int exam = rs.getInt("Exam");
            int midterm = rs.getInt("Midterm");
            Date midtermdate = rs.getDate("midtermDate");
            Date examdate = rs.getDate("examDate");
            toReturn = new Model.Grades(grade,examdate,midtermdate,midterm,exam,studentId,idCourse);


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"GradesDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return rs;
    }

    public static ArrayList<Grades> findByStudentIdAllCourses(int studentId) {
        Model.Grades toReturn = null;
        ArrayList<Grades> lista= new ArrayList<Grades>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringStudent);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
           while(rs.next()) {

               // String idStudent=rs.getString(1,"idStudent");
               int idCourse = rs.getInt("idCourses");
               int grade = rs.getInt("Grade");
               int exam = rs.getInt("Exam");
               int midterm = rs.getInt("Midterm");
               Date midtermdate = rs.getDate("midtermDate");
               Date examdate = rs.getDate("examDate");
               toReturn = new Model.Grades(grade, examdate, midtermdate, midterm, exam, studentId, idCourse);
               lista.add(toReturn);

           }
            System.out.println(lista);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"GradesDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return lista;
    }
    //public static Model.Grades findAllByStudentID


    public static Model.Grades findByCoursesId(int courseId) {
        Model.Grades toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementStringCourses);
            findStatement.setLong(1, courseId);
            rs = findStatement.executeQuery();
            rs.next();

            // String idStudent=rs.getString(1,"idStudent");
            int idStudent=rs.getInt("idStudent");
            int grade = rs.getInt("Grade");
            int exam = rs.getInt("Exam");
            int midterm = rs.getInt("Midterm");
            Date midtermdate = rs.getDate("midtermDate");
            Date examdate = rs.getDate("examDate");
            toReturn = new Model.Grades(grade,examdate,midtermdate,midterm,exam,idStudent,courseId);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"GradesDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }



    public static int insert(Model.Grades grades) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1, grades.getStudentID());
            insertStatement.setInt(2, grades.getCoursesID());
            insertStatement.setInt(3, grades.getGrade());
            insertStatement.setInt(4, grades.getExam());
            insertStatement.setInt(5, grades.getMidtermGrade());
            insertStatement.setDate(6, grades.getMidtermDate());
            insertStatement.setDate(7, grades.getExamDate());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Grades:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static ArrayList<Grades> allgrades() {
        Model.Grades toReturn = null;
        ArrayList<Model.Grades> lista= new ArrayList<Grades>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement("SELECT * FROM Grades");
            // findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            while(rs.next()) {

                int idStudent=rs.getInt("idStudent");
                int idCourse=rs.getInt("idCourses");
                int Grade=rs.getInt("Grade");
                int Exam=rs.getInt("Exam");
                int Midterm=rs.getInt("Midterm");
                Date examDate=rs.getDate("examDate");
                Date midtermDate=rs.getDate("midtermDate");
                //String password=rs.getString("password");
                //String name = rs.getString("name");
                //String address = rs.getString("address");
               // String email = rs.getString("email");
               // int age = rs.getInt("age");
                toReturn = new Model.Grades(Grade, examDate,midtermDate,Midterm,Exam,idStudent,idCourse);
                lista.add(toReturn);

            }
            System.out.println(lista);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"GRADEDAO:all grades " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return lista;
    }


    public static ArrayList<Grades> findStudentsbyCourseid(int course) {
        Model.Grades toReturn = null;
        ArrayList<Model.Grades> lista= new ArrayList<Grades>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement("SELECT * FROM Grades WHERE idCourses=?");
             findStatement.setLong(1, course);
            rs = findStatement.executeQuery();
            while(rs.next()) {

                int idStudent=rs.getInt("idStudent");
             //   int idCourse=rs.getInt("idCourses");
                int Grade=rs.getInt("Grade");
                int Exam=rs.getInt("Exam");
                int Midterm=rs.getInt("Midterm");
                Date examDate=rs.getDate("examDate");
                Date midtermDate=rs.getDate("midtermDate");
                //String password=rs.getString("password");
                //String name = rs.getString("name");
                //String address = rs.getString("address");
                // String email = rs.getString("email");
                // int age = rs.getInt("age");
                toReturn = new Model.Grades(Grade, examDate,midtermDate,Midterm,Exam,idStudent,course);
                lista.add(toReturn);

            }
            System.out.println(lista);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"GRADEDAO:all grades " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return lista;
    }
    public static int delete(int CourseID,int studentID) {
        Connection dbConnection = ConnectionFactory.getConnection();
        System.out.println(deleteStatementString);
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,CourseID );
            insertStatement.setInt(2,studentID );
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GradesDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    public static int deleteStudent(int CourseID) {
        Connection dbConnection = ConnectionFactory.getConnection();
        System.out.println(deleteStatementStringStudent);
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(deleteStatementStringStudent, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,CourseID );
            //insertStatement.setInt(2,studentID );
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GradesDAOstudent delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    public static int deleteCourse(int CourseID) {
        Connection dbConnection = ConnectionFactory.getConnection();
        System.out.println(deleteStatementStringCourse);
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(deleteStatementStringCourse, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setInt(1,CourseID );
            //insertStatement.setInt(2,studentID );
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "GradesDAocourse delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

}

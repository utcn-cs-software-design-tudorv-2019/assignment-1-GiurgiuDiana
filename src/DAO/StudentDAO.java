package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConnectionFactory.ConnectionFactory;
import Model.Grades;
import Model.Student;

public class StudentDAO {
    protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO student ( password, address, name,email ,age)"
            + " VALUES (?,?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM student where idStudent = ?";
    private final static String operationStatementString="UPDATE";
    private final static String tableStatementString="student";
    private final static String setStatementString="set";
    private static String whatWeUpdateStatementString="";
    private final static String equalStatementString="=";
    private static String ValueOFUpdateStatementString="";
    private final static String whereStatementString="where";
    private final static String idStatementString="idStudent=";
    private static String IDvalueStatementString="";
    private static final String deleteStatementString = "DELETE FROM student WHERE idStudent = ?";

    public static Model.Student findById(int studentId) {
        Model.Student toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            rs.next();

           // String idStudent=rs.getString(1,"idStudent");
            String password=rs.getString("password");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            toReturn = new Model.Student(studentId,password, address, name,email ,age);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"StudentDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    public static ArrayList<Model.Student> allstudents() {
        Model.Student toReturn = null;
        ArrayList<Model.Student> lista= new ArrayList<Student>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement("SELECT * FROM STUDENT");
           // findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            while(rs.next()) {

                 int idStudent=rs.getInt("idStudent");
                String password=rs.getString("password");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                toReturn = new Model.Student(idStudent,password, name,address,email ,age);
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


    public static int insert(Model.Student student) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(3, student.getName());
            insertStatement.setString(2, student.getAddress());
            insertStatement.setString(4, student.getEmail());
            insertStatement.setInt(5, student.getAge());
            insertStatement.setString(1,student.getPassword());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    public static int update(Model.Student client,String whatWeWantToUpdate, String WhatValue,int id)
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
            else if(whatWeWantToUpdate=="email")
            {
                client.setEmail(WhatValue);
                insertStatement.setString(1, client.getEmail());
                insertStatement.setInt(2,id);
                insertedId=1;

            }
            else if(whatWeWantToUpdate=="password")
            {
                client.setPassword(WhatValue);
                insertStatement.setString(1, client.getPassword());
                insertStatement.setInt(2,id);
                insertedId=1;

            }
            else if(whatWeWantToUpdate=="age")
            {
                client.setAge(Integer.parseInt(WhatValue));
                insertStatement.setInt(1, client.getAge());
                insertStatement.setInt(2,id);
                insertedId=1;

            }
            else if(whatWeWantToUpdate=="address")
            {
                client.setAddress((WhatValue));
                insertStatement.setString(1, client.getAddress());
                insertStatement.setInt(2,id);
                insertedId=1;

            }
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "STUDENTDAO:UPDATE" + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }

        return insertedId;

    }
    public static int delete(Student client) {
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
            LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

}

package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import ConnectionFactory.ConnectionFactory;
import Model.Student;
import Model.Teacher;

public class TeacherDAO {
    protected static final Logger LOGGER = Logger.getLogger(TeacherDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO teacher ( name,password, address,email ,age)"
            + " VALUES (?,?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM teacher where  idTeacher= ?";
    private final static String operationStatementString="UPDATE";
    private final static String tableStatementString="Teacher";
    private final static String setStatementString="set";
    private static String whatWeUpdateStatementString="";
    private final static String equalStatementString="=";
    private static String ValueOFUpdateStatementString="";
    private final static String whereStatementString="where";
    private final static String idStatementString="idTeacher=";
    private static String IDvalueStatementString="";
    private static final String deleteStatementString = "DELETE FROM Teacher WHERE idTeacher =?";


    public static Model.Teacher findById(int teacherId) {
        Model.Teacher toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, teacherId);
            rs = findStatement.executeQuery();
            rs.next();

            // String idStudent=rs.getString(1,"idStudent");
            String password=rs.getString("password");
            String name = rs.getString("name");
            String address = rs.getString("address");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            toReturn = new Model.Teacher(teacherId,name,password, address,email ,age);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"TeacherDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }


    public static int insert(Model.Teacher teacher) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, teacher.getName());
            insertStatement.setString(3, teacher.getAddress());
            insertStatement.setString(4, teacher.getEmail());
            insertStatement.setInt(5, teacher.getAge());
            insertStatement.setString(2,teacher.getPassword());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "TeacherDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }
    public static int updateTeacher(Model.Teacher client,String whatWeWantToUpdate, String WhatValue, int id)
    {
        PreparedStatement  updateSales =null;
        Connection dbConnection = ConnectionFactory.getConnection();
        whatWeUpdateStatementString=whatWeWantToUpdate;
        ValueOFUpdateStatementString=WhatValue;
      //  IDvalueStatementString=IDValue;
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
            LOGGER.log(Level.WARNING, "TeacherDAO:UPDATE" + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    public static ArrayList<Teacher> allteacher() {
        Model.Teacher toReturn = null;
        ArrayList<Model.Teacher> lista= new ArrayList<Teacher>();
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement("SELECT * FROM TEACHER");
            // findStatement.setLong(1, studentId);
            rs = findStatement.executeQuery();
            while(rs.next()) {

                int idStudent=rs.getInt("idTeacher");
                String password=rs.getString("password");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                toReturn = new Model.Teacher(idStudent,name,password,address,email ,age);
                lista.add(toReturn);

            }
            System.out.println(lista);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"TeacherDAO:all teachers " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return lista;
    }
    public static int delete(Teacher client) {
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
            LOGGER.log(Level.WARNING, "TeacherDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }


}


package org.jboss.tools.examples.data;

import org.jboss.tools.examples.model.LoginBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginDAO {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;
        
     //   try ("java:jboss/datasources/MySqlDS");
       //         .getConnection("jdbc:mysql://localhost:3306/members?useSSL=false", "root", "Steelers01!");
        	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/members?useSSL=false", "root", "Steelers01!");
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection
                .prepareStatement("select * from login where username = ? and password = ? ")) {
                preparedStatement.setString(1, loginBean.getUsername());
                preparedStatement.setString(2, loginBean.getPassword());

                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                status = rs.next();
   
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }                               
	}
}
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

import java.sql.*;
import java.util.*;

public class KerberosJDBCClient {
  public static void main(String[] args) {
    String connUrl = "jdbc:sqlserver://dvvrpw01.devadmin.nbsdev.co.uk:1433;databaseName=NBS_OB;trustServerCertificate=true;integratedSecurity=true;authenticationScheme=JavaKerberos";
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection conn = DriverManager.getConnection(connUrl);
      Statement statement = conn.createStatement();
      ResultSet resultSet = statement.executeQuery("select auth_scheme from sys.dm_exec_connections where session_id=@@spid");
      while (resultSet.next()) {
        System.out.println("Authentication Scheme is " + resultSet.getString(1));
      }
    }
    catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}

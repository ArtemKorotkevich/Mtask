package by.mbicycle.TestTasks.jdbsTask.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSingleton {
  static Connection connection;

  private  ConnectionSingleton() {
  }
  public static Connection getDBConnection(){
    String URL = "jdbc:mysql://localhost:3306/mtask?&amp;allowMultiQueries=true";
    String User = "root";
    String Pass = "root";

    try{
      if(connection == null){
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, User, Pass);
      }
    }catch(Exception e){
      e.printStackTrace();
    }
    return connection;
  }


}

package by.mbicycle.TestTasks.jdbsTask;

import java.sql.SQLException;
import java.util.Scanner;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.HelperDB;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.DBWriter;

public class Runner {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    HelperDB helperDB = new HelperDB();
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    System.out.println(": \n1.ShowWriter ");
    int num = scanner.nextInt();
    if(num == 1){
      DBWriter dbWriter = new DBWriter();
      dbWriter.getWriters();
      helperDB.close();
    }
    
  }

}

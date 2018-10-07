package by.mbicycle.TestTasks.jdbsTask;

import java.sql.SQLException;
import java.util.Scanner;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.HelperDB;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.DBBooks;
import by.mbicycle.TestTasks.jdbsTask.interlayerDAO.DBWriter;

public class Runner {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    HelperDB helperDB = new HelperDB();
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);
    System.out.println("menu: \n1.ShowWriter \n2. ShowBoks \n3. Showlibery");
    int num = scanner.nextInt();
    if(num == 1){
      DBWriter dbWriter = new DBWriter();
      dbWriter.getWriters();
      helperDB.close();
    }
    else if (num == 3) {
      String LastName = scanner.next();
      DBBooks books = new DBBooks();
      books.getBooksWriter(LastName);
      helperDB.close();
    }
    
    
  }

}

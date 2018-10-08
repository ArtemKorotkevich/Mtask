package by.mbicycle.TestTasks.jdbsTask.interlayerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import by.mbicycle.TestTasks.jdbsTask.beans.Writers;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.ConnectionSingleton;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.HelperDB;
import by.mbicycle.TestTasks.jdbsTask.exception.DAOException;
import by.mbicycle.TestTasks.jdbsTask.factory.WriterFactory;

public class DBWriter implements IDaoWriter {

  private final Connection connection;

  public DBWriter() {
    this.connection = ConnectionSingleton.getDBConnection();
  }

  @Override
  public List<Writers> getWriters() throws DAOException {
    String query = "SELECT * FROM mtask.writer;";
    ResultSet rs = null;
    List<Writers> writersList = new ArrayList<>();
    try{
      rs = connection.createStatement().executeQuery(query);
      while(rs.next()){
        writersList.add(WriterFactory.getWritersFromFactory(rs.getInt("idwriter"), rs.getString("lastName"), rs.getString("firstName"), rs.getString("birthday")));
      }
      System.out.println(writersList);
      return writersList;
    }catch(SQLException e){
      throw new DAOException(e);
    }finally {
      HelperDB.closeResultSet(rs);
    }
  }

  @Override
  public boolean addWriter(Writers writers) throws DAOException {
    String InsertQeryForWriter = "insert into mtask.writer"
        + "(lastName, firstName, birthday)"
        + "values(?,?,?);";
    PreparedStatement ps = null;
    try{
      ps = ConnectionSingleton.getDBConnection().prepareStatement(InsertQeryForWriter);
      synchronized (ps) {
        ps.setString(1, writers.getLastName());
        ps.setString(2, writers.getLastName());
        ps.setString(3, writers.getBirthday());
        return ps.execute();
      }
    }catch(SQLException e){
      throw new DAOException(e);
    }
  }
  public static Writers returnWriters(){
    Scanner scanner = new Scanner(System.in);
    while(scanner.hasNext()){
      System.out.println("lastname");
      String lastname =  scanner.next();
      System.out.println("name");
      String name = scanner.next();
      System.out.println("Birthday");
      String birthday = scanner.next();

      return new Writers(lastname, name, birthday);
    }
    return returnWriters();

  }
}

package by.mbicycle.TestTasks.jdbsTask.interlayerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.mbicycle.TestTasks.jdbsTask.beans.Writers;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.ConnectionSingleton;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.HelperDB;
import by.mbicycle.TestTasks.jdbsTask.exception.DAOException;
import by.mbicycle.TestTasks.jdbsTask.factory.WriterFactory;

public class DBWriter implements IDaoWriter {
  
  private final Connection connection;
  private static final Object LOCK = new Object();
  
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
  public boolean setWriter(Writers writers) throws DAOException {
    return false;
  }

}

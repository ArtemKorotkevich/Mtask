package by.mbicycle.TestTasks.jdbsTask.interlayerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.mbicycle.TestTasks.jdbsTask.beans.Books;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.ConnectionSingleton;
import by.mbicycle.TestTasks.jdbsTask.connectionDB.HelperDB;
import by.mbicycle.TestTasks.jdbsTask.exception.DAOException;
import by.mbicycle.TestTasks.jdbsTask.factory.BookFactory;

public class DBBooks implements IDaoBooks {
 private final Connection connection;
 
 public DBBooks(){
   this.connection = ConnectionSingleton.getDBConnection();
 }
  
  @Override
  public List<Books> getBooks() throws DAOException {
    String query = "SELECT * FROM mtask.book;";
    ResultSet rs = null;
    List<Books> booksList = new ArrayList<>();
    try{
      rs = connection.createStatement().executeQuery(query);
      while(rs.next()){
        booksList.add(BookFactory.getBooksFromFactory(rs.getInt("idbook"),rs.getInt("idwriter"), 
            rs.getString("name"), rs.getString("printData"), rs.getString("printingHouse"), rs.getString("printingHouse")));
      }
      System.out.println(booksList);
      return booksList;
    }catch(SQLException e){
      throw new DAOException(e);
    }finally {
      HelperDB.closeResultSet(rs);
    }
  }

  @Override
  public boolean addBooks(Books books) throws DAOException {
    String InsertQeryForBook = "insert into mtask.book"
        + "('idwriter','name','PrintData','printingHouse','description')"
        + "values(?,?,?,?,?);";
    PreparedStatement ps = null;
    try{
      ps=connection.prepareStatement(InsertQeryForBook);
      synchronized (ps) {
        ps.setInt(1, books.getWritersId());
        ps.setString(2, books.getName());
        ps.setString(3, books.getPrintData());
        ps.setString(4, books.getPrintHouse());
        ps.setString(5, books.getDescription());
        return ps.execute();
      }
    }catch (SQLException e){
      throw new DAOException(e);
    }
  }
  public List<Books> getBooksWriter(String LastName){
    List<Books>bookList = new ArrayList<>();
    String query = "SELECT * FROM mtask.book where idwriter = (SELECT idwriter FROM mtask.writer where lastName=\"" + LastName.trim() + "\");";
    ResultSet rs = null;
    try{
      rs = connection.createStatement().executeQuery(query);
      while(rs.next()){
        bookList.add(BookFactory.getBooksFromFactory(rs.getInt("idbook"), rs.getInt("idwriter"),
            rs.getString("name"), rs.getString("printDate"), rs.getString("printingHouse"),
            rs.getString("description")));
      }
       System.out.println(bookList);
       return bookList;
    }catch (SQLException e){
      throw new DAOException(e);
    } 
  }
}

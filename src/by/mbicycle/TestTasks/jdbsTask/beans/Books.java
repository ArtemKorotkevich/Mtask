package by.mbicycle.TestTasks.jdbsTask.beans;

import java.time.LocalDate;

public class Books {
  private int idBook;
  private Writers writers;
  private String name;
  private LocalDate printData;
  private String printHouse;
  private String description;

  public int getIdBook() {
    return idBook;
  }

  public Writers getWriters() {
    return writers;
  }

  public String getName() {
    return name;
  }

  public LocalDate getPrintData() {
    return printData;
  }

  public String getPrintHouse() {
    return printHouse;
  }

  public String getDescription() {
    return description;
  }

  public void setIdBook(int idBook) {
    this.idBook = idBook;
  }

  public void setWriters(Writers writers) {
    this.writers = writers;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrintData(LocalDate printData) {
    this.printData = printData;
  }

  public void setPrintHouse(String printHouse) {
    this.printHouse = printHouse;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Books() {
    super();
  }

  public Books(int idBook, Writers writers, String name, LocalDate printData, String printHouse,
      String description) {
    super();
    this.idBook = idBook;
    this.writers = writers;
    this.name = name;
    this.printData = printData;
    this.printHouse = printHouse;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Books [idBook=" + idBook + ", writers=" + writers + ", name=" + name + ", printData="
        + printData + ", printHouse=" + printHouse + ", description=" + description + "]";
  }
}

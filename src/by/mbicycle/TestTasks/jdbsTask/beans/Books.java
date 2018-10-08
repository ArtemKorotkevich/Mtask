package by.mbicycle.TestTasks.jdbsTask.beans;


public class Books {
  private int idBook;
  private int idWorker;
  private String name;
  private String printData;
  private String printHouse;
  private String description;

  public int getIdBook() {
    return idBook;
  }

  public int getWritersId() {
    return idWorker;
  }

  public String getName() {
    return name;
  }

  public String getPrintData() {
    return printData;
  }

  public String getPrintHouse() {
    return printHouse;
  }

  public String getDescription() {
    return description;
  }

  public Books setIdBook(int idBook) {
    this.idBook = idBook;
    return this;
  }

  public Books setWriters(int idWorker) {
    this.idWorker = idWorker;
    return this;
  }

  public Books setName(String name) {
    this.name = name;
    return this;
  }

  public Books setPrintData(String printData) {
    this.printData = printData;
    return this;
  }

  public Books setPrintHouse(String printHouse) {
    this.printHouse = printHouse;
    return this;
  }

  public Books setDescription(String description) {
    this.description = description;
    return this;
  }

  public Books() {
    super();
  }

  public Books(int idBook, int idWorker, String name, String printData, String printHouse,
      String description) {
    super();
    this.idBook = idBook;
    this.idWorker = idWorker;
    this.name = name;
    this.printData = printData;
    this.printHouse = printHouse;
    this.description = description;
  }
  public Books(int idWorker, String name, String printData, String printHouse, String description) {
    super();
    this.idWorker = idWorker;
    this.name = name;
    this.printData = printData;
    this.printHouse = printHouse;
    this.description = description;
  }

  @Override
  public String toString() {
    return "Books [idBook=" + idBook + ", writers=" + idWorker + ", name=" + name + ", printData="
        + printData + ", printHouse=" + printHouse + ", description=" + description + "]";
  }
}

package by.mbicycle.TestTasks.echoServer.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class MyThread implements Runnable {

  Socket soc;
  InputStream io;
  OutputStream os;
  private PrintWriter pw;

  public MyThread(Socket soc) {
    this.soc = soc;
  }

  @Override
  public void run() {
    try {
      io =  soc.getInputStream();
      os =  soc.getOutputStream();
      try(Scanner sc = new Scanner(io)){
        pw = new PrintWriter(os, true);
        pw.println("Connected");
        while(sc.hasNextLine()){

          String line = sc.nextLine();
          System.out.println("Client" + line);
          pw.println("Echo: "+ line);

          if(line.equalsIgnoreCase("quet")){
            System.out.println("Client initialize connections suicide ...");
            System.out.println("Server reply - "+ line + " - OK");
            os.flush();
            break;
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

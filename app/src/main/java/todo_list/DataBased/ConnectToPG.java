package todo_list.DataBased;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import todo_list.Domain.ListObj;

public class ConnectToPG {
    private final String default_url = "jdbc:postgresql://127.0.0.1:5432/postgres?sslmode=disable";
    private final String main_url = "jdbc:postgresql://127.0.0.1:5432/my_main_db?sslmode=disable";
    private final String user = "postgres";
    private final String password = "1";

    private final String check_sql_command2 = """
          SELECT datname FROM pg_catalog.pg_database WHERE lower(datname) = lower('my_main_db');
    """;

    private final String createDB = """
          CREATE DATABASE my_main_db;
    """;

    private final String createListsList = """
          CREATE TABLE IF NOT EXISTS Lists(\r
            id SERIAL PRIMARY KEY NOT NULL,\r
            name text NOT NULL,\r
            timeCreate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP\r
          );\r
    """;     
    
    private final String createTasksList = """
          CREATE TABLE IF NOT EXISTS TasksList(\r
            id SERIAL PRIMARY KEY NOT NULL,\r
            idList INTEGER NOT NULL REFERENCES Lists(id),\r
            msg text NOT NULL,\r
            dataCreate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\r
            checkComplite boolean NOT NULL DEFAULT false,\r
            dataComplite TIMESTAMP NULL DEFAULT NULL\r
          );\r
    """;

    private final String insertDefaultData = """
        INSERT INTO Lists (name) VALUES ('Создать дефолтный список задач');
    """;
    
    private final String getData = """
          select * FROM Lists;
    """;
    
    public void connect(){
      if(checkLists()) 
        downloadData();
      else 
        createDb();
    }

    private boolean checkLists() {
      boolean check = false;
        try (
            Connection c = DriverManager.getConnection(main_url, user, password); //Передаём данные для создания соединения
            Statement st = c.createStatement(); //Создаём соединение
            ResultSet rs = st.executeQuery(check_sql_command2) //Создаём запрос
        ) {
          check = rs.next();
        } catch(SQLException e) {
          printErr(e, "проверка бд");
        }
      
      return check;
    }

    private void createDb() {
      createRequest(default_url, user, password, createDB);
      createRequest(main_url, user, password, createListsList);
      createRequest(main_url, user, password, createTasksList);
      createRequest(main_url, user, password, insertDefaultData);
    }

    private void downloadData() {
        try (
          Connection c = DriverManager.getConnection(main_url, user, password);
          Statement st = c.createStatement(); 
          ResultSet rs = st.executeQuery(getData) 
        ) {
          while(rs.next()){ //Идём по каждой строке в таблице
            ListObj listObj = new ListObj(
              rs.getInt("id"),
              rs.getString("name")
            );
            System.out.println(listObj.id() + " " + listObj.name());
          }
        
        } catch(SQLException e) {
          printErr(e, "скачивание данных");
        }
    }

  private void createRequest(String url, String user, String password, String command){
        try (
            Connection c1Connection = DriverManager.getConnection(url, user, password);
            Statement st = c1Connection.createStatement(); 
            ResultSet rs = st.executeQuery(command) 
        ) {

        } catch(SQLException e) {
          printErr(e, "создание бд");
        }
  }

  private void printErr(Exception e, String msg){
    System.err.println(msg);
    System.err.println("ОШИБКА: " + e.getClass().getName());
    System.err.println("Сообщение: " + e.getMessage());
  }

  private void printLogs(){
    //System.out.println("URL: " + default_url);
  }
}

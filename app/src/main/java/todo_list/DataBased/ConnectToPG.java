package todo_list.DataBased;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import todo_list.Model.Tasks.TaskObj;

public class ConnectToPG {
    private final String default_url = "jdbc:postgresql://127.0.0.1:5432/postgres?sslmode=disable";
    private final String main_url = "jdbc:postgresql://127.0.0.1:5432/test2?sslmode=disable";
    private final String user = "postgres";
    private final String password = "1";

    private final String check_sql_command = """
          SELECT EXISTS (\r
            SELECT 1 FROM pg_database\r
                WHERE datname = 'test2' \r      
          ) AS table_exists;\r 
    """;

    private final String createDB = """
          CREATE DATABASE test2
    """;

    private final String createTables = """
          CREATE TABLE IF NOT EXISTS students(\r
            s_id integer PRIMARY KEY,\r
            name text,\r
            start_year integer\r
          );\r
    """;        
    
    private final String getData = """
          select s_id, name, start_year FROM students
    """;
    
    public void connect(){
      if(checkLists()) 
        downloadData();
      else 
        createDb();
    }

    private boolean checkLists() {
      boolean check = false;
      
      try {
        Class.forName("org.postgresql.Driver");
        printLogs();

        try (
            Connection c = DriverManager.getConnection(default_url, user, password); //Передаём данные для создания соединения
            Statement st = c.createStatement(); //Создаём соединение
            ResultSet rs = st.executeQuery(check_sql_command) //Создаём запрос
        ) {
          check = rs.next();
          System.out.println("Результат проверки: " + check);
        }
      } catch(ClassNotFoundException | SQLException e){
          System.err.println("ОШИБКА: " + e.getClass().getName());
          System.err.println("Сообщение: " + e.getMessage());
      }
    
      return check;
    }

    private void createDb() {
      try {
        Class.forName("org.postgresql.Driver");
        printLogs();

        try (
            Connection c1Connection = DriverManager.getConnection(default_url, user, password); //Передаём данные для создания соединения
            Statement st = c1Connection.createStatement(); //Создаём соединение
            ResultSet rs = st.executeQuery(createDB) //Создаём запрос
        ) {}
      } catch(ClassNotFoundException | SQLException e){
          System.err.println("ОШИБКА: " + e.getClass().getName());
          System.err.println("Сообщение: " + e.getMessage());
      }

      try {
        Class.forName("org.postgresql.Driver");
        printLogs();

        try (
            Connection c2Connection = DriverManager.getConnection(main_url, user, password); //Передаём данные для создания соединения
            Statement st = c2Connection.createStatement(); //Создаём соединение
            ResultSet rs = st.executeQuery(createTables) //Создаём запрос
        ) {}
      } catch(ClassNotFoundException | SQLException e){
          System.err.println("ОШИБКА: " + e.getClass().getName());
          System.err.println("Сообщение: " + e.getMessage());
      }

    }

    private void downloadData() {
      try {
        Class.forName("org.postgresql.Driver");
        printLogs();

        try (
            Connection c = DriverManager.getConnection(default_url, user, password); //Передаём данные для создания соединения
            Statement st = c.createStatement(); //Создаём соединение
            ResultSet rs = st.executeQuery(getData) //Создаём запрос
        ) {
          while(rs.next()){ //Идём по каждой строке в таблице
            TaskObj taskObj = new TaskObj(
            rs.getInt("s_id"), 
            rs.getString("c_no"), 
            rs.getInt("score"), 
            0, 
            false, 
            false
            );
            System.err.println(taskObj.getId() + " " + taskObj.getName());
          }
        
        }
      } catch(ClassNotFoundException | SQLException e){
          System.err.println("ОШИБКА: " + e.getClass().getName());
          System.err.println("Сообщение: " + e.getMessage());
      }
    }

  private void printLogs(){
    System.out.println("Драйвер загружен");
    System.out.println("Идёт подключение к БД");
    System.out.println("URL: " + default_url);
  }
}

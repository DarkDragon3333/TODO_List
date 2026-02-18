package todo_list.dataBased.model.factoryTask.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractTask {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/my_main_db?sslmode=disable";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    public abstract TaskInterface createTaskObj();

    public void complite(){
        TaskInterface compliteTask = createTaskObj();
        compliteTask.compliteThisTask();
    }

    static public void connectToPG(String command){
        try (
            Connection c1Connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement st = c1Connection.createStatement(); 
        ) {
           st.executeQuery(command);
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

}

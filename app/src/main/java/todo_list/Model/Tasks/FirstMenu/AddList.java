package todo_list.Model.Tasks.FirstMenu;

import java.util.Scanner;

import todo_list.Model.Acrions.AbstractTask;
import todo_list.Model.Acrions.TaskInterface;

public class AddList implements TaskInterface{

    @Override
    public void compliteThisTask() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Введите имя задачи: ");
            String line = input.nextLine();

            String addTaskCommand = "INSERT INTO Lists (name) VALUES ('" + line + "');";
            AbstractTask.connectToPG(addTaskCommand);
            //System.out.println(addTaskCommand);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    
}

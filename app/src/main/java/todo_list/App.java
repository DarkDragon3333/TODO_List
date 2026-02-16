package todo_list;

import java.util.Scanner;

import todo_list.Cli.CommandParser;
import todo_list.Cli.ConsoleMenu;
import todo_list.DataBased.ConnectToPG;
import todo_list.Model.Acrions.AbstractTask;
import todo_list.Model.TaskCreators.FirstMenu.AddListCreator;
import todo_list.Model.TaskCreators.FirstMenu.CheckHistoryCreator;
import todo_list.Model.TaskCreators.FirstMenu.DeleteListCreator;
import todo_list.Model.TaskCreators.FirstMenu.ExportListToTxtCreator;
import todo_list.Model.TaskCreators.FirstMenu.GoToListCreator;
import todo_list.Model.TaskCreators.FirstMenu.RefactorNameListCreator;

public class App {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            boolean flag = true;
            
            ConsoleMenu consoleMenu = new ConsoleMenu();
            consoleMenu.showMainMenu();
            
            System.out.println("Ваши списки дел: \n");
            
            ConnectToPG connectToPG = new ConnectToPG();
            connectToPG.connect();
            
            while (flag){
                System.out.print("Введите команду: ");
                String commandId = input.nextLine();
                CommandParser commandParser = new CommandParser();
                String command = commandParser.parseMainMenuComand(commandId);
                
                AbstractTask creatorTask;
                switch(command) {
                    case "Добавить список" -> {
                        creatorTask = new AddListCreator();
                        creatorTask.complite();
                    }
                    case "Перейти в список" -> {
                        creatorTask = new GoToListCreator();
                        creatorTask.complite();
                    }
                    case "Редактировать имя списка" -> {
                        creatorTask = new RefactorNameListCreator();
                        creatorTask.complite();
                    }
                    case "Удалить список" -> {
                        creatorTask = new DeleteListCreator();
                        creatorTask.complite();
                    }
                    case "Экспортировать списки в формате txt" -> {
                        creatorTask = new ExportListToTxtCreator();
                        creatorTask.complite();
                    }
                    case "История выполнения задач" -> {
                        creatorTask = new CheckHistoryCreator();
                        creatorTask.complite();
                    }
                    case "Выход" -> {
                        flag = false;
                        break;
                    }
                }
                                  
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
}

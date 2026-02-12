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
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        ConnectToPG connectToPG = new ConnectToPG();
        connectToPG.connect();

        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.showMainMenu();
        
        while (flag){
            String commandId = input.nextLine();
            CommandParser commandParser = new CommandParser();
            String command = commandParser.parseMainMenuComand(commandId);

            AbstractTask creatorTask;
            switch(command) {
                case "Добавить список":
                    creatorTask = new AddListCreator();
                    creatorTask.createTaskObj();
                    break;
                case "Перейти в список":
                    creatorTask = new GoToListCreator();
                    creatorTask.createTaskObj();
                    break;
                case "Редактировать имя списка":
                    creatorTask = new RefactorNameListCreator();
                    creatorTask.createTaskObj();
                    break;
                case "Удалить список":
                    creatorTask = new DeleteListCreator();
                    creatorTask.createTaskObj();
                    break;
                case "Экспортировать списки в формате txt":
                    creatorTask = new ExportListToTxtCreator();
                    creatorTask.createTaskObj();
                    break;
                case "История выполнения задач":
                    creatorTask = new CheckHistoryCreator();
                    creatorTask.createTaskObj();
                    break;                   
            }
            flag = false;
        }
        input.close();
        
    }
}

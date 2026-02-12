package todo_list.Cli;

public class ConsoleMenu {
    private final String[] commands_first_menu = {
        "Добавить список", "Перейти в список", "Редактировать имя списка", "Удалить список", 
        "Экспортировать списки в формате txt", "История выполнения задач"
    };

    private final String[] commands_second_menu = {
        "Добавить задачу", "Удалить задачу", "Редактировать задачу", 
        "Добавить вложенный список", "Удалить вложенынй список", "Поменять задачи местами", 
        "Отметить, что задача выполнена", "Отметить, что задача не выполнена", "Назад"
    };

    public void showMainMenu(){
        printComand(commands_first_menu);
    }
    
    public void showListMenu() {
       printComand(commands_second_menu);
    }

    private void printComand(String[] menu_commands){
        for (int i = 0; i < menu_commands.length; i++) {
            System.out.print(Integer.toString(i) + " - " + menu_commands[i] + ", ");
        }
        System.out.println("");
    }
}

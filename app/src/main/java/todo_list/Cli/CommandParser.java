package todo_list.Cli;

public class CommandParser {
    public String parseMainMenuComand (String commandId){
        switch (commandId) {
            case "1": return "Добавить список";
            case "2": return "Перейти в список";
            case "3": return "Редактировать имя списка";
            case "4": return "Удалить список";   
            case "5": return "Экспортировать списки в формате txt";   
            case "0": return "История выполнения задач";
            default:
                throw new AssertionError();
        }
        
    }
}

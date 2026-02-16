package todo_list.Cli;

public class CommandParser {
    public String parseMainMenuComand (String commandId){
        return switch (commandId) {
            case "0" -> "Добавить список";
            case "1" -> "Перейти в список";
            case "2" -> "Редактировать имя списка";
            case "3" -> "Удалить список";
            case "4" -> "Экспортировать списки в формате txt";
            case "5" -> "История выполнения задач";
            case "6" -> "Выход";
            default -> "Неверная набранная команда";
        };
        
    }
}

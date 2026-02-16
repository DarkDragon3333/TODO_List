package todo_list.Domain;

public record TaskObj(
    int id, String text, String timeOfCreate, 
    int timeOfComplite, boolean checkComplite
){}



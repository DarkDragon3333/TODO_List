package todo_list.dataBased.model;

public record TaskObj(
    int id, String text, String timeOfCreate, 
    int timeOfComplite, boolean checkComplite
){}



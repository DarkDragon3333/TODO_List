package todo_list.Model.Tasks;

public class TasksList {
    private int id = 0;
    private String name = "";
    private int timeOfBorn = 0;
    private int timeOfCheck = 0;
    private boolean boxCheck = false;

    public TasksList(int id, String name, int timeOfBorn, int timeOfCheck, boolean boxCheck, boolean isList) {
        this.id = id;
        this.name = name;
        this.timeOfBorn = timeOfBorn;
        this.timeOfCheck = timeOfCheck;
        this.boxCheck = boxCheck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeOfBorn() {
        return timeOfBorn;
    }

    public void setTimeOfBorn(int timeOfBorn) {
        this.timeOfBorn = timeOfBorn;
    }

    public int getTimeOfCheck() {
        return timeOfCheck;
    }

    public void setTimeOfCheck(int timeOfCheck) {
        this.timeOfCheck = timeOfCheck;
    }

    public boolean isBoxCheck() {
        return boxCheck;
    }

    public void setBoxCheck(boolean boxCheck) {
        this.boxCheck = boxCheck;
    }
}

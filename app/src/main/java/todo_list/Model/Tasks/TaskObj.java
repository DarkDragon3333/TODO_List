package todo_list.Model.Tasks;

public class TaskObj {
    private int id = 0;
    private String text = "";
    private int timeOfBorn = 0;
    private int timeOfCheck = 0;
    private boolean boxCheck = false;
    private boolean isList = false;

    public TaskObj(int id, String text, int timeOfBorn, int timeOfCheck, boolean boxCheck, boolean isList) {
        this.id = id;
        this.text = text;
        this.timeOfBorn = timeOfBorn;
        this.timeOfCheck = timeOfCheck;
        this.boxCheck = boxCheck;
        this.isList = isList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return text;
    }

    public void setName(String text) {
        this.text = text;
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

    public boolean isIsList() {
        return isList;
    }

    public void setIsList(boolean isList) {
        this.isList = isList;
    }
}

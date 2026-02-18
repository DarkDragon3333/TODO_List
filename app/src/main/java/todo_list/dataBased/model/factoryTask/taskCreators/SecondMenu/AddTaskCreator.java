package todo_list.dataBased.model.factoryTask.taskCreators.SecondMenu;

import todo_list.dataBased.model.factoryTask.actions.AbstractTask;
import todo_list.dataBased.model.factoryTask.actions.TaskInterface;
import todo_list.dataBased.model.factoryTask.tasks.SecondMenu.AddTask;

public class AddTaskCreator extends AbstractTask{
    @Override
    public TaskInterface createTaskObj() {
        return new AddTask();
    }
}

package todo_list.dataBased.model.factoryTask.taskCreators.SecondMenu;

import todo_list.dataBased.model.factoryTask.actions.AbstractTask;
import todo_list.dataBased.model.factoryTask.actions.TaskInterface;
import todo_list.dataBased.model.factoryTask.tasks.SecondMenu.SwapTasks;

public class SwapTasksCreator extends AbstractTask{
    @Override
    public TaskInterface createTaskObj() {
        return new SwapTasks();
    }
}

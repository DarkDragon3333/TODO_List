package todo_list.dataBased.model.factoryTask.taskCreators.SecondMenu;

import todo_list.dataBased.model.factoryTask.actions.AbstractTask;
import todo_list.dataBased.model.factoryTask.actions.TaskInterface;
import todo_list.dataBased.model.factoryTask.tasks.SecondMenu.RefactorTask;

public class RefactorTaskCreator extends AbstractTask{
    @Override
    public TaskInterface createTaskObj() {
        return new RefactorTask();
    }
}

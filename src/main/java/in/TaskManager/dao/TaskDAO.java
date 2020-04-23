package in.TaskManager.dao;

import java.util.List;

import in.TaskManager.model.Task;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface TaskDAO {
	int addTask(Task task);	
	Task getTaskById(int task_Id);
	List<Task> list();
	void updateTaskbyId(int task_Id, Task user);
	void deleteTaskById(int task_Id);
}

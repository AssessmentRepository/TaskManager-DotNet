package in.TaskManager.service;

import java.util.List;

import in.TaskManager.model.Task;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface TaskService {
	int addTask(Task task);	
	Task getTaskById(int task_Id);
	List<Task> listAllTask();
	void updateTaskbyId(int task_Id, Task user);
	void deleteTaskById(int task_Id);
}

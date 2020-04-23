package in.TaskManager.UtilTestClass;

import in.TaskManager.model.PatentTask;
import in.TaskManager.model.Task;

public class MasterData {
	public static PatentTask getParentTaskDetails() {
		PatentTask parentTask = new PatentTask();
		parentTask.setParent_Id(1);
		parentTask.setParent_Task("Parent-Task-1");
		return parentTask;
	}

	public static Task getTaskDetails() {
		Task task = new Task();
		task.setTask_Id(1);
		task.setParent_Id(1);
		task.setTask("do task-1");
		task.setStart_Date("20-04-2020");
		task.setEnd_Date("20-04-2020");
		task.setPriority("30");		
		return task;
	}
}
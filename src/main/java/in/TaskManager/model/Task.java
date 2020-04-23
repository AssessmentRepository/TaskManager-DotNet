package in.TaskManager.model;

import javax.persistence.Id;

/**
 * @author B Shashidhar
 *
 * 
 */
public class Task {
	@Id
	private int task_Id;
	private int parent_Id;
	private String task;
	private String start_Date;
	private String end_Date;
	private String priority;
	public int getTask_Id() {
		return task_Id;
	}
	public void setTask_Id(int task_Id) {
		this.task_Id = task_Id;
	}
	public int getParent_Id() {
		return parent_Id;
	}
	public void setParent_Id(int parent_Id) {
		this.parent_Id = parent_Id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStart_Date() {
		return start_Date;
	}
	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}
	public String getEnd_Date() {
		return end_Date;
	}
	public void setEnd_Date(String end_Date) {
		this.end_Date = end_Date;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
}

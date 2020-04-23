package in.TaskManager.model;

import javax.persistence.Id;

/**
 * @author B Shashidhar
 *
 * 
 */
public class PatentTask {
	@Id
	private int parent_Id;
	private String parent_Task;

	public int getParent_Id() {
		return parent_Id;
	}

	public void setParent_Id(int parent_Id) {
		this.parent_Id = parent_Id;
	}

	public String getParent_Task() {
		return parent_Task;
	}

	public void setParent_Task(String parent_Task) {
		this.parent_Task = parent_Task;
	}
}

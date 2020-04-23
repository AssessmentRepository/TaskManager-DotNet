package in.TaskManager.service;

import java.util.List;

import in.TaskManager.model.PatentTask;

/**
 * @author B Shashidhar
 *
 * 
 */
public interface ParentTaskService {
	int addParentTask(PatentTask patentTask);	
	PatentTask getParentTaskbyId(int parent_Id);
	List<PatentTask> listParentTask();
	void updateParentTaskById(int parent_Id, PatentTask user);
	void deleteParentTaskById(int parent_Id);
}

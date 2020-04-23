package in.TaskManager.serviceImplTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import in.TaskManager.UtilTestClass.MasterData;
import in.TaskManager.dao.ParentTaskDAO;
import in.TaskManager.dao.TaskDAO;
import in.TaskManager.model.PatentTask;
import in.TaskManager.model.Task;
import in.TaskManager.service.ParentTaskServiceImpl;
import in.TaskManager.service.TaskServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserRegiServiceImplTest {

	@Mock
	private ParentTaskDAO parentTaskDAO;
	@Mock
	private TaskDAO taskDAO;

	@Mock
	private PatentTask patentTask;
	@Mock
	private Task task;

	@InjectMocks
	private ParentTaskServiceImpl parentTaskServiceImpl;
	@InjectMocks
	private TaskServiceImpl taskServiceImpl;

	private MockMvc mockMvc;

	@Test
	public void testSaveParentTaskServiceImpl() throws Exception {
		int id=parentTaskServiceImpl.addParentTask(MasterData.getParentTaskDetails());
		assertEquals(id, parentTaskDAO.addParentTask(patentTask));
	}
	@Test
	public void testSaveTaskServiceImpl() throws Exception {
		int id=taskServiceImpl.addTask(MasterData.getTaskDetails());
		assertEquals(id, taskDAO.addTask(task));
	}

	@Test
	public void testGetParentTaskServiceImpl() {
		patentTask = parentTaskServiceImpl.getParentTaskbyId(MasterData.getParentTaskDetails().getParent_Id());
		when(parentTaskDAO.getParentTaskbyId(1)).thenReturn(null);
		PatentTask res = parentTaskServiceImpl.getParentTaskbyId(1);
		assertEquals(null, res);
	}
	@Test
	public void testGetTaskServiceImpl() {
		task = taskServiceImpl.getTaskById(MasterData.getTaskDetails().getTask_Id());
		when(taskDAO.getTaskById(1)).thenReturn(null);
		Task res = taskServiceImpl.getTaskById(1);
		assertEquals(null, res);
	}
	
	@Test
	public void testGetAllParentTaskServiceImpl() {
		List<PatentTask> parentTasks = new ArrayList<>();
		parentTasks.add(new PatentTask());
		when(parentTaskDAO.listParentTask()).thenReturn((List) parentTasks);
		List<PatentTask> list = parentTaskServiceImpl.listParentTask();
		assertEquals(1, list.size());
	}
	@Test
	public void testGetAllTaskServiceImpl() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task());
		when(taskDAO.list()).thenReturn((List) tasks);
		List<Task> list = taskServiceImpl.listAllTask();
		assertEquals(1, list.size());
	}
	
	@Test
	public void testGetAllParentTaskImpl() throws Exception {
		List<PatentTask> parentTasks = new ArrayList<>();
		when(parentTaskDAO.listParentTask()).thenReturn((List) parentTasks);
		List<PatentTask> list = parentTaskServiceImpl.listParentTask();
		assertEquals(Collections.EMPTY_LIST, list);
	}	
	@Test
	public void testGetAllTaskImpl() throws Exception {
		List<Task> tasks = new ArrayList<>();
		when(taskDAO.list()).thenReturn((List) tasks);
		List<Task> l = taskServiceImpl.listAllTask();
		assertEquals(Collections.EMPTY_LIST, l);
	}	

	
	@Test
	public void testDeleteParentTaskImpl() throws Exception {
		PatentTask patentTask = parentTaskServiceImpl.getParentTaskbyId(MasterData.getParentTaskDetails().getParent_Id());
		when(parentTaskDAO.getParentTaskbyId(1)).thenReturn(patentTask).thenReturn(null);
		PatentTask res = parentTaskServiceImpl.getParentTaskbyId(1);
		assertEquals(null, res);
	}
	@Test
	public void testDeleteTaskImpl() throws Exception {
		Task task = taskServiceImpl.getTaskById(MasterData.getTaskDetails().getParent_Id());
		when(taskDAO.getTaskById(1)).thenReturn(task).thenReturn(null);
		Task res = taskServiceImpl.getTaskById(1);
		assertEquals(null, res);
	}
}

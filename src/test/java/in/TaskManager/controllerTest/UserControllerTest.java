package in.TaskManager.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import in.TaskManager.UtilTestClass.MasterData;
import in.TaskManager.controller.TaskManagerController;
import in.TaskManager.service.ParentTaskService;
import in.TaskManager.service.TaskService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	private ParentTaskService parentTaskService;
	@Mock
	private TaskService taskService;

	@InjectMocks
	private TaskManagerController taskManagerController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(taskManagerController).build();
	}

	@Test
	public void testLoadingPageUrl() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void testAddParentTaskApiTestCase1() throws Exception {
		Gson gson = new Gson();
		when(parentTaskService.addParentTask(MasterData.getParentTaskDetails())).thenReturn(0);
		this.mockMvc
				.perform(post("/addparenttask").content(gson.toJson(MasterData.getParentTaskDetails()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(view().name("record not saved"));

	}
	@Test
	public void testAddtTaskApiTestCase1() throws Exception {
		Gson gson = new Gson();
		when(taskService.addTask(MasterData.getTaskDetails())).thenReturn(0);
		this.mockMvc
		.perform(post("/addtask").content(gson.toJson(MasterData.getParentTaskDetails()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(view().name("record not saved"));
		
	}
}

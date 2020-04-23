package in.TaskManager.EntityValidationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import in.TaskManager.UtilTestClass.MasterData;
import in.TaskManager.model.PatentTask;
import in.TaskManager.model.Task;

public class EntityValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void testPatentTaskSuccess() {
    	PatentTask patentTask = MasterData.getParentTaskDetails();
        Set<ConstraintViolation<PatentTask>> violations = validator.validate(patentTask);
        assertTrue(violations.isEmpty());
    }
    @Test
    public void testTaskSuccess() {
    	Task task = MasterData.getTaskDetails();
    	Set<ConstraintViolation<Task>> violations = validator.validate(task);
    	assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testParentTaskParentId() {
    	PatentTask patentTask = MasterData.getParentTaskDetails();
    	patentTask.setParent_Id(0);
        Set<ConstraintViolation<PatentTask>> violations = validator.validate(patentTask);
        assertFalse(violations.isEmpty());
    }
    @Test
    public void testParentTaskParentTask() {
    	PatentTask patentTask = MasterData.getParentTaskDetails();
    	patentTask.setParent_Task(null);
    	Set<ConstraintViolation<PatentTask>> violations = validator.validate(patentTask);
    	assertFalse(violations.isEmpty());
    }
    @Test
    public void testTaskParentId() {
    	Task task = MasterData.getTaskDetails();
    	task.setParent_Id(0);
    	Set<ConstraintViolation<Task>> violations = validator.validate(task);
    	assertFalse(violations.isEmpty());
    }
    @Test
    public void testTaskTaskId() {
    	Task task = MasterData.getTaskDetails();
    	task.setTask_Id(0);
    	Set<ConstraintViolation<Task>> violations = validator.validate(task);
    	assertFalse(violations.isEmpty());
    }
    @Test
    public void testTaskTask() {
    	Task task = MasterData.getTaskDetails();
    	task.setTask(null);
    	Set<ConstraintViolation<Task>> violations = validator.validate(task);
    	assertFalse(violations.isEmpty());
    }
    @Test
    public void testTaskPriority() {
    	Task task = MasterData.getTaskDetails();
    	task.setPriority(null);
    	Set<ConstraintViolation<Task>> violations = validator.validate(task);
    	assertFalse(violations.isEmpty());
    }
    
    @Test
	public void testParentTaskNameLength() {
    	PatentTask patentTask = MasterData.getParentTaskDetails();
    	patentTask.getParent_Task();
		int maxChar = 5;
		boolean tasknameLength = ((patentTask.getParent_Task().length()) >= maxChar);
		assertEquals(tasknameLength, true);
	}
    
    @Test
	public void testTestPriorityPasswordLength() {
    	Task task = MasterData.getTaskDetails();
    	task.getPriority();
		int priorityLength = 30;
		assertEquals(priorityLength, task.getPriority().length());
	}
}
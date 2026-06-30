package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Task;
import com.example.demo.Repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskrepository; 
	
	public List<Task> getTask() {
		return taskrepository.findAll();
	}

	public void createTask(String title) {
		Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
		taskrepository.save(task);
	}

	public void deleteTask(Long id) {
		taskrepository.deleteById(id);
	}

	public void toggleTask(Long id) {
		 Task task = taskrepository.findById(id)
	                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
	        task.setCompleted(!task.isCompleted());
	        taskrepository.save(task);
	}
	
	
}

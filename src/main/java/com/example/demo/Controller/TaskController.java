package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskservice;
	
	@GetMapping
	public String getTask(Model model) {
		List<Task> tasks=taskservice.getTask();
		model.addAttribute("tasks",tasks);
		return "tasks";
	}

	
	@PostMapping
	public String createTask(@RequestBody String title ) {
		taskservice.createTask(title);
        return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		taskservice.deleteTask(id);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskservice.toggleTask(id);
        return "redirect:/";
    }
	
}

package com.example.todoweb.controllers;

import com.example.todoweb.models.Tasks;
import com.example.todoweb.repos.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/")
    private String index(Model model){
        Iterable<Tasks> tasks = tasksRepository.findAll();
        model.addAttribute("tasks", tasks);

        return "index";
    }

    @PostMapping("/")
    private String getAddData(@RequestParam String contentName,
                              @RequestParam String priority, Model model){

        Tasks tasks = new Tasks(contentName, priority);
        tasksRepository.save(tasks);
        return "redirect:/";
    }
}

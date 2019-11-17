package com.tayfurunal.validations.controller;

import com.tayfurunal.validations.domain.Task;
import com.tayfurunal.validations.service.TaskService;
import com.tayfurunal.validations.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private ValidationService validationService;

    @PostMapping("")
    public ResponseEntity<?> createNewTask(@Valid @RequestBody Task task, BindingResult result){
        ResponseEntity<?> errorMap = validationService.ErrorService(result);
        if(errorMap!=null) return errorMap;
        Task newTask = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<Task>(newTask, HttpStatus.CREATED);
    }
}

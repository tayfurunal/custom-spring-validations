package com.tayfurunal.validations.service;

import com.tayfurunal.validations.domain.Task;
import com.tayfurunal.validations.exception.TaskIdException;
import com.tayfurunal.validations.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveOrUpdateTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new TaskIdException("Task ID '" + task.getTaskId() + "' already exist");
        }
    }
}

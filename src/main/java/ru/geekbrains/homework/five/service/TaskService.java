package ru.geekbrains.homework.five.service;

import ru.geekbrains.homework.five.model.TaskStatus;
import ru.geekbrains.homework.five.repository.TaskRepository;
import ru.geekbrains.homework.five.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getAllTasksByStatus(TaskStatus status) {
        return taskRepository.findAllTasksByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task task) {
        Task taskForUpdate = taskRepository.findById(id).orElse(null);
        if (taskForUpdate != null) {
            taskForUpdate.setStatus(task.getStatus());
            return taskRepository.save(taskForUpdate);
        }
        throw new RuntimeException("Task with id: " + id + " - not found");
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
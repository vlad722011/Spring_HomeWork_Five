package ru.geekbrains.homework.five.repository;

import ru.geekbrains.homework.five.model.Task;
import ru.geekbrains.homework.five.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllTasksByStatus(TaskStatus status);
}
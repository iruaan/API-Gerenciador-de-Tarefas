package com.example.demo.TaskRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.task.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    void deleteById(Long id);
    
}

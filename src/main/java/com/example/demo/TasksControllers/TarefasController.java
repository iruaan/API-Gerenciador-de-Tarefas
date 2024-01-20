package com.example.demo.TasksControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TaskRepository.TarefaRepository;
import com.example.demo.task.Tarefa;

@RestController
@RequestMapping("/tasks")
public class TarefasController {
    

    @Autowired
    TarefaRepository tarefaRepository;


    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    @PostMapping
    @RequestMapping("inserir-tarefa")
    public @ResponseBody Tarefa criarTarefa(Tarefa tarefa){
        tarefaRepository.save(tarefa);
        return tarefa;

    }
    @DeleteMapping
    @RequestMapping("delete")
    public void deletarTarefa(Long id) throws TarefaNaoEncontradaException{
        if(tarefaRepository.existsById(id)){
            tarefaRepository.deleteById(id);
            System.out.println("Tarefa excluída com sucesso!");
        } 
    
     
        else{
            throw new TarefaNaoEncontradaException("Tarefa não encontrada para o ID: " + id);
            
        }
            
    }

    @PutMapping
    @RequestMapping("update")
    public void atualizarTarefa(Tarefa tarefaAtualizada) throws TarefaNaoEncontradaException{
        
        if(tarefaRepository.existsById(tarefaAtualizada.getId())){

           Tarefa tarefaExistente = tarefaRepository.findById(tarefaAtualizada.getId()).orElse(null);

            tarefaExistente.setName(tarefaAtualizada.getName());
            tarefaExistente.setDescription(tarefaAtualizada.getDescription());
            tarefaExistente.setStatus(tarefaAtualizada.getStatus());
            tarefaRepository.save(tarefaExistente);}

        else{

            throw new TarefaNaoEncontradaException("Tarefa não encontrada para o id fornecido.");
        }
    
        }
    }
   
    


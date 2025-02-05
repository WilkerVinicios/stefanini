package com.br.stefanini.controller;

import com.br.stefanini.dto.TarefaDTO;
import com.br.stefanini.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarTarefas() {
        List<TarefaDTO> tarefas = tarefaService.listarTarefas();
        if (tarefas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma tarefa encontrada.");
        }
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarTarefa(@RequestBody TarefaDTO tarefa) {
        tarefaService.salvarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa salva com sucesso.");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tarefaService.buscarPorId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa com ID " + id + " não encontrada.");
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDto) {
        try {
            tarefaService.editarTarefa(id, tarefaDto);
            return ResponseEntity.ok("Tarefa editada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa com ID " + id + " não encontrada.");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirTarefa(@PathVariable Long id) {
        try {
            tarefaService.excluirTarefa(id);
            return ResponseEntity.ok("Tarefa excluída com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tarefa com ID " + id + " não encontrada.");
        }
    }
}

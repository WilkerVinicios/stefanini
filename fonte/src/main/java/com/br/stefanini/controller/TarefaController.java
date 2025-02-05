package com.br.stefanini.controller;

import com.br.stefanini.dto.TarefaDTO;
import com.br.stefanini.service.TarefaService;
import org.springframework.validation.annotation.Validated;
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
    public List<TarefaDTO> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/listar/{id}")
    public TarefaDTO buscarTarefaPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id);
    }

    @PostMapping("/salvar")
    public void salvarTarefa(@Validated @RequestBody TarefaDTO tarefa) {
        tarefaService.salvarTarefa(tarefa);
    }

    @PutMapping("/editar/{id}")
    public void editarTarefa(@PathVariable Long id, @Validated @RequestBody TarefaDTO tarefaDto) {
        tarefaService.editarTarefa(id, tarefaDto);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirTarefa(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
    }
}

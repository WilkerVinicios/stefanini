package com.br.stefanini.service;

import com.br.stefanini.dto.TarefaDTO;
import com.br.stefanini.entity.Tarefa;
import com.br.stefanini.exception.BadRequestException;
import com.br.stefanini.exception.NotFoundException;
import com.br.stefanini.mapper.TarefaMapper;
import com.br.stefanini.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper mapper;

    public TarefaService(TarefaRepository tarefaRepository,
                         TarefaMapper mapper) {
        this.tarefaRepository = tarefaRepository;
        this.mapper = mapper;
    }


    public List<TarefaDTO> listarTarefas() {
        return tarefaRepository.findAll().stream().map(mapper::toDTO).toList();
    }

    public void salvarTarefa(TarefaDTO tarefa) {
        if (tarefa.getId() != null) {
            throw new BadRequestException("Id não pode ser informado!");
        }
        tarefaRepository.save(mapper.toEntity(tarefa));
    }

    public void atualizarTarefa(Long id) {
        final var tarefa = buscarTarefaPorId(id);
    }

    public void excluirTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

    private Tarefa buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id).orElseThrow(() -> new NotFoundException("Tarefa não encontrada!"));
    }
}

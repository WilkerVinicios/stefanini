package com.br.stefanini.mapper;

import com.br.stefanini.dto.TarefaDTO;
import com.br.stefanini.entity.Tarefa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper {


    Tarefa toEntity(TarefaDTO tarefaDTO);

    TarefaDTO toDTO(Tarefa tarefa);
}

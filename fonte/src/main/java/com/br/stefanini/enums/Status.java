package com.br.stefanini.enums;

import lombok.Getter;

public enum Status {
    PENDENTE(1, "Pendente"),
    EM_ANDAMENTO(2, "Em andamento"),
    COMPLETO(3, "Completo");

    @Getter
    private int id;
    private String descricao;

    Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
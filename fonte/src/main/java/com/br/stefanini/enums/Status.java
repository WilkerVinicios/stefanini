package com.br.stefanini.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Status {
    PENDENTE(1, "Pendente"),
    EM_ANDAMENTO(2, "Em andamento"),
    COMPLETO(3, "Completo");

    private final int id;
    private final String descricao;

    Status(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Status fromId(int id) {
        return Arrays.stream(Status.values())
                .filter(status -> status.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Status inválido: " + id));
    }
}
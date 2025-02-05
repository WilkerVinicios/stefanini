package com.br.stefanini.entity;

import com.br.stefanini.enums.Status;
import com.br.stefanini.enums.converter.StatusConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAREFA")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Convert(converter = StatusConverter.class)
    @Column(name = "STATUS", nullable = false)
    private Status status;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }
}

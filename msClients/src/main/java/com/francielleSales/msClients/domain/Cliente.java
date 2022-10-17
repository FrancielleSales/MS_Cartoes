package com.francielleSales.msClients.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "idade", length = 3, nullable = false)
    private Integer idade;

    public Cliente(String cpf, String nome, Integer idade) {
        this.cpf = cpf;
        this.nome= nome;
        this.idade = idade;
    }
}

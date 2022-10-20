package com.francielleSales.msCartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@Entity
@Table(name="CARTAO")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "bandeira", length = 10, nullable = false)
    private BandeiraCartao bandeira;

    @Column(name = "renda", nullable = false)
    private BigDecimal renda;

    @Column(name = "limite", nullable = false)
    private BigDecimal limiteBasico;

    public Cartao(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }
}

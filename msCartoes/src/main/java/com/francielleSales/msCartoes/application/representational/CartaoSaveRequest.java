package com.francielleSales.msCartoes.application.representational;

import com.francielleSales.msCartoes.domain.BandeiraCartao;
import com.francielleSales.msCartoes.domain.Cartao;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    @NotBlank(message = "O campo nome é obrigatório!")
    @Size(min = 3, max = 100)
    private String nome;
    @NotNull
    private BandeiraCartao bandeira;
    @NotNull(message = "O campo renda é obrigatório!")
    @PositiveOrZero(message = "A renda deve ser um número maior ou igual a zero.")
    private BigDecimal renda;

    @NotNull(message = "O campo limite é obrigatório!")
    @PositiveOrZero(message = "O limite deve ser um número maior ou igual a zero.")
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}

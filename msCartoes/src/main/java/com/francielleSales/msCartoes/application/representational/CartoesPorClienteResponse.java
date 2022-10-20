package com.francielleSales.msCartoes.application.representational;

import com.francielleSales.msCartoes.domain.ClienteCartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteResponse {

    @NotBlank(message = "O campo nome é obrigatório!")
    @Size(min = 3, max = 100)
    private String nome;

    @NotNull
    private String bandeira;

    @NotNull(message = "O campo limite liberado é obrigatório!")
    @PositiveOrZero(message = "O limite liberado deve ser um número maior ou igual a zero.")
    private BigDecimal limiteLiberado;

    public static CartoesPorClienteResponse fromModel(ClienteCartao model){
        return new CartoesPorClienteResponse(
                model.getCartao().getNome(),
                model.getCartao().getBandeira().toString(),
                model.getLimite()
        );
    }

}

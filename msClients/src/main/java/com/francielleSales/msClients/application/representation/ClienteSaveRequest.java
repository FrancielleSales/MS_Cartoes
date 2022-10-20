package com.francielleSales.msClients.application.representation;

import com.francielleSales.msClients.domain.Cliente;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;

@Data
public class ClienteSaveRequest {

    @NotBlank(message = "O campo CPF é obrigatório!")
    @CPF(message = "CPF inválido!")
    private String cpf;

    @NotBlank(message = "O campo nome é obrigatório!")
    @Size(min = 3, max = 150)
    private String nome;

    @NotNull(message = "O campo idade é obrigatório!")
    @Min(value = 18, message = "A idade mínima é 18 anos!")
    @Max(value = 120, message = "A idade máxima é 120 anos!")
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(cpf, nome, idade);
    }
}

package med.voll.apimed.Domain.Medicos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.apimed.Domain.Endereco.EnderecoBody;

public record MedicosBody(

        @NotNull(message = "O nome do médico é obrigatório")
        @NotBlank(message = "O nome do médico não pode estar em branco")
        String nome,
        @NotNull(message = "O email do médico é obrigatório")
        @NotBlank(message = "O email do médico não pode estar em branco")
        @Email(message = "O email do médico deve ser válido")
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}", message = "O CRM deve conter entre 4 e 6 dígitos")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull(message = "O endereço do médico é obrigatório")
        @Valid
        EnderecoBody endereco,
        @NotBlank
        String telefone
) {

}

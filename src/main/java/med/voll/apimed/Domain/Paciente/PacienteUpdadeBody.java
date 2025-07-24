package med.voll.apimed.Domain.Paciente;

import med.voll.apimed.Domain.Endereco.EnderecoBody;

public record PacienteUpdadeBody(
        String nome,
        String telefone,
        EnderecoBody endereco
) {
}

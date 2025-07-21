package med.voll.apimed.domain.Paciente;

import med.voll.apimed.domain.Endereco.EnderecoBody;

public record PacienteUpdadeBody(
        String nome,
        String telefone,
        EnderecoBody endereco
) {
}

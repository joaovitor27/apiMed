package med.voll.apimed.Paciente;

import med.voll.apimed.Endereco.EnderecoBody;

public record PacienteUpdadeBody(
        String nome,
        String telefone,
        EnderecoBody endereco
) {
}

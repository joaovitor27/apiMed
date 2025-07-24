package med.voll.apimed.Domain.Medicos;

import med.voll.apimed.Domain.Endereco.EnderecoBody;

public record MedicosUpdateBody(
        String nome,
        String telefone,
        EnderecoBody endereco
) {
}

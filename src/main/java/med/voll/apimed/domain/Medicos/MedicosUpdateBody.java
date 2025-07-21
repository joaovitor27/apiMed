package med.voll.apimed.domain.Medicos;

import med.voll.apimed.domain.Endereco.EnderecoBody;

public record MedicosUpdateBody(
        String nome,
        String telefone,
        EnderecoBody endereco
) {
}

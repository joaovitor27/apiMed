package med.voll.apimed.Medicos;

import med.voll.apimed.Endereco.EnderecoBody;

public record MedicosUpdateBody(
        String nome,
        String telefone,
        EnderecoBody endereco
) {
}

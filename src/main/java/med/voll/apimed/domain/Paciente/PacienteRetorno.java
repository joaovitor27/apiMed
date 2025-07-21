package med.voll.apimed.domain.Paciente;

import med.voll.apimed.domain.Endereco.Endereco;

public record PacienteRetorno(
    Long id,
    String nome,
    String email,
    String cpf,
    String telefone,
    Boolean ativo,
    Endereco endereco
) {
    public PacienteRetorno(Paciente paciente) {
        this(
            paciente.getId(),
            paciente.getNome(),
            paciente.getEmail(),
            paciente.getCpf(),
            paciente.getTelefone(),
            paciente.getAtivo(),
            paciente.getEndereco()
        );
    }
}

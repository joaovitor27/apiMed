package med.voll.apimed.domain.Paciente;

import med.voll.apimed.domain.Endereco.Endereco;

public record PacienteList(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco
) {
    public PacienteList(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}

package med.voll.apimed.domain.Medicos;

import med.voll.apimed.domain.Endereco.Endereco;

public record MedicosReturn(
    Long id,
    String nome,
    String email,
    String crm,
    String telefone,
    Especialidade especialidade,
    Boolean ativo,
    Endereco endereco
) {
    public MedicosReturn(Medico medico) {
        this(
            medico.getId(),
            medico.getNome(),
            medico.getEmail(),
            medico.getCrm(),
            medico.getTelefone(),
            medico.getEspecialidade(),
            medico.getAtivo(),
            medico.getEndereco()
        );
    }
}

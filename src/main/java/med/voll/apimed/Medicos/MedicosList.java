package med.voll.apimed.Medicos;

public record MedicosList(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public MedicosList(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}

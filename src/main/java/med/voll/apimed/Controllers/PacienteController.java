package med.voll.apimed.Controllers;

import jakarta.validation.Valid;
import med.voll.apimed.Paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public Paciente cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        return repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteList> list(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(PacienteList::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public Paciente atualizar(@RequestBody @Valid PacienteUpdadeBody dados, @PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
        return repository.save(paciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        repository.save(paciente);
    }

    @GetMapping("/{id}")
    public Paciente detalhar(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
    }
}

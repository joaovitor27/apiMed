package med.voll.apimed.Controllers;

import jakarta.validation.Valid;
import med.voll.apimed.Domain.Paciente.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    private final PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteRetorno> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        repository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacienteRetorno(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteList>> list(Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(PacienteList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteRetorno> atualizar(@RequestBody @Valid PacienteUpdadeBody dados, @PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
        repository.save(paciente);
        return ResponseEntity.ok(new PacienteRetorno(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PacienteRetorno> excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        repository.save(paciente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteRetorno> detalhar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacienteRetorno(paciente));
    }
}

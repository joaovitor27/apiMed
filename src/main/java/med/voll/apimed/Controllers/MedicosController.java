package med.voll.apimed.Controllers;

import jakarta.validation.Valid;
import med.voll.apimed.domain.Medicos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicosController {

    private final MedicoRepository medicoRepository;

    public MedicosController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MedicosReturn> cadastrar(@RequestBody @Valid MedicosBody dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicosReturn(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicosList>> list(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(MedicosList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicosReturn> atualizar(@RequestBody @Valid MedicosUpdateBody dados, @PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new MedicosReturn(medicoRepository.save(medico)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<MedicosReturn> excluir(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        medicoRepository.save(medico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicosReturn> detalhar(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new MedicosReturn(medico));
    }
}

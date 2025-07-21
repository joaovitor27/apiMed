package med.voll.apimed.Controllers;

import jakarta.validation.Valid;
import med.voll.apimed.Medicos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("medicos")
public class MedicosController {

    private final MedicoRepository medicoRepository;

    public MedicosController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public Medico cadastrar(@RequestBody @Valid MedicosBody dados) {
        var medico = new Medico(dados);
        return medicoRepository.save(medico);
    }

    @GetMapping
    public Page<MedicosList> list(@PageableDefault(size = 5, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(MedicosList::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public Medico atualizar(@RequestBody @Valid MedicosUpdateBody dados, @PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
        return medicoRepository.save(medico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        medicoRepository.save(medico);
    }

    @GetMapping("/{id}")
    public Medico detalhar(@PathVariable Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Médico não encontrado"));
    }
}

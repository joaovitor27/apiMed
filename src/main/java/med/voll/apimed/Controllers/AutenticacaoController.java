package med.voll.apimed.Controllers;

import jakarta.validation.Valid;
import med.voll.apimed.domain.Usuario.DadosAutenticacao;
import med.voll.apimed.domain.Usuario.Usuario;
import med.voll.apimed.infra.security.DadosTokenJWT;
import med.voll.apimed.infra.security.TokenServices;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager authenticationManager;
    private final TokenServices tokenService;

    public AutenticacaoController(AuthenticationManager authenticationManager, TokenServices tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var tokenAutentication = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = authenticationManager.authenticate(tokenAutentication);

        var token = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(new DadosTokenJWT(token));
        } else {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }
}

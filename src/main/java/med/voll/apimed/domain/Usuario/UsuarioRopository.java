package med.voll.apimed.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRopository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}

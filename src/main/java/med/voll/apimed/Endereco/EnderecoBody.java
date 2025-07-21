package med.voll.apimed.Endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoBody(
        @NotNull(message = "O logradouro é obrigatório")
        @NotBlank(message = "O logradouro não pode estar em branco")
        String logradouro,
        String numero,
        String complemento,
        @NotBlank(message = "O bairro não pode estar em branco")
        String bairro,
        @NotBlank(message = "O CEP não pode estar em branco")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato XXXXX-XXX")
        String cep,
        @NotBlank(message = "A cidade não pode estar em branco")
        String cidade,
        @NotBlank(message = "A UF não pode estar em branco")
        String uf
) {
    public Endereco toEndereco() {
        return new Endereco(logradouro, numero, complemento, bairro, cep, cidade, uf);
    }
}

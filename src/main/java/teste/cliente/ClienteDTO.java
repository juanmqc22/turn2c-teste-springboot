package teste.cliente;

import teste.endereco.Endereco;

public record ClienteDTO(String nome,
                         String email,
                         String cpf,
                         Endereco endereco) {
    public static ClienteDTO from(Cliente cliente) {
        return new ClienteDTO(
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getEndereco()
        );
    }

}

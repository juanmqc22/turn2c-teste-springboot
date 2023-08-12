package teste.service;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import teste.cliente.Cliente;
import teste.cliente.ClienteRepository;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository repository;

    public Cliente saveCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Page<Cliente> findAllClientes(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Cacheable(value = "cliente", key = "#id")
    public Cliente getClienteById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public void deleteClienteById(Long id) {
        Cliente cliente = getClienteById(id);
        repository.deleteById(cliente.getId());
    }

}

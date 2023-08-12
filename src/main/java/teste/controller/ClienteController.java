package teste.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import teste.cliente.*;
import teste.service.ClienteService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid DadosCadastroCliente dados) {
        var cliente = service.saveCliente(new Cliente(dados));
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteDTO.from(cliente));
    }

    @GetMapping
    public Page<DadosListagemCliente> listar(Pageable pageable) {
        Page<Cliente> clientePage = service.findAllClientes(pageable);
        return clientePage.map(DadosListagemCliente::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
        var cliente = service.getClienteById(id);
        return ResponseEntity.ok(ClienteDTO.from(cliente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ClienteDTO> atualizar(@RequestBody @Valid DadosListagemCliente dados) {
        var cliente = service.getClienteById(dados.id());
        cliente.atualizarInformacoes(dados);
        service.saveCliente(cliente);
        return ResponseEntity.ok(ClienteDTO.from(cliente));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.deleteClienteById(id);
    }

}

package co.edu.sena.eprueba.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.sena.eprueba.modelo.Cliente;
import co.edu.sena.eprueba.negocio.services.ClienteService;
import co.edu.sena.eprueba.vista.resources.DTO.ClienteDTO;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {

	private final ClienteService clienteService;
	
	
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody ClienteDTO clienteDto){
		Cliente cliente = new Cliente();
		
		cliente.setNombreCli(clienteDto.getNombreCli());
		cliente.setApellidoCli(clienteDto.getApellidoCli());
		cliente.setDocumentoCli(clienteDto.getDocumentoCli());
		cliente.setDireccionCli(clienteDto.getDireccionCli());
		cliente.setTelefonoCli(clienteDto.getTelefonoCli());
		cliente.setEmailCli(clienteDto.getEmailCli());
		return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
	}

	
	@PutMapping("/{documentoCli}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("documentoCli") int documentoCli, ClienteDTO clienteDto) {
		
		Cliente cliente = this.clienteService.findByDocumentCli(documentoCli);
		
		if(cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND); 
		}else {
			cliente.setIdCli(clienteDto.getIdCli());
			cliente.setNombreCli(clienteDto.getNombreCli());
			cliente.setApellidoCli(clienteDto.getApellidoCli());
			cliente.setDocumentoCli(clienteDto.getDocumentoCli());
			cliente.setDireccionCli(clienteDto.getDireccionCli());
			cliente.setTelefonoCli(clienteDto.getTelefonoCli());
			cliente.setEmailCli(clienteDto.getEmailCli());
		}
		
		return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{documentoCli}")
	public void removeCliente(@PathVariable("documentoCli") int documentoCli, ClienteDTO clienteDto) {
		Cliente cliente = this.clienteService.findByDocumentCli(documentoCli);
		if(cliente != null) {
			this.clienteService.delete(cliente);
		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}
}

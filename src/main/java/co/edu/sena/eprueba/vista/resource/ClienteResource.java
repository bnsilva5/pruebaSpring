package co.edu.sena.eprueba.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.sena.eprueba.modelo.Cliente;
import co.edu.sena.eprueba.negocio.services.ClienteService;
import co.edu.sena.eprueba.vista.resources.DTO.ClienteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

	private final ClienteService clienteService;
	
	
	public ClienteResource(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servicio para crear un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
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
	@ApiOperation(value = "Actualizar Cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 400, message = "Cliente no actualizado") })
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
	@ApiOperation(value = "Eliminar Cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 400, message = "cliente no eliminado") })
	public void removeCliente(@PathVariable("documentoCli") int documentoCli, ClienteDTO clienteDto) {
		Cliente cliente = this.clienteService.findByDocumentCli(documentoCli);
		if(cliente != null) {
			this.clienteService.delete(cliente);
		}
	}
	
	
	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 400, message = "Clientes no encontrados") })
	public ResponseEntity<List<Cliente>> findAll() {
		return ResponseEntity.ok(this.clienteService.findAll());
	}
}

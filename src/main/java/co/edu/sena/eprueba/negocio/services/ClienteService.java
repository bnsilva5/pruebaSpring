package co.edu.sena.eprueba.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.sena.eprueba.modelo.Cliente;
import co.edu.sena.eprueba.negocio.repository.ClienteRepository;

@Service
@Transactional(readOnly = true)
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;		
	}
	
	
	/*
	 * Metodo para realizar la operacion de guardar un cliente
	 */
	@Transactional
	public Cliente create(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	
	/*
	 * Metodo para actualizar un cliente
	 */
	@Transactional
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	
	/*
	 * Metodo para eliminar
	 */
	@Transactional
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
	
	
	/*
	 * Metodo para consultar por el documento del cliente
	 */
	public Cliente findByDocumentCli(int documentoCli) {
		return this.clienteRepository.findByDocumentoCli(documentoCli);
	}
	
	
	/*
	 * Metodo para consultar por el nombre del cliente
	 */
	public List<Cliente> findByNombreCli(String nombreCli) {
		return this.clienteRepository.findByNombreCli(nombreCli);
	}
	
	
	/*
	 * Metodo para consultar todos los clientes
	 */
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}
}

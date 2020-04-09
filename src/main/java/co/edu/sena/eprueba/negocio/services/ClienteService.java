package co.edu.sena.eprueba.negocio.services;

import co.edu.sena.eprueba.modelo.Cliente;
import co.edu.sena.eprueba.negocio.repository.ClienteRepository;

public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;		
	}
	
	
	/*
	 * Metodo para realizar la operacion de guardar un cliente
	 */
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	
	/*
	 * Metodo para actualizar un cliente
	 */
	public Cliente update(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}

	
	/*
	 * Metodo para eliminar
	 */
	public void delete(Cliente cliente) {
		this.clienteRepository.delete(cliente);
	}
}

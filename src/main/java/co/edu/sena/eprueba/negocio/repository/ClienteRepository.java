package co.edu.sena.eprueba.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.sena.eprueba.modelo.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
	
	List<Cliente> findByNombreCli(String nombreCli);
	
	public Cliente findByDocumentoCli(int documentoCli);

}

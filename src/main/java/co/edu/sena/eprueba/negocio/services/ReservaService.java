package co.edu.sena.eprueba.negocio.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.sena.eprueba.modelo.Reserva;
import co.edu.sena.eprueba.negocio.repository.ReservaRepository;

@Service
@Transactional(readOnly = true)
public class ReservaService {
	
	private final ReservaRepository reservaRepository;
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	
	/*
	 * Metodo para crear una reserva
	 */
	@Transactional
	public Reserva create(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	
	/*
	 * Metodo para actualizar una reserva
	 */
	@Transactional
	public Reserva update(Reserva reserva) {
		return this.reservaRepository.save(reserva);
	}
	
	
	/*
	 * Metodo para eliminar una reserva
	 */
	@Transactional
	public void delete(Reserva reserva) {
		this.reservaRepository.delete(reserva);
	}
	
	
	/*
	 * Metodo para consultar por IdReserva
	 */
	public Reserva findByIdRes(Long idRes) {
		return this.reservaRepository.findByIdRes(idRes);
	}
	
	
	/*
	 * Metodo para consultar por cantidad de personas que reservaron
	 */
	public Reserva findByCantidadPersonasRes(int cantidadPersonasRes) {
		return this.reservaRepository.findByCantidadPersonasRes(cantidadPersonasRes);
	}
	
	
	/*
	 * Metodo para consultar todas las reservas
	 */
	public List<Reserva> findAll() {
		return this.reservaRepository.findAll();
	}
}

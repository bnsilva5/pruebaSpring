package co.edu.sena.eprueba.negocio.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.sena.eprueba.modelo.Reserva;

public interface ReservaRepository extends JpaRepository <Reserva, Long> {

	@Query("select r from Reserva r where r.fechaIngresoRes  =: fechaInicio and r.fechaSalidaRes =: fechaSalida")
	public List<Reserva> find(@Param("fechaIngresoRes") Date fechaIngresoRes, @Param("fechaSalidaRes") Date fechaSalidaRes);
	
	public Reserva findByIdRes(Long idRes);
	
	public Reserva findByCantidadPersonasRes(int cantidadPersonasRes);
}

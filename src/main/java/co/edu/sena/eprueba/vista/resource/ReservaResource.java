package co.edu.sena.eprueba.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.sena.eprueba.modelo.Reserva;
import co.edu.sena.eprueba.negocio.services.ReservaService;
import co.edu.sena.eprueba.vista.resources.DTO.ReservaDTO;

@RestController
@RequestMapping("/api/reserva")
public class ReservaResource {

	private final ReservaService reservaService;
	
	public ReservaResource(ReservaService reservaService) {
		this.reservaService = reservaService;
	}
	
	
	@PostMapping
	public ResponseEntity<Reserva> createReserva(@RequestBody ReservaDTO reservaDto) {
		Reserva reserva = new Reserva();
		
		reserva.setFechaIngresoRes(reservaDto.getFechaIngresoRes());
		reserva.setFechaSalidaRes(reservaDto.getFechaSalidaRes());
		reserva.setCantidadPersonasRes(reservaDto.getCantidadPersonasRes());
		reserva.setDescripcionRes(reservaDto.getDescripcionRes());
		return new ResponseEntity<>(this.reservaService.create(reserva), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{idRes}")
	public ResponseEntity<Reserva> updateReserva(@PathVariable("idRes") Long idRes, ReservaDTO reservaDto) {
		Reserva reserva = this.reservaService.findByIdRes(idRes);
		
		if(reserva == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			reserva.setIdRes(reservaDto.getIdRes());
			reserva.setFechaIngresoRes(reservaDto.getFechaIngresoRes());
			reserva.setFechaSalidaRes(reservaDto.getFechaSalidaRes());
			reserva.setCantidadPersonasRes(reservaDto.getCantidadPersonasRes());
			reserva.setDescripcionRes(reservaDto.getDescripcionRes());
		}
		
		return new ResponseEntity<>(this.reservaService.update(reserva), HttpStatus.OK);
	}
	
	
	@DeleteMapping
	public void removeReserva(@PathVariable("idRes") Long idRes, ReservaDTO reservaDto) {
		Reserva reserva = this.reservaService.findByIdRes(idRes);
		
		if(reserva != null) {
			this.reservaService.delete(reserva);
		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<Reserva>> findAll() {
		return ResponseEntity.ok(this.reservaService.findAll());
	}
}

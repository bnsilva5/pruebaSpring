package co.edu.sena.eprueba.vista.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.sena.eprueba.modelo.Reserva;
import co.edu.sena.eprueba.negocio.services.ReservaService;
import co.edu.sena.eprueba.vista.resources.DTO.ReservaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/reserva")
@Api(tags = "reserva")
public class ReservaResource {

	private final ReservaService reservaService;
	
	public ReservaResource(ReservaService reservaService) {
		this.reservaService = reservaService;
	}
	
	
	@PostMapping
	@ApiOperation(value = "Crear Reserva", notes = "Servicio para crear una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva creada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public ResponseEntity<Reserva> createReserva(@RequestBody ReservaDTO reservaDto) {
		Reserva reserva = new Reserva();
		
		reserva.setFechaIngresoRes(reservaDto.getFechaIngresoRes());
		reserva.setFechaSalidaRes(reservaDto.getFechaSalidaRes());
		reserva.setCantidadPersonasRes(reservaDto.getCantidadPersonasRes());
		reserva.setDescripcionRes(reservaDto.getDescripcionRes());
		return new ResponseEntity<>(this.reservaService.create(reserva), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{idRes}")
	@ApiOperation(value = "Actualizar Reserva", notes = "Servicio para actualizar una reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reserva actualizada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
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
	@ApiOperation(value = "Eliminar Reserva", notes = "Servicio para eliminar reserva")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "reserva eliminada correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public void removeReserva(@PathVariable("idRes") Long idRes, ReservaDTO reservaDto) {
		Reserva reserva = this.reservaService.findByIdRes(idRes);
		
		if(reserva != null) {
			this.reservaService.delete(reserva);
		}
	}
	
	
	@GetMapping
	@ApiOperation(value = "Listar reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontradas"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public ResponseEntity<List<Reserva>> findAll() {
		return ResponseEntity.ok(this.reservaService.findAll());
	}
}

package co.edu.sena.eprueba.modelo;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRes;
	
	@NotNull
	@Column(name = "fecha_ingreso_reserva")
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	
	@NotNull
	@Column(name = "fecha_salida_reserva")
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	
	@NotNull
	@Size(max= 50)
	@Column(name = "cantida_personas_reservas", length = 50)
	private int cantidadPersonasRes;
	
	@NotNull
	@Size(max= 100)
	@Column(name = "nombre_cliente", length = 100, nullable = false)
	private String descripcionRes;
	
	@ManyToOne
	@JoinColumn(name = "idCli")
	private Cliente cliente;
	
	public Reserva() {
		
	}
	
	public Reserva(Long idRes, Date fechaIngresoRes, Date fechaSalidaRes, int cantidadPersonasRes, String descripcionRes) {
		this.idRes = idRes;
		this.fechaIngresoRes = fechaIngresoRes;
		this.fechaSalidaRes = fechaSalidaRes;
		this.cantidadPersonasRes = cantidadPersonasRes;
		this.descripcionRes = descripcionRes;
	}

	public Long getIdRes() {
		return idRes;
	}

	public void setIdRes(Long idRes) {
		this.idRes = idRes;
	}

	public Date getFechaIngresoRes() {
		return fechaIngresoRes;
	}

	public void setFechaIngresoRes(Date fechaIngresoRes) {
		this.fechaIngresoRes = fechaIngresoRes;
	}

	public Date getFechaSalidaRes() {
		return fechaSalidaRes;
	}

	public void setFechaSalidaRes(Date fechaSalidaRes) {
		this.fechaSalidaRes = fechaSalidaRes;
	}

	public int getCantidadPersonasRes() {
		return cantidadPersonasRes;
	}

	public void setCantidadPersonasRes(int cantidadPersonasRes) {
		this.cantidadPersonasRes = cantidadPersonasRes;
	}

	public String getDescripcionRes() {
		return descripcionRes;
	}

	public void setDescripcionRes(String descripcionRes) {
		this.descripcionRes = descripcionRes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRes == null) ? 0 : idRes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (idRes == null) {
			if (other.idRes != null)
				return false;
		} else if (!idRes.equals(other.idRes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [idRes=" + idRes + ", fechaIngresoRes=" + fechaIngresoRes + ", fechaSalidaRes=" + fechaSalidaRes
				+ ", cantidadPersonasRes=" + cantidadPersonasRes + ", descripcionRes=" + descripcionRes + "]";
	}
	
	

}

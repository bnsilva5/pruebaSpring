package co.edu.sena.eprueba.modelo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRes;
	private Date fechaIngresoRes;
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
	
	private Cliente cliente;
	
	public Reserva() {
		
	}
	
	public Reserva(Long idRes) {
		this.idRes = idRes;
	}
	
	public Reserva(Date fechaIngresoRes, Date fechaSalidaRes, int cantidadPersonasRes) {
		this.fechaIngresoRes = fechaIngresoRes;
		this.fechaSalidaRes = fechaSalidaRes;
		this.cantidadPersonasRes = cantidadPersonasRes;
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

package co.edu.sena.eprueba.vista.resources.DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReservaDTO {
	
	
	private Long idRes;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	
	@NotNull
	@Size(max= 50)
	private int cantidadPersonasRes;
	
	@NotNull
	@Size(max= 100)
	private String descripcionRes;
	
	
	public ReservaDTO() {
		
	}
	
	public ReservaDTO(Long idRes, Date fechaIngresoRes, Date fechaSalidaRes, int cantidadPersonasRes, String descripcionRes) {
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
		ReservaDTO other = (ReservaDTO) obj;
		if (idRes == null) {
			if (other.idRes != null)
				return false;
		} else if (!idRes.equals(other.idRes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReservaDTO [fechaIngresoRes=" + fechaIngresoRes + ", fechaSalidaRes=" + fechaSalidaRes
				+ ", cantidadPersonasRes=" + cantidadPersonasRes + ", descripcionRes=" + descripcionRes + "]";
	}
}

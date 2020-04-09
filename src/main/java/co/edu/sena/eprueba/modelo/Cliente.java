package co.edu.sena.eprueba.modelo;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
@NamedQuery(name="Cliente.findByDocumentoCli", query="select c from Cliente c where c.documentoCli = ?1")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCli;
	
	@NotNull
	@Size(max= 50)
	@Column(name = "nombre_cliente", length = 50, nullable = false)
	private String nombreCli;
	
	@NotNull
	@Size(max= 50)
	@Column(name = "apellido_cliente", length = 50, nullable = false)
	private String apellidoCli;
	
	@NotNull
	@Size(max= 50)
	@Column(name = "documento_cliente", length = 50, nullable = false)
	private int documentoCli;
	
	@NotNull
	@Size(max= 100)
	@Column(name = "direccion_cliente", length = 100, nullable = false)
	private String direccionCli;
	
	@NotNull
	@Size(max= 30)
	@Column(name = "telefono_cliente", length = 31, nullable = false)
	private int telefonoCli;
	
	@NotNull
	@Size(max= 100)
	@Column(name = "email_cliente", length = 100, nullable = false)
	private String emailCli;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> reservas;
	
	
	public Cliente() {
		
	}
	
	public Cliente(Long idCli, String nombreCli, String apellidoCli, int documentoCli, String direccionCli, int telefonoCli, String emailCli) {
		this.idCli = idCli;
		this.nombreCli = nombreCli;
		this.apellidoCli = apellidoCli;
		this.documentoCli = documentoCli;
		this.direccionCli = direccionCli;
		this.telefonoCli = telefonoCli;
		this.emailCli = emailCli;
	}

	public Long getIdCli() {
		return idCli;
	}

	public void setIdCli(Long idCli) {
		this.idCli = idCli;
	}

	public String getNombreCli() {
		return nombreCli;
	}

	public void setNombreCli(String nombreCli) {
		this.nombreCli = nombreCli;
	}

	public String getApellidoCli() {
		return apellidoCli;
	}

	public void setApellidoCli(String apellidoCli) {
		this.apellidoCli = apellidoCli;
	}

	public int getDocumentoCli() {
		return documentoCli;
	}

	public void setDocumentoCli(int documentoCli) {
		this.documentoCli = documentoCli;
	}

	public String getDireccionCli() {
		return direccionCli;
	}

	public void setDireccionCli(String direccionCli) {
		this.direccionCli = direccionCli;
	}

	public int getTelefonoCli() {
		return telefonoCli;
	}

	public void setTelefonoCli(int telefonoCli) {
		this.telefonoCli = telefonoCli;
	}

	public String getEmailCli() {
		return emailCli;
	}

	public void setEmailCli(String emailCli) {
		this.emailCli = emailCli;
	}

	public Set<Reserva> getReserva() {
		return reservas;
	}

	public void setReserva(Set<Reserva> reserva) {
		this.reservas = reserva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + documentoCli;
		result = prime * result + ((emailCli == null) ? 0 : emailCli.hashCode());
		result = prime * result + ((idCli == null) ? 0 : idCli.hashCode());
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
		Cliente other = (Cliente) obj;
		if (documentoCli != other.documentoCli)
			return false;
		if (emailCli == null) {
			if (other.emailCli != null)
				return false;
		} else if (!emailCli.equals(other.emailCli))
			return false;
		if (idCli == null) {
			if (other.idCli != null)
				return false;
		} else if (!idCli.equals(other.idCli))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idCli=" + idCli + ", nombreCli=" + nombreCli + ", apellidoCli=" + apellidoCli
				+ ", documentoCli=" + documentoCli + ", direccionCli=" + direccionCli + ", telefonoCli=" + telefonoCli
				+ ", emailCli=" + emailCli + "]";
	}

	
	
}

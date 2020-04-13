package co.edu.sena.eprueba.vista.resources.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteDTO {
	

	private Long idCli;
	
	@NotNull
	@Size(max= 50)
	private String nombreCli;
	
	@NotNull
	@Size(max= 50)
	private String apellidoCli;
	
	@NotNull
	@Size(max= 50)
	private int documentoCli;
	
	@NotNull
	@Size(max= 100)
	private String direccionCli;
	
	@NotNull
	@Size(max= 30)
	private int telefonoCli;
	
	@NotNull
	@Size(max= 100)
	private String emailCli;
	
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(Long idCli, String nombreCli, String apellidoCli, int documentoCli, String direccionCli, int telefonoCli, String emailCli) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + documentoCli;
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
		ClienteDTO other = (ClienteDTO) obj;
		if (documentoCli != other.documentoCli)
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
		return "ClienteDTO [nombreCli=" + nombreCli + ", apellidoCli=" + apellidoCli + ", documentoCli=" + documentoCli
				+ ", direccionCli=" + direccionCli + ", telefonoCli=" + telefonoCli + ", emailCli=" + emailCli + "]";
	}
	
}

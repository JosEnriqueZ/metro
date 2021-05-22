package ts.com.service.model.persona;

import java.io.Serializable;

import ts.com.service.util.db.client.TableDB;

@TableDB(name="persona.direccion")
public class Direccion implements Serializable {

	public Integer id;
	public String creador;
	public Boolean activo;
	public Persona persona;
	public String ubigeo;
	public String descripcion;
	public String telefono;
	public String email;
	public String referencia;
	
	
	@Override
	public String toString() { 
		return descripcion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Direccion other = (Direccion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

package ts.com.service.model;

import java.io.Serializable;

import ts.com.service.util.db.client.TableDB;

@TableDB(name="public.ubigeo")
public class Ubigeo implements Serializable{

	public Integer id;
	public String codigo;
	public String departamento;
	public String provincia;
	public String distrito;
	public String descripcion;
	
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
		Ubigeo other = (Ubigeo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

package ts.com.service.model.empresa;

import java.io.Serializable;

import ts.com.service.model.persona.Direccion;
import ts.com.service.model.rrhh.Empleado;
import ts.com.service.util.db.client.TableDB;

@TableDB(name="empresa.sucursal")
public class Sucursal implements Serializable {
	
	public Integer id;
	public String creador;
	public Boolean activo;
	public String codigo;
	public String descripcion;
	public Direccion direccion;
	public Empresa empresa;
	public Integer serie;
	public Integer default_filter_ver_productos;
	
	@Override
	public String toString() {
		return codigo;
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
		Sucursal other = (Sucursal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

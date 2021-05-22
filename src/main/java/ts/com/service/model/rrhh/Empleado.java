package ts.com.service.model.rrhh;

import java.io.Serializable;

import ts.com.service.model.almacen.Almacen;
import ts.com.service.model.empresa.Empresa;
import ts.com.service.model.empresa.Sucursal;
//import ts.com.service.model.finanza.Caja;
import ts.com.service.model.persona.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

@TableDB(name="rrhh.empleado")
public class Empleado implements Serializable{

	public Integer id;
	public Persona persona;
	public Sucursal sucursal;
	public Cargo cargo;
	public String usuario;
	public String clave;
	public Boolean activo;
	public String creador;
	public Empresa empresa;
	public Integer caja;
	public Integer pin;

	@FieldDB("es_usuario_sistema")
	public Boolean esUsuarioSistema;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	
	public Empleado(int id, String nombre){
		this.id = id;
		this.persona = new Persona();
		this.persona.apellidos = nombre;
		this.persona.nombres="";
	}
	
	@Override
	public String toString() {
		return persona.toString();
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
		Empleado other = (Empleado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

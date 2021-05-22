package ts.com.service.model.rrhh;


import java.io.Serializable;

import ts.com.service.util.db.client.TableDB;

@TableDB(name="rrhh.cargo")
public class Cargo implements Serializable {
	
	public Integer id;
	public String creador;
	public Boolean activo;
	public String descripcion;
	public Area area;
	
	@Override
	public String toString() {
		return descripcion;
	}

}

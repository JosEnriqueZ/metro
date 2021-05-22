package ts.com.service.model.rrhh;

import java.io.Serializable;

import ts.com.service.util.db.client.TableDB;

@TableDB(name="rrhh.cargo_permiso")
public class CargoPermiso implements Serializable {

	public Integer id;
	public String creador;
	public Cargo cargo;
	public Permiso permiso;
	
}

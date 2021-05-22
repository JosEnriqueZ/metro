package ts.com.service.model;

import java.io.Serializable;

import ts.com.service.model.empresa.Sucursal;
import ts.com.service.model.rrhh.Empleado;
import ts.com.service.util.db.client.TableDB;

@TableDB(name="public.serie")
public class Serie implements Serializable {

	public Integer id;
	public Empleado creador;
	public Boolean activo;
	public String numero;
	public DocumentoTipo documentoTipo;
	public Sucursal sucursal;
}

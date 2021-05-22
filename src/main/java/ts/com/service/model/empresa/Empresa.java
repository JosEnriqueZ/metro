package ts.com.service.model.empresa;

import java.io.Serializable;

import ts.com.service.model.persona.Direccion;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

@SuppressWarnings("serial")
@TableDB(name="empresa.empresa")
public class Empresa implements Serializable {

	public Integer id;
	public String creador;
	public Boolean activo;
	public Direccion direccion;
	@FieldDB("folder_temps")
	public String folderTemps;
	@FieldDB("folder_reports")
	public String folderReports;

	
	@Override
	public String toString() {
		return direccion.persona.toString();
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
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

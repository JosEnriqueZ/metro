package ts.com.server.service;

import java.util.List;




import ts.com.service.model.almacen.Marca;

public interface MarcaService{
	
	public List<Marca> list(int empresaId) throws Exception;
	public List<Marca> listActives(int empresaId) throws Exception;
	public void saveOrUpdate(Marca marca) throws Exception;
	public void delete(Marca marca) throws Exception;
	
}
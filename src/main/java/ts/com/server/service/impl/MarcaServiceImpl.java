package ts.com.server.service.impl;

import java.util.List;

import javax.servlet.annotation.WebServlet;

//import com.caucho.hessian.server.HessianServlet;

import ts.com.service.model.almacen.Marca;
import ts.com.server.service.MarcaService;
import ts.com.service.util.db.server.CRUD;

@WebServlet("/eva/MarcaService")
public class MarcaServiceImpl implements MarcaService {

	@Override
	public List<Marca> list(int empresaId) throws Exception {
		return CRUD.list(Marca.class,"where empresa= " + empresaId+" order by nombre asc");
	}

	@Override
	public void saveOrUpdate(Marca marca) throws Exception {
		if(marca.id==null){
			CRUD.save(marca);
		}else{
			CRUD.update(marca);
		}
	}

	@Override
	public void delete(Marca marca) throws Exception {
		CRUD.delete(marca);
	}

	@Override
	public List<Marca> listActives(int empresaId) throws Exception {
		return CRUD.list(Marca.class,"where empresa= " + empresaId+" and activo is true order by nombre asc");
	}

}

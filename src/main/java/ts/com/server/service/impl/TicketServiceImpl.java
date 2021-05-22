package ts.com.server.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;

//import com.caucho.hessian.server.HessianServlet;

import ts.com.service.model.playa.Ticket;
import ts.com.server.service.MarcaService;
import ts.com.server.service.TicketService;
import ts.com.service.util.db.server.CRUD;

@WebServlet("/eva/MarcaService")
public class TicketServiceImpl implements TicketService {

	@Override
	public List<Ticket> list(Date fi, Date fd) throws Exception {
            String[] req = {};

            String filter = "where a.fecha_ingreso between '" + fi + "' and '" + fd + "'"
                        + "order by a.id desc";
            return CRUD.list(Ticket.class,req,filter);
	}

	@Override
	public void saveOrUpdate(Ticket ticket) throws Exception {
		if(ticket.id==null){
			CRUD.save(ticket);
		}else{
			CRUD.update(ticket);
		}
	}

	@Override
	public void delete(Ticket ticket) throws Exception {
		CRUD.delete(ticket);
	}

	@Override
	public List<Ticket> listActives() throws Exception {
		return CRUD.list(Ticket.class,"where activo is true order by nombre asc");
	}

    @Override
    public String getHello(String sms) {
        return "Hola : " + sms;
    }

}

package ts.com.server.service;

import java.util.Date;
import java.util.List;



import ts.com.service.model.playa.Ticket;
import ts.com.service.model.almacen.Marca;

public interface TicketService{
	
	public List<Ticket> list(Date fi, Date fd) throws Exception;
	public List<Ticket> listActives() throws Exception;
	public void saveOrUpdate(Ticket ticket) throws Exception;
	public void delete(Ticket ticket) throws Exception;
        public String getHello(String sms);
	
}
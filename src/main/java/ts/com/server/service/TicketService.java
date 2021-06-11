package ts.com.server.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



import ts.com.service.model.playa.Ticket;
import ts.com.service.model.almacen.Marca;
import ts.com.service.model.persona.Persona;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;

public interface TicketService{
	
	public List<Ticket> list(Date fi, Date fd) throws Exception;
	public List<Ticket> listActives() throws Exception;
	public String saveOrUpdate(Ticket ticket) throws Exception;
	public void delete(Ticket ticket) throws Exception;
        public String getHello(String sms);
        public int getLastNumeroXSerie(String serie);
        public String getSalida(String placa)throws Exception;
        public List<Persona> listPersonas();
	public String CerrarTurno(String dni) throws Exception;
        
        
        ///
        public List<CierreCab> listCierreCab(Date fi,Date fe, String persona, String turno);
        public List<CierreDet> listCierreDet(int cab);
        public String saveOrUpdateCab(CierreCab cierreCab) throws Exception;
        public String saveOrUpdateDet(CierreDet cierreDet) throws Exception;
        
}
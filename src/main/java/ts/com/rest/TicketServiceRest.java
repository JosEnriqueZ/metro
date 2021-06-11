/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ts.com.rest;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ts.com.service.model.playa.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ts.com.server.service.TicketService;
import ts.com.service.factory.Services;
import ts.com.service.model.persona.Persona;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;

/**
 * 
 * @author Enrique Gutierrez Arias
 */
@RequestMapping("/ticket")
@RestController
//@Route(value = "ticket", layout = MainView.class)
//@RouteAlias(value = "", layout = MainView.class)
//@PageTitle("Ticket")
public class TicketServiceRest implements TicketService{
    
    @GetMapping("/prueba")
    public ResponseEntity<Ticket> getTicket(){
        Ticket ticket = new Ticket();
        ticket.id = 5;
        ticket.creador = "enriquez";
        ticket.activo = true;
        ticket.fecha_ingreso = new Date();
        ticket.fecha_salida = new Date();
        ticket.serie = "F001";
        ticket.numero = 0;
        ticket.encargado_dni = "73301974";
        ticket.monto = new BigDecimal(0);
        ticket.placa = "TD455";
        ticket.tarifa = new BigDecimal(100);
        ticket.turno = 1;
        return ResponseEntity.ok(ticket);
    }

    @Override
    public List<Ticket> list(Date f_ini, Date f_fin) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ticket> listActives() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @PostMapping("/saveTicket")
    @Override
    public String saveOrUpdate(@RequestBody Ticket ticket) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateInString = ticket.str_fecha_ingreso; 
        Date date = formatter.parse(dateInString);
        ticket.fecha_ingreso = date;
        
        Integer numero = Services.getTicket().getLastNumeroXSerie(ticket.serie);
        ticket.numero = ++numero;
        String cadena = Services.getTicket().saveOrUpdate(ticket);
        return cadena;
    }

    @Override
    public void delete(Ticket ticket) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    @GetMapping("/getHello")
    @Override
    public String getHello(String sms) {
        return "SERVER: " + sms;
    }
    
    
    @GetMapping("/getNumeroXSerie")
    @Override
    public int getLastNumeroXSerie(@RequestParam String serie) {
        int num = Services.getTicket().getLastNumeroXSerie(serie);
        System.out.println("SERIE y NUM : " +serie +"-"+ num);
        
        return ++num;
    }

    @PostMapping("/getSalida")
    @Override
    public String getSalida(@RequestBody String placa) throws Exception {
        String t = Services.getTicket().getSalida(placa);
        return t;
    }
    
    @GetMapping("/getPersonas")
    @Override
    public List<Persona> listPersonas() {
        List<Persona> list = Services.getTicket().listPersonas();
        return list;
    }
    
    @GetMapping("/cerrarTurno")
    @Override
    public String CerrarTurno(@RequestParam String dni) throws Exception {
        String cadena = Services.getTicket().CerrarTurno(dni);
        System.out.println("CADENA: " + cadena);
        return cadena;
    }

    @Override
    public List<CierreCab> listCierreCab(Date fi,Date fe, String persona, String turno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CierreDet> listCierreDet(int cab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String saveOrUpdateCab(CierreCab cierreCab) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String saveOrUpdateDet(CierreDet cierreDet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}




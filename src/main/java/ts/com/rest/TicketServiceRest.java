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
        Ticket t = new Ticket();
        t.placa = "VG1252";
        return ResponseEntity.ok(t);
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
    public void saveOrUpdate(@RequestBody Ticket ticket) throws Exception {
        Services.getTicket().saveOrUpdate(ticket);
        return; 
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
    

    
}




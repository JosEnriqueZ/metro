/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.service.factory;

import ts.com.server.service.PersonaService;
import ts.com.server.service.ReporteService;
import ts.com.server.service.TicketService;
import ts.com.server.service.impl.PersonaServiceImpl;
import ts.com.server.service.impl.ReporteServiceImpl;
import ts.com.server.service.impl.TicketServiceImpl;

/**
 *
 * @author enriqueZ
 * 
 */
public class Services {
    private static final TicketService          ticket        = new TicketServiceImpl();   
    private static final PersonaService         persona        = new PersonaServiceImpl();   
    private static final ReporteService         reporte        = new ReporteServiceImpl();   
    public static TicketService getTicket() {
        return ticket;
    }   
    public static PersonaService getPersona() {
        return persona;
    }   
    public static ReporteService getReporte() {
        return reporte;
    }   
}

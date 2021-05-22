/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.service.factory;

import ts.com.server.service.TicketService;
import ts.com.server.service.impl.TicketServiceImpl;

/**
 *
 * @author StarkLord
 */
public class Services {
    private static final TicketService          ticket        = new TicketServiceImpl();   
    public static TicketService getTicket() {
        return ticket;
    }   
}

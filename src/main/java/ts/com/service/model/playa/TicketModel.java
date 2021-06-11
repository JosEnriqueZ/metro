/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ts.com.service.model.playa;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.client.component.ListBox;
import ts.com.client.component.TextBox;
import ts.com.service.util.db.server.CRUD;

/**
 * 
 * @author Enrique Gutierrez Arias
 */
public class TicketModel {

//    public TextBox txtactivo;
    public ListBox<String> lbxActivo = new ListBox<>();
    public Ticket  ticket;
    
    public TicketModel(Ticket ticket) {
        this.ticket = ticket;
        List<String> l = new ArrayList<>();
        l.add("SI");
        l.add("NO");
        lbxActivo.setList(l);
        lbxActivo.setValue(ticket.activo==true?"SI":"NO");
        lbxActivo.addValueChangeListener(e->{
            String valor = lbxActivo.getValue();
            if ("SI".equals(valor)) {
                this.ticket.activo = true;
                try {
                    CRUD.update(ticket);
                } catch (Exception ex) {
                    Logger.getLogger(TicketModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.ticket.activo = false;
                try {
                    CRUD.update(ticket);
                } catch (Exception ex) {
                    Logger.getLogger(TicketModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
//        txtactivo = new TextBox("", ticket.activo==true?"SI":"NO");
    }
    
    
    
    


    public  String getSerieNumero() {
        return ticket.serie + "-" + ticket.numero;
    }

    public String getFechaIngreso() {
        return ticket.str_fecha_ingreso;
    }
    
    public String getFechaSalida() {
        return ticket.str_fecha_salida;
    }
    
    public String getPlaca() {
        return ticket.placa;
    }
    
    public String getMonto() {
        return ticket.monto.toString();
    }
    
    public String getTarifa() {
        return ticket.tarifa.toString();
    }    

    public String getTurno() {
        return ticket.turno.toString();
    }
    public String getObservado() {
        return ticket.observacion==true?"SI":"NO";
    }
//    public String getTurno() {
//        return ticket.turno.toString();
//    }

}

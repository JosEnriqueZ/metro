/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ts.com.service.model.playa;

import java.io.Serializable;
import java.util.Objects;
import ts.com.service.util.db.client.TableDB;

/**
 * 
 * @author Enrique Gutierrez Arias
 */
@SuppressWarnings("serial")
@TableDB(name="playa.cierre_det")

public class CierreDet implements Serializable {
    
    public Integer     id;
    public String      creador;
    public Boolean     activo;
    
    public CierreCab   cierre_cab;
    public Ticket      ticket;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CierreDet other = (CierreDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Ticket getTicket() {
        return ticket;
    }
    
    
    

}

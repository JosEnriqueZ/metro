/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ts.com.service.model.playa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import ts.com.service.model.persona.Persona;
import ts.com.service.util.db.client.TableDB;

/**
 * 
 * @author Enrique Gutierrez Arias
 */
@SuppressWarnings("serial")
@TableDB(name="playa.cierre_cab")

public class CierreCab implements Serializable {
    
    public Integer     id;
    public String      creador;
    public Boolean     activo;
    
    public Persona      vigilante;
    public Date         fecha;
    public String       turno ;       
    public BigDecimal   total;        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final CierreCab other = (CierreCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

    public Persona getVigilante() {
        return vigilante;
    }

    public String getTurno() {
        return turno;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Date getFecha() {
        return fecha;
    }
    
    

    
        
}

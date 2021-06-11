/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.service.model.playa;

import com.fasterxml.jackson.annotation.JsonFormat;
import ts.com.service.util.db.client.TableDB;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import ts.com.service.util.Util;

/**
 *
 * @author Enrique
 */
@SuppressWarnings("serial")
@TableDB(name="playa.ticket")

public class Ticket implements Serializable {

    public Integer     id;
    public String      str_creado; 
    public String      creador;
    public Boolean     activo;
    
    public String       serie;
    public Integer      numero;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date         fecha_ingreso;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date         fecha_salida;
    public String       str_fecha_ingreso;
    public String       str_fecha_salida;
    public String       placa;
    public String       encargado_dni;
    public BigDecimal   monto;
    public BigDecimal   tarifa;
    public Integer      turno;
    public Boolean      cuadre_caja;
    public Boolean      observacion;


    public Ticket() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Ticket other = (Ticket) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getActivo() {
        return activo==false?"SI":"NO   ";
    }

    public String isCuadre_caja() {
        return cuadre_caja==false?"NO":"SI   ";
    }
    
    public String getObs() {
        return observacion==false?"NO":"SI   ";
    }
    

    public String getCreador() {
        return creador;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getFecha_ingreso() {
        return str_fecha_ingreso;
    }

    public String getFecha_salida() {
        return str_fecha_salida;
    }

    public String getPlaca() {
        return placa;
    }

    public String getEncargado_dni() {
        return encargado_dni;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }
    
    
    
    
    
}

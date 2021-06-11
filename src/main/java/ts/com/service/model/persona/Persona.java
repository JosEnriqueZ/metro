package ts.com.service.model.persona;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import ts.com.service.factory.Services;

import ts.com.service.model.DocumentoIdentidad;
//import ts.com.service.model.academico.Ciclo;
import ts.com.service.util.Util;
import ts.com.service.util.db.client.TableDB;

@SuppressWarnings("serial")
@TableDB(name = "persona.persona")
public class Persona implements Serializable {

    public Integer id;//
    public String creador;//
    public Boolean activo; //
    public String apellidos; //
    public String nombres; //
    public Character sexo;//
    public Integer documento_identidad;//
    public String identificador; //
    public String brevette;//
    public String email; //
    public String telefonos;//
    public String nombre_comercial; //
    
    public Character tipo_persona;//
    public String codigo;//
    
    public String clave_portal;//
    public Integer ciclo;   //

	
    

    public Boolean getActivo() {
        return activo;
    }
    
    public Direccion getDireccion() {
        Direccion dir = null;
//        try {
//            dir = Services.getDireccion().getDireccionDNI(identificador).get(0);
//        } catch (Exception ex) {
//            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Error en obtener direccion por dni :" + ex);
//        }
        return dir;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getActivoStr() {
        return activo?"SI":"NO";
    }
    
    public String getIdentificador() {
        return identificador;
    }
    public String getApellidos(){
        return apellidos;
    }
    
    public String getNombres(){
        return nombres;
    }

    public String getCodigo() {
        return codigo;
    }
    
    
    
    public String getCicloStr() {
        return "";
//        return ciclo==null?"Sin Asignar":ciclo.codigo;
    }
    
    
    @Override
    public String toString() {
        return apellidos + (nombres == null ? "" : (" " + nombres));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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
        Persona other = (Persona) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}

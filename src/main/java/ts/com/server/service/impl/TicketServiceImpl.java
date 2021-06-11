package ts.com.server.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;

//import com.caucho.hessian.server.HessianServlet;
import ts.com.service.model.playa.Ticket;
import ts.com.server.service.MarcaService;
import ts.com.server.service.TicketService;
import ts.com.service.factory.Services;
import ts.com.service.model.persona.Persona;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;
import ts.com.service.util.db.server.CRUD;

public class TicketServiceImpl implements TicketService {

    @Override
    public List<Ticket> list(Date fi, Date fd) throws Exception {
        String[] req = {};

        String filter = "where a.fecha_ingreso >= '" + fi + "' and a.fecha_ingreso <='" + fd + "'"
                //                    + "where a.fecha_ingreso between '" + fi + "' and '" + fd + "'"
                + "order by a.id desc";
        return CRUD.list(Ticket.class, req, filter);
    }

    @Override
    public String saveOrUpdate(Ticket ticket) throws Exception {
        if (ticket.id == null) {
            CRUD.save(ticket);
        } else {
            CRUD.update(ticket);
        }
        String cadena = ticket.numero.toString() + "|" +
                        getCuadreTurno(ticket);
        return cadena;
    }
    
    public String getCuadreTurno(Ticket ticket){
        BigDecimal suma = new BigDecimal(BigInteger.ZERO);
        String[] req = {};
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = df.format(ticket.fecha_ingreso);
        String filter = "where CAST(a.fecha_ingreso AS VARCHAR) LIKE '"+ fecha +"%'  " 
                +        "and a.encargado_dni = '"+ ticket.encargado_dni +"' and a.turno = "+ ticket.turno +" "
                + "order by a.id desc";
        try {
            List<Ticket> list = CRUD.list(Ticket.class, req, filter);  
            if (!list.isEmpty()) {
                for (Ticket t : list) {
                    BigDecimal diferencia = new BigDecimal(BigInteger.ZERO);
                    if (t.monto!=BigDecimal.ZERO) {
                        diferencia = t.monto.subtract(t.tarifa);   
                    }
                    suma = suma.add(t.tarifa);
                    suma = suma.add(diferencia);
                }
                System.out.println("TOTAL TURNO; " + suma);
            }else {
                return suma.toString();
            }
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR API: " + ex.getMessage());
        }
        return suma.toString();
    }

    @Override
    public void delete(Ticket ticket) throws Exception {
        CRUD.delete(ticket);
    }

    @Override
    public List<Ticket> listActives() throws Exception {
        return CRUD.list(Ticket.class, "where activo is true order by nombre asc");
    }

    @Override
    public String getHello(String sms) {
        return "Hola : " + sms;
    }

    @Override
    public int getLastNumeroXSerie(String serie) {
        String[] req = {};
        String filter = "where  a.serie = '" + serie + "' "
                + "order by a.numero desc limit 1";
        try {
            List<Ticket> list = CRUD.list(Ticket.class, req, filter);
            return list.isEmpty() ? null : list.get(0).numero;
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public String getSalida(String placa) throws Exception {
        String datos= new String();
        Ticket t = BusquedaPlaca(placa);
        System.out.println("TICKET ENCONTRADO: " + t);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BigDecimal monto = BigDecimal.ZERO;
        if (t!=null) {
            Date ingreso    = t.fecha_ingreso;
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaActual = df.format(c);
                Date date = formatter.parse(fechaActual);
                t.str_fecha_salida = fechaActual;
                t.fecha_salida = date;
            Date salida     = date;
            Long diff = salida.getTime() - ingreso.getTime();
            Long diffSeconds = diff / 1000;         
            Long diffMinutes = diff / (60 * 1000);         
            Long diffHours = diff / (60 * 60 * 1000);
            System.out.println("Horas: "+diffHours);
            System.out.println("Min:   "+diffMinutes);
            System.out.println("Seg:   "+diffSeconds);
            Integer horas = diffHours == null ? null : Math.toIntExact(diffHours);
            Integer minut = diffMinutes == null ? null : Math.toIntExact(diffMinutes);
            System.out.println("Horas: "+horas);
            System.out.println("Min:   "+minut);
            if ((horas<=2 && minut<=5)||(horas<=0)||(horas<=1)) {
                System.out.println("HORA PERMITIDA");
                t.monto = t.tarifa;
                t.fecha_salida = salida;
                CRUD.update(t);
            }
            if (horas>=2 && minut>=5) {
                System.out.println("FUERA DE LAHORA");
                horas = horas - 2;
                BigDecimal h = new BigDecimal(horas);
                monto = t.tarifa.multiply(h).add(BigDecimal.ONE);
                t.monto = t.tarifa;
                t.fecha_salida = salida;
                CRUD.update(t);
            }
        }
        //numero //ingreso // salida //placa //tarifa //monto //
        if (datos!=null) {
                datos = t.numero.toString() +"|"+   //numero    0
                t.str_fecha_ingreso +"|"+           //ingreso   1    
                t.str_fecha_salida  +"|"+           //salida    2
                t.placa             +"|"+           //placa     3
                t.tarifa            +"|"+           //tarifa    4
                t.monto             +"|";           //monto     5
        } 
    return datos;  
    }
    
    public Ticket BusquedaPlaca(String Placa){
        System.out.println("PLACA?? : " + Placa);
        String nPlaca =Placa.substring(1,Placa.length()-1);
        System.out.println("PLACA?? : " + nPlaca);
        String[] req = {};
        String filter = "where a.fecha_salida is null and a.placa = '" + Placa + "'" 
                + "order by a.numero desc limit 1";
        try {
            List<Ticket> list = CRUD.list(Ticket.class, req, filter);
            return list.isEmpty() ? null : list.get(0);
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Persona> listPersonas(){
        List<Persona> list = new ArrayList<>() ;
        try {
        String[] req = {};
        String filter = "where a.tipo_persona = 'G' order by a.id asc";
        list = CRUD.list(Persona.class, req, filter);  
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.isEmpty() ? null : list;
    }

    @Override
    public String CerrarTurno(String dni) throws Exception {
        System.out.println("REPORTE CAJA: ");
        String[] req = {};
        String filter = "where a.encargado_dni = '" + dni + "' and a.cuadre_caja = false "  
                + "order by a.id";
        Integer count1 = new Integer(0);
        Integer count2 = new Integer(0);
        Integer count5 = new Integer(0);
        Integer count10= new Integer(0);
        Integer count20= new Integer(0);
        Integer count0 = new Integer(0);
        Integer anul = new Integer(0);
        Integer numeroTotalTicket = new Integer(0);
        
        
        BigDecimal  sub1 = new BigDecimal(1);
        BigDecimal  sub2 = new BigDecimal(2);
        BigDecimal  sub5 = new BigDecimal(5);
        BigDecimal  sub10= new BigDecimal(10);
        BigDecimal  sub20= new BigDecimal(20);
        BigDecimal  sub0 = new BigDecimal(0);
        BigDecimal  TOTAL= new BigDecimal(0); 
        
        String fechainicio, fechafinal = new String();
        Date fecha = new Date();
        try {
            String turno = new String();
            Calendar c = Calendar.getInstance();
            if (c.get(Calendar.HOUR_OF_DAY)>=0 && c.get(Calendar.HOUR_OF_DAY)<=13) {
                turno="MAÑANA";
            }else{
                turno="TARDE";
            }
            List<Ticket> list = CRUD.list(Ticket.class, req, filter);
            if (list.isEmpty()) {
                System.out.println("NO SE ENCONTRARON TICKETS SIN CUADRES CAJA ABIERTOS");
                return null;
            }
            System.out.println("numero de ticket Cerrados: " + list.size());
            fechainicio = list.get(0).str_fecha_ingreso;
            fecha = list.get(0).fecha_ingreso;
            fechafinal = list.get(list.size()-1).str_fecha_ingreso;
            
            for (Ticket t : list) {
                t.cuadre_caja = true;
                CRUD.update(t);
                if (t.activo == false) {
                    anul++;
                    continue;
                }
                
                switch(t.tarifa.intValue()) {
                  case 1:
                        count1++;
                        numeroTotalTicket++;
                    break;
                  case 2:
                        count2++;
                        numeroTotalTicket++;
                    break;
                  case 5:
                        count5++;
                        numeroTotalTicket++;
                    break;
                  case 10:
                        count10++;
                        numeroTotalTicket++;
                    break;
                  case 20:
                        count20++;
                        numeroTotalTicket++;
                    break;
                  case 0:
                        count0++;
                        numeroTotalTicket++;
                    break;
                } 
            }
            sub1 = sub1.multiply(new BigDecimal(count1));
            sub2 = sub2.multiply(new BigDecimal(count2));
            sub5 = sub5.multiply(new BigDecimal(count5));
            sub10= sub10.multiply(new BigDecimal(count10));
            sub20= sub20.multiply(new BigDecimal(count20));
            sub0 = sub0.multiply(new BigDecimal(count0));
            TOTAL = TOTAL.add(sub1).add(sub2).add(sub5).add(sub10).add(sub20);
            
            String Cadena = new String();
                    Cadena = fechainicio    +"|"+   //0
                    fechafinal              +"|"+   //1        
                    turno                   +"|"+   //2    
                    count1                  +"|"+   //3           
                    count2                  +"|"+   //4          
                    count5                  +"|"+   //5           
                    count10                 +"|"+   //6           
                    count20                 +"|"+   //7          
                    count0                  +"|"+   //8
                    numeroTotalTicket       +"|"+   //9
                    sub1                    +"|"+   //10
                    sub2                    +"|"+   //11
                    sub5                    +"|"+   //12
                    sub10                   +"|"+   //13
                    sub20                   +"|"+   //14
                    sub0                    +"|"+   //15
                    anul                    +"|"+   //16
                    TOTAL                   +"|";   //17
           
            List<Persona> personas = Services.getPersona().getListByIdentificador(dni);
            CreaCierreCaja(list, fecha, personas.get(0), turno, TOTAL);
            return Cadena;
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: SERVIDOR:_ " + ex.getMessage());
            return null;
        }
    }
    
    public void CreaCierreCaja(List<Ticket> list, Date fecha, Persona vigilante, String turno, BigDecimal total){
        try {
        CierreCab cab = new CierreCab();
        cab.activo  = true;
        cab.creador = "admin";
        
        cab.fecha   = fecha;
        cab.vigilante = vigilante;
        cab.turno   = turno;
        cab.total   = total;
        CRUD.save(cab);
            for (Ticket ticket : list) {
                CierreDet det   = new CierreDet();
                det.activo      = true;
                det.creador     = "admin";
                
                det.cierre_cab  = cab;
                det.ticket      = ticket;
                CRUD.save(det);
            }
        
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error: " + ex.getMessage());
        }

    }

    @Override
    public List<CierreCab> listCierreCab(Date fi, Date fe, String persona, String turno) {
        String[] req = {"vigilante"};

        String filter = "where a.creado >= '" + fi + "' and a.creado <='" + fe + "' "
                 + " and b.apellidos ilike '%" + persona + "%'"
                 + "order by a.id desc";
        try {
            return CRUD.list(CierreCab.class, req, filter);
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR SERVIDOR: "+ ex.getMessage());
            return null;
        }
    }

    @Override
    public List<CierreDet> listCierreDet(int cab) {
        String[] req = {"cierre_cab","ticket"};

        String filter = "where b.id = '" + cab + "'"
                        + "order by a.id desc";
        try {
            return CRUD.list(CierreDet.class, req, filter);
        } catch (Exception ex) {
            Logger.getLogger(TicketServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR SERVIDOR: "+ ex.getMessage());
            return null;
        }
    }

    @Override
    public String saveOrUpdateCab(CierreCab cierreCab) throws Exception {
        if (cierreCab.id == null) {
            CRUD.save(cierreCab);
        } else {
            CRUD.update(cierreCab);
        }
        String cadena = "";
        return cadena;
    }

    @Override
    public String saveOrUpdateDet(CierreDet cierreDet) throws Exception {
        if (cierreDet.id == null) {
            CRUD.save(cierreDet);
        } else {
            CRUD.update(cierreDet);
        }
        String cadena = "";
        return cadena;
    }

}

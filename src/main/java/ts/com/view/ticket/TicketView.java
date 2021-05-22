/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.view.ticket;


//import ts.com.client.view.*;
import com.vaadin.flow.component.UI;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sk.smartbase.component.qrscanner.QrScanner;
//import org.vaadin.stefan.*;
//import org.vaadin.stefan.fullcalendar.Entry;
//import org.vaadin.stefan.fullcalendar.FullCalendar;
//import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
//import ts.com.App;
import ts.com.Client;
import ts.com.client.factory.Alerts;
//import ts.com.client.view.persona.PersonasView;
import ts.com.service.factory.Services;
import ts.com.service.model.almacen.Almacen;
import ts.com.service.model.empresa.Empresa;
import ts.com.service.model.empresa.Sucursal;
import ts.com.service.model.playa.Ticket;
import ts.com.service.util.db.server.CRUD;

/**
 *
 * @author EnriqueZ
 */

public class TicketView extends TicketUI {
    
   public List<Ticket> listTicket;
   public TicketView() {
        try {
            onRefresh();
            
            
            } catch (Exception ex) {
            Logger.getLogger(TicketView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: "+ex);
            }
    }

    @Override
    public void onBtnConnect() {
//        try {
//            String path = "";
//            ValorizacionCab cab = dtValorizaciones.getSelectionModel().getFirstSelectedItem().get();
//            if (cab.valorizacion_anidada == null) {
//            path = Services.getReporte().exportEXCELValorizacionCab(cab);   
//            System.out.println("VALORIZACION NORMAL");
//            }else{
//            path = Services.getReporte().exportEXCELValorizacionCabFinal(cab);
//            System.out.println("VALORIZACION PRODUCTOS FINALES");
//            }
//            
//            String url = "http://142.44.162.39:8088/"+path;;
////           String url = "D:/files/"+path;  sadfasdfasfdsadfasdfas
//            System.out.println("Esperando Documento");
//            System.out.println("URL :" + url);
//            UI.getCurrent().getPage().open(url, "_blank");
//            //System.out.println("URL :" + url);
//            //UI.getCurrent().getPage().open(url, "_blank");
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ValorizacionesView.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Alerts.error("Error al obtener el reporte. Debe de Seleccionar una Valorizacion");
//            Logger.getLogger(ValorizacionesView.class.getName()).log(Level.SEVERE, null, ex);
//        }  
    }


    @Override
    public void onAdd() {
        try {
            //List<Persona> personas = Services.getPersona().getList(tf_dni.getValue(), tf_dni.getValue(), tf_dni.getValue());
//            view = new ValorizacionView();
//            System.out.println("hola");
//            view.showDialog();
//            onRefresh();
//        ValorizacionView view = new ValorizacionView();
//        view.addSaveHandler(this::onRefresh);
//        view.showDialog();
        } catch (Exception ex) {
            Alerts.error("No se Encontro Alumno. \n" + ex.getMessage());
            Logger.getLogger(TicketView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onRefresh() {
        System.out.println("REFRSH");
       try {
           listTicket = Services.getTicket().list(Client.ConvertToDate(dpFechaInicial.getValue()) , Client.ConvertToDate(dpFechaFinal.getValue()));
           dtTickets.setList(listTicket);
       } catch (Exception ex) {
           Logger.getLogger(TicketView.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public void onBtnPlantilla() {
//        viewPlantilla = new PlantillaView();
//        viewPlantilla.showDialog();
    }

    @Override
    public void onCambiarEstado() {
       try {
//            ValorizacionCab vc = dtValorizaciones.getSelectionModel().getFirstSelectedItem().get();
//            if (vc.estado == 'P') {
//                vc.estado = 'C';
//            }else{
//                vc.estado = 'P';
//            }
//           CRUD.update(vc);
//           onRefresh();
       } catch (Exception ex) {
           Logger.getLogger(TicketView.class.getName()).log(Level.SEVERE, null, ex);
           Alerts.error("Debe seleccionar una Valorizacion. " + ex);
       }
    }

    @Override
    public void onEdit() {
//        ValorizacionView view = new ValorizacionView(dtValorizaciones.getSelectionModel().getFirstSelectedItem().get());
//        view.addSaveHandler(this::onRefresh);
//        view.showDialog();
    }

    @Override
    public void onBtnTotal() {
//        try {
//        ValorizacionCab vc = dtValorizaciones.getSelectionModel().getFirstSelectedItem().get();   
//        Alerts.infoSaved();
//        Rutina r = new Rutina(vc.id);
//        } catch (Exception e) {
//            Alerts.info("Debe Seleccionar una Valorizacion");
//        }
        
    }
    
    @Override
    public void onBtnIndicadores() {
//        IndicadoresView view = new IndicadoresView();
//        view.addSaveHandler(this::onRefresh);
//        view.showDialog();
    }
    
    

    
}

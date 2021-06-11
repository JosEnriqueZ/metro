/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.view.ticket;


//import ts.com.client.view.*;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
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
import ts.com.service.model.persona.Persona;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.Ticket;
import ts.com.service.util.db.server.CRUD;

/**
 *
 * @author EnriqueZ
 */

public class CierreCajaView extends CierreCajaUI {
    
   public List<Ticket> listTicket;
   public List<CierreCab> listCab;
   public List<Persona> listVigilantes;
   public List<String> listTurno;
   public CierreCajaView() {
       
       
       login();
        try {
            listVigilantes = Services.getTicket().listPersonas();
            Persona a = new Persona();
            a.id = -1;
            a.apellidos = "";
            a.nombres = "SELECIONE VIGILANTE";  
//            a.descripcion = "SELECIONE UN ALMACEN->";
            listVigilantes.add(0, a);
            lbxVigilante.setList(listVigilantes);
            
            listTurno = new ArrayList<>();
            listTurno.add("MAÑANA");
            listTurno.add("TARDE");
            String turno = new String("SELECCIONE UN TURNO");
            listTurno.add(0, turno);
            lbxTurno.setList(listTurno);
            
            onRefresh();
            
            } catch (Exception ex) {
            Logger.getLogger(CierreCajaView.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: "+ex);
            }
    }
   
   public boolean login(){
        LoginOverlay component = new LoginOverlay();
        component.addLoginListener(e -> component.close());
        component.setOpened(true);
        
        

        LoginI18n i18n = LoginI18n.createDefault();
//        i18n.getHeader().setTitle("asdfasdfasfd");
        i18n.getForm().setPassword("Contraseña");
        i18n.getForm().setUsername("Usuario");
        i18n.getForm().setTitle("LOGIN");
        i18n.getForm().setSubmit("INGRESAR");
        i18n.getForm().setForgotPassword("Olvide mi Contraseña");

        
//        i18n.getForm().set("LOGIN!=");
//        i18n.setAdditionalInformation("Ingrese usuario y contraseña");
        component.setTitle("MERCADO METROPOLITANO");
        component.setDescription("Aplicacion PARKING");
        component.setI18n(i18n);

        this.add(component);
        return true;
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
        CierreCabView view = new CierreCabView();
        view.addSaveHandler(this::onRefresh);
        view.showDialog();
        } catch (Exception ex) {
            Alerts.error("ERROR AL ABRIR. \n" + ex.getMessage());
            Logger.getLogger(CierreCajaView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onRefresh() {
        System.out.println("REFRSH");
       try {
            Date fin = Client.ConvertToDate(dpFechaFinal.getValue());
            fin.setHours(23);
            fin.setMinutes(59);
            fin.setSeconds(59);   
             listCab = Services.getTicket().listCierreCab(Client.ConvertToDate(dpFechaInicial.getValue()),fin, lbxVigilante.getValue().apellidos, lbxTurno.getValue());
            dtCierreCab.setList(listCab);
       } catch (Exception ex) {
           Logger.getLogger(CierreCajaView.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(CierreCajaView.class.getName()).log(Level.SEVERE, null, ex);
           Alerts.error("Debe seleccionar una Valorizacion. " + ex);
       }
    }

    @Override
    public void onEdit() {
        CierreCabView view = new CierreCabView(dtCierreCab.getSelectionModel().getFirstSelectedItem().get());
        view.addSaveHandler(this::onRefresh);
        view.showDialog();
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
    
    @Override
    public void onBtnExportPDF() {

    }
    
    

    
}

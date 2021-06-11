/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.view.loguin;


import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sk.smartbase.component.qrscanner.QrScanner;
//import org.vaadin.stefan.*;
//import org.vaadin.stefan.fullcalendar.Entry;
//import org.vaadin.stefan.fullcalendar.FullCalendar;
//import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
//import ts.com.App;
import ts.com.client.factory.Alerts;
//import ts.com.client.view.alumno.AlumnoView;
import ts.com.service.factory.Services;
import ts.com.service.model.empresa.Empresa;
import ts.com.service.model.empresa.Sucursal;

/**
 *
 * @author Enriquez
 */

public class LoginView extends LoginUI {


    public LoginView() {
        List<String> empresas = new ArrayList<>();
        List<String> sucursales = new ArrayList<>();
        try {
            String empresa = new String("MERCADO METROPOLITANO");
            empresas.add(empresa);
            lbxEmpresas.setItems(empresas);
            String sucursal = new String("ANDRES AVELINO CACERES");
            sucursales.add(sucursal);
            lbxSucursales.setItems(sucursales);
            lbxEmpresas.setValue(empresas.get(0));
            lbxSucursales.setValue(sucursales.get(0));     
            txtUser.focus();
//            txtUser.setValue("hernan.esguar");
//            txtPass.setValue("80482065");    
//              txtUser.setValue("enriquez");
//              txtPass.setValue("123456"); 
//              txtUser.setValue("evelym");
//              txtPass.setValue("123456"); 
//              txtUser.setValue("magaly.guerra");
//              txtPass.setValue("42666876magaly"); 
              //Anular retiro
//              txtUser.setValue("mirelly");
//              txtPass.setValue("29700832"); 

//              txtUser.setValue("mescobar");
//              txtPass.setValue("123456"); 
              
              
//            txtUser.setValue("eduardo.rojas");
//            txtPass.setValue("29365126");
//            txtUser.setValue("evander");
//            txtPass.setValue("123456");
//            txtUser.setValue("delfor");
//            txtPass.setValue("123456");

        } catch (Exception ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onBtnConnect() {
        try {
            String user = txtUser.getValue();
            String pass = txtPass.getValue();
            if (user.isEmpty()) {
                txtUser.focus();
                return;
            }
            if (pass.isEmpty()) {
                txtPass.focus();
                return;
            }
            try {
//                Services.getLogin().login(user, pass, lbxEmpresas.getValue().id, lbxSucursales.getValue().id);
                
//                app.add(app.appLayout);
//                app.Ocultar();
                  this.setVisible(false);
                
                this.close();
                return;
            } catch (Exception ex) {
                Alerts.error(ex.getMessage());
            }
        } catch (Exception ex) {
            Alerts.info(ex.getMessage());
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void onBtnSubscribe() {
//        AlumnoView view = new AlumnoView(null, null);
//        view.showDialog();
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.view.loguin;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.time.LocalDate;
//import org.vaadin.stefan.fullcalendar.Entry;
//import org.vaadin.stefan.fullcalendar.FullCalendar;
//import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
//import ts.com.App;
import ts.com.client.component.Button;
import ts.com.client.component.Image;
import ts.com.client.component.Label;
import ts.com.client.component.ListBox;
import ts.com.client.component.PanelView;
import ts.com.client.component.PasswordTextBox;
import ts.com.client.component.TextBox;
import ts.com.server.Server;
import ts.com.service.model.empresa.Empresa;
import ts.com.service.model.empresa.Sucursal;
/**
 *
 * @author StarkLord
 */
public abstract class LoginUI extends PanelView {

    public final Image image = new Image(Server.LOGO, "logo_app").setStyles(
            "maxWidth","250px"
    );
//    public final Image image = new Image("img/logo_cetpro.png", "logo_app").setStyles(
//            "maxWidth","300px"
//    );
    
    public final ListBox<String> lbxEmpresas = new ListBox("Institucion").setStyles(
            "width","100%"
    );
    public final ListBox<String> lbxSucursales = new ListBox("Sucursal").setStyles(
            "width","100%"
    );
    public final TextBox txtUser = new TextBox("Usuario", "Digitar Usuario").setStyles(
            "width","100%"
    );
    public final PasswordTextBox txtPass = new PasswordTextBox("Clave", "Digitar Clave").setStyles(
            "width","100%"
    );
    public final Button btnConnect = new Button("Ingresar",VaadinIcon.KEY, this::onBtnConnect).setStyles(
            "width","100%",
            "font-size","20px",
            "height","50px"
    );
    public final Button btnSubscribe = new Button("No tengo usuario. Deseo Inscribirme Ya!").setStyle("color", "#fe4164");
//    public final VerticalLayout pnl = new VerticalLayout(
//            image, lbxEmpresas, lbxSucursales, txtUser, txtPass, btnConnect
//    );
    public final Label lblprueba = new Label("PRUEBA");
    public final VerticalLayout pnl = new VerticalLayout(
            image,lbxEmpresas,lbxSucursales, txtUser, txtPass, btnConnect
    );
    
    public DatePicker datePicker = new DatePicker();
//    public FullCalendar calendar = FullCalendarBuilder.create().build();

    public LoginUI() {
        super(VaadinIcon.SHOP, "MERCADO METROPOLITANO"); 
//        label.setStyles("color",App.COLOR2);
//        video.getElement().getStyle().se t("width", "300px"); 
 
//        video.getElement().getStyle().set("height", "200px");
//        video.getElement().setAttribute("url", "http://144.91.125.121:7007/files/prueba.mp4");
        //pnl.add(video);
        
        datePicker.setOpened(true);
        btnSubscribe.addClickListener(e->this.onBtnSubscribe());
        btnSubscribe.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        getBody().add(pnl);
        pnl.setAlignItems(FlexComponent.Alignment.CENTER);
        //init styles
        btnConnect.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.getStyle().set("maxWidth", "600px" );
        this.getStyle().set("border-radius", "10px ");
        this.setPadding(true);
        lblprueba.setStyles("-webkit-user-select","nome");
        lblprueba.setStyles("-moz-user-select","nome");
        lblprueba.setStyles("-ms-user-select","nome");
        lblprueba.setStyles("user-select","nome");
//        this.getStyle().set("background", "#f9eef4"); 
        //this.getStyle().set("background", "linear-gradient(indigo,#20242C) ");
        //this.getStyle().set("opacity", "0.9");
        txtUser.focus();
        
    }
    
    public abstract void onBtnConnect();
    public abstract void onBtnSubscribe();
    
}

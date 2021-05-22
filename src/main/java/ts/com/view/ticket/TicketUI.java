/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.view.ticket;

//import ts.com.client.view.*;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import java.time.LocalDate;
//import org.vaadin.stefan.fullcalendar.Entry;
//import org.vaadin.stefan.fullcalendar.FullCalendar;
//import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
import ts.com.Client;
import ts.com.client.component.Button;
import ts.com.client.component.DataTable;
import ts.com.client.component.FileModel;
import ts.com.client.component.Image;
import ts.com.client.component.ListBox;
import ts.com.client.component.PanelView;
import ts.com.service.model.almacen.Almacen;
import ts.com.service.model.empresa.Empresa;
import ts.com.service.model.empresa.Sucursal;
import ts.com.service.model.playa.Ticket;
/**
 *
 * @author Enriquez
 */
@Route("")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public abstract class TicketUI extends PanelView {


    public final Button btnConnect = new Button("EXCEL",VaadinIcon.FILE, this::onBtnConnect).setStyles(
            "width","100%",
            "font-size","15px",
            "height","30px"
    );
    public final Button btnIndicadores = new Button("Indicadores",VaadinIcon.ADJUST, this::onBtnIndicadores).setStyles(
            "font-size","15px",
            "height","30px",
            "color","red"
    );
    public final Button btnPlantilla = new Button("Plantilla",VaadinIcon.NOTEBOOK, this::onBtnPlantilla);
    public final Button btnTotal = new Button("Recalcular",VaadinIcon.NOTEBOOK, this::onBtnTotal);
    public final Button btnCerrar = new Button("Cerrar",VaadinIcon.NOTEBOOK, this::onCambiarEstado).setStyles(
            "font-size","15px",
            "height","30px"
    );
    
    public final Button btnSubscribe = new Button("No tengo usuario. Deseo Inscribirme Ya!").setStyle("color", "#fe4164");
    public final HorizontalLayout pnl2 = new HorizontalLayout();
    public final HorizontalLayout pnl3 = new HorizontalLayout();
    public final VerticalLayout pnldash = new VerticalLayout();
    public final DatePicker datePicker = new DatePicker();
    public final DatePicker dpFechaInicial = new DatePicker(LocalDate.now());
    public final DatePicker dpFechaFinal = new DatePicker(LocalDate.now());
    public final ListBox<Sucursal> lbxSucursales = new ListBox();
    public final DataTable<Ticket> dtTickets = new DataTable<>(true,false);
    public final HorizontalLayout Footer = new HorizontalLayout();
    
//    public SearchPerson person = new SearchPerson();
//    public ListBox<Almacen> lbxAlmacenes = new ListBox().setStyles(
//            "width","100%"
//    );
//    public Checkbox cbxIsFinalProduct = new Checkbox("Productos Finales");
//    
    public TicketUI() {
        
        super(VaadinIcon.RECORDS, "TICKETS"); 
//        label.setStyles("color",App.COLOR2);
//      video.getElement().setAttribute("url", "http://144.91.125.121:7007/files/prueba.mp4");
        dtTickets.addCol(Ticket::getFecha_ingreso, "F INGRESO").setTextAlign(ColumnTextAlign.END);
        dtTickets.addCol(Ticket::getFecha_salida, "F SALIDA").setTextAlign(ColumnTextAlign.END);
        dtTickets.addCol(Ticket::getCreador, "MOVIL").setTextAlign(ColumnTextAlign.END);
        dtTickets.addCol(Ticket::getNumero, "NUMERO").setTextAlign(ColumnTextAlign.END);
        dtTickets.addCol(Ticket::getPlaca, "PLACA");
        dtTickets.addCol(Ticket::getMonto, "MONTO");
        dtTickets.addCol(Ticket::getTarifa, "TARIFA");
        dtTickets.addCol(Ticket::getEncargado_dni, "ENCARGADO");
//        dtValorizaciones.addCol(Ticket::getCosto_total, "TOTAL");
      
        btnSubscribe.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        pnl2.add(dpFechaInicial,dpFechaFinal);
//        person.setWidthFull();
        pnl2.setWidthFull();
        getHeader().add(getToolBar());
//        getToolBar().getStyle().set("border", "red 5px solid");
        
        getToolBar().setWidthFull();
        getToolBar().add(getBtnAdd(),getBtnEdit(),getBtnRefresh());
        Footer.add(btnCerrar);
        pnl2.setDefaultVerticalComponentAlignment(Alignment.END);
        getToolBar().setJustifyContentMode(JustifyContentMode.END);
        getBody().add(pnl2,pnl3,dtTickets,Footer);
        getBody().setWidthFull();
        btnConnect.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.getStyle().set("maxWidth", "1500px" );
        this.getStyle().set("border-radius", "10px ");
        this.setPadding(true);
        dpFechaInicial.focus();
//        lbxAlmacenes.addValueChangeListener(e->onRefresh());
        dpFechaInicial.addValueChangeListener(e->onRefresh());
        dpFechaFinal.addValueChangeListener(e->onRefresh());
//        cbxIsFinalProduct.addValueChangeListener(e->this.onRefresh());
        initStyles();
    }
    
    public void initStyles(){
//        lbxAlmacenes.setPlaceholder("ALMACEN DESTINO");
        dtTickets.setHeight("500px");
        btnPlantilla.setWidth("150px");
        btnCerrar.setWidth("150px");
        btnConnect.setWidth("150px");
        getToolBar().setWidth("100%");
        getToolBar().setWidthFull();
        Footer.setWidthFull();
        getBody().setHeightFull();
        this.setWidth("100%");
    }
    
    
    
//    public abstract void onBtnAdd();
    public abstract void onBtnTotal();
    public abstract void onBtnIndicadores();
    public abstract void onBtnConnect();
    public abstract void onBtnPlantilla();
    public abstract void onCambiarEstado();
    
}

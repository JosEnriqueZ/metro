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
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.time.LocalDate;
//import org.vaadin.stefan.fullcalendar.Entry;
//import org.vaadin.stefan.fullcalendar.FullCalendar;
//import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;
//import ts.com.App;
import ts.com.Client;
import ts.com.client.component.Button;
import ts.com.client.component.DataTable;
import ts.com.client.component.Image;
import ts.com.client.component.Label;
import ts.com.client.component.ListBox;
import ts.com.client.component.PanelView;
import ts.com.client.component.PasswordTextBox;
//import ts.com.client.component.SearchPerson;
import ts.com.client.component.TextBox;
//import ts.com.client.view.persona.SearchPersonView;
import ts.com.server.Server;
import ts.com.service.model.almacen.Almacen;
import ts.com.service.model.empresa.Empresa;
import ts.com.service.model.empresa.Sucursal;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;
import ts.com.service.model.playa.TicketModel;
//import ts.com.service.model.logistica.ValorizacionCab;
//import ts.com.service.model.valorizacion.ValorizacionDetModel;
/**
 *
 * @author EnriqueZ
 */
public abstract class CierreCabUI extends PanelView {


    public final Button btnConnect = new Button("OBTENER PDF",VaadinIcon.FILE, this::onBtnConnect).setStyles(
            "width","100%",
            "font-size","20px",
            "height","30px"
    );
    public final Button btnDelete = new Button("Limpiar",VaadinIcon.REFRESH, this::onBtnSubscribe).setStyles(
            "width","100%",
            "font-size","20px",
            "height","30px"
    );
    public final Button btnExportPDF   = new Button("", VaadinIcon.FILE,"Exportar en PDF",
    this::onBtnExportPDF).setStyle("color", "#F61F43");
    public final TextBox txtVigilante = new TextBox("Vigilante:", "-");
    public final TextBox txtTurno = new TextBox("Turno:", "-");
    public final TextBox txtTotal = new TextBox("TOTAL:", "-");
    public final Button btnSubscribe = new Button("No tengo usuario. Deseo Inscribirme Ya!").setStyle("color", "#fe4164");
    public final HorizontalLayout pnl2 = new HorizontalLayout();
    public final HorizontalLayout pnl3 = new HorizontalLayout();
    public final HorizontalLayout pnl4 = new HorizontalLayout();
    public final HorizontalLayout Footer = new HorizontalLayout();
    public final VerticalLayout pnldash = new VerticalLayout();
    public final Button btnBuscarValorizacion = new Button("Buscar Valorizacion");
    public DatePicker datePicker = new DatePicker();
    public final DatePicker dpFechaInicial = new DatePicker(LocalDate.now());
    public final DatePicker dpFechaFinal = new DatePicker(LocalDate.now());
    
    public final ListBox<Sucursal> lbxSucursales = new ListBox();
    public final ListBox<CierreCab> lbxValorizacionAnidada = new ListBox<>();
    
//    public SearchPerson galpon      = new SearchPerson();
    public ListBox<Almacen> lbxAlmacenes = new ListBox("Almacenes").setStyles(
            "width","100%"
    );
    public ListBox<Integer> lbxLotes = new ListBox("Lotes").setStyles(
            "width","100%"
    );
//    public SearchPerson encargado   = new SearchPerson();
    public Checkbox cbxIsFinalProduct = new Checkbox("Productos Finales");
    public final TextBox total        = new TextBox("Total", "Total");
    public DataTable<TicketModel> dtCierresDet = new DataTable<>(true, false);
    public Label TOTAL = new Label("");
//    public AreaChartExample ace = new AreaChartExample();
//    public FullCalendar calendar = FullCalendarBuilder.create().build();

    public CierreCabUI() {
        super(VaadinIcon.RECORDS, "CIERRE DE CAJA"); 
        
        getHeader().add(btnExportPDF,getBtnAdd(),getBtnEdit(),getBtnRefresh());
//        getToolBar().add(btnExportPDF);
        datePicker.setOpened(true);
        btnSubscribe.addClickListener(e->this.onBtnSubscribe());
        lbxSucursales.addValueChangeListener(e->this.onLbxSucursales());
        lbxLotes.addValueChangeListener(e->this.onLbxLotes());
        btnBuscarValorizacion.addClickListener(e->onBuscarValorizacionAnidada());
        
        
        dtCierresDet.addCol(TicketModel::getSerieNumero, "SERIE");
        dtCierresDet.addCol(TicketModel::getFechaIngreso, "INGRESO");
        dtCierresDet.addCol(TicketModel::getFechaSalida, "SALIDA");

        dtCierresDet.addComponentColumn(item-> {
           return item.lbxActivo;
        }).setHeader("ANULADO").setAutoWidth(true).setSortable(true);
        dtCierresDet.addCol(TicketModel::getTarifa, "TARIFA");
        
        dtCierresDet.addCol(TicketModel::getObservado, "OBSERVADO");

        btnSubscribe.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
//        pnl2.add();
        pnl3.add(dpFechaInicial,dpFechaFinal,txtTurno,txtVigilante,txtTotal);
        pnl4.add(lbxValorizacionAnidada,btnBuscarValorizacion);
//        pnl3.add(lbxLotes,encargado);
        Footer.add(TOTAL,getBtnSave(),getBtnClose());
        getBody().add(pnl3,pnl4,dtCierresDet,Footer);
        getBody().setWidthFull();
        
        pnl2.setAlignItems(FlexComponent.Alignment.CENTER);
        pnl3.setDefaultVerticalComponentAlignment(Alignment.END);
        pnl4.setDefaultVerticalComponentAlignment(Alignment.END);
        btnConnect.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnDelete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        this.getStyle().set("border-radius", "10px ");
        dpFechaInicial.focus();
        initStyle();
    }
    
    public void initStyle(){
        txtVigilante.setReadOnly(true);
        txtVigilante.setWidth("300px");
        txtTurno.setReadOnly(true);
        txtTurno.setWidth("100px");
        txtTotal.setReadOnly(true);
        txtTotal.setWidth("100px");
        
        pnl4.setVisible(false);
        Footer.setWidthFull();
        Footer.setJustifyContentMode(JustifyContentMode.END);
        pnl3.setJustifyContentMode(JustifyContentMode.END);
        pnl2.setWidthFull();
        pnl4.setWidthFull();
//        encargado.setWidthFull();
//        encargado.lblSearch.setWidthFull();
        lbxValorizacionAnidada.setPlaceholder("Sin Valorizacion");
        dpFechaInicial.setLabel("Fecha Inicial:");
        dpFechaFinal.setLabel("Fecha Final:");
//        encargado.lblSearch.setLabel("Encargado:");
//        galpon.lblSearch.setLabel("Galpon Destino:");
        lbxValorizacionAnidada.setWidthFull();
        btnBuscarValorizacion.setWidth("300px");
        lbxValorizacionAnidada.setReadOnly(true);
        dpFechaFinal.setReadOnly(true);
        total.setReadOnly(true);
        dtCierresDet.setWidthFull();
        TOTAL.setWidth("150px");
        this.setWidth("1000px");
    }
    
    
    
    public abstract void onBtnConnect();
    public abstract void onBtnExportPDF();
    public abstract void onBtnSubscribe();
    public abstract void onLbxSucursales();
    public abstract void onLbxLotes();
    public abstract void onBuscarValorizacionAnidada();
    
}

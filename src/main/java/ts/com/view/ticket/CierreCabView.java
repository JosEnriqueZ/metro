/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.view.ticket;


//import ts.com.client.view.*;
import com.vaadin.flow.component.UI;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DriverCommand;
//import sk.smartbase.component.qrscanner.QrScanner;
//import org.vaadin.stefan.*;
//import org.vaadin.stefan.fullcalendar.Entry;
//import org.vaadin.stefan.fullcalendar.FullCalendar;
//import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import ts.com.Client;
import ts.com.client.factory.Alerts;
import ts.com.service.factory.Numbers;
import ts.com.service.factory.Services;
import ts.com.service.model.almacen.Almacen;
import ts.com.service.model.empresa.Empresa;
import ts.com.service.model.empresa.Sucursal;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;
import ts.com.service.model.playa.TicketModel;


/**
 *
 * @author StarkLord
 */

public class CierreCabView extends CierreCabUI {

//   public App app;
   public Boolean save = true;
   public CierreCab cc;
//   public List<ValorizacionCab> vcAnidada;
   public List<CierreDet> listCierreDet;
   public List<TicketModel> listmodel;
//   public List<ValorizacionDetModel> listValorizacionesDetModel;
   public List<Integer> lotes;
   
   public CierreCabView(CierreCab cc) {
        this.cc = cc;
        save = this.cc == null;
//        List<Almacen> almacenes;
//        try {
//            //empresas = Services.getEmpresa().listActive();
//            almacenes = Services.getAlmacen().listActives(0);
//            Almacen a = new Almacen();
//            a.id = -1;
//            a.codigo = "SELECIONE UN ALMACEN";  
//            a.descripcion = "->";
//            almacenes.add(0, a);
//            lbxAlmacenes.setList(almacenes);
            doInitData();
            onRefresh();
//            
//            } catch (Exception ex) {
//            Logger.getLogger(ValorizacionesView.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("ERROR: "+ex);
//            }
    }
   
   public CierreCabView() {
        this.cc = cc;
        save = this.cc == null;
        List<Almacen> almacenes;
//        try {
//            //empresas = Services.getEmpresa().listActive();
//            almacenes = Services.getAlmacen().listActives(0);
//            Almacen a = new Almacen();
//            a.id = -1;
//            a.codigo = "SELECIONE UN ALMACEN";  
//            a.descripcion = "->";
//            almacenes.add(0, a);
//            lbxAlmacenes.setList(almacenes);
            doInitData();
//            } catch (Exception ex) {
//            Logger.getLogger(ValorizacionesView.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("ERROR: "+ex);
//            }
    }
      

    public void doInitData() {
        if(!save){
            try {
                txtTurno.setValue(cc.turno);
                txtVigilante.setValue(cc.vigilante.toString());
                txtTotal.setValue("S/" + cc.total.toString()+ ".00");
                
//                dpFechaFinal.setValue(Client.ConvertToLocalDate(vc.fecha_fin));
//                dpFechaInicial.setValue(Client.ConvertToLocalDate(vc.fecha_inicio));
//                cbxIsFinalProduct.setValue(vc.is_final_product);
//                lbxAlmacenes.setValue(vc.almacen_destino);
////                encargado.persona = vc.encargado;
////              encargado.tf_dni.setValue(vc.encargado.toString());
////                encargado.lblSearch.setValue(vc.encargado.toString());
//                vcAnidada = new ArrayList<>();
//                if (vc.valorizacion_anidada != null) {
////                  System.out.println("es PRODUCTO FINALK_ " + vc.valorizacion_anidada.is_final_product);
//                    System.out.println("es PRODUCTO FINALK_ " + vc.valorizacion_anidada);
//                    vcAnidada.add(vc.valorizacion_anidada);
//                    lbxValorizacionAnidada.setList(vcAnidada);
//                    lbxValorizacionAnidada.setValue(vc.valorizacion_anidada);
//                    
//                }
//                TOTAL.setText("TOTAL: "+Numbers.getBigDecimal(vc.costo_total, 2).toString());
                
            } catch (Exception ex) {
                Logger.getLogger(CierreCabView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
//            dtValorizacionesDet.setVisible(false);
            lbxLotes.setVisible(false);
        }
        
    }

   
    @Override
    public void onBtnConnect() {
//        try {
            
//            String path = Services.getReporte().exportEXCELValorizacion(Client.ConvertToDate(dpFechaInicial.getValue()), Client.ConvertToDate(dpFechaFinal.getValue()) , person.persona);
//            String url = "http://142.44.162.39:8088/"+path;;
////           String url = "D:/files/"+path;  sadfasdfasfdsadfasdfas
//            System.out.println("Esperando Documento");
//            System.out.println("URL :" + url);
//            UI.getCurrent().getPage().open(url, "_blank");
//            //System.out.println("URL :" + url);
//            //UI.getCurrent().getPage().open(url, "_blank");
//        } catch (FileNotFoundException ex) {
//            Alerts.error("Error al obtener el reporte");
//            Logger.getLogger(ValorizacionView.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (Exception ex) {
//            Logger.getLogger(ValorizacionView.class.getName()).log(Level.SEVERE, null, ex);
//        }  
    }

    @Override
    public void onBtnSubscribe() {
//        ace.Close();
        pnldash.removeAll();
    }

    @Override
    public void onLbxSucursales() {
        
    }

    @Override
    public void onSave() {
        
            if (save) {
//                ValorizacionCab vc = new ValorizacionCab();
//                vc.creador = "root";
//                vc.activo = true;
//                vc.fecha_inicio = Client.ConvertToDate(dpFechaInicial.getValue());
//                vc.fecha_fin = Client.ConvertToDate(dpFechaFinal.getValue());
//                vc.almacen_destino = lbxAlmacenes.getValue();
////                vc.encargado = encargado.persona;
//                vc.costo_total = new BigDecimal(BigInteger.ZERO);
//                vc.is_final_product = cbxIsFinalProduct.getValue();
//                vc.estado = 'P';
//                vc.num_lotes = 1;       
//                System.out.println("Valorizacion CAB CREADA");
//                onClose();
                try {
//                    Services.getValorizacion().saveOrUpdate(save, vc);
//                    Alerts.info("Grabado exitosamente");
                    saveAndClose();
                } catch (Exception ex) {
                    Alerts.error(ex.getMessage());
//                    Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);

                }  
            }else{
////                vc = new ValorizacionCab();
//                vc.creador = "root";
//                vc.activo = true;
//                vc.fecha_inicio = Client.ConvertToDate(dpFechaInicial.getValue());
//                vc.fecha_fin = Client.ConvertToDate(dpFechaFinal.getValue());
//                vc.almacen_destino = lbxAlmacenes.getValue();
////                vc.encargado = encargado.persona;
////                vc.costo_total = new BigDecimal(BigInteger.ZERO);
//                vc.is_final_product = cbxIsFinalProduct.getValue();
//                if (lbxValorizacionAnidada.getValue()!=null) {
//                vc.valorizacion_anidada = lbxValorizacionAnidada.getValue();
//                    System.out.println("VC SAVE: " + vc.valorizacion_anidada);
//                }
//                System.out.println("VC aaaa: " + lbxValorizacionAnidada.getValue());

//                vc.estado = 'P';
                System.out.println("Valorizacion CAB actualizada");
//                onClose();
//                try {
//                    List<ValorizacionDetModel> list = dtValorizacionesDet.getList();
//                    for (ValorizacionDetModel vdm : list) {
//                        Services.getValorizacion().saveOrUpdateValoDet(false, vdm.valorizacion_det);
//                    }
//                    Services.getValorizacion().saveOrUpdate(save, vc);
//                    saveAndClose();
//                } catch (Exception ex) {
//                    Alerts.error(ex.getMessage());
//                    Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
//
//                }
            } 
    }
    
    public void onClose(){
        this.close();
    }

    @Override
    public void onRefresh() {
           lotes = new ArrayList<>();
            try {
                listCierreDet = Services.getTicket().listCierreDet(cc.id);
            } catch (Exception ex) {
                Logger.getLogger(CierreCabView.class.getName()).log(Level.SEVERE, null, ex);
            }
            listmodel = new ArrayList<>();
           for (CierreDet cd : listCierreDet) {
               System.out.println("cd: " + cd.id);
            TicketModel tm = new TicketModel(cd.ticket);
            listmodel.add(tm);
           }
           dtCierresDet.setList(listmodel);
    }

    @Override
    public void onLbxLotes() {
//           Integer lote = lbxLotes.getValue();
//           listValorizacionesDetModel = new ArrayList<>();
//           for (ValorizacionDet vd : listValorizacionesDet) {
//               if (vd.lote == lote) {
//               ValorizacionDetModel vdm = new ValorizacionDetModel();
//               vdm.valorizacion_det = vd;
//               vdm.txtcantidad.setValue(vd.cantidad.toString());
//               listValorizacionesDetModel.add(vdm); 
//               }
//           }
//           dtValorizacionesDet.setList(listValorizacionesDetModel);
    }

    @Override
    public void onBuscarValorizacionAnidada() {
//        ValorizacionesView view = new ValorizacionesView();
//        view.btnCerrar.setVisible(false);
//        view.btnPlantilla.setVisible(false);
//        view.btnConnect.setVisible(false);
//        view.getBtnAdd().setVisible(false);
//        view.getBtnEdit().setVisible(false);
//        view.getBtnRefresh().setVisible(false);
//        view.getToolBar().add(view.getBtnChoose());
//        view.getToolBar().add(view.getBtnClose());
//        
//        view.addChooseHandler(() -> {
//            this.vcAnidada = new ArrayList<>();
//            this.vcAnidada.add(view.dtValorizaciones.getSelectionModel().getFirstSelectedItem().get());
//            this.lbxValorizacionAnidada.setList(vcAnidada);
////            this.lbxValorizacionAnidada.setValue(vc);
//        });
////        view.addSaveHandler(this::onRefresh);
//        view.showDialog();
    }
    

        
        
    @Override
    public void onBtnExportPDF() {
       try {
//           UI.getCurrent().getSession().setAttribute("app", this);
//            CierreCab cb = dtCierreCab.getSelectionModel().getFirstSelectedItem().get();
            String path = Services.getReporte().exportPDFCierreCaja(cc,listCierreDet);
            //String url = App.getRequestUrl()+path;
//            String url = "http://144.217.15.161:8088/"+path;;
//            String url = "http://62.171.179.192:8088/"+path;;
            String url = "http://144.126.132.140:7007/"+path;;
//            String url = "D:/files/"+path;
            System.out.println("Esperando Documento");
            System.out.println("URL :" + url);
            UI.getCurrent().getPage().open(url, "_blank");
//            UI.getCurrent().getPage().open(url, "_blank");
//            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
//            DriverCommand.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
            //System.out.println("URL :" + url);
            //UI.getCurrent().getPage().open(url, "_blank");
        } catch (FileNotFoundException ex) {
            Alerts.error("Error al obtener el reporte" + ex.getMessage());
            Logger.getLogger(CierreCabView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Alerts.error("Error al obtener el reporte" + ex.getMessage());
            Logger.getLogger(CierreCabView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}

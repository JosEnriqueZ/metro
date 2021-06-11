/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ts.com.server.itext;


import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.WebColors;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument; 
import com.itextpdf.kernel.pdf.PdfWriter; 
import com.itextpdf.layout.Document; 
import com.itextpdf.layout.element.Paragraph;  
import java.io.FileNotFoundException;
import com.itextpdf.layout.element.Cell; 
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Table;  
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.Client;
import ts.com.client.component.DataTable;
import ts.com.server.Server;
import ts.com.service.factory.Numbers;
import ts.com.service.factory.Services;
import ts.com.service.model.persona.Persona;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;
import ts.com.service.model.playa.Ticket;
import ts.com.service.util.db.server.CRUD;

/**
 * 
 * @author Enrique Gutierrez Arias
 */

public class ReportPDFCierreCaja {
    CierreCab cc = new CierreCab();
    List<CierreDet> listCDet = new ArrayList<>();
    Persona alumno;
    Integer numpag;
    PdfFont bold = null;
    String nombre;
    BigDecimal  TOTAL= new BigDecimal(0);
    
//    HashMap<Matricula, HashMap<MatriculaDet, List<OrdenVentaDet>>> mapMatriculas = new HashMap<Matricula, HashMap<MatriculaDet, List<OrdenVentaDet>>>();
    
    public ReportPDFCierreCaja(CierreCab cc,List<CierreDet> list, String nombre) throws FileNotFoundException {

        System.out.println("Inicio el PDF tabla model");
        this.nombre = nombre;
        this.cc = cc;
        this.listCDet = list;
        try {
            
            
        } catch (Exception ex) {
            Logger.getLogger(ReportPDFCierreCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        initPDF();
    }
    
    public void initPDF() throws FileNotFoundException{

//         String usuario = App.getPersona().codigo;
        String url = Server.PATH_WEBAPPS;
         
        try {
            this.bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        } catch (IOException ex) {
            Logger.getLogger(ReportPDFCierreCaja.class.getName()).log(Level.SEVERE, null, ex);
        }

         String dest = url +"temps/"+ this.nombre + ".pdf";
          System.out.println("PDF creado: " + dest);
         PdfWriter writer = new PdfWriter(dest);   

         // Creating a PdfDocument       
         PdfDocument pdf = new PdfDocument(writer);

         // Creating a Document        
         //Document document = new Document(pdf,PageSize.A4.rotate());
         Document document = new Document(pdf);

         // Creando un objeto ImageData
//         String imageFile = url + "images/logo_ibero.jpg";
//         String imageFile2 = url + "images/leyenda.png";

//         ImageData data = null;
//         ImageData data2 = null;
//           try {
//               data = ImageDataFactory.create(imageFile);
//               data2 = ImageDataFactory.create(imageFile2);
//           } catch (MalformedURLException ex) {
//               Logger.getLogger(ReportPDFCierreCaja.class.getName()).log(Level.SEVERE, null, ex);
//           }
//         // Crear un objeto de imagen
//         Image img = new Image(data);
//         Image img2 = new Image(data2);
         // Establecer la posición de la imagen en el centro de la página
         //img.setAutoScale(true);
//         img.setWidth(70);
//         img.setHeight(55);
//         img2.setWidth(70);
//         img2.setHeight(55);
//
//         //(X,Y)
//         //empieza posicion (0,0) en la izquierda inferior 
//         img.setFixedPosition(40, 777);
//         img2.setFixedPosition(700, 627);

         //document.getPageEffectiveArea(PageSize.A4.rotate());
         //pdf.getFirstPage().setRotation(90);
         String para1 = "          METROPOLITANO";  

         Date fecha = cc.fecha;
         //String para2 = "REPORTE DE PAGOS Y DEUDAS DEL DIA " + new SimpleDateFormat("yyyy-MM-dd").format(fecha);  
         String paraTitutlo       = "REPORTE CIERRE DE CAJA ("+ new SimpleDateFormat("yyyy-MM-dd").format(fecha) +")";  
         String paravig     = "Vigilante : "+ cc.vigilante.toString();
//         String parafechas  = "Fecha Inicial: "+ cc..toString();
         String paraturno   = "Turno      : "+ cc.turno;
         
         String paradirec = "";  
        try {
//            paradirec = "Direccion : "+ Services.getDireccion().getDireccionDNI(alumno.identificador).get(0);
        } catch (Exception ex) {
            Logger.getLogger(ReportPDFCierreCaja.class.getName()).log(Level.SEVERE, null, ex);
        }
//         String paracel     = "Celular : " + Services.getMatricula().listByAlumno(alumno.id).get(0).cel_propio; 
         //String para3 = "Alumno: " + alumno.toString();
         
         // Creating Paragraphs    
         //PdfPCell celda = new PdfPCell(new Paragraph("Fin tabla"));
         //Paragraph espacio = new Paragraph("////////////////////"); 
         //espacio.setFontColor(Color.BLUE);
         //espacio.setFontSize(30F);
         Paragraph paragraph1 = new Paragraph(para1);  
         paragraph1.setMarginLeft(100);
         paragraph1.setFontColor(Color.WHITE);
         Paragraph paragraph2 = new Paragraph(paraTitutlo);
         paragraph2.setFixedPosition(60, 777, 700);
         //paragraph2.setMarginLeft(70);
         paragraph2.setHorizontalAlignment(HorizontalAlignment.CENTER);
         paragraph2.setFontSize(25F);
         paragraph2.setFont(bold);
         //Paragraph paragraph3 = new Paragraph(para3); 
         Paragraph NumPag = new Paragraph(); 
         Paragraph Vigilante = new Paragraph();
         Paragraph turno = new Paragraph();
         
         Vigilante.setFixedPosition(55, 765, 500);
         Vigilante.setFontSize(10F);
         Vigilante.add(paravig);
         
         turno.setFixedPosition(55, 755, 500);
         turno.setFontSize(10F);
         turno.add(paraturno);
         

         
         Paragraph cel = new Paragraph();
         cel.setFontSize(10F);
         cel.setFixedPosition(45, 785, 500);

         
         
         String EspacioBlanco= ".";
         Paragraph paragraphEspacio = new Paragraph(EspacioBlanco);
         paragraphEspacio.setFontSize(35F);
         //paragraphEspacio.setBackgroundColor(Color.WHITE, 95);
         paragraphEspacio.setFontColor(Color.WHITE, 100);
         document.add(paragraphEspacio);
         
         document.add(paragraph1);       
         document.add(paragraph2); 
         document.add(Vigilante); 
         document.add(turno); 
         
         
         document.add(cel); 
         //CREACION DE TABLAS
        //for (Matricula matricula : listMatr) {
            Table table = CreateTable();
            //DATOS
            //////////////////////////////////////////////////////////////
            List<Cell> datos = writePDFModel();
            for (Cell cell : datos) {
                table.addCell(cell);
            }
            table.setMarginLeft(180);
            //table.setFixedPosition(45, 580, 500);
            
            
            String paratotal   = "TOTAL   : S/"+ TOTAL.toString()+".00";
            Paragraph Total = new Paragraph();
            Total.setFixedPosition(55, 745, 500);
            Total.setFontSize(10F);
            Total.add(paratotal);
            
            document.add(Total); 
            document.add(table);
            //document.add(paragraphEspacio);
        //}     
         
         // Closing the document

         numpag = pdf.getNumberOfPages();
         System.out.println("num paginas: " + numpag);
//         NumPag.add("Paginas 1/1");
//         NumPag.setFixedPosition(745, 10, 50);
//         NumPag.setFontSize(9F);
//         document.add(NumPag);
         document.close();     
         System.out.println("Parrafo añadido added");   

      }
    
    private Table CreateTable() {
        // Creando una mesa             serie/numero /ciclo/concepto/monto       
        float[] pointColumnWidths = {   
//                                        30F, 35F, 
            //20F,//boleta
            60F,//fecha                            
            40F, //ciclo
            50F,//concepto  
            };      //pagos                          //PROM FINAL Y RECUP
        
        Table table = new Table(pointColumnWidths);

        table.setFontSize(12F);
//        table.addHeaderCell(createHeaderCell("SERIE"));
//        table.addHeaderCell(createHeaderCell("NUMERO"));
        table.addHeaderCell(createHeaderCell("TARIFA"));//28
        table.addHeaderCell(createHeaderCell("CANTIDAD"));//28
        table.addHeaderCell(createHeaderCell("SUBTOTAL"));
//        table.addHeaderCell(createHeaderCell("CONCEPTO"));//28
//        table.addHeaderCell(createHeaderCell("PAGOS"));//28
//        table.addHeaderCell(createHeaderCell("DEUDA"));//28

        return table;
    }
    
    private Cell createHeaderCell(String text){
        Cell cell = new Cell();
        cell.add(text);
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setFont(bold);
        if (text=="NUMERO"|| text=="TARIFA"|| text=="CANTIDAD"|| text=="SUBTOTAL") {
            cell.setTextAlignment(TextAlignment.CENTER);
        }
//        if (text=="MONTO") {
//            cell.setTextAlignment(TextAlignment.RIGHT);
//        }
        return cell;
    }
    
    private Cell createDataCell(String text){
        //System.out.println("DATO CELDA: "+ text);
        Cell cell = new Cell();
        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.setFont(bold);
//        double doble = Double.parseDouble(text);
//        if (doble<=12) {
//            cell.setFontColor(Color.RED, 10);    
//        }
//        if(doble==0){
//            cell.add(" ");
//            return cell;
//        } 
        cell.add(text);
        return cell;
    }
    
    
    private List<Cell> writePDFModel() throws FileNotFoundException {
        List<Cell> datos = new ArrayList<>();
        //lista de notasDET
//        mapMatriculas = new TreeMap<>(mapMatriculas);
        BigDecimal sumaTotal = new BigDecimal(0);
        try {
        System.out.println("REPORTE CAJA: ");

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
//        TOTAL= new BigDecimal(0); 
        
        String fechainicio = new String(), fechafinal = new String();
        Date fecha = cc.fecha;
            for (CierreDet cd : listCDet) {
//                cd.ticket.cuadre_caja = true;
//                CRUD.update(t);
                if (cd.ticket.activo == false) {
                    anul++;
                    continue;
                }
                
                switch(cd.ticket.tarifa.intValue()) {
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
                    cc.turno                +"|"+   //2    
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

                    datos.add(setCell("S/1.00"));
                    datos.add(setCell(count1.toString()));
                    datos.add(setCell("S/"+sub1.toString()+".00"));
                    
                    datos.add(setCell("S/2.00"));
                    datos.add(setCell(count2.toString()));
                    datos.add(setCell("S/"+sub2.toString()+".00"));
                    
                    datos.add(setCell("S/5.00"));
                    datos.add(setCell(count5.toString()));
                    datos.add(setCell("S/"+sub5.toString()+".00"));
                    
                    datos.add(setCell("S/10.00"));
                    datos.add(setCell(count10.toString()));
                    datos.add(setCell("S/"+sub10.toString()+".00"));
                    
                    datos.add(setCell("S/20.00"));
                    datos.add(setCell(count20.toString()));
                    datos.add(setCell("S/"+sub20.toString()+".00"));
                    
                    datos.add(setCell("S/0.00"));
                    datos.add(setCell(count0.toString()));
                    datos.add(setCell("S/"+sub0.toString()+".00"));
                    
                    datos.add(setCell("Anulados"));
                    datos.add(setCell(anul.toString()));
                    datos.add(setCell(""));
                    
                    datos.add(setCell("TOTAL"));
                    datos.add(setCell(numeroTotalTicket.toString()));
                    datos.add(setCell("S/"+TOTAL.toString()+".00"));

//                    datos.add(createDataCell(" "));
//                    datos.add(createDataCell(" "));
//                    datos.add(createDataCell(" "));
//                    datos.add(createDataCell(" "));
//                    datos.add(createDataCell(" "));
//                    datos.add(createDataCell(" "));
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
         
        
        
//        for (Ciclo ciclo : listCiclos) {
//            BigDecimal suma = new BigDecimal(0);
//            for (OrdenVentaDet ovd : listOVDet) {
//                if (Objects.equals(ovd.orden_venta.ciclo.id, ciclo.id)) {
//                    Cell cellcon = new Cell();
//                    cellcon.add(cont.toString());
//                    //cellcon.setMarginLeft(2);
//                    cellcon.setHorizontalAlignment(HorizontalAlignment.CENTER);
//                    datos.add(cellcon);
                    //SERIE

                    
//
//                    //NUMERO
//                    Cell cellNumero = new Cell();
//                    cellNumero.add(ovd.orden_venta.numero.toString());
//                    //cellcon.setMarginLeft(2);
//                    cellNumero.setHorizontalAlignment(HorizontalAlignment.CENTER);
//                    cellNumero.setTextAlignment(TextAlignment.CENTER);
//                    datos.add(cellNumero);
//
//                    //CICLO
//                    datos.add(createDataCell(ovd.orden_venta.ciclo.toString()));
//                    //CONCEPTO
//                    Cell cellConcepto = new Cell();
//                    cellConcepto.add(ovd.producto.nombre);
//                    //cellcon.setMarginLeft(2);
//                    cellConcepto.setHorizontalAlignment(HorizontalAlignment.CENTER);
//                    datos.add(cellConcepto);
//                    //MONTO
//                    Cell cellMonto = new Cell();
//                    cellMonto.add(Numbers.getBigDecimal(ovd.total, 2).toString());
//                    //cellcon.setMarginLeft(2);
//                    cellMonto.setTextAlignment(TextAlignment.RIGHT);
//                    cellMonto.setHorizontalAlignment(HorizontalAlignment.CENTER);
//                    datos.add(cellMonto);
//                    //SUMA
//                    suma = suma.add(Numbers.getBigDecimal(ovd.total, 2));
//                    System.out.println("monto: "+ Numbers.getBigDecimal(ovd.total, 2));
//                    System.out.println("SUMA: "+ suma);
//                }
//            }
//
//            //VACIOS
//            datos.add(createDataCell(" "));
//            datos.add(createDataCell(" "));
//            datos.add(createDataCell(" "));
//            String descripcion = "SUBTOTAL";
//            if(listCiclos.indexOf(ciclo)==listCiclos.size()-1){
//                descripcion = "TOTAL";
//            }
//            sumaTotal = sumaTotal.add(suma);
//            datos.add(createDataCell(descripcion));
//            datos.add(createDataCell(sumaTotal.toString()));
//            
//        }
//            //VACIOS
//            datos.add(createDataCell(" "));
//            datos.add(createDataCell(" "));
//            datos.add(createDataCell(" "));
//            datos.add(createDataCell("TOTAL"));
//            datos.add(createDataCell(sumaTotal.toString()));
        return datos;
    }
    
    public void setFormatoDeuda(Cell cell,String monto){
               if (monto.charAt(0)== '-') {
               cell.setFontColor(Color.RED, 100);
                }
    }
    
    public Cell setCell(String dato){
        Cell cell = new Cell();
        cell.add(dato);
        //cellcon.setMarginLeft(2);
        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
        cell.setTextAlignment(TextAlignment.CENTER);
        return  cell;           
    }
    
//    public void SetFormatAlumno(Cell cell, Matricula matri){
//        if (matri.tipo_matricula == Client.INGRESO_REINGRESO) {
//            //cell.setFontColor(Color.convertRgbToCmyk("#209115"));
//            cell.setFontColor(WebColors.getRGBColor("#209115"), 90);
//        }
//        if (matri.tipo_matricula == Client.INGRESO_DISTANCIA) {
//            cell.setFontColor(Color.BLUE, 100);
//        }
//        if (matri.tipo_matricula == Client.INGRESO_REPITENTE) {
//            cell.setFontColor(Color.ORANGE, 100);
//        }
//        cell.setHorizontalAlignment(HorizontalAlignment.LEFT);
//        cell.setTextAlignment(TextAlignment.LEFT);
//    }
//    
//    public String ValidarPagos(MatriculaDet md){
//        System.out.println("NO PAGO: " + md.monto.subtract(md.monto_pagado).toString());;
//        if (md.monto.compareTo(BigDecimal.ZERO)==0) {
//            return "";
//        }
//        if (md.monto.compareTo(md.monto_pagado)==0) {
//            return "";
//        }
//        if (md.monto.subtract(md.monto_pagado).compareTo(BigDecimal.ZERO)>0) {
//            return "-" + md.monto.subtract(md.monto_pagado).toString();
//        }
//        return "*";
//    }
//    
//    public BigDecimal ValidarSuma(MatriculaDet md){
//        if (md.monto.compareTo(BigDecimal.ZERO)==0) {
//            return new BigDecimal(BigInteger.ZERO);
//        }
//        if (md.monto.compareTo(md.monto_pagado)==0) {
//            return md.monto_pagado;
//        }
//        if (md.monto.subtract(md.monto_pagado).compareTo(BigDecimal.ZERO)<0) {
//            return new BigDecimal(BigInteger.ZERO);
//        }
//        return new BigDecimal(BigInteger.ZERO);
//    }
//    
//    public void getPagos(List<Cell> datos, String lblCiclo, MatriculaDet md, OrdenVentaDet ovd){
//        //NUMERO
//        Cell cellNumero = new Cell();
//        cellNumero.add(ovd.orden_venta.documento_serie +"-"+ ovd.orden_venta.documento_numero);
//        //cellcon.setMarginLeft(2);
//        cellNumero.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        cellNumero.setTextAlignment(TextAlignment.CENTER);
//        datos.add(cellNumero);
//        
//        //FECHA
//        Cell cellFecha = new Cell();
//        cellFecha.add(ovd.orden_venta.fecha.toString());
//        //cellcon.setMarginLeft(2);
//        cellFecha.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        cellFecha.setTextAlignment(TextAlignment.CENTER);
//        datos.add(cellFecha);
//        
//        //CICLO
//        datos.add(createDataCell(lblCiclo));
//        
//        //CONCEPTO
//        Cell cellConcepto = new Cell();
//        cellConcepto.add(md.producto.nombre);
//        //cellcon.setMarginLeft(2);
//        cellConcepto.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        datos.add(cellConcepto);
//        
//        //PAGOS
//        Cell cellPagos = new Cell();
//        String Pagos = "";
//        Pagos = ovd.total.toString();
//        cellPagos.add(Pagos);
//        //cellcon.setMarginLeft(2);
//        cellPagos.setTextAlignment(TextAlignment.RIGHT);
//        cellPagos.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        datos.add(cellPagos);
//        
//        //MONTO
//        Cell cellMonto = new Cell();
//        String m = ValidarPagos(md);
//        if (m.contains("-")) {
//            cellMonto.setFontColor(WebColors.getRGBColor("#AF002A"), 90);
//        }
//        cellMonto.add(m);
//        //cellcon.setMarginLeft(2);
//        cellMonto.setTextAlignment(TextAlignment.RIGHT);
//        cellMonto.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        datos.add(cellMonto);
//
//        //SUMA
//    }
//    
//    public void getConcepto(List<Cell> datos, String lblCiclo, MatriculaDet md){
//        //NUMERO
//        Cell cellNumero = new Cell();
//        cellNumero.add("-");
//        //cellcon.setMarginLeft(2);
//        cellNumero.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        cellNumero.setTextAlignment(TextAlignment.CENTER);
//        datos.add(cellNumero);
//        
//        //FECHA
//        Cell cellFecha = new Cell();
//        cellFecha.add("-");
//        //cellcon.setMarginLeft(2);
//        cellFecha.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        cellFecha.setTextAlignment(TextAlignment.CENTER);
//        datos.add(cellFecha);
//        
//        //CICLO
//        datos.add(createDataCell(lblCiclo));
//        
//        //CONCEPTO
//        Cell cellConcepto = new Cell();
//        cellConcepto.add(md.producto.nombre);
//        //cellcon.setMarginLeft(2);
//        cellConcepto.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        datos.add(cellConcepto);
//        
//        //PAGOS
//        Cell cellPagos = new Cell();
//        String Pagos = "EXO";
//        
//        Cell cellMonto = new Cell();
//        String m = ValidarPagos(md);
//        if (m.contains("-")) {
//            cellMonto.setFontColor(WebColors.getRGBColor("#AF002A"), 90);
//            Pagos = "";
//        }
//        
//        cellPagos.add(Pagos);
//        //cellcon.setMarginLeft(2);
//        cellPagos.setTextAlignment(TextAlignment.RIGHT);
//        cellPagos.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        datos.add(cellPagos);
//        
//        //MONTO
//
//        cellMonto.add(m);
//        //cellcon.setMarginLeft(2);
//        cellMonto.setTextAlignment(TextAlignment.RIGHT);
//        cellMonto.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        datos.add(cellMonto);
//
//    }

  

}

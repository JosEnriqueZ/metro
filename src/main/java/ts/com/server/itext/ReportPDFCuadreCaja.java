/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ts.com.server.itext;


/**
 * 
 * @author Enrique Gutierrez Arias  
 */

//public class ReportPDFCuadreCaja {
//    List<RetiroDet> listRetiroDetTemps = new ArrayList<>();
//    List<RetiroDet> listRetiroDet = new ArrayList<>();
//    Map<Integer, RetiroDet> listMAP = new HashMap<Integer, RetiroDet>();
//    Integer numpag;
//    Ciclo ciclo;
//    PdfFont bold = null;
//    
//    public ReportPDFCuadreCaja(Ciclo ciclo) throws FileNotFoundException {
//        System.out.println("Inicio el PDF tabla model");
//        this.ciclo = ciclo;
//        //list de notaDet
//        listRetiroDetTemps = Services.getRetiro().listXCiclo(ciclo.id);
//        for (RetiroDet temp : listRetiroDetTemps) {
//            if (listMAP.containsKey(temp.persona.id)) {
//            listMAP.replace(temp.persona.id, temp);
//            }else{
//            listMAP.put(temp.persona.id, temp);
//            }
//        }
//        listMAP = new TreeMap<>(listMAP);
//        
//        for (Map.Entry<Integer, RetiroDet> entry : listMAP.entrySet()) {
//            Integer key = entry.getKey();
//            RetiroDet val = entry.getValue();
//            listRetiroDet.add(val);
//        }
//        
//        
//        
//        initPDF();
//    }
//    
//    public void initPDF() throws FileNotFoundException{
//
//         String usuario = App.getPersona().codigo;
//         String url = Server.PATH_WEBAPPS;
//         
//        try {
//            this.bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
//        } catch (IOException ex) {
//            Logger.getLogger(ReportPDFCuadreCaja.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//         String dest = url +"temps/"+ usuario + ".pdf";
//          System.out.println("PDF creado: " + dest);
//         PdfWriter writer = new PdfWriter(dest);   
//
//         // Creating a PdfDocument       
//         PdfDocument pdf = new PdfDocument(writer);
//
//         // Creating a Document        
//         //Document document = new Document(pdf,PageSize.A4.rotate());
//         Document document = new Document(pdf,PageSize.A4.rotate());
//
//         // Creando un objeto ImageData
//         String imageFile = url + "images/logo_ibero.jpg";
//         String imageFile2 = url + "images/leyenda.png";
//
//         ImageData data = null;
//         ImageData data2 = null;
//           try {
//               data = ImageDataFactory.create(imageFile);
//               data2 = ImageDataFactory.create(imageFile2);
//           } catch (MalformedURLException ex) {
//               Logger.getLogger(ReportPDFCuadreCaja.class.getName()).log(Level.SEVERE, null, ex);
//           }
//         // Crear un objeto de imagen
//         Image img = new Image(data);
//         Image img2 = new Image(data2);
//         // Establecer la posición de la imagen en el centro de la página
//         //img.setAutoScale(true);
//         img.setWidth(70);
//         img.setHeight(55);
//         img2.setWidth(70);
//         img2.setHeight(55);
//
//         //(X,Y)
//         //empieza posicion (0,0) en la izquierda inferior 
//         img.setFixedPosition(40, 527);
//         img2.setFixedPosition(700, 527);
//
//         //document.getPageEffectiveArea(PageSize.A4.rotate());
//         //pdf.getFirstPage().setRotation(90);
//         String para1 = "          IBEROAMERICANO";  
//
//         Date fecha = new Date();
//         //String para2 = "REPORTE DE PAGOS Y DEUDAS DEL DIA " + new SimpleDateFormat("yyyy-MM-dd").format(fecha);  
//         String para2 = "REPORTE DE RETIRADOS POR CICLO ";  
//         String para3 = "Ciclo: " + this.ciclo.toString();
//         
//         // Creating Paragraphs    
//         //PdfPCell celda = new PdfPCell(new Paragraph("Fin tabla"));
//         //Paragraph espacio = new Paragraph("////////////////////"); 
//         //espacio.setFontColor(Color.BLUE);
//         //espacio.setFontSize(30F);
//         Paragraph paragraph1 = new Paragraph(para1);  
//         paragraph1.setMarginLeft(100);
//         paragraph1.setFontColor(Color.WHITE);
//         Paragraph paragraph2 = new Paragraph(para2);
//         paragraph2.setFixedPosition(275, 527, 750);
//         //paragraph2.setMarginLeft(70);
//         paragraph2.setHorizontalAlignment(HorizontalAlignment.CENTER);
//         paragraph2.setFontSize(25F);
//         paragraph2.setFont(bold);
//         Paragraph paragraph3 = new Paragraph(para3); 
//         Paragraph NumPag = new Paragraph(); 
//         Paragraph Autor = new Paragraph(); 
//         //Añadiendo IMG
//         document.add(img);
//         //document.add(img2);
//         // Adding paragraphs to document  
//         //document.add(espacio);       
//         document.add(paragraph1);       
//         document.add(paragraph2);   
//         document.add(paragraph3); 
//         
//         
//         String EspacioBlanco= " ";
//         Paragraph paragraphEspacio = new Paragraph(EspacioBlanco);
//         paragraphEspacio.setFontSize(14F);
//         //CREACION DE TABLAS
//            Table table = CreateTable(ciclo.getCodigo());
//            //DATOS
//            List<Cell> datos = writePDFModel(ciclo.id);
//            for (Cell cell : datos) {
//                table.addCell(cell);
//            }
//            document.add(table);
//            document.add(paragraphEspacio);    
//         
//         // Closing the document
//
//         numpag = pdf.getNumberOfPages();
//         System.out.println("num paginas: " + numpag);
//         NumPag.add("Paginas 1/1");
//         NumPag.setFixedPosition(745, 10, 50);
//         NumPag.setFontSize(9F);
//         
//         
//         Autor.add("Exportado por: " + App.getPersona().toString());
//         Autor.setFixedPosition(30, 10, 200);
//         Autor.setFontSize(7F);
//         
//         
//         document.add(NumPag);
//         document.add(Autor);
//         document.close();     
//         System.out.println("Parrafo añadido added");   
//
//      }
//    
//    private Table CreateTable(String ciclo) {
//        // Creando una mesa             cont/alumno  tipo/fecha/ responsable/descripcion
//        float[] pointColumnWidths = {   15F, 210F,  
//                                        //     40F, 
//                                             60F, 
//                                        //     30F,  120F
//                                        20F, 20F, 20F, 20F, 20F, 20F     
//                                    };       //PROM FINAL Y RECUP
//        
//        Table table = new Table(pointColumnWidths);
//        
//        table.setFontSize(9F);
//        //table.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        //table.setTextAlignment(TextAlignment.CENTER);
//        table.addHeaderCell(createHeaderCell("N°"));
////        table.addHeaderCell(createHeaderCell(ciclo));
//        table.addHeaderCell(createHeaderCell("Alumno"));
////        table.addHeaderCell(createHeaderCell("Tipo de Retiro"));
//        table.addHeaderCell(createHeaderCell("Fecha"));
////        table.addHeaderCell(createHeaderCell("Autor del Movimiento"));
////        table.addHeaderCell(createHeaderCell("Descripcion"));
//        table.addHeaderCell(createHeaderCell("Matr"));
//        table.addHeaderCell(createHeaderCell("Pn1"));
//        table.addHeaderCell(createHeaderCell("Pn2"));
//        table.addHeaderCell(createHeaderCell("Pn3"));
//        table.addHeaderCell(createHeaderCell("Pn4"));
//        table.addHeaderCell(createHeaderCell("Pn5"));
//
//
//        return table;
//    }
//    
//    private Cell createHeaderCell(String text){
//        Cell cell = new Cell();
//        cell.add(text);
//        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
//        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        cell.setFont(bold);
//        return cell;
//    }
//    
//    private Cell createDataCell(String text){
//        //System.out.println("DATO CELDA: "+ text);
//        Cell cell = new Cell();
//        cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
//        cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
//        cell.setTextAlignment(TextAlignment.CENTER);
//        cell.setFont(bold);
//        cell.add(text);
//        return cell;
//    }
//    
//    
//    private List<Cell> writePDFModel(Integer cicloId) throws FileNotFoundException {
//        List<Cell> datos = new ArrayList<>();
//        //lista de notasDET
//        Integer cont = 1;
//        for (RetiroDet rd : listRetiroDet) { 
//            try {
//                if (Services.getMatricula().HayMatriculaMayor(rd)) {
//                //contador
//                    Cell cellcon = new Cell();
//                    cellcon.add(cont.toString());
//                    //cellcon.setMarginLeft(2);
//                    cellcon.setHorizontalAlignment(HorizontalAlignment.CENTER);
//                    datos.add(cellcon);
//                    //Alumno
//                    Cell cellCurso = new Cell();
//                    cellCurso.add(rd.matricula.persona.toString());
//                    cellCurso.setMarginLeft(5);
//                    datos.add(cellCurso);
//                    //Tipo
//    //                Cell cellTipo = new Cell();
//    //                cellTipo.add(rd.tipo);
//    //                cellTipo.setMarginLeft(5);
//    //                datos.add(cellTipo);
//                    //Fecha
//                    Cell cellFecha = new Cell();
//                    cellFecha.add(rd.getFecha());
//                    cellFecha.setMarginLeft(5);
//                    datos.add(cellFecha);
//                        //RESPONSABLE
//        //                Cell cellResp = new Cell();
//        //                cellResp.add(rd.persona.codigo);
//        //                cellResp.setMarginLeft(5);
//        //                datos.add(cellResp);
//        //                //DESCRIPCION
//        //                Cell cellDescrip = new Cell();
//        //                cellDescrip.add(rd.descripcion);
//        //                cellDescrip.setMarginLeft(5);
//        //                datos.add(cellDescrip);
//                    //PAGOS X ALUMNO
//                    PagosXCicloModel model = Services.getCiclo().listPagosXMatricula(rd.matricula);
//                    model.matriculaCmp  = new PagoCmp(model.matricula, model.monto_matricula);
//                    model.pension1Cmp   = new PagoCmp(model.pension1, model.monto_pension1);            
//                    model.pension2Cmp   = new PagoCmp(model.pension2, model.monto_pension2);            
//                    model.pension3Cmp   = new PagoCmp(model.pension3, model.monto_pension3);            
//                    model.pension4Cmp   = new PagoCmp(model.pension4, model.monto_pension4);            
//                    model.pension5Cmp   = new PagoCmp(model.pension5, model.monto_pension5);            
//                    Cell cellMatr = new Cell();
//                    cellMatr.add(model.matriculaCmp.getMonto());
//                    cellMatr.setMarginLeft(5);
//                    datos.add(cellMatr);
//                    Cell cellPn1 = new Cell();
//                    cellPn1.add(model.pension1Cmp.getMonto());
//                    cellPn1.setMarginLeft(5);
//                    datos.add(cellPn1);
//                    Cell cellPn2 = new Cell();
//                    cellPn2.add(model.pension2Cmp.getMonto());
//                    cellPn2.setMarginLeft(5);
//                    datos.add(cellPn2);
//                    Cell cellPn3 = new Cell();
//                    cellPn3.add(model.pension3Cmp.getMonto());
//                    cellPn3.setMarginLeft(5);
//                    datos.add(cellPn3);
//                    Cell cellPn4 = new Cell();
//                    cellPn4.add(model.pension4Cmp.getMonto());
//                    cellPn4.setMarginLeft(5);
//                    datos.add(cellPn4);
//                    Cell cellPn5 = new Cell();
//                    cellPn5.add(model.pension5Cmp.getMonto());
//                    cellPn5.setMarginLeft(5);
//                    datos.add(cellPn5);
//                }
//            } catch (Exception ex) {
//                Logger.getLogger(ReportPDFCuadreCaja.class.getName()).log(Level.SEVERE, null, ex);
//            }     
//            cont++;
//        }
//        return datos;
//    }
//    
//    public void setFormatoDeuda(Cell cell,String monto){
//               if (monto.charAt(0)== '-') {
//               cell.setFontColor(Color.RED, 100);
//                }
//    }
//    
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
//
//    
//
//  
//
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.server.service.impl;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import ts.com.client.component.DataTable;
import ts.com.client.factory.Alerts;
import ts.com.server.Server;
import ts.com.server.itext.ReportPDFCierreCaja;
import ts.com.server.service.ReporteService;
import ts.com.service.factory.Services;

import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;

import ts.com.service.util.db.CConexion;

/**
 *
 * @author EnriqueZ Gutierrez Arias
 */
public class ReporteServiceImpl implements ReporteService {
    
    @Override
    public String exportPDFCierreCaja(CierreCab cb,List<CierreDet> list) throws Exception {
//      String usuario = App.getPersona().codigo;
        String nombre = "REPORTE_CIERRE_CAJA";
        ReportPDFCierreCaja pdf = new ReportPDFCierreCaja(cb, list, nombre);
        //String url = Server.PATH_WEBAPPS;
        String ruta = "temps/" + nombre + ".pdf";
        return ruta;
    }

}

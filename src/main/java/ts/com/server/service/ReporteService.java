/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts.com.server.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import ts.com.client.component.DataTable;
import ts.com.service.model.persona.Persona;
import ts.com.service.model.playa.CierreCab;
import ts.com.service.model.playa.CierreDet;

/**
 *
 * @author EnriqueZ 
 */
public interface ReporteService {
    public String exportPDFCierreCaja(CierreCab cb,List<CierreDet> list) throws Exception;
    
}

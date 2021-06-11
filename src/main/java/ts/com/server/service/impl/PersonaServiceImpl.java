/** *****************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ****************************************************************************** */
package ts.com.server.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import ts.com.service.model.persona.Direccion;
import ts.com.service.model.persona.Persona;
import ts.com.service.model.rrhh.Empleado;

import ts.com.server.service.PersonaService;
import ts.com.service.util.db.Update;
import ts.com.service.util.db.server.CRUD;


public class PersonaServiceImpl implements PersonaService {


    @Override
    public Persona save(Persona persona, Direccion direccion) throws Exception {
        try {
            Update.beginTransaction();
            CRUD.save(persona);
            if (direccion != null) {
                direccion.persona = persona;
                CRUD.save(direccion);
            }
            Update.commitTransaction();
            return persona;

        } catch (Exception ex) {
            ex.printStackTrace();
            Update.rollbackTransaction();
            throw new Exception(ex.getMessage());
        }

    }

//    @Override
//    public List<Persona> getListByNombre(String nombres, String apellidos) throws Exception {
//
////        String filter = "where apellidos ilike '%" + apellidos + "%' ";
////        if (!nombres.isEmpty()) {
////            filter += "and nombres ilike '%" + nombres + "%' ";
////        }
////        filter += "order by apellidos asc";
////        return CRUD.list(table, filter);
//    }

    @Override
    public Persona getByCodigoAndClavePortal(String codigo, String clavePortal) throws Exception {
        String[] req = {"documento_identidad","ciclo"};
        String filter = "where a.codigo ='" + codigo + "' and clave_portal = '"+clavePortal + "' order by apellidos asc";
        List<Persona> list =  CRUD.list(Persona.class, req, filter);
        return list.isEmpty()?null:list.get(0);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Persona> getListByIdentificador(String identificador) throws Exception {
        String[] req = {};
        String filter = "where identificador ='" + identificador + "' " + "order by apellidos asc";
        return CRUD.list(Persona.class, req, filter);
        
        // return CRUD.list(table,filter);
    }

    @Override
    public List<Persona> getListByRazonSocial(String razonSocial) throws Exception {
        String[] req = {"documento_identidad"};
        String filter = "where apellidos ilike '%" + razonSocial + "%' ";
        filter += "order by apellidos asc";
        return CRUD.list(Persona.class, req, filter);
        // return CRUD.list(table,filter);
    }

    @Override
    public void update(Persona persona) throws Exception {
        CRUD.update(persona);
    }

    @Override
    public List<Persona> getList(String nombres, String apellidos, String identificador) throws Exception {
        String[] req = {"documento_identidad"};
        String filterNames = " and nombres ilike '%" + nombres + "%' ";
        if (nombres.isEmpty()) {
            filterNames = " and (nombres ilike '%" + nombres + "%' or nombres is null) ";
        }

        String filter = "where apellidos ilike '%" + apellidos + "%' ";
        filter += filterNames;
        filter += "and identificador ilike '%" + identificador + "%' ";

        filter += "order by apellidos asc limit 100";
        return CRUD.list(Persona.class, req, filter);
        // return CRUD.list(table,filter);
    }



    @Override
    public List<Persona> getListPersonas(String nombres, String apellidos, String identificador) throws Exception {
        String[] req = {"documento_identidad"};

        String filter = " where (a.nombres ilike '%" + nombres + "%' or a.apellidos ilike '%" + apellidos + "%' "
                + "or a.identificador ilike '%" + identificador + "%') ";

        filter += "and a.activo is true order by a.apellidos asc";
        return CRUD.list(Persona.class, req, filter);
    }

}

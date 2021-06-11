/*******************************************************************************
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
 *******************************************************************************/
package ts.com.server.service;

import java.util.List;




import ts.com.service.model.persona.Direccion;
import ts.com.service.model.persona.Persona;

public interface PersonaService{
	
	public Persona save(Persona persona, Direccion direccion) throws Exception;
	public void update(Persona persona) throws Exception;
        
//        public Persona saveOrUpdate(boolean save, Curso curso, Ciclo ciclo)throws Exception ;
        public Persona getByCodigoAndClavePortal(String codigo, String clavePortal) throws Exception;
	
	public List<Persona> getList(String nombres, String apellidos, String identificador) throws Exception;
//	public List<Persona> getListByNombre(String nombres, String apellidos) throws Exception;
	public List<Persona> getListByIdentificador(String identificador) throws Exception;
	public List<Persona> getListByRazonSocial(String razonSocial) throws Exception;
//	public List<Persona> getList(String coincidence) throws Exception;
	
	//import
//	public void importClientsFromTxt() throws Exception;
	List<Persona> getListPersonas(String nombres, String apellidos, String identificador) throws Exception;
}

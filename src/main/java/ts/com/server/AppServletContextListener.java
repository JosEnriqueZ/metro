package ts.com.server;

import ts.com.service.util.db.CConexion;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import ts.com.Client;
//import ts.com.service.factory.Services;

@WebListener
public class AppServletContextListener implements ServletContextListener {

    public AppServletContextListener() {
        
        // TODO Auto-generated constructor stub
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            
            ServletContext sc = servletContextEvent.getServletContext();
            //Server.INIT_FILE = sc.getInitParameter("init_file");   
            Map<String, String> map = readFileInit(); 
            System.out.println("LEIDOOOO");
            Server.APP_NAME = map.get("app_name"); 
            Server.RUC = map.get("ruc");
            Server.DB_URL = map.get("db_url");
            Server.DB_DRIVER = map.get("db_driver");
            Server.DB_USR = map.get("db_usr"); 
            Server.DB_PWD = map.get("db_pwd");
            Server.URL_INVOICE_SERVICE = map.get("url_invoice_service");
            Server.PORT_TOMCAT = map.get("port_tomcat");
            Server.PATH_WEBAPPS = map.get("path_webapps");
            Server.PATH_SUNAT_SFS = map.get("path_sunat_sfs");
            Server.LOGO = map.get("logo");
            Server.PHRASE = map.get("phrase");
            Server.COMMERCIAL_NAME = map.get("commercial_name");
            Server.IMAGE_WALL = map.get("image_wall");
            CConexion.strUrl = Server.DB_URL;
            CConexion.strDriver = Server.DB_DRIVER;
            CConexion.strUsr = Server.DB_USR;
            CConexion.strPwd = Server.DB_PWD;
            initMetaData();

        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
    }
    
	private void initMetaData() {
		
		try {
//			Client.UBIGEOS = Services.getUbigeo().list();
		} catch (Exception ex) {
			Logger.getLogger(AppServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

    private Map<String, String> readFileInit() throws Exception {
        try {
            
            String iso = "ISO-8859-1";
            String utf = "UTF-8";
            File file = new File(Server.INIT_FILE);
            Scanner scan = new Scanner(file, iso);
            scan.useDelimiter("\n");
            String text = "";

            Map<String, String> map = new HashMap<>();

            while (scan.hasNext()) {
                String line = scan.next();
                Scanner scanLine = new Scanner(line);
                scanLine.useDelimiter("\t");
                //lectura de datos				
                String codigo = scanLine.next().trim();
                String data = scanLine.next().trim();
                //fin lectura de datos
                map.put(codigo, data);
            }
            scan.close();
            return map;

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

}

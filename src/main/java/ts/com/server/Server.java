package ts.com.server;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//import ts.com.service.model.academico.PreguntaAlumno;

public class Server {
//  public static String INIT_FILE = "D:\\evasoft\\tomcat8\\webapps\\reports\\init_evademy_ibero.txt";
//    public static String INIT_FILE = "D:\\files\\init_evademy_ibero.txt";  
//    public static String INIT_FILE = "D:\\files\\init_metropolitano.txt";  
//  public static String INIT_FILE = "/var/lib/tomcat8/webapps/reports/init_evademy_afleming.txt";
//  public static String INIT_FILE = "/var/lib/tomcat8/webapps/reports/init_evademy_ibero.txt";
  public static String INIT_FILE = "/var/lib/tomcat9/webapps/reports/init_metropolitano.txt";
    public static String APP_NAME; 
    public static String RUC; 
    public static String PORT_TOMCAT;
    public static String PATH_WEBAPPS;
    public static String PATH_SUNAT_SFS;
    public static String URL_INVOICE_SERVICE;
    public static String DB_URL;
    public static String DB_DRIVER;
    public static String DB_USR;
    public static String DB_PWD;
    public static String LOGO;
    public static String PHRASE;
    public static String COMMERCIAL_NAME;
    public static String IMAGE_WALL;
    public static List<String> sesiones = new ArrayList<>();
    

    /**
     * converts the given width(pixels) into width of that table relative to the
     * given width
     *
     * @param width
     * @return
     */
    public static int getCellWidth(int width) {
        return width * (35);
    }

    public static String quitaEspacios(String texto) {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(texto);
        StringBuilder buff = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            buff.append(" ").append(tokens.nextToken());
        }
        return buff.toString().trim();
    }

    public static void writeFile(String filePath, String content) throws Exception {
        System.out.println("grabando en: " + filePath);
        System.out.println("contenido: " + content);
        FileWriter fw = new FileWriter(filePath);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(content);
        fw.close();

    }
    
    

}

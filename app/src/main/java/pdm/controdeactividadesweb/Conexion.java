package pdm.controdeactividadesweb;

/**
 * Created by Rodrigo on 6/11/2016.
 */


public class Conexion {
    //Cambie estos Parametos segun su PC
    public String URLLocal = "http://192.168.1.8/ControlActividades";
    public String URLServerLocal = "http://192.168.1.8/";
    public String URLServerPublico = "http://190.62.44.208/";
    public Conexion() {}

    public String getURLServerLocal() {
        return URLServerLocal;
    }
    public String getURLServerPublico() {
        return URLServerPublico;
    }
    public String getURLLocal() {
        return URLLocal;
    }
}
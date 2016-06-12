package pdm.controdeactividadesweb;

/**
 * Created by Rodrigo on 6/11/2016.
 */


public class Conexion {
    //Cambie estos Parametos segun su PC
    public String URLLocal = "http://169.254.80.80";
    public String URLServerLocal = "http://10.10.60.3";
    public String URLServerPublico = "http://138.255.154.43";
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
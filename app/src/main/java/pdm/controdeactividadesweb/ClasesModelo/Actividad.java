package pdm.controdeactividadesweb.ClasesModelo;

/**
 * Created by yohalmo on 06-12-16.
 */
public class Actividad {
    String id_actividad;
    String cod_docente;
    String nom_actividad;
    String detalle_actividad;
    String fecha;
    String hora_ini;
    String hora_fin;

    public Actividad() {
    }

    public Actividad(String id_actividad, String cod_docente, String nom_actividad, String detalle_actividad, String fecha, String hora_ini, String hora_fin) {
        this.id_actividad = id_actividad;
        this.cod_docente = cod_docente;
        this.nom_actividad = nom_actividad;
        this.detalle_actividad = detalle_actividad;
        this.fecha = fecha;
        this.hora_ini = hora_ini;
        this.hora_fin = hora_fin;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getCod_docente() {
        return cod_docente;
    }

    public void setCod_docente(String cod_docente) {
        this.cod_docente = cod_docente;
    }

    public String getNom_actividad() {
        return nom_actividad;
    }

    public void setNom_actividad(String nom_actividad) {
        this.nom_actividad = nom_actividad;
    }

    public String getDetalle_actividad() {
        return detalle_actividad;
    }

    public void setDetalle_actividad(String detalle_actividad) {
        this.detalle_actividad = detalle_actividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora_ini() {
        return hora_ini;
    }

    public void setHora_ini(String hora_ini) {
        this.hora_ini = hora_ini;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }
}

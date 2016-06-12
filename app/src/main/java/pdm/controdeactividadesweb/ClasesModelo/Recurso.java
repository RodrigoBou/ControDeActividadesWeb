package pdm.controdeactividadesweb.ClasesModelo;

/**
 * Created by kelly on 11/06/2016.
 */
public class Recurso {
    private int id_recurso;
    private int id_cat_recurso;
    private int estado;
    private String nom_recurso;
    private String detalle_recurso;

    public  Recurso(){

    }

    public Recurso(int id_recurso, int id_cat_recurso, int estado, String nom_recurso, String detalle_recurso) {
        this.id_recurso = id_recurso;
        this.id_cat_recurso = id_cat_recurso;
        this.estado = estado;
        this.nom_recurso = nom_recurso;
        this.detalle_recurso = detalle_recurso;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getId_cat_recurso() {
        return id_cat_recurso;
    }

    public void setId_cat_recurso(int id_cat_recurso) {
        this.id_cat_recurso = id_cat_recurso;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNom_recurso() {
        return nom_recurso;
    }

    public void setNom_recurso(String nom_recurso) {
        this.nom_recurso = nom_recurso;
    }

    public String getDetalle_recurso() {
        return detalle_recurso;
    }

    public void setDetalle_recurso(String detalle_recurso) {
        this.detalle_recurso = detalle_recurso;
    }
}

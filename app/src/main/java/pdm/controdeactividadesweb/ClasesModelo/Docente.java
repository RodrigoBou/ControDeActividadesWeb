package pdm.controdeactividadesweb.ClasesModelo;

/**
 * Created by yohalmo on 06-11-16.
 */
public class Docente {

    String cod_docente;
    String nom_docente;

    public Docente() {
    }

    public Docente(String cod_docente, String nom_docente) {
        this.cod_docente = cod_docente;
        this.nom_docente = nom_docente;
    }

    public String getCod_docente() {
        return cod_docente;
    }

    public void setCod_docente(String cod_docente) {
        this.cod_docente = cod_docente;
    }

    public String getNom_docente() {
        return nom_docente;
    }

    public void setNom_docente(String nom_docente) {
        this.nom_docente = nom_docente;
    }
}

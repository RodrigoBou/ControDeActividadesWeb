package pdm.controdeactividadesweb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import pdm.controdeactividadesweb.ClasesModelo.Docente;


@SuppressLint("NewApi")
public class DocenteConsultarActivity extends Activity {

    Conexion conn;

    EditText codDocente;
    TextView texto1;
    TextView texto2;
    Docente docente = new Docente();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docente_consultar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        conn = new Conexion();

        codDocente = (EditText) findViewById(R.id.editText_fecha);
        texto1 = (TextView) findViewById(R.id.texto1);
        texto2 = (TextView) findViewById(R.id.texto2);
        //valor default
        codDocente.setText("YV00001");
    }

    public void servicioPHP(View v) {
        String codigo = codDocente.getText().toString();
        String url = "";

        if (v.getId() == R.id.boton)
            url = conn.getURLLocal() + "/ControlActividades/ws_consultar_docente.php" + "?cod_docente=" + codigo;

        String docenteExterno = "";
        docenteExterno = ControlServicios.obtenerRespuestaPeticion(url, this);
        docente = ControlServicios.obtenerDocente(docenteExterno, this);

        String cod = "Codigo Docente: " + docente.getCod_docente();
        String nom = "Nombre Docente: " + docente.getNom_docente();
        texto1.setText(cod);
        texto2.setText(nom);

    }

}





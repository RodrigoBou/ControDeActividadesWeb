package pdm.controdeactividadesweb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import pdm.controdeactividadesweb.ClasesModelo.Actividad;


@SuppressLint("NewApi")
public class  ActividadConsultarActivity extends Activity {

    Conexion conn;

    EditText fechaTxt;
    TextView texto1;
    TextView texto2;
    TextView texto3;
    TextView texto4;
    TextView texto5;
    TextView texto6;
    TextView texto7;
    Actividad actividad = new Actividad();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_consultar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        conn = new Conexion();

        fechaTxt = (EditText) findViewById(R.id.editTextFecha);
        texto1 = (TextView) findViewById(R.id.texto1);
        texto2 = (TextView) findViewById(R.id.texto2);
        texto3 = (TextView) findViewById(R.id.texto3);
        texto4 = (TextView) findViewById(R.id.texto4);
        texto5 = (TextView) findViewById(R.id.texto5);
        texto6 = (TextView) findViewById(R.id.texto6);
        texto7 = (TextView) findViewById(R.id.texto7);

    }

    public void servicioPHP(View v) {
        String fecha = fechaTxt.getText().toString();
        String url = "";

        if (v.getId() == R.id.boton)
            url = conn.getURLLocal() + "/ControlActividades/ws_consultar_actividad_fecha.php" + "?fecha=" + fecha;

        String actividadExterna = "";
        actividadExterna = ControlServicios.obtenerRespuestaPeticion(url, this);
        actividad = ControlServicios.obtenerActividad(actividadExterna, this);

        String id = "ID Actividad: " + actividad.getId_actividad();
        String cod = "Codigo Docente: " + actividad.getCod_docente();
        String nom = "Nombre Actividad: " + actividad.getNom_actividad();
        String det = "Detalle Actividad: " + actividad.getDetalle_actividad();
        String ini = "Hora Inicio: " + actividad.getHora_ini();
        String fin = "Hora Fin: " + actividad.getHora_fin();
        String Fecha = "Fecha: " + actividad.getFecha();

        texto1.setText(id);
        texto2.setText(cod);
        texto3.setText(nom);
        texto4.setText(det);
        texto5.setText(ini);
        texto6.setText(fin);
        texto7.setText(Fecha);
    }

}


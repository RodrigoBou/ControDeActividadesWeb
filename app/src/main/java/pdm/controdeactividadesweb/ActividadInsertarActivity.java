package pdm.controdeactividadesweb;

import org.json.JSONObject;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")


public class ActividadInsertarActivity extends Activity {


    EditText editID_ACTIVIDAD;
    EditText editCOD_DOCENTE;
    EditText editNOM_ACTIVIDAD;
    EditText editDETALLE_ACTIVIDAD;
    EditText editFECHA;
    EditText editHORA_INI;
    EditText editHORA_FIN;


    Conexion conn;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_insertar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        conn=new Conexion();
        editID_ACTIVIDAD = (EditText) findViewById(R.id.editID_ACTIVIDAD);
        editCOD_DOCENTE = (EditText) findViewById(R.id.editCOD_DOCENTE);
        editNOM_ACTIVIDAD = (EditText) findViewById(R.id.editNOM_ACTIVIDAD);
        editDETALLE_ACTIVIDAD = (EditText) findViewById(R.id.editDETALLE_ACTIVIDAD);
        editFECHA = (EditText) findViewById(R.id.editFECHA);
        editHORA_INI = (EditText) findViewById(R.id.editHORA_INI);
        editHORA_FIN = (EditText) findViewById(R.id.editHORA_FIN);


    }
    public void insertarActividad(View v) {

        String IDACTIVIDAD = editID_ACTIVIDAD.getText().toString();
        String COD_DOCENTE = editCOD_DOCENTE.getText().toString();
        String NOM_ACTIVIDAD = editNOM_ACTIVIDAD.getText().toString();
        String DETALLE_ACTIVIDAD = editDETALLE_ACTIVIDAD.getText().toString();
        String FECHA = editFECHA.getText().toString();
        String HORA_INI = editHORA_INI.getText().toString();
        String HORA_FIN = editHORA_FIN.getText().toString();

        String url = null;

        url ="";

        url=conn.getURLLocal()+"/ControlActividades/ws_actividad_insert.php"+ "?ID_ACTIVIDAD=" + IDACTIVIDAD + "&COD_DOCENTE=" + COD_DOCENTE + "&NOM_ACTIVIDAD=" + NOM_ACTIVIDAD + "&DETALLE_ACTIVIDAD=" + DETALLE_ACTIVIDAD + "&FECHA=" + FECHA + "&HORA_INI=" + HORA_INI + "&HORA_FIN=" + HORA_FIN;


        String ingresado;
        ingresado=ControlServicios.insertarActividadPHP(url, this);

        Toast.makeText(this, ingresado, Toast.LENGTH_LONG).show();

    }


    public void limpiarTextoReserva(View v) {

        editID_ACTIVIDAD.setText("");
        editCOD_DOCENTE.setText("");
        editNOM_ACTIVIDAD.setText("");
        editDETALLE_ACTIVIDAD.setText("");
        editFECHA.setText("");
        editHORA_INI.setText("");
        editHORA_FIN.setText("");


    }
}




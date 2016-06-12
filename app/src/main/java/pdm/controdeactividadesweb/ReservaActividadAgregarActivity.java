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
public class ReservaActividadAgregarActivity extends Activity {

    EditText edit_ID_RECURSO;
    EditText edit_ID_ACTIVIDAD;
    Conexion conn;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_actividad_agregar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        conn=new Conexion();
        edit_ID_RECURSO = (EditText) findViewById(R.id.editID_RECURSO);
        edit_ID_ACTIVIDAD = (EditText) findViewById(R.id.editID_ACTIVIDAD);
    }
    public void insertarReservaActividad(View v) {

        String ID_RECURSO = edit_ID_RECURSO.getText().toString();
        String ID_ACTIVIDAD = edit_ID_ACTIVIDAD.getText().toString();


        String url = null;

        url ="";

        url=conn.getURLLocal()+"/ControlActividades/ws_reservaactividad_insert.php"+ "?ID_RECURSO=" + ID_RECURSO + "&ID_ACTIVIDAD=" + ID_ACTIVIDAD;


        String ingresado;
        ingresado=ControlServicios.insertarReservaActividadPHP(url, this);

        Toast.makeText(this, ingresado, Toast.LENGTH_LONG).show();

    }


    public void limpiarTextoReserva(View v) {

        edit_ID_RECURSO.setText("");
        edit_ID_ACTIVIDAD.setText("");


    }
}


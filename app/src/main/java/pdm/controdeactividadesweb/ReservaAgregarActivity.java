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


public class ReservaAgregarActivity extends Activity {


    EditText editReserva;
    EditText editGrupo;
    EditText editRecurso;


    Conexion conn;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_agregar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        conn=new Conexion();
        editReserva = (EditText) findViewById(R.id.editIdReserva);
        editGrupo = (EditText) findViewById(R.id.editGrupo);
        editRecurso = (EditText) findViewById(R.id.editRecurso);


    }
    public void insertarReserva(View v) {

        String reserva = editReserva.getText().toString();
        String grupo = editGrupo.getText().toString();
        String recurso = editRecurso.getText().toString();

        String url = null;

        url ="";

        url=conn.getURLLocal()+"/ControlActividades/ws_insertar_reserva.php"+ "?ID_GRUPO=" + grupo + "&ID_RESERVA=" + reserva + "&ID_RECURSO=" + recurso;


        String ingresado;
        ingresado=ControlServicios.insertarReservaPHP(url, this);

        Toast.makeText(this, ingresado, Toast.LENGTH_LONG).show();

        }


    public void limpiarTextoReserva(View v) {

        editRecurso.setText("");
        editReserva.setText("");
        editGrupo.setText("");

    }

}
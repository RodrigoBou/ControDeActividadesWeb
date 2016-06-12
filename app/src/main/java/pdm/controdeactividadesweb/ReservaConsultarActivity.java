package pdm.controdeactividadesweb;

import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.Parser;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ReservaConsultarActivity extends Activity {
    EditText editIdReserva;
    EditText editIdGrupo;
    TextView textViewRecurso;
    Conexion conn;

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_consultar);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        editIdReserva = (EditText) findViewById(R.id.editIdReserva);
        editIdGrupo = (EditText) findViewById(R.id.editIdGrupo);
        textViewRecurso = (TextView) findViewById(R.id.textViewRecurso);
        conn=new Conexion();
    }

    public void consultarReservaPHP(View v) {
        Integer IdReserva = Integer.valueOf(editIdReserva.getText().toString());
        Integer IdGrupo= Integer.valueOf(editIdGrupo.getText().toString());
        String url = null;
        url ="";
        url=conn.getURLLocal()+"/ControlActividades/ws_reserva_consultar.php"+ "?id_reserva="+ IdReserva + "&id_grupo=" + IdGrupo;

        String consultaReservaJSON = ControlServicios.obtenerRespuestaPeticion(url, this);
        textViewRecurso.setText(ControlServicios.consultaReservaPHP(consultaReservaJSON, this));
    }


    public void limpiarTextoReserva(View v) {

        editIdReserva.setText("");
        editIdGrupo.setText("");
        textViewRecurso.setText("");

    }
}

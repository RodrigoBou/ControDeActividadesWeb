package pdm.controdeactividadesweb;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pdm.controdeactividadesweb.ClasesModelo.Recurso;

@SuppressLint("NewApi")
public class RecursoEliminarActivity extends AppCompatActivity {

    Conexion conn;

    EditText editRecurso;
    TextView text;

    Recurso recurso = new Recurso();


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurso_eliminar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        conn = new Conexion();

        editRecurso = (EditText) findViewById(R.id.editRecurso);
        text = (TextView) findViewById(R.id.text);
    }

    public void servicioPHP(View v){
        Integer id = Integer.valueOf(editRecurso.getText().toString());
        String url = "";

            url = conn.getURLLocal() + "/ControlActividades/ws_eliminar_recurso.php" + "?id_recurso=" + id;

        String eliminarRecursoJSON = ControlServicios.obtenerRespuestaPeticion(url, this);

        text.setText(ControlServicios.eliminarRecurso(eliminarRecursoJSON, this));

    }
}

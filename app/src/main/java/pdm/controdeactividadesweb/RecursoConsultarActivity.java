package pdm.controdeactividadesweb;

import org.json.JSONException;
import org.json.JSONObject;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pdm.controdeactividadesweb.ClasesModelo.Recurso;


public class RecursoConsultarActivity extends Activity {
    EditText editIdRecurso;
    EditText editIdCatRecurso;
    TextView textViewNombre;
    TextView textViewDetalle;
    TextView textViewEstado;
    Conexion conn;
    static List<Recurso> listaRecursos;

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurso_consultar);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        editIdRecurso = (EditText) findViewById(R.id. editIdRecurso);
        editIdCatRecurso = (EditText) findViewById(R.id.editIdCatRecurso);
        textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        textViewDetalle = (TextView) findViewById(R.id.textViewDetalle);
        textViewEstado = (TextView) findViewById(R.id.textViewEstado);
        conn=new Conexion();


    }

    public void consultarRecursoPHP(View v) {
        Integer IdRecurso =  Integer.valueOf(editIdRecurso.getText().toString());
        Integer IdCatRecurso=  Integer.valueOf(editIdCatRecurso.getText().toString());
        String url = null;
        url ="";
        url=conn.getURLLocal()+"/ControlActividades/ws_recurso_consultar.php"+ "?id_recurso="+ IdRecurso + "&id_cat_recurso=" + IdCatRecurso;



        Recurso gm= new  Recurso();

        gm=ControlServicios.consultaRecursoPHP(url, this);




        if (gm.getNom_recurso()==null){
            Toast.makeText(this, "No se encontro el resgistro", Toast.LENGTH_LONG).show();

        }

        else{

            textViewNombre.setText(gm.getNom_recurso().toString());
            textViewDetalle.setText(gm.getDetalle_recurso().toString());
            textViewEstado.setText(String.valueOf(gm.getEstado()));
        }

    }


    public void limpiarTextoReserva(View v) {

        editIdRecurso.setText("");
        editIdCatRecurso.setText("");
        textViewNombre.setText("");
        textViewDetalle.setText("");
        textViewEstado.setText("");


    }
}

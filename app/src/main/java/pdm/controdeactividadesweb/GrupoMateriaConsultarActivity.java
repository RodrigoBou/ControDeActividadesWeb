package pdm.controdeactividadesweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pdm.controdeactividadesweb.ClasesModelo.GrupoMateria;

@SuppressLint("NewApi")


public class GrupoMateriaConsultarActivity extends Activity {


    EditText editCodigo;
    EditText editMateria;
    EditText editDocente;
    EditText editTipoGrupo;
    EditText editCiclo;
    EditText editHorario;
    EditText editDias;
    EditText editNum;
    EditText editLocal;

     Conexion conn;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo_materia_consultar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        conn=new Conexion();

        editCodigo = (EditText) findViewById(R.id.editIdGrupo);
        editDocente = (EditText) findViewById(R.id.editDocente);
        editMateria = (EditText) findViewById(R.id.editMateria);
        editLocal = (EditText) findViewById(R.id.editLocal);
        editCiclo = (EditText) findViewById(R.id.editCiclo);
        editDias = (EditText) findViewById(R.id.editDiasImpartida);
        editNum = (EditText) findViewById(R.id.editNumGrupo);
        editHorario = (EditText) findViewById(R.id.editHorario);



    }
    public void consultarGrupoMateria(View v) {


        String grupo = editCodigo.getText().toString();


        String url = null;

        url ="";

        url=conn.getURLLocal()+"/ControlActividades/ws_consultar_grupo.php"+ "?ID_GRUPO=" + grupo;



        GrupoMateria gm= new GrupoMateria();

        gm=ControlServicios.obtenerGrupoMateria(url, this);

        editCiclo.setText(gm.getCiclo().toString());



    }


    public void limpiarTextoReserva(View v) {

        editCodigo.setText("");
        editDias.setText("");
        editDocente.setText("");
        editHorario.setText("");
        editNum.setText("");
        editLocal.setText("");
        editNum.setText("");
        editTipoGrupo.setText("");

    }

}

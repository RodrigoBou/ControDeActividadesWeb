package pdm.controdeactividadesweb;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {

    private EditText editNomUsuario;
    private EditText editPasswordUsuario;
    Conexion conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        editNomUsuario = (EditText) findViewById(R.id.editNomUsuario);
        editPasswordUsuario = (EditText) findViewById(R.id.editTextPassword);
        conn=new Conexion();
        SharedPreferences session = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(session.getInt("id",0) > 0){
            Intent intent = new Intent(this, ControlActividades.class);
            startActivity(intent);
        }



    }

    public void validarUsuario(View v) {
        String Usuario = editNomUsuario.getText().toString();
        String Password=  editPasswordUsuario.getText().toString();
        String url = null;
        url ="";
        url=conn.getURLLocal()+"/ControlActividades/login.php"+ "?usuario="+ Usuario + "&password=" + Password;

        String consultaReservaJSON = ControlServicios.obtenerRespuestaPeticion(url, this);

        if((ControlServicios.validarUsuario(consultaReservaJSON, this))){
            SharedPreferences session = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = session.edit();
            editor.apply();
            Intent intent = new Intent(this,ControlActividades.class);
            startActivity(intent);
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("El usuario o contraseña son incorrectos");

            alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int idDialog) {
                    editNomUsuario.setText("");
                    editPasswordUsuario.setText("");
                    dialog.dismiss();
                }
            });
        }








    }

}


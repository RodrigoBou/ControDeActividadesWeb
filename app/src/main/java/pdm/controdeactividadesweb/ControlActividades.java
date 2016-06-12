package pdm.controdeactividadesweb;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
public class ControlActividades extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_actividades);
    }
    public void lanzarActividad(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.button_consultarDocente:
                i = new Intent(this, DocenteConsultarActivity.class);
                break;
            case R.id.button_eliminarReserva:
                i = new Intent(this, ReservaEliminarActivity.class);
                break;

            case R.id.button_consultarReserva:
                i = new Intent(this, ReservaConsultarActivity.class);
                break;
            case R.id.button_agregarReserva:
                i = new Intent(this, ReservaAgregarActivity.class);
                break;
            case R.id.button_consultarRecurso:
                i = new Intent(this, RecursoConsultarActivity.class);
                break;
            case R.id.button_consultarGrupoMateria:
                i = new Intent(this, GrupoMateriaConsultarActivity.class);
                break;
            case R.id.button_agregarReservaActividad:
                i = new Intent(this, ReservaActividadAgregarActivity.class);
                break;
            case R.id.button_consultarActividad:
                i = new Intent(this, ActividadConsultarActivity.class);
                break;
            case R.id.button_agrgarActividad:
                i = new Intent(this, ActividadInsertarActivity.class);
                break;
            case R.id.button_cerrarSesion:
                SharedPreferences session = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = session.edit();
                editor.remove("id");
                editor.apply();

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        if (i != null)
            startActivity(i);
    }
}


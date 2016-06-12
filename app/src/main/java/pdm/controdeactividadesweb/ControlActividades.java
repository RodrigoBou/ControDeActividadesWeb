package pdm.controdeactividadesweb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
            case R.id.button_consultarReservaActividad:
                i = new Intent(this, ReservaActividadConsultarActivity.class);
                break;
            case R.id.button_agrgarActividad:
                i = new Intent(this, ActividadInsertarActivity.class);
                break;
        }
        if (i != null)
            startActivity(i);
    }
}


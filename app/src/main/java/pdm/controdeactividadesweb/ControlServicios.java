package pdm.controdeactividadesweb;

/**
 * Created by Rodrigo on 6/11/2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import pdm.controdeactividadesweb.ClasesModelo.Actividad;
import pdm.controdeactividadesweb.ClasesModelo.Docente;
import pdm.controdeactividadesweb.ClasesModelo.GrupoMateria;
import pdm.controdeactividadesweb.ClasesModelo.Recurso;

public class ControlServicios {


    public static String obtenerRespuestaPeticion(String url, Context ctx) {
        String respuesta = " ";
// Estableciendo tiempo de espera del servicio
        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 3000);
        HttpConnectionParams.setSoTimeout(parametros, 5000);
// Creando objetos de conexion
        HttpClient cliente = new DefaultHttpClient(parametros);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpRespuesta = cliente.execute(httpGet);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                HttpEntity entidad = httpRespuesta.getEntity();
                respuesta = EntityUtils.toString(entidad);
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion",
                    Toast.LENGTH_LONG).show();
// Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static String obtenerRespuestaPost(String url, JSONObject obj,
                                              Context ctx) {
        String respuesta = " ";
        try {
            HttpParams parametros = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(parametros, 3000);
            HttpConnectionParams.setSoTimeout(parametros, 5000);
            HttpClient cliente = new DefaultHttpClient(parametros);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("content-type", "application/json");
            StringEntity nuevaEntidad = new StringEntity(obj.toString());
            httpPost.setEntity(nuevaEntidad);
            Log.v("Peticion", url);
            Log.v("POST", httpPost.toString());
            HttpResponse httpRespuesta = cliente.execute(httpPost);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                respuesta = Integer.toString(codigoEstado);
                Log.v("respuesta", respuesta);
            } else {
                Log.v("respuesta", Integer.toString(codigoEstado));
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG)
                    .show();
// Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }


    //SERVICIO PARA INSERTAR RESERVAS

    public static String insertarReservaPHP(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        String cadena;
        cadena = "";
        try {
            JSONObject resultado = new JSONObject(json);
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1) {
                cadena = "Registro ingresado";
            } else {
            }
        } catch (JSONException e) {
            e.printStackTrace();
            cadena = "Error registro duplicado";
        }


        return cadena;
    }


    public static String insertarReservaActividadPHP(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        String cadena;
        cadena = "";
        try {
            JSONObject resultado = new JSONObject(json);
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1) {
                cadena = "Registro ingresado";
            } else {
            }
        } catch (JSONException e) {
            e.printStackTrace();
            cadena = "Error registro duplicado";
        }


        return cadena;
    }



    public static boolean validarUsuario(String json, Context ctx) {
        boolean validacion = false;

        try {
            JSONObject resultado = new JSONObject(json);
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                validacion = true;
            else {

            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return validacion;
    }

    public static String eliminarRecurso(String json, Context ctx) {
        String cadena;
        cadena = "";

        try {
            JSONObject resultado = new JSONObject(json);
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                cadena = "Registro eliminado";
            else {

            }
        } catch (JSONException e) {
            e.printStackTrace();
            cadena = "Error registro no encontrado";

        }
        return cadena;
    }


    public static String insertarActividadPHP(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        String cadena;
        cadena = "";
        try {
            JSONObject resultado = new JSONObject(json);
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1) {
                cadena = "Registro ingresado";
            } else {
            }
        } catch (JSONException e) {
            e.printStackTrace();
            cadena = "Error registro duplicado";
        }


        return cadena;
    }

    public static String consultaReservaPHP(String json, Context ctx) {
        try {
            JSONArray objs = new JSONArray(json);
            if (objs.length() != 0)
                return objs.getJSONObject(0).getString("ID_RECURSO");
            else {
                Toast.makeText(ctx, "Error no existe", Toast.LENGTH_LONG).show();
                return " ";
            }
        } catch (JSONException e) {
            Toast.makeText(ctx, "Error con la respuesta JSON", Toast.LENGTH_LONG).show();
            return " ";
        }
    }

    public static Recurso consultaRecursoPHP(String url, Context ctx) {

        String json = obtenerRespuestaPeticion(url, ctx);
        Recurso recurso;
        recurso = new Recurso();

        try {
            JSONArray objs = new JSONArray(json);
            if (objs.length() != 0) {
                recurso.setId_recurso(objs.getJSONObject(0).getInt("ID_RECURSO"));
                recurso.setId_cat_recurso(objs.getJSONObject(0).getInt("ID_CAT_RECURSO"));
                recurso.setNom_recurso(objs.getJSONObject(0).getString("NOM_RECURSO"));
                recurso.setDetalle_recurso(objs.getJSONObject(0).getString("DETALLE_RECURSO"));
                recurso.setEstado(objs.getJSONObject(0).getInt("ESTADO"));
            } else {

                Toast.makeText(ctx, "Error no existe", Toast.LENGTH_LONG).show();

            }
        } catch (JSONException e) {

        }

        return recurso;
    }


    //SERVICIO PARA INSERTAR CONSULTAR GRUPOS POR SU ID

    public static GrupoMateria obtenerGrupoMateria(String url, Context ctx) {

        String json = obtenerRespuestaPeticion(url, ctx);
        GrupoMateria grupo;
        grupo = new GrupoMateria();

        try {
            JSONArray objs = new JSONArray(json);
            if (objs.length() != 0) {
                grupo.setIdGrupo(objs.getJSONObject(0).getInt("ID_GRUPO"));
                grupo.setCiclo(objs.getJSONObject(0).getString("ID_CICLO"));
                grupo.setDocente(objs.getJSONObject(0).getString("COD_DOCENTE"));
                grupo.setHorario(objs.getJSONObject(0).getInt("ID_HORARIO"));
                grupo.setLocal(objs.getJSONObject(0).getString("LOCAL"));
                grupo.setMateria(objs.getJSONObject(0).getString("COD_MATERIA"));
                grupo.setDiasImpartida(objs.getJSONObject(0).getString("DIASIMPARTIDA"));
                grupo.setNumGrupo(objs.getJSONObject(0).getString("NUM_GRUPO"));
                grupo.setTipoGrupo(objs.getJSONObject(0).getString("ID_TIPO_GRUPO"));

            } else {

                Toast.makeText(ctx, "Error carnet no existe", Toast.LENGTH_LONG).show();

            }
        } catch (JSONException e) {

        }

        return grupo;
    }

    public static Docente obtenerDocente(String json, Context ctx) {

        try {
            JSONArray docenteJSON = new JSONArray(json);
            JSONObject obj = docenteJSON.getJSONObject(0);

            Docente docente = new Docente();

            docente.setCod_docente(obj.getString("COD_DOCENTE"));
            docente.setNom_docente(obj.getString("NOM_DOCENTE"));
            return docente;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseo de JSON", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public static Actividad obtenerActividad(String json, Context ctx) {

        try {
            JSONArray actividadJSON = new JSONArray(json);
            JSONObject obj = actividadJSON.getJSONObject(0);

            Actividad actividad = new Actividad();

            actividad.setId_actividad(obj.getString("ID_ACTIVIDAD"));
            actividad.setCod_docente(obj.getString("COD_DOCENTE"));
            actividad.setNom_actividad(obj.getString("NOM_ACTIVIDAD"));
            actividad.setDetalle_actividad(obj.getString("DETALLE_ACTIVIDAD"));
            actividad.setFecha(obj.getString("FECHA"));
            actividad.setHora_ini(obj.getString("HORA_INI"));
            actividad.setHora_fin(obj.getString("HORA_FIN"));
            return actividad;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseo de JSON", Toast.LENGTH_LONG).show();
            return null;
        }
    }


}
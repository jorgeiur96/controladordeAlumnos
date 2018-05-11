package com.example.jorge.controlalumnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Grupo extends AppCompatActivity {
    GridView listado;

    profesores pr=new profesores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupo);
     listado =(GridView) findViewById(R.id.listView);
        Intent intent2 = getIntent();

        Bundle extras = intent2.getExtras();

        final String Nombre=extras.getString("Nombre");
        final String Apellido=extras.getString("Apellido");
        final String correo=extras.getString("correo");
        final String contrasenia=extras.getString("contrasenia");
        final String cedula=extras.getString("cedula");
        pr.setCedulaProfesor(cedula);



        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Grupo.this, ""+i, Toast.LENGTH_SHORT).show();
               // .makeText(Bloque1.this,""+i,Toast.LENGTH_SHORT).show();
                Intent intent2 =new Intent(Grupo.this,Alumnos.class);

                String d= String.valueOf(listado.getItemAtPosition(i));
                Toast.makeText(Grupo.this, ""+d, Toast.LENGTH_SHORT).show();

                int numero = i;

                String cadena = "";
                cadena = String.valueOf(numero);

                intent2.putExtra("cedula",pr.getCedulaProfesor());
                startActivity(intent2);



            }

        });
        obtDatos();
    }

    public void obtDatos(){

        AsyncHttpClient client =new AsyncHttpClient();
        String url="http://192.168.1.6:8081/control/grupo.php";
        RequestParams parametros =new RequestParams();
        parametros.put("cedula","'"+pr.getCedulaProfesor()+"'");

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    cargarListaJSON(obtDatos(new String(responseBody)));
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });


    }

    public  void cargarListaJSON(ArrayList<String> datos){

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        listado.setAdapter(adapter);

    }

    public ArrayList<String> obtDatos (String response){
        ArrayList<String> listado=new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            String texto,texto2,texto3;

            for (int i=0;i<21;i++){

                texto =jsonArray.getJSONObject(i).getString("GradoGrupo");

                listado.add(texto);

            }

        }catch (Exception e){

            e.printStackTrace();
        }
        return  listado;
    }
}

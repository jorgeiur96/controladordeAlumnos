package com.example.jorge.controlalumnos;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    Spinner sp1;
    TextInputEditText txtUser;
    TextInputEditText txtPasword;

    profesores pro=new profesores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Incializar();
    }

    private void Incializar() {

        txtUser=(TextInputEditText)findViewById(R.id.txtUser);
        txtPasword=(TextInputEditText)findViewById(R.id.txtpass);
       sp1=(Spinner)findViewById(R.id.sp1);

    }
    public  void B1clik(View Btn){
        switch (sp1.getSelectedItemPosition()){
            case 0: VerMensaje(Btn,"Debes escoger alguna  opcion de la lista");break;
            case 1:Acudiente(Btn);break;
            case 2:Profesor(Btn);break;

            default:
                VerMensaje(Btn,"Debes escoger alguna  opcion de la lista");
                break;
        }



    }

    public  void VerMensaje(View btn,String Men){
        Snackbar.make(btn,Men,Snackbar.LENGTH_INDEFINITE)
                .show();

    }

    private void Acudiente(View Btn) {
        VerMensaje(Btn,"Esto es para acudiente");
    }

    private void Profesor(View Btn) {

        if(!txtUser.getText().toString().isEmpty()) {
            boolean is = isValidEmail(txtUser.getText() + "");
            if (is != false ) {


                AsyncHttpClient client = new AsyncHttpClient();
                String url = "http://192.168.1.6:8081/control/index.php";
                RequestParams parametros = new RequestParams();
                parametros.put("correo", "'" + txtUser.getText().toString() + "'");


                client.post(url, parametros, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                        if (statusCode == 200) {
                            cargarListaJSON(obtDatos(new String(responseBody)));


                            if (pro.getCorreo().equals(txtUser.getText()+"")) {
                                if (pro.getContrasenia().equals(txtPasword.getText() + "")) {


                                    Intent intent2 =new Intent(MainActivity.this,ClaseProfesor.class);


                                    intent2.putExtra("Nombre",pro.getNombre());
                                    intent2.putExtra("Apellido",pro.getPrimerapellido());
                                    intent2.putExtra("correo",pro.getCorreo());
                                    intent2.putExtra("contrasenia",pro.getContrasenia());
                                    intent2.putExtra("cedula",pro.getCedulaProfesor());
                                    startActivity(intent2);

                                } else {


                                    Toast.makeText(getBaseContext(), "contraseña erronea", Toast.LENGTH_LONG).show();
                                }


                            } else {

                                Toast.makeText(getBaseContext(), "usuario  no existe", Toast.LENGTH_LONG).show();
                            }


                        }


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });

            }else{


                VerMensaje(Btn, "debe ser  un correo");
            }
        }else {


            VerMensaje(Btn, "campos vacios");
        }
    }

    public final static boolean isValidEmail(CharSequence email) {
        if (email== null) return false;
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    public  void cargarListaJSON(ArrayList<String> datos){

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        //listado.setAdapter(adapter);
        //Toast.makeText(this,adapter.getItem(0),Toast.LENGTH_LONG).show();


    }

    public ArrayList<String> obtDatos (String response){
        ArrayList<String> listado=new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            String texto,texto2,texto3,texto4,texto5,texto6;



            for (int i=0;i<jsonArray.length();i++){

                texto =jsonArray.getJSONObject(i).getString("nombre");
                texto2 =jsonArray.getJSONObject(i).getString("primerapellido");
                texto3=jsonArray.getJSONObject(i).getString("SegundoApellido");
                texto4 =jsonArray.getJSONObject(i).getString("CedulaProfesor");
                texto5 =jsonArray.getJSONObject(i).getString("correo");
                texto6 =jsonArray.getJSONObject(i).getString("contrasenia");

                pro.setNombre(texto);
                pro.setPrimerapellido(texto2);
                pro.setSegundoApellido(texto3);
                pro.setCedulaProfesor(texto4);
                pro.setCorreo(texto5);
                pro.setContrasenia(texto6);



                listado.add(texto);

            }

        }catch (Exception e){

            e.printStackTrace();
        }
        return  listado;
    }




}





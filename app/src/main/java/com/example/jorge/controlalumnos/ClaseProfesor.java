package com.example.jorge.controlalumnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jorge.controlalumnos.Vista.Ialumnos;

public class ClaseProfesor extends AppCompatActivity {
    TextView txtNombre;
    TextView txtApellido;
    ImageButton btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase_profesor);
        txtNombre=(TextView)findViewById(R.id.txtnombre);
        txtApellido=(TextView)findViewById(R.id.txtappellido);
        btnadd=(ImageButton)findViewById(R.id.add);

        Intent intent2 = getIntent();

        Bundle extras = intent2.getExtras();

        final String Nombre=extras.getString("Nombre");
        final String Apellido=extras.getString("Apellido");
        final String correo=extras.getString("correo");
        final String contrasenia=extras.getString("contrasenia");
        final String cedula=extras.getString("cedula");
        txtNombre.setText(Nombre);
        txtApellido.setText(Apellido);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(ClaseProfesor.this,Grupo.class);
                intent.putExtra("Nombre",Nombre);
                intent.putExtra("Apellido",Apellido);
                intent.putExtra("correo",correo);
                intent.putExtra("contrasenia",contrasenia);
                intent.putExtra("cedula",cedula);

                startActivity(intent);
            }
        });


    }


}

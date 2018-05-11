package com.example.jorge.controlalumnos;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.jorge.controlalumnos.Adaptador.AlumnosAdaptador;
import com.example.jorge.controlalumnos.Modelo.infoAlumno;
import com.example.jorge.controlalumnos.Vista.Ialumnos;

import java.util.ArrayList;

public class Alumnos extends AppCompatActivity   implements Ialumnos {
    private RecyclerView ListaAlumno;
    ArrayList<infoAlumno> alumnos;
    profesores pr=new profesores();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        Intent intent2 = getIntent();

        Bundle extras = intent2.getExtras();

        final String cedula=extras.getString("cedula");
        pr.setCedulaProfesor(cedula);

       ListaAlumno=(RecyclerView)findViewById(R.id.rvListaPerfil);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 =new Intent(Alumnos.this,Materias.class);





                intent2.putExtra("cedula",pr.getCedulaProfesor());
                startActivity(intent2);
                Snackbar.make(view, ""+pr.getCedulaProfesor(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        generarLayout();
        inicializarAdaptadorRV();
        crearAdaptador();
    }

    public void generarLayout(){

        GridLayoutManager glm = new GridLayoutManager(this,2);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        ListaAlumno.setLayoutManager(glm);


    }
 public  void crearAdaptador(){
        AlumnosAdaptador AdaptadorAlumnos=new AlumnosAdaptador(alumnos,this);
        ListaAlumno.setAdapter(AdaptadorAlumnos);

}
   public  void  inicializarAdaptadorRV(){

  alumnos =new ArrayList<infoAlumno>();

  alumnos.add(new infoAlumno("jorge","1067947217"));
       alumnos.add(new infoAlumno("andres arrieta","765447897"));
       alumnos.add(new infoAlumno("jorge","1067947217"));
       alumnos.add(new infoAlumno("andres arrieta","765447897"));
       alumnos.add(new infoAlumno("jorge","1067947217"));
       alumnos.add(new infoAlumno("andres arrieta","765447897"));

   }


}

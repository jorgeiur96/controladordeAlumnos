package com.example.jorge.controlalumnos.Adaptador;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jorge.controlalumnos.Modelo.infoAlumno;
import com.example.jorge.controlalumnos.R;

import java.util.ArrayList;

public class AlumnosAdaptador extends RecyclerView.Adapter<AlumnosAdaptador.adaViewHolder> {

    private Activity activity;
    private ArrayList<infoAlumno> AlumnolDataset;


    public AlumnosAdaptador(ArrayList<infoAlumno> myDataset, Activity activity) {
        this.AlumnolDataset = myDataset;
        this.activity = activity;
    }







    @Override
    public adaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vw = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_alumnos, parent, false);
        adaViewHolder vh = new adaViewHolder(vw);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull adaViewHolder vHolder, int position) {


        final infoAlumno infoAlumnos = AlumnolDataset.get(position);

        //vHolder.imgFoto.setImageResource(perfilInfo.getFoto());
        vHolder.Nombre.setText(infoAlumnos.getNombre());
        vHolder.Identificacion.setText(infoAlumnos.getIdentificacion());

    }

    @Override
    public int getItemCount() {
        return AlumnolDataset.size();
    }

    public static class adaViewHolder extends RecyclerView.ViewHolder {

        private TextView Nombre;
        private TextView Identificacion;

        public adaViewHolder(View itemView) {
            super(itemView);


            Nombre= (TextView) itemView.findViewById(R.id.txtNombre);
            Identificacion= (TextView) itemView.findViewById(R.id.txtidentificacion);

        }
    }
}

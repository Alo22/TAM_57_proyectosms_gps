package com.example.tam_sms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{
    private Context context;
    private List<Llamada> llamadas;

    public Adapter(Context context, List<Llamada> llamadas) {
        this.context = context;
        this.llamadas = llamadas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Llamada llamada = llamadas.get(position);
        holder.nombre.setText( llamada.getNumero());
        holder.fabricante.setText( llamada.getBody());
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( context,"" + position,Toast.LENGTH_SHORT ).show();
            }
        } );
    }

    @Override
    public int getItemCount() {
        return llamadas.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder {

    public TextView nombre, fabricante;

    public ViewHolder(View itemView){
        super(itemView);
        nombre = itemView.findViewById(R.id.lblMsg );
        fabricante = itemView.findViewById(R.id.lblNumber );
    }
}


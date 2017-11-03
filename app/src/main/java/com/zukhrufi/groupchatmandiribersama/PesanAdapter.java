package com.zukhrufi.groupchatmandiribersama;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by WINDOWS on 11/3/2017.
 */

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.MAdapter> {

    JSONArray jsonArray;

    public PesanAdapter(JSONArray jsonArray){
        this.jsonArray = jsonArray;
    }


    @Override
    public MAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_pesan,parent,false);
        return new MAdapter(view);
    }

    @Override
    public void onBindViewHolder(MAdapter holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.foto.setImageResource(jsonObject.getInt("Foto"));
            holder.pengirim.setText(jsonObject.getString("Pengirim"));
            holder.content.setText(jsonObject.getString("Content"));
            holder.waktu.setText(jsonObject.getString("Waktu"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    };

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class MAdapter extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView pengirim, content, waktu;
        public MAdapter(View view) {
            super(view);
            foto = (ImageView) view.findViewById(R.id.gambar);
            pengirim = (TextView) view.findViewById(R.id.pengirim);
            content = (TextView) view.findViewById(R.id.content);
            waktu = (TextView) view.findViewById(R.id.waktu);
        }
    }
}

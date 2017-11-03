package com.zukhrufi.groupchatmandiribersama;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    public static String mainPers = "file.main.message";
    RecyclerView view;
    PesanAdapter pesanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (RecyclerView) findViewById(R.id.rv_main);
        view.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences sp = getSharedPreferences(mainPers, 0);
        String dataPesan = sp.getString("memssage","");
        try {
            JSONArray jsonArray = new JSONArray(dataPesan);
            pesanAdapter = new PesanAdapter(jsonArray);

            view.setAdapter(pesanAdapter);
            pesanAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("JSON", dataPesan);
    }

    public void tambahPesan(View view){
        startActivity(new Intent(this, FormActivity.class));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

}

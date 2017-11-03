package com.zukhrufi.groupchatmandiribersama;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FormActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    EditText namaPengguna, kontenChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void kirim(View view){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Pengirim", namaPengguna.getText().toString());
            jsonObject.put("Content", kontenChat.getText().toString());
            jsonObject.put("Waktu", new SimpleDateFormat("yyyy=MM-dd").format(Calendar.getInstance().getTime()));
            jsonObject.put("Foto", R.drawable.gambar1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(preferences.contains("message")){
            String dataPesan = preferences.getString("message","");
            try {
                JSONArray jsonArray = new JSONArray(dataPesan);
                jsonArray.put(jsonObject);
                editor.putString("message", jsonArray.toString());
                editor.apply();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else {
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);
            editor.putString("message", jsonArray.toString());
            editor.apply();
        }
        finish();
    }
}

package com.example.app;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    String[] nomes =new String[]{"Helena", "Livia", "Gabi 2026", "Pedro", "Romulo 2006", "Gabriel"};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv=findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item_lista,
                R.id.tvnome,
                nomes
        );
        lv.setAdapter(adapter);
        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            Toast.makeText(this, nomes[position], Toast.LENGTH_LONG).show();
        });
    }
}
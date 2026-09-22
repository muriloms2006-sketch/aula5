package com.example.app;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayList<PackageInfo>installedApps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = findViewById(R.id.listview_apps);
        PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> packageInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> appList = packageManager.queryIntentActivities(mainIntent, 0);
        AppAdapter appAdapter = new AppAdapter(this, R.layout.item_lista, installedApps);
        listView = findViewById(R.id.listview_apps);
        listView.setAdapter(appAdapter);
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ApplicationInfo applicationInfo = (ApplicationInfo) parent.getItemAtPosition(position);
        String packageName = applicationInfo.packageName;
        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

        Intent intent = packageManager.getLaunchIntentForPackage(packageName);
        if (intent != null) {
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
        }
    }
});

}
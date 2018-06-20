package com.example.a021054970.incrupdate;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button diffBt;
    private Button patchBt;
    private TextView contentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        contentTv = (TextView) findViewById(R.id.content_tv);
        contentTv.setText("这是一个***旧***版本");
        diffBt = (Button) findViewById(R.id.diff_bt);
        patchBt = (Button) findViewById(R.id.patch_bt);
        diffBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldpath = getApplicationContext().getPackageResourcePath();
                Log.d(TAG,"oldpath:"+oldpath);
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                String  newpath = path+ File.separator+"app-debug_new.apk";
                Log.d(TAG,"newpath:"+newpath);
                String patch = path+File.separator+"patch.patch";
                PathUtils.diff(newpath, oldpath, patch);
            }
        });

        patchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldpath = getApplicationContext().getPackageResourcePath();
                Log.d(TAG,"oldpath:"+oldpath);
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                String  newpath = path+ File.separator+"app-debug_gen.apk";
                Log.d(TAG,"newpath:"+newpath);
                String patch = path+File.separator+"patch.patch";
                PathUtils.patch(newpath, oldpath, patch);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

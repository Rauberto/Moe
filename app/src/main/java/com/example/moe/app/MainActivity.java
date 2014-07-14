package com.example.moe.app;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.app.R;

public class MainActivity extends ActionBarActivity {
    private TextView miLabel;
    private Button botonAcerca;
    private Button botonJugar;
    private ImageView moe1;
    private int moe3;
    private MediaPlayer mp;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonJugar = (Button) findViewById(R.id.button1);
        mp = MediaPlayer.create(MainActivity.this, R.raw.moe);
        moe1 = (ImageView)findViewById(R.id.moeDibujo);
        moe3 = R.drawable.moe3;
        i=0;

        botonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                i++;
                if(i>=5){
                    i=1;
                }
                switch (i){
                case 1:
                    moe1.setImageResource(R.drawable.moe2);
                break;
                case 2:
                    moe1.setImageResource(R.drawable.moe1);
                break;
                case 3:
                    moe1.setImageResource(R.drawable.moe3);
                break;
                case 4:
                    moe1.setImageResource(R.drawable.moe1);
                break;
                }

                if(mp.isPlaying()){
                }
                else {
                    mp.start();
                }
            }

        });


//        botonAcerca = (Button) findViewById(R.id.button3);
//        miLabel = (TextView) findViewById(R.id.titulo);
//        botonJugar = (Button) findViewById(R.id.button1);
//        moe1 = (ImageView) findViewById(R.drawable.moe1);
//        moe2 = (ImageView) findViewById(R.drawable.moe2);
//        moe3 = R.drawable.moe3;
//
//        botonJugar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                moe1.setImageResource(moe3);
//            }
//        });
//
//        botonAcerca.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                miLabel.setText(getString(R.string.titulo2));
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void lanzarAcercaDe(View view){
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }
    public void salir(View view){
        finish();
        mp.stop();
    }
}
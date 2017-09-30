package mx.devf.cintanegra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO Pasar aqui otro día
        Log.d("myLog","OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myLog","onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myLog","OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myLog","OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myLog","OnStop");
    }

    @Override
    protected void onDestroy() {
        Log.d("myLog","OnDestroy");
        super.onDestroy();
    }
}

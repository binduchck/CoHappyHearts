package com.example.bindu_c.cohappyhearts;


import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.graphics.Bitmap;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Button;
import android.widget.ImageView;


public class CameraActivity extends ActionBarActivity {

    static final int REQUEST_CAPTURE= 1;
    ImageView imageButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(requestCode== REQUEST_CAPTURE && resultCode == RESULT_OK){
           Bundle pics =data.getExtras();
           Bitmap picture= (Bitmap) pics.get("data");
           imageButton.setImageBitmap(picture);

       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        Button buttonCam = (Button) findViewById(R.id.buttonCam);
        imageButton = (ImageView) findViewById(R.id.imageButton);

        if (!hasCamera())
            imageButton.setEnabled(false);
    }

        private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }


public void startCamera(View view){
    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(i,REQUEST_CAPTURE);

        }
        }


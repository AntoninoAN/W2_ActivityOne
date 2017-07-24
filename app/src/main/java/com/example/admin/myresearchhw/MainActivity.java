
package com.example.admin.myresearchhw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
public static final String MAIN_ACTIVITY_EXTRA="com.example.admin.myresearchhw_MAIN_ACTIVITY_EXTRA";
public static final String MAIN_ACTIVITY_EXTRA_2="com.example.admin.myresearchhw_MAIN_ACTIVITY_EXTRA_2";
public Bitmap imgBMP;
public static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activateCamera(View view) {
        Intent takePictureIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode== RESULT_OK){
            Bundle extraPic=data.getExtras();
            imgBMP=(Bitmap) extraPic.get("data");
            ImageView imgView=(ImageView)findViewById(R.id.imgview);
            imgView.setImageBitmap(imgBMP);
        }
    }

    public void callDetailActivity(View view) {
        Intent intent= new Intent(MainActivity.this,DetailActivity.class);
        List<String> listado= new ArrayList<>();
        EditText etName=(EditText) findViewById(R.id.tv_name);
        EditText etLastName= (EditText) findViewById(R.id.tv_lastname);

        listado.add(etName.getText().toString());
        listado.add(etLastName.getText().toString());


        intent.putExtra(MAIN_ACTIVITY_EXTRA,etName.getText().toString());
        intent.putExtra(MAIN_ACTIVITY_EXTRA_2,etLastName.getText().toString());

        ByteArrayOutputStream streamoutput= new ByteArrayOutputStream();
        imgBMP.compress(Bitmap.CompressFormat.JPEG,100,streamoutput);
        byte[] byteArray = streamoutput.toByteArray();
        intent.putExtra("image",byteArray);
        startActivity(intent);
    }
}

package com.example.admin.myresearchhw;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
public static final String DETAIL_EXTRA= "com.example.admin.myresearchhw_DETAIL_EXTRA";
ImageView imgViewDetail;
TextView tvnamedetail,tvlastnamedetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        if(intent!=null){
            tvnamedetail=(TextView)findViewById(R.id.tv_name_detail);
            tvlastnamedetail=(TextView)findViewById(R.id.tv_lastname_detail);
            imgViewDetail=(ImageView)findViewById(R.id.imgview_detail);
            tvnamedetail.setText(intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA));
            tvlastnamedetail.setText(intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA_2));
            imgViewDetail.setImageBitmap(returnBitmapFromByte());
        }
    }
    public Bitmap returnBitmapFromByte(){
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        return  bmp;
    }

    public void return2Main(View view) {
        finish();
    }
}

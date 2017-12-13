package com.example.wakasugiakira.mymaillauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private String mail;
    private String title;
    private String memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // radioButtonを押したときに画像を変更する
        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                ImageView mImageView = (ImageView) findViewById(R.id.my_image);
                switch (checkedId) {
                    case R.id.mail1:
                        mImageView.setImageResource(R.drawable.kyu);
                        mail = radioButton.getText().toString();
                        break;
                    case R.id.mail2:
                        mImageView.setImageResource(R.drawable.rara);
                        mail = radioButton.getText().toString();
                        break;
                    case R.id.mail3:
                        mImageView.setImageResource(R.drawable.rehi);
                        mail = radioButton.getText().toString();
                        break;
                }
            }
        });

        Button button = (Button) findViewById(R.id.sousin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = (EditText) findViewById(R.id.title);
                title = et.getText().toString();
                EditText et2 = (EditText) findViewById(R.id.memo);
                memo = et2.getText().toString();

                Uri uri = Uri.parse("mailto:" + mail);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, title);
                intent.putExtra(Intent.EXTRA_TEXT, memo);
                startActivity(intent);
            }
        });


    }
}

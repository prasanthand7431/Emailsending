package com.example.gspl.email_sending;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


class MainActivity extends AppCompatActivity {

    EditText editText, editText1, editText2;
    String mailid, mailsub, mailmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText1);
        editText1 = findViewById(R.id.editText2);
        editText2 = findViewById(R.id.editText3);
    }


    public void sendmail(View view) {
        mailid = editText.getText().toString();
        mailsub = editText1.getText().toString();
        mailmsg = editText2.getText().toString();


        Intent email = new Intent(Intent.ACTION_SEND);


        email.putExtra(Intent.EXTRA_EMAIL, new String[]{mailid});
        email.putExtra(Intent.EXTRA_SUBJECT, mailsub);
        email.putExtra(Intent.EXTRA_TEXT, mailmsg);

        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }

}
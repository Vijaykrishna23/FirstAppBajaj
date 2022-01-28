package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = findViewById(R.id.tvMain);
        String name = getIntent().getExtras().getString("kv");
        textview.setText(name);
    }

    public void handleClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                startHome();
                break;
            case R.id.btnCancel:
                createAlarm("bajaj", 14, 29);
                break;
            case R.id.btnFinish:
                sendContact();
                break;
        }
    }

    private void sendContact() {
        //get the contact from edittext
        EditText nameEditText = findViewById(R.id.etName);
        String contact = nameEditText.getText().toString();
        //put the contact in intent
        Intent cIntent = new Intent();
        cIntent.putExtra("con", contact);
        //set the result
        setResult(RESULT_OK, cIntent);
        //close this activity
        finish();
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void startHome() {
        Toast.makeText(this, "loggin in", Toast.LENGTH_SHORT).show();
        Intent mIntent;
        mIntent = new Intent(MainActivity.this, HomeActivity.class);

        mIntent.putExtra("vk", "vijay krishna");
        startActivity(mIntent);
    }


}
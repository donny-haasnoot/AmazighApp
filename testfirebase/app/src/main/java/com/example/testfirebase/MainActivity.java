package com.example.testfirebase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4;
    TextView tvOutput;
    Spinner spWoorden;
    ImageView ivOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        tvOutput = findViewById(R.id.textView);
        ivOutput = findViewById(R.id.imgData);
        spWoorden = findViewById(R.id.spWoorden);
        button1.setText("Do Hello");
        button2.setText("get Hello");
        button3.setText("Get List");
        button4.setText("Reserved");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                make_hello_world();
                break;
            case R.id.btn2:
                //make_hello_world();
                break;
            case R.id.btn3:
                //make_hello_world();
                break;
            case R.id.btn4:
                //make_hello_world();
                break;
        }
    }
    private void make_hello_world(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://testfirebase-9e883-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("message");
        Date currentTime = Calendar.getInstance().getTime();
        String m = "Hallo Wereld!...de tijd is:"+currentTime.toString();
        myRef.setValue(m);
        Toast.makeText(getApplicationContext(), "Melding: "+m, Toast.LENGTH_SHORT);
    }
}




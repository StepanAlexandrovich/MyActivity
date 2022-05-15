package java.android.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Constants{
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonNextWindow).setOnClickListener(this);
        editText = findViewById(R.id.editText);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonNextWindow){
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            intent.putExtra(KEY,editText.getText().toString());
            startActivity(intent);
        }
    }
}
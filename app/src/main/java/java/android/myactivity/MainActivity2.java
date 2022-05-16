package java.android.myactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements Constants{
    RadioButton radioButtonRed,radioButtonGreen,radioButtonBlue;

    private int codeTheme = R.style.ThemeGreen;
    SharedPreferences pref;
    String key = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setCodeTheme(getCodeThemeOut());
        setTheme(getCodeTheme());

        setContentView(R.layout.activity_main2);

        init();
        setRadioButtonChecked(getCodeTheme());

        // передача данных из первого активити
        TextView textView = findViewById(R.id.textView);
        textView.setText( getIntent().getExtras().getString(KEY,"default") );
    }

    void init(){
        View.OnClickListener buttonListener = new ButtonListener(this);

        radioButtonRed = findViewById(R.id.radioButtonRed);
        radioButtonGreen = findViewById(R.id.radioButtonGreen);
        radioButtonBlue = findViewById(R.id.radioButtonBlue);

        radioButtonRed.setOnClickListener(buttonListener);
        radioButtonGreen.setOnClickListener(buttonListener);
        radioButtonBlue.setOnClickListener(buttonListener);

        findViewById(R.id.buttonBack).setOnClickListener(buttonListener);
    }

    void setRadioButtonChecked(int codeTheme){
        switch (codeTheme){
            case R.style.ThemeRed:
                radioButtonRed.setChecked(true);
                break;
            case R.style.ThemeGreen:
                radioButtonGreen.setChecked(true);
                break;
            case R.style.ThemeBlue:
                radioButtonBlue.setChecked(true);
                break;
        }
    }

    public void buttonBack(){
        finish();
    }

    // getset //
    public void setCodeTheme(int codeTheme) {
        this.codeTheme = codeTheme;
    }

    public int getCodeTheme() {
        return codeTheme;
    }

    // работа с памятью //
    public void setCodeThemeOut(int codeTheme){
        SharedPreferences.Editor edit = pref.edit();
        edit.putInt(key,codeTheme);
        edit.apply();

        recreate();
    }

    public int getCodeThemeOut() {
        pref = getSharedPreferences("Test",MODE_PRIVATE);
        return pref.getInt(key,R.style.ThemeRed);
    }

}
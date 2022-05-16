package java.android.myactivity;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ButtonListener implements View.OnClickListener{
    MainActivity2 mainActivity2;

    public ButtonListener(MainActivity2 mainActivity2) {
        this.mainActivity2 = mainActivity2;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radioButtonRed:  mainActivity2.setCodeThemeOut(R.style.ThemeRed); break;
            case R.id.radioButtonGreen:  mainActivity2.setCodeThemeOut(R.style.ThemeGreen); break;
            case R.id.radioButtonBlue:  mainActivity2.setCodeThemeOut(R.style.ThemeBlue); break;

            case R.id.buttonBack:  mainActivity2.finish(); break;
        }
    }

}

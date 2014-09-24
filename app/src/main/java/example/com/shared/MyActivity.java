package example.com.shared;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity
{
    EditText name;
    TextView dv;

    EditText age;
    Button buttonSaveMem1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        dv = (TextView)findViewById(R.id.dataView);


        name = (EditText)findViewById(R.id.nameText);
        age = (EditText)findViewById(R.id.ageText);
        buttonSaveMem1 = (Button)findViewById(R.id.save_mem1);


        loadPreferences();   }

    public void buttonClick(View v)
    {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name.getText().toString());
        editor.putString("Age", (age.getText().toString()));
        editor.commit();
        name.setText("");
        age.setText("");

        loadPreferences();

        ((InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                age.getWindowToken(), 0);

    }








    private void loadPreferences()
    {

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String personData = sharedPreferences.getString("Name", "");
        personData += " " + sharedPreferences.getString("Age", String.valueOf(2));
        dv.setText(personData);
         }

}
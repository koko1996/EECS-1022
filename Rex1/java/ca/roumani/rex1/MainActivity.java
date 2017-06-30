package ca.roumani.rex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{  RexModel model;
    ;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model=new RexModel();
    }

    public void GenerateButtonClicked(View v){
        boolean CheckAZ = ((CheckBox) findViewById(R.id.checkBox)).isChecked();
        boolean Check09 = ((CheckBox) findViewById(R.id.checkBox2)).isChecked();
        boolean Checksigns = ((CheckBox) findViewById(R.id.checkBox3)).isChecked();
        model.setAnchor(Checksigns);
        model.setDigit(Check09);
        model.setLetter(CheckAZ);
        model.generate(2);
        st=model.getRex();
        ((TextView) findViewById(R.id.tt)).setText(st);


    }
    public void CheckButtonClicked(View v){
        String Entered = ((EditText) findViewById(R.id.String1)).getText().toString();
        boolean doeas=model.doesMatch(Entered);
        String answer="string =";

        ((TextView) findViewById(R.id.Log)).setText(((TextView) findViewById(R.id.Log)).getText().toString()+"regex = "+st+" string = "+ Entered+"----->"+ doeas+"\n" );


    }
}

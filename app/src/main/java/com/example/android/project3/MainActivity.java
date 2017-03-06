package com.example.android.project3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    int start = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * points system. + 1 for every correct answer out of seven
     */
    private void points()
    {
        RadioButton check1 = (RadioButton) findViewById(R.id.q1radioA);
        RadioButton check4 = (RadioButton) findViewById(R.id.q2radioB);
        RadioButton check6 = (RadioButton) findViewById(R.id.q3radioB);
        RadioButton check8 = (RadioButton) findViewById(R.id.q4radioB);
        RadioButton check10 = (RadioButton) findViewById(R.id.q5radioB);
        CheckBox check11 = (CheckBox) findViewById(R.id.q6checkA);
        CheckBox check12 = (CheckBox) findViewById(R.id.q6checkB);
        CheckBox check13 = (CheckBox) findViewById(R.id.q6checkC);
        CheckBox check14 = (CheckBox) findViewById(R.id.q6checkD);
        EditText check15 = (EditText) findViewById(R.id.q7text);
        if (start < 0)
            start = 0;

        else if( start > 7)
            start = 7;

        if(check1.isChecked())
            start++;

        if(check4.isChecked())
            start++;

        if(check6.isChecked())
            start++;

        if(check8.isChecked())
            start++;

        if(check10.isChecked())
            start++;

        if(check12.isChecked() && check13.isChecked() && check11.isChecked() == false && check14.isChecked() == false)
            start++;

        if(check15.getText().toString().toLowerCase().equals("acne"))
            start++;
    }
    /**
     * Check to see if selections are correct. If multiple checkboxes are selected, display toast to select only one box.
     * If selection is incorrect, display appropriate toast.
     * @param view
     */
    public void checkAnswers(View view)
    {
        RadioButton check1 = (RadioButton) findViewById(R.id.q1radioA);
        RadioButton check2 = (RadioButton) findViewById(R.id.q1radioB);
        RadioButton check3 = (RadioButton) findViewById(R.id.q2radioA);
        RadioButton check4 = (RadioButton) findViewById(R.id.q2radioB);
        RadioButton check5 = (RadioButton) findViewById(R.id.q3radioA);
        RadioButton check6 = (RadioButton) findViewById(R.id.q3radioB);
        RadioButton check7 = (RadioButton) findViewById(R.id.q4radioA);
        RadioButton check8 = (RadioButton) findViewById(R.id.q4radioB);
        RadioButton check9 = (RadioButton) findViewById(R.id.q5radioA);
        RadioButton check10 = (RadioButton) findViewById(R.id.q5radioB);
        CheckBox check11 = (CheckBox) findViewById(R.id.q6checkA);
        CheckBox check12 = (CheckBox) findViewById(R.id.q6checkB);
        CheckBox check13 = (CheckBox) findViewById(R.id.q6checkC);
        CheckBox check14 = (CheckBox) findViewById(R.id.q6checkD);
        EditText check15 = (EditText) findViewById(R.id.q7text);

        //check if incorrect selection is made
        if(check2.isChecked() || check3.isChecked() || check5.isChecked() || check7.isChecked() || check9.isChecked() || check11.isChecked() || check14.isChecked() ||
                check15.getText().toString().toLowerCase().equals("") || !check15.getText().toString().toLowerCase().equals("acne"))
        {
            points();
            Toast.makeText(this,"Incorrect " + start + "/7",Toast.LENGTH_SHORT).show();
            start = 0;
            return;
        }

        //check if selection is correct
        else if(check1.isChecked() && check4.isChecked() && check6.isChecked() && check8.isChecked() && check10.isChecked() && check12.isChecked() &&
                check13.isChecked() && check15.getText().toString().toLowerCase().equals("acne") )
        {
            points();
            Toast.makeText(this,"You got them all correct! " + start + "/7",Toast.LENGTH_SHORT).show();
            start = 0;
            return;
        }
    }

    /**
     * Reset the radio buttons, check boxes, and score.
     * @param view
     */
    public void reset(View view)
    {
        RadioButton check1 = (RadioButton) findViewById(R.id.q1radioA);
        RadioButton check2 = (RadioButton) findViewById(R.id.q1radioB);
        RadioButton check3 = (RadioButton) findViewById(R.id.q2radioA);
        RadioButton check4 = (RadioButton) findViewById(R.id.q2radioB);
        RadioButton check5 = (RadioButton) findViewById(R.id.q3radioA);
        RadioButton check6 = (RadioButton) findViewById(R.id.q3radioB);
        RadioButton check7 = (RadioButton) findViewById(R.id.q4radioA);
        RadioButton check8 = (RadioButton) findViewById(R.id.q4radioB);
        RadioButton check9 = (RadioButton) findViewById(R.id.q5radioA);
        RadioButton check10 = (RadioButton) findViewById(R.id.q5radioB);
        CheckBox check11 = (CheckBox) findViewById(R.id.q6checkA);
        CheckBox check12 = (CheckBox) findViewById(R.id.q6checkB);
        CheckBox check13 = (CheckBox) findViewById(R.id.q6checkC);
        CheckBox check14 = (CheckBox) findViewById(R.id.q6checkD);
        EditText check15 = (EditText) findViewById(R.id.q7text);

        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
        check4.setChecked(false);
        check5.setChecked(false);
        check6.setChecked(false);
        check7.setChecked(false);
        check8.setChecked(false);
        check9.setChecked(false);
        check10.setChecked(false);
        check11.setChecked(false);
        check12.setChecked(false);
        check13.setChecked(false);
        check14.setChecked(false);
        check15.setText("");

        start = 0;
    }


}

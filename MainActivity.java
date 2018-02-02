package com.example.android.quizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int totalPoints = 0;

    //This method increment points
    public int incrementPoints() {
        totalPoints = totalPoints + 20;
        return totalPoints;
    }

    //This method decrement points
    public int decrementPoints() {
        totalPoints = totalPoints - 20;
        return totalPoints;
    }

    public void RadioButtonClicked (View view){

    //if the right answer is clicked, it will increment points

        boolean checked = ((RadioButton) view).isChecked();
         switch (view.getId()) {
             case R.id.ButtonC:
             if(checked)
                 incrementPoints();
         }
    }

    //Check EditText
    public void checkEditText() {

        EditText editTextAnswer = findViewById(R.id.edit_text_answer);

        String typedAnswer = editTextAnswer.getText().toString().trim();


        String correctAnswer = "Roger Federer";

        if (typedAnswer.equals(correctAnswer)) {
            incrementPoints();
        }
    }

    //Checking the CheckBox
    public void CheckBoxClicked(View view) {

        CheckBox checkBoxA = findViewById(R.id.checkbox_a);
        boolean hasCheckedA = checkBoxA.isChecked();

        CheckBox checkBoxB = findViewById(R.id.checkbox_b);
        boolean hasCheckedB = checkBoxB.isChecked();

        CheckBox checkBoxC = findViewById(R.id.checkbox_c);
        boolean hasCheckedC = checkBoxC.isChecked();

        CheckBox checkBoxD = findViewById(R.id.checkbox_d);
        boolean hasCheckedD = checkBoxD.isChecked();

        if (hasCheckedA) {
            incrementPoints();
        }
        if (hasCheckedD) {
            incrementPoints();
        }

        if (hasCheckedB) {
            decrementPoints();
        }
        if (hasCheckedC) {
            decrementPoints();
        }
    }

    public void RadioButtonClicked2 (View view){

        //if the right answer is clicked, it will increment points

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.question_4_d:
                if(checked)
                    incrementPoints();
        }
    }

    //this is used when the submit button is clicked

    public void submit(View view) {

        EditText name = findViewById(R.id.name_field);
        String nameOfUser = name.getText().toString();

        // toast message
        checkEditText();
        Toast.makeText(this, "Thank you: " + nameOfUser + "\nYour points: " + totalPoints + "/100", Toast.LENGTH_LONG).show();

    }

    public void reset(View view){

        //when the reset button is clicked the screen will scroll on top

        ScrollView topScroll = (ScrollView)findViewById(R.id.scroll);
        topScroll.fullScroll(ScrollView.FOCUS_UP);
        topScroll.setFocusableInTouchMode(true);

        //reset the editText field for the player`s name
        EditText namePlayer = (EditText)findViewById(R.id.name_field);
        namePlayer.setText(null);

        //reset the radioGroup for the first question
        RadioButton firstRadioG1 = (RadioButton) findViewById(R.id.ButtonA);
        firstRadioG1.setChecked(false);

        RadioButton firstRadioG2 = (RadioButton) findViewById(R.id.ButtonB);
        firstRadioG2.setChecked(false);

        RadioButton firstRadioG3 = (RadioButton) findViewById(R.id.ButtonC);
        firstRadioG3.setChecked(false);

        RadioButton firstRadioG4 = (RadioButton) findViewById(R.id.ButtonD);
        firstRadioG4.setChecked(false);


        //reset the editText field for the second question
        EditText secondQuestion = (EditText)findViewById(R.id.edit_text_answer);
        secondQuestion.setText(null);


        //reset the CheckBox answers
        CheckBox novak = (CheckBox) findViewById(R.id.checkbox_a);
        novak.setChecked(false);

        CheckBox dimitrov = (CheckBox) findViewById(R.id.checkbox_b);
        dimitrov.setChecked(false);

        CheckBox zverev = (CheckBox) findViewById(R.id.checkbox_c);
        zverev.setChecked(false);

        CheckBox murray = (CheckBox) findViewById(R.id.checkbox_d);
        murray.setChecked(false);


        //reset the second radioGroup for the fourth question
        RadioButton secondRadioG1 = (RadioButton) findViewById(R.id.question_4_a);
        secondRadioG1.setChecked(false);

        RadioButton secondRadioG2 = (RadioButton) findViewById(R.id.question_4_b);
        secondRadioG2.setChecked(false);

        RadioButton secondRadioG3 = (RadioButton) findViewById(R.id.question_4_c);
        secondRadioG3.setChecked(false);

        RadioButton secondRadioG4 = (RadioButton) findViewById(R.id.question_4_d);
        secondRadioG4.setChecked(false);


        //reset the points
        totalPoints = 0;

    }
}

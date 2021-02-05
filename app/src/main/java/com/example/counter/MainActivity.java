package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Declare boolean for 3 buttons
    private boolean resetBtn = false;
    private boolean minusBtn = false;
    private boolean plusBtn = false;

    // Object counter class Counter
    private Counter counter;

    // Counter parameters
    private int minVal = 100;
    private int maxVal = 1000;
    private int staVal = 10;
    private int steVal = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Object counter class Counter
        counter = new Counter(minVal, maxVal, staVal, steVal);

        /*
        If want to call default counter (-100, 100, 0, 1)
        counter = new Counter();
         */

        // Call UI function
        updateUI();
    }

    // Method handles click event for radio buttons
    public void onRadioBtnClick(View v) {
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioBtnGroup);

        // Get selected radio button ID from group
        int selectedBtnId = radioGroup.getCheckedRadioButtonId();

        // Find the selected button
        RadioButton radioButton = (RadioButton)findViewById(selectedBtnId);

        // When button is checked
        boolean checked = ((RadioButton) v).isChecked();
        Log.i("my_counter", "radioBtnClick()");
        switch (v.getId()) {
            case R.id.decBtn:
                if (checked)
                    // Call method set___() when option btn is selected
                    counter.setDecimal();
                    updateUI();
                break;
            case R.id.binBtn:
                if (checked)
                    counter.setBinary();
                    updateUI();
                break;
            case R.id.hexBtn:
                if (checked)
                    counter.setHexadecimal();
                    updateUI();
                break;
        }
    }

    // Functions for 3 buttons onClick
    public void resetBtnClick(View v) {
        Log.i("my_counter", "resetBtnClick()");

        // When button is clicked, run updateUI()
        resetBtn = true;
        updateUI();
    }
    public void minusBtnClick(View v) {
        Log.i("my_counter", "minusBtnClick()");

        minusBtn = true;
        updateUI();
    }
    public void plusBtnClick(View v) {
        Log.i("my_counter", "plusBtnClick()");

        plusBtn = true;
        updateUI();
    }

    // When buttons are clicked, reset gives start value
    // minus gives decreasing by step value
    // plus increasing by step value
    // All activities above are written inside class Counter
    // then call them inside updateUI

    private void updateUI() {
        TextView tv = findViewById(R.id.textView);

        // Assign result to return value method getValue class Counter
        String result = counter.getValue();

        // Default counter: int result = 0;

        if (resetBtn) {
            result = counter.getResetValue();
            resetBtn = false;
        }
        if (minusBtn) {
            result = counter.getMinusValue();
            minusBtn = false;
        }
        if (plusBtn) {
            result = counter.getPlusValue();
            plusBtn = false;
        }

        tv.setText(result);
    }
}
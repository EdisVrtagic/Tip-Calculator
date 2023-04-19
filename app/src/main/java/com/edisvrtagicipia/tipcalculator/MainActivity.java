package com.edisvrtagicipia.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView totalResultTextView;
    private TextView textViewSeekbar;
    private int seekbarPercentage;
    private float enteredBillFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText) findViewById(R.id.billAmountID);
        seekBar = (SeekBar) findViewById(R.id.percentageSeekbar);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        totalResultTextView = (TextView) findViewById(R.id.result);
        textViewSeekbar = (TextView)findViewById(R.id.textViewSeekbar);

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textViewSeekbar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercentage = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View view) {
        calculate();
    }
    public void calculate()
    {
        float result = 0.0f;
        if(!enteredAmount.getText().toString().equals(""))
        {
            enteredBillFloat = Float.parseFloat((enteredAmount.getText().toString()));
            result = enteredBillFloat * seekbarPercentage / 100;
            totalResultTextView.setText("Vas Tip ce biti" + " $" + String.valueOf(result));
        }
        else
        {
            Toast.makeText(MainActivity.this,"Molim unesite iznos racuna",Toast.LENGTH_LONG).show();
        }
    }
}
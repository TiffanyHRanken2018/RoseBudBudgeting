package edu.ranken.tharris.rosebudbudgeting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class BudgetActivity extends AppCompatActivity {


    TextView textViewBudgetTitle;
    EditText editTextYearlyIncome;
    EditText editTextRent;
    EditText editTextCarPayment;
    EditText editTextUtilities;
    EditText editTextChildCare;
    EditText editTextInsurance;
    EditText editTextGroceries;
    EditText editTextGas;
    EditText editTextPhoneBill;
    EditText editTextOther;
    TextView textViewSavings;
    TextView textViewSavingsImportance;
    TextView textViewHowMuch;
    TextView textViewWhatPercent;
    SeekBar seekBarSavings = null;
    Button buttonSubmit;
    TextView textViewAnalysisTitle;
    TextView textViewResults;
    View view;

    static double yearlyIncome = 0.0;
    static double monthlyIncome = 0.0;
    static double rent = 0.0;
    static double carPayment = 0.0;
    static double utilities = 0.0;
    static double childCare = 0.0;
    static double insurance = 0.0;
    static double groceries = 0.0;
    static double gas = 0.0;
    static double phoneBill = 0.0;
    static double other = 0.0;
    static double bills = 0.0;
    static double savingsBar = 0.0;
    static double savingsPercentage = 0.0;
    static double yearlySavings = 0.0;
    static double monthlySavings = 0.0;
    static double results = 0.0;
    static double savingsResult = 0.0;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_budget );

        textViewBudgetTitle = findViewById( R.id.textViewBudgetTitle );
        editTextYearlyIncome = findViewById( R.id.editTextYearlyIncome );
        editTextRent = findViewById( R.id.editTextRent );
        editTextCarPayment = findViewById( R.id.editTextCarPayment );
        editTextChildCare = findViewById( R.id.editTextChildCare );
        editTextUtilities = findViewById( R.id.editTextUtilities );
        editTextInsurance = findViewById( R.id.editTextInsurance );
        editTextGroceries = findViewById( R.id.editTextGroceries );
        editTextGas = findViewById( R.id.editTextGas );
        editTextPhoneBill = findViewById( R.id.editTextPhoneBill );
        editTextOther = findViewById( R.id.editTextOther );
        textViewSavings = findViewById( R.id.textViewSavings );
        textViewSavingsImportance = findViewById( R.id.textViewSavingsImportance );
        textViewHowMuch = findViewById( R.id.textViewHowMuch );
        textViewWhatPercent = findViewById( R.id.textViewWhatPercent );
        seekBarSavings = findViewById( R.id.seekBarSavings );
        buttonSubmit = findViewById( R.id.buttonSubmit );


        seekBarSavings.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText( BudgetActivity.this, "seek bar progress:" + progressChanged,
                        Toast.LENGTH_SHORT ).show();
            }
        } );




        calculateBudget();
        Display();
        addButtonOnClickListener();


      }




     public void calculateBudget() {
        String yrInStr = editTextYearlyIncome.getText().toString();


        try {
            yearlyIncome = Double.parseDouble( yrInStr );


        } catch (NumberFormatException e) {
            yearlyIncome = 10000.00;

        }

        String strRent = editTextRent.getText().toString();

        try {
            rent = Double.parseDouble( strRent );


        } catch (NumberFormatException e) {
            rent = 0.0;
        }
        String strCar = editTextCarPayment.getText().toString();

        try {
            carPayment = Double.parseDouble( strCar );
        } catch (NumberFormatException e) {
            carPayment = 0.0;

        }
        String strUtilities = editTextUtilities.getText().toString();

        try {
            utilities = Double.parseDouble( strUtilities );
        } catch (NumberFormatException e) {
            utilities = 0.0;

        }
        String strChild = editTextChildCare.getText().toString();

        try {
            childCare = Double.parseDouble( strChild );

        } catch (NumberFormatException e) {
            childCare = 0.0;
        }

        String strInsurance = editTextInsurance.getText().toString();

        try {
            insurance = Double.parseDouble( strInsurance );
        } catch (NumberFormatException e) {
            insurance = 0.0;
        }
        String strGroceries = editTextGroceries.getText().toString();

        try {
            groceries = Double.parseDouble( strGroceries );
        } catch (NumberFormatException e) {
            groceries = 0.0;
        }
        String strGas = editTextGas.getText().toString();

        try {
            gas = Double.parseDouble( strGas );
        } catch (NumberFormatException e) {
            gas = 0.0;
        }
        String strPhoneBill = editTextPhoneBill.getText().toString();

        try {
            phoneBill = Double.parseDouble( strPhoneBill );
        } catch (NumberFormatException e) {
            phoneBill = 0.0;
        }
        String strOther = editTextOther.getText().toString();

        try {
            other = Double.parseDouble( strOther );
        } catch (NumberFormatException e) {
            other = 0.0;
        }

        bills = rent + carPayment + utilities + childCare + insurance + groceries + gas + phoneBill + other;
         savingsBar = seekBarSavings.getProgress();
         savingsPercentage = savingsBar / 100;
         yearlySavings = yearlyIncome - (yearlyIncome * savingsPercentage);
           monthlySavings = yearlySavings / 12;
           results = monthlyIncome - bills;
           savingsResult = monthlyIncome - bills - monthlySavings;


    }

       public void Display()
        {


            String outputStr = "";
        outputStr += "Yearly Income: " + Double.toString(yearlyIncome);
        outputStr += "\n\nMonthly Income: " + Double.toString( monthlyIncome);
        outputStr += "\n\nTotal Amount Owed in Bills Each Month: " + Double.toString( bills);
        outputStr += "\n\nMonthly Income - Your Bills = " + Double.toString(results);
        outputStr += "\n\nYour Monthly Savings Goal is: " + Double.toString(monthlySavings);
        outputStr += "\n\nMonthly Income - Your Bills - Your Monthly Savings = " + Double.toString( savingsResult);
        outputStr += "\n\nJust Think if You Stay Dedicated in 1 Year You Will Have Saved: " + Double.toString( yearlySavings);

        textViewResults.setText(  );

    }

   public void addButtonOnClickListener()
   {
         buttonSubmit.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Display();
            }

        });

}

}










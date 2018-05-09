package edu.ranken.tharris.rosebudbudgeting;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    TextView textViewMainTitle;
    ImageView imageViewRose;
    EditText editTextName;
    EditText editTextEmail;
    Button buttonLetsBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        textViewMainTitle = findViewById( R.id.textViewMainTitle );
        imageViewRose = findViewById( R.id.imageViewRose );
        editTextName = findViewById( R.id.editTextName );
        editTextEmail = findViewById( R.id.editTextEmail );
        buttonLetsBegin = findViewById( R.id.buttonLetsBegin );


        addListenerOnButton();

    }

    public void addListenerOnButton() {



        buttonLetsBegin.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                Intent intent = new Intent( getApplicationContext(), BudgetActivity.class );
                startActivity( intent );

            }

        } );


    }





}






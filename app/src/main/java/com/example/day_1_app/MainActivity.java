package com.example.day_1_app;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    TextView textname,address,textView3,delivery_label,dropdown;
    EditText editText1,editText2,editText3;
    RadioButton pickup,nextday,sameday;
    String message;
    RadioGroup radioGroup;
    Spinner label_spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Specify the layout to use when the list of choices appears.


        if (label_spinner!=null){
            label_spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.labels_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (label_spinner != null) {
            label_spinner.setAdapter(adapter);
        }

        textname = (TextView) findViewById(R.id.textname);
        address = (TextView) findViewById(R.id.address);
        textView3 = (TextView) findViewById(R.id.textView3);
        delivery_label = (TextView) findViewById(R.id.delivery_label);
        dropdown=(TextView)findViewById(R.id.dropdown);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);
        radioGroup=(RadioGroup)findViewById(R.id.radiogroup);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        pickup = (RadioButton) findViewById(R.id.pickup);
        sameday = (RadioButton) findViewById(R.id.sameday);
        nextday = (RadioButton) findViewById(R.id.nextday);

        label_spinner=(Spinner)findViewById(R.id.label_spinner);




    }





    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(
                            R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(
                            R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(
                            R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        String spinnerLabel = parent.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

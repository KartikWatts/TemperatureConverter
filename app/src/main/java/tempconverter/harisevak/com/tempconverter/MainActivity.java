package tempconverter.harisevak.com.tempconverter;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button Cel_btn;
    private Button Fer_btn;
    private TextView Result1;
    DecimalFormat round= new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText)findViewById(R.id.editText);
        Cel_btn = (Button)findViewById(R.id.Cel_btn);
        Fer_btn = (Button)findViewById(R.id.Fer_btn);
        Result1 = (TextView)findViewById(R.id.Result);

        Cel_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Temp = editText.getText().toString();
                if(Temp.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter a Value", Toast.LENGTH_LONG).show();
                }
                else{
                    double Tempint = Double.parseDouble(Temp);
                    double convertedVal= convertToCelsius(Tempint);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    Result1.setText(stringResult + "C");
                }

            }
        });

        Fer_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Temp = editText.getText().toString();
                if (Temp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    double Tempint = Double.parseDouble(Temp);
                    double convertedVal = convertToFeren(Tempint);
                    String stringResult = String.valueOf(round.format(convertedVal));
                    Result1.setText(stringResult + "F");
                }
            }
        });

    }

    public double convertToCelsius(double farVal){
        double resultCel=(farVal - 32)* 5/9;
        return resultCel;
    }
    public double convertToFeren(double celVal){
        double resultFer= (celVal * 9/5)+32;
        return resultFer;
    }
}

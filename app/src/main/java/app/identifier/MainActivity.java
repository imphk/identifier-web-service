package app.identifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evaluate(View view){
        String input = ((EditText) findViewById(R.id.input)).getText().toString();
        TextView output = (TextView) findViewById(R.id.output);

        Identifier id = new Identifier();

        boolean result = id.validateIdentifier(input);
        if(result)
            output.setText(R.string.valid);
        else
            output.setText(R.string.invalid);
    }

    public void resetOutput(View view){
        TextView output = (TextView) findViewById(R.id.output);
        output.setText(R.string.output);
    }
}

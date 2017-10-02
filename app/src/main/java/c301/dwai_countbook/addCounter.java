package c301.dwai_countbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by DWai on 10/2/2017.
 */

//creates a new counter
public class AddCounter extends AppCompatActivity{

    private EditText nameText, updatedText, currentText, initialText, commentText;
    private CounterDetails counterDetails = null;
    private int counter_total = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_counter);
        nameText = (EditText) findViewById(R.id.addName);
        currentText = (EditText) findViewById(R.id.addCurrent);
        initialText = (EditText) findViewById(R.id.addInitial);
        commentText = (EditText) findViewById(R.id.addComment);
    }

    protected void onStart(){
        super.onStart();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

    }

    public void submit(View view){

    }
}

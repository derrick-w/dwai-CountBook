package c301.dwai_countbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static c301.dwai_countbook.R.id.addCounter;
import static c301.dwai_countbook.R.id.counter_total;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ListView oldCounterList;
    private ArrayList<CounterDetails> countersList = new ArrayList<CounterDetails>();

    private static ArrayAdapter<CounterDetails> adapter;
    private TextView counterTotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addCounter = (Button) findViewById(R.id.addCounter);

        counterTotal = (TextView) findViewById(R.id.counter_total);
        Integer size = countersList.size();
        counterTotal.setText(String.format("%d", size));

        countersList = loadFromFile();


    }


    public void updateCounterTotal(){
        int t = countersList.size();
        counterTotal.setText(String.format ("%d", t));
        }

    public void addCounter(View view) {
        Intent intent = new Intent(MainActivity.this, AddCounter.class);
        startActivity(intent);
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(countersList, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    public ArrayList<CounterDetails> loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            //Taken from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2017-09-19
            Type listType = new TypeToken<ArrayList<CounterDetails>>(){}.getType();
            countersList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            countersList = new ArrayList<CounterDetails>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }

        return countersList;

    }
}

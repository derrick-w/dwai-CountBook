package c301.dwai_countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView counterList;
    private ArrayList<counterInfo> counterArrayList;

    private ArrayAdapter<counterInfo> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addCounter(View view) {
        Intent intent = new Intent(this, R.layout.list_item, counterList);
        startActivity(intent);
    }
}

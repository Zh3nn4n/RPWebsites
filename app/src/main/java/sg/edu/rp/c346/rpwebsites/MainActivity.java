package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCat;
    Spinner spnsubCat;
    Button btngo;
    ArrayList<String> alCat;
    ArrayAdapter<String> aaCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCat = findViewById(R.id.spinner);
        spnsubCat = findViewById(R.id.spinner2);
        btngo = findViewById(R.id.buttonGo);


        alCat = new ArrayList<>();
        aaCat = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alCat);

        //bind arrayadapter to the spinner
        spnsubCat.setAdapter(aaCat);

        spnCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        aaCat.clear();
                        String[] strcat = getResources().getStringArray(R.array.Sub_CategoryRP);

                        alCat.addAll(Arrays.asList(strcat));
                        aaCat.notifyDataSetChanged();
                        break;
                    case 1:
                        aaCat.clear();
                        String[] strcat1 = getResources().getStringArray(R.array.Sub_CategorySOI);

                        alCat.addAll(Arrays.asList(strcat1));
                        aaCat.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String[][] sites = {
                            {
                                    "https://www.rp.edu.sg/",
                                    "https://www.rp.edu.sg/student-life",
                            },
                            {
                                    "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                    "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"
                            }
                    };

                    String url = sites[spnCat.getSelectedItemPosition()][spnsubCat.getSelectedItemPosition()];
                int pos = spnCat.getSelectedItemPosition();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("url",url);
                intent.putExtra("pos",pos);
                startActivity(intent);




            }
        });

    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor prefEdit = prefs.edit();
//
//        Intent intentReceived = getIntent();
//        String url = intentReceived.getStringExtra("url");
//        int pos = intentReceived.getIntExtra("pos",0);
//
//        prefEdit.putString("url",url);
//        prefEdit.putInt("pos",pos);
//        prefEdit.commit();
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//
//        String url = prefs.getString("url","");
//        int pos = prefs.getInt("pos",0);
//
//        if(pos ==0) {
//            aaCat.clear();
//            String[] strcat = getResources().getStringArray(R.array.Sub_CategoryRP);
//
//            alCat.addAll(Arrays.asList(strcat));
//            aaCat.notifyDataSetChanged();
//
//            if (url.equals("https://www.rp.edu.sg/")) {
//
//                spnsubCat.setSelection(0);
//            } else if (url.equals("https://www.rp.edu.sg/student-life")) {
//
//                spnsubCat.setSelection(1);
//            }
//        }
//        else if(pos==1) {
//            aaCat.clear();
//            String[] strcat = getResources().getStringArray(R.array.Sub_CategorySOI);
//
//            alCat.addAll(Arrays.asList(strcat));
//            aaCat.notifyDataSetChanged();
//
//        if (url.equals("https://www.rp.edu.sg/soi/full-time-diplomas/details/r47")) {
//
//                spnsubCat.setSelection(0);
//            } else if (url.equals("https://www.rp.edu.sg/soi/full-time-diplomas/details/r12")) {
//
//                spnsubCat.setSelection(1);
//            }
//        }
//
//
//    }
}

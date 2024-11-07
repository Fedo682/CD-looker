package com.example.cd_show_subject;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<Type>  types    = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner Spin= findViewById(R.id.Spinny);
        Button Show= findViewById(R.id.ShowBooks);
//        TextView TxtVU = findViewById(R.id.TextView);
        ListView LV = findViewById(R.id.ListView);


        FillBooks();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);


        ArrayList<String> SubjectNames=new ArrayList<>();





        for (Type type : types){
            SubjectNames.add(type.getName());



        }
        adapter.addAll(SubjectNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spin.setAdapter(adapter);



        Show.setOnClickListener(view -> {
            String SelectedSubject = Spin.getSelectedItem().toString();



            for (Type type : types) {

                ArrayAdapter<CD> Listadapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);

                if (type.getName().equals(SelectedSubject)) {
                    Listadapter.addAll(type.getCds());

                    LV.setAdapter(Listadapter);
//                   TxtVU.append(subject.PrintBooks());
//                    TxtVU.setText(subject.getBooks().toString());
                }
            }
        });


        // add the name and other StUFF BOI !

        String EXTRA_CD_DATA = "CD";

        LV.setOnItemClickListener((adapterView, view, i, l) -> {

           Type type =findtype(Spin.getSelectedItem().toString());
            String nameCd=type.getName();


            CD cd = findCD(i,nameCd);
            String CDname= cd.getName();
            double priceCd = cd.getPrice();


            String data_toSend=nameCd+" "+CDname+" " +priceCd;
            Toast.makeText(this, data_toSend, Toast.LENGTH_LONG).show();
            if (types != null && i >= 0) {
                Intent intent = new Intent(this, cd_Data_display.class);
                intent.putExtra(EXTRA_CD_DATA, data_toSend);
                startActivity(intent);
            }


        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Show_Data), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public Type findtype(String name) {
        for (Type type : types) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }

        public CD findCD(int pos,String name) {
            for (Type type : types) {

                if(type.getName().equals(name)&& type!=null){
                    return type.getCds().get(pos);
                }

            }
            return null;
        }
            private void FillBooks () {

                types.add(new Type("Synaptik ", List.of(
                        new CD("Omm EL mawjat ", 29.90),
                        new CD("Dallek", 29.90),
                        new CD("Matahat  ", 29.90),
                        new CD("Laulaby for the weary", 29.90))));

                types.add(new Type("Omm Kalthum ", List.of(
                        new CD("alf Leila w Leila  ", 29.90),
                        new CD("Seret El Hobb", 29.90),
                        new CD("Enta Omry", 29.90),
                        new CD("Fe Nour Mahyak", 29.90))));

                types.add(new Type("Majedah El roumi ", List.of(
                        new CD("Etzalet el gharam", 29.90),
                        new CD("Ghanny Lal Houb", 29.90),
                        new CD("Enta Omry", 29.90),
                        new CD("Aheboka Gedan", 29.90))));

            }



    @Override
    protected void onStart() {

        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
    }
    @Override
    protected void onPause() {

        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }

}

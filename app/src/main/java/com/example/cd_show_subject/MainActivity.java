package com.example.cd_show_subject;


import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

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




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void FillBooks() {

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

}
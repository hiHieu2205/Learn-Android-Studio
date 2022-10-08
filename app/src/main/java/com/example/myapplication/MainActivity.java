package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button buttonSubmit;
    EditText editTextHoten, editTextNgaysinh;
    Spinner spinnerQuoctich;
    RadioButton radioButtonNam, radioButtonNu;
    CheckBox checkBoxDulich, checkBoxThethao;
    String qt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initwedgets();
        ArrayList<String> qt = new ArrayList<String>();
        qt.add("Viet nam");
        qt.add("Trung quoc ");
        qt.add("Lien xo");
        qt.add("Hoa ky");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, androidx.appcompat.R.layout.
                support_simple_spinner_dropdown_item, qt);
        spinnerQuoctich.setAdapter(adapter);
        // button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mh2_Activity.class);
                Bundle bundle = new Bundle();
                //dua du lieu vao bundler
                bundle.putString("hoten", editTextHoten.getText().toString());
                bundle.putString("ngaysinh", editTextNgaysinh.getText().toString());
                if (radioButtonNam.isChecked()) {
                    bundle.putString("gioitinh", radioButtonNam.getText().toString());

                }
                if (radioButtonNu.isChecked()) {
                    bundle.putString("gioitinh", radioButtonNu.getText().toString());

                }
                spinnerQuoctich.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        qt1 = qt.get(i);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                bundle.putString("quoctich", qt1);
                String st = "";
                if (checkBoxDulich.isChecked()) {
                    st = st + checkBoxDulich.getText().toString();
                }
                if (checkBoxThethao.isChecked()) {
                    st = st + checkBoxThethao.getText().toString();
                }
                bundle.putString("sothich", st);
                // dua boundle vao intent
                intent.putExtra("MyBundle", bundle);
                startActivity(intent);
            }
        });
    }

    private void Initwedgets() {
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        editTextHoten = (EditText) findViewById(R.id.editTextHoten);
        editTextNgaysinh = (EditText) findViewById(R.id.editTextNgaysinh);
        spinnerQuoctich = (Spinner) findViewById(R.id.spinnerQuoctich);
        radioButtonNam = (RadioButton) findViewById(R.id.radioButtonNam);
        radioButtonNu = (RadioButton) findViewById(R.id.radioButtonNu);
        checkBoxDulich = (CheckBox) findViewById(R.id.checkBoxDulich);
        checkBoxThethao = (CheckBox) findViewById(R.id.checkBoxThethao);
    }
}
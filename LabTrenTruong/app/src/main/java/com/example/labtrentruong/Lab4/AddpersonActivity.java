package com.example.labtrentruong.Lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.labtrentruong.Models.Person;
import com.example.labtrentruong.R;

public class AddpersonActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView edtAddName, edtAddphone;
    private Spinner spnAddAddress;
    private RadioButton rbNam, rbNu;
    private Button btnAdd;
    private Person person;
    private String DiaChi;
    private  Boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addperson);
//        getSupportActionBar().hide();
        initview();
    }
    private void LoadSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Adress, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAddAddress.setAdapter(adapter);
        spnAddAddress.setOnItemSelectedListener(this);
    }

    private void initview() {
        edtAddName = (EditText) findViewById(R.id.edtAddname);
        spnAddAddress = (Spinner) findViewById(R.id.spnAdress);
        edtAddphone = (EditText) findViewById(R.id.edtAddPhone);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        rbNam= (RadioButton)findViewById(R.id.rbNam);
        rbNu= (RadioButton)findViewById(R.id.rbNu);
        LoadSpinner();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbNam.isChecked()==true){
                    flag=true;
                }else if(rbNu.isChecked()==true){
                    flag=false;
                }
                person = new Person(0,R.drawable.heo, edtAddName.getText().toString(),
                        DiaChi,flag, edtAddphone.getText().toString());
                Intent intent = new Intent(AddpersonActivity.this, Lab4Activity.class);
                intent.putExtra("ADD", person);
                setResult(100, intent);
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        DiaChi= parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

package com.example.labtrentruong.Lab5;

import android.app.Activity;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.labtrentruong.Models.LaiThangKH;
import com.example.labtrentruong.R;

import java.util.ArrayList;

public class Lab5Activity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextInputEditText edtNameKH, edtSoTienVay;
    private RadioButton rb12Thang,rb24Thang,rb36Thang;
    private ListView lvLaiXuat;
    private Button btnTinhLaiXuat;
    private int laiThang;
    ArrayList<LaiThangKH> _list= new ArrayList<LaiThangKH>();;
    LaiThangAdapter item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
        findviewbyid();
        even();
    }

    private void even() {
        LoadSpinner();
        listView();
        btnTinhLaiXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sotien= Integer.parseInt(edtSoTienVay.getText().toString());
                int sothang = 0;
                if(rb12Thang.isChecked()==true){
                    sothang=12;
                    rb24Thang.setChecked(false);
                    rb36Thang.setChecked(false);
                }else if(rb24Thang.isChecked()==true){
                    sothang=24;
                    rb12Thang.setChecked(false);
                    rb36Thang.setChecked(false);
                }else  if(rb36Thang.isChecked()==true){
                    sothang=36;
                    rb24Thang.setChecked(false);
                    rb12Thang.setChecked(false);
                }
                _list.add(new LaiThangKH(edtNameKH.getText().toString(),sotien,sothang,laiThang));
                item.notifyDataSetChanged();
            }
        });

    }

    private void listView() {
        _list= LaiThangKH.init();
        item= new LaiThangAdapter(this, _list);
        lvLaiXuat.setAdapter(item);
        lvLaiXuat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtNameKH.setText(_list.get(position).getNameKH());
                if(_list.get(position).getSoThangTra()==12){
                    rb12Thang.setChecked(true);
                    rb24Thang.setChecked(false);
                    rb36Thang.setChecked(false);
                }else if(_list.get(position).getSoThangTra()==24){
                    rb24Thang.setChecked(true);
                    rb12Thang.setChecked(false);
                    rb36Thang.setChecked(false);
                }else if(_list.get(position).getSoThangTra()==36) {
                    rb36Thang.setChecked(true);
                    rb24Thang.setChecked(false);
                    rb12Thang.setChecked(false);
                }
                String sotien = String.valueOf(_list.get(position).getSoTienVay());
                edtSoTienVay.setText(sotien);

            }
        });
    }

    private void findviewbyid() {
        spinner = (Spinner) findViewById(R.id.snLai_thang);
        lvLaiXuat =(ListView)findViewById(R.id.lvLaiThang);
        edtNameKH= (TextInputEditText)findViewById(R.id.edtMember);
        edtSoTienVay= (TextInputEditText)findViewById(R.id.edtMoneys);
        rb12Thang=(RadioButton)findViewById(R.id.rb12_Thang);
        rb24Thang=(RadioButton)findViewById(R.id.rb24_Thang);
        rb36Thang=(RadioButton)findViewById(R.id.rb36_Thang);
        btnTinhLaiXuat=(Button) findViewById(R.id.btnTinhLaiXuat);
    }

    private void LoadSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lai_thang, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        laiThang= Integer.parseInt(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

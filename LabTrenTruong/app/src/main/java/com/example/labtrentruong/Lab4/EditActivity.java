package com.example.labtrentruong.Lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.labtrentruong.Models.Person;
import com.example.labtrentruong.R;

public class EditActivity extends AppCompatActivity {
    ImageView imgEditAvatar;
    EditText edtEditName, edtEditAddress, edtEditPhone;
    Button btnSaveEdit, btnExitEdit, btnDel;
    RadioButton rbNamed,rbNued;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initView();
        getData();
    }
    private void initView() {
        imgEditAvatar = (ImageView) findViewById(R.id.imgEditAvatar);
        edtEditName = (EditText) findViewById(R.id.edtEditName);
        edtEditAddress = (EditText) findViewById(R.id.edtEditAddress);
        edtEditPhone = (EditText) findViewById(R.id.edtEditPhone);
        btnExitEdit = (Button) findViewById(R.id.btnExitEdit);
        btnSaveEdit = (Button) findViewById(R.id.btnEdit);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnSaveEdit.setOnClickListener(SaveEdit_Click);
        btnExitEdit.setOnClickListener(Exit_Edit);
        btnDel.setOnClickListener(Del_Click);
        rbNamed= (RadioButton) findViewById(R.id.rbNamed);
        rbNued= (RadioButton) findViewById(R.id.rbNued);
    }
    // Kh??i ta??o getData
    private void getData() {
        if (getIntent().getExtras() != null) {
            person = (Person) getIntent().getSerializableExtra("EDIT");
            int a = person.getCode();
            imgEditAvatar.setImageResource(person.getAvatar());
            edtEditName.setText(person.getName());
            edtEditAddress.setText(person.getAddress());
            edtEditPhone.setText(person.getPhone());
            Boolean flag=person.getGioiTinh();
            if(flag==true){
                rbNamed.setChecked(true);
            }else {
                rbNued.setChecked(true);
            }
        }
    }

    View.OnClickListener SaveEdit_Click= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(EditActivity.this, Lab4Activity.class);
            int b = person.getCode();
            Person person1 = new Person(b, person.getAvatar(),
                    edtEditName.getText().toString(), edtEditAddress.getText().toString(),true, edtEditPhone.getText().toString());
            intent.putExtra("EDIT", person1);
            setResult(200, intent);
            finish();
        }
    };
    View.OnClickListener Del_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(EditActivity.this, Lab4Activity.class);
            intent.putExtra("DEL", person.getCode());
            setResult(300, intent);
            finish();
        }
    };
    View.OnClickListener Exit_Edit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}

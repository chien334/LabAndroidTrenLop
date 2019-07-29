package com.example.labtrentruong.Lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.labtrentruong.Models.Person;
import com.example.labtrentruong.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Lab4Activity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    PersonAdapter adapter;
    ArrayList<Person> listData;
    ListView lvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
        getData();
        initView();
    }

    private void initView() {
        adapter = new PersonAdapter(listData, Lab4Activity.this);
        lvData = (ListView) findViewById(R.id.lvData);
        lvData.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lvData.setOnItemLongClickListener(this);
    }

    private void getData() {
        listData = new ArrayList<>();
        listData.add(new Person(0, R.drawable.cho, "Hương Tràm", "Hà Nội",false, "0123456789"));
        listData.add(new Person(1, R.drawable.heo, "Issac", "Hà Nội", true,"012342327"));
        listData.add(new Person(2, R.drawable.ga, "Minh Hằng", "TP.HCM",false, "01234546889"));
        listData.add(new Person(3, R.drawable.chuot, "Mỹ Tâm", "Bình Định", false,"0123976439"));
        listData.add(new Person(4, R.drawable.dadieu, "OnlyC", "Quảng Bình", true,"016491372"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.btnAdd){
            Intent inte = new Intent(Lab4Activity.this, AddpersonActivity.class);
            startActivityForResult(inte, 10);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(Lab4Activity.this, EditActivity.class);
        intent.putExtra("EDIT", (Serializable) adapter.getItem(position));
        startActivityForResult(intent, 20);
        return true;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 10:
                if (data != null) {
                    Person person = (Person) data.getSerializableExtra("ADD");
                    if (resultCode == 100) {
                        person.setCode(adapter.getCount() + 1);
                        adapter.getListData().add(0, person);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(Lab4Activity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(Lab4Activity.this, "Có lỗi xảy ra vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                break;
            case 20:
                if (data != null) {
                    Person select = (Person) data.getSerializableExtra("EDIT");
                    if (resultCode == 200) {
                        for (Person item : adapter.getListData()) {
                            if (item.getCode() == select.getCode()) {
                                item.setName(select.getName());
                                item.setAddress(select.getAddress());
                                item.setPhone(select.getPhone());
                                break;
                            }
                        }
                        adapter.notifyDataSetChanged();
                        break;
                    } else if (resultCode == 300) {
                        int ID = data.getExtras().getInt("DEL");
                        int position = -1;
                        for (int i = 0; i < adapter.getCount(); i++) {
                            if (adapter.getItem(i).getCode() == ID) {
                                position = i;
                                break;
                            }
                        }
                        if (position < 0) {
                            Toast.makeText(Lab4Activity.this, "Không xác định được bạn cần xóa cái gi", Toast.LENGTH_SHORT).show();
                        } else {
                            adapter.getListData().remove(position);
                            adapter.notifyDataSetChanged();
                            Toast.makeText(Lab4Activity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        }
    }
}

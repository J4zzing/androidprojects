package com.itcast.product;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.itcast.product.bean.Account;
import com.itcast.product.dao.AccountDao;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Account> list;
    private AccountDao dao;
    private EditText nameET;
    private EditText balanceET;
    private ListView accountLV;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        dao = new AccountDao(this);
        list = dao.queryAll();
        adapter = new MyAdapter();
        accountLV.setAdapter(adapter);
    }

    private void initView() {
        accountLV = findViewById(R.id.accountLV);
        nameET = findViewById(R.id.nameET);
        balanceET = findViewById(R.id.balanceET);
        accountLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Account a = (Account)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), a.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void add(View v) {
        String name = nameET.getText().toString().trim();
        String balance = balanceET.getText().toString().trim();
        Account a = new Account(name, balance.equals("") ? 0 : Integer.parseInt(balance));
        dao.insert(a);
        list.add(a);
        adapter.notifyDataSetChanged();
        accountLV.setSelection(accountLV.getCount() - 1);
        nameET.setText("");
        balanceET.setText("");
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = convertView != null ? convertView : View.inflate(
                    getApplicationContext(), R.layout.item, null);
            TextView idTV = item.findViewById(R.id.idTV);
            TextView nameTV = item.findViewById(R.id.nameTV);
            TextView balanceTV = item.findViewById(R.id.balanceTV);
            final Account a = list.get(position);
            idTV.setText(a.getId() + "");
            nameTV.setText(a.getName());
            balanceTV.setText(a.getBalance() + "");

            ImageView upIV = item.findViewById(R.id.upIV);
            ImageView downIV = item.findViewById(R.id.downIV);
            ImageView deleteIV = item.findViewById(R.id.deleteIV);

            upIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a.setBalance(a.getBalance() + 1);
                    notifyDataSetChanged();
                    dao.update(a);
                }
            });

            downIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    a.setBalance(a.getBalance() - 1);
                    notifyDataSetChanged();
                    dao.update(a);
                }
            });

            deleteIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            list.remove(a);
                            dao.delete(a.getId());
                            notifyDataSetChanged();
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("确定要删除吗？");
                    builder.setPositiveButton("确定", listener);
                    builder.setNegativeButton("取消", null);
                    builder.show();
                }
            });
            return item;
        }
    }
}

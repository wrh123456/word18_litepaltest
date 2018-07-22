package com.example.word18_litepaltest;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase=(Button)findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });
        Button addDatabase=(Button)findViewById(R.id.add);
        addDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();
            }
        });
        Button modifyDatebase=(Button)findViewById(R.id.modify);
        modifyDatebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name=? and author=?","The Da Vinci Code","Dan Brown");
                //这里指定name="The Da Vinci Code"和antuor="Dan Brown"的书的价格改变为14.95

                //book.setToDefault("列名")；可以将数据更新为默认值
            }
        });
        Button deleteDatebase=(Button)findViewById(R.id.delete);
        deleteDatebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class,"price<?","15");
            }
        });
        Button query=(Button)findViewById(R.id.query_data);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books=DataSupport.findAll(Book.class);
                for(Book book:books){
                    Log.d("MainActivity","book name is "+book.getName());
                    Log.d("MainActivity","book author is"+book.getAuthor());
                    Log.d("MainAcivity","book pages is "+book.getPages());
                    Log.d("MainActivity","book price is"+book.getPrice());
                    Log.d("MainActivity", "book press is"+book.getPress());
                }
            }
        });
    }
}

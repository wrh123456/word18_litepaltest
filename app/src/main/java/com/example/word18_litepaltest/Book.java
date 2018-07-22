package com.example.word18_litepaltest;

import android.support.v4.view.PagerAdapter;

import org.litepal.crud.DataSupport;

public class Book extends DataSupport{//LitePal在进行表管理操作时不需要模型类有任何的继承结构，但是进行CRUD操作时必须要继承DataSupport类才行
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String press;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}

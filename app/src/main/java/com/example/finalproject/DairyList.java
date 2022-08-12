package com.example.finalproject;

public class DairyList {
    String title, writer, date, time;
    int imageId;

    public DairyList(String title, String writer, String time, String date, int imageId) {
        this.title = title;
        this.writer = writer;
        this.time = time;
        this.date = date;
        this.imageId = imageId;
    }
}

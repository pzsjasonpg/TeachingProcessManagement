package com.example.a28256.tpm.entity;

public class TeachNotice {
    private String url;
    private String title;
    private String date;

    public TeachNotice() {
    }

    public TeachNotice(String title, String date,String url) {
        this.url = url;
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.example.eventos.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Eventos {

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    @SerializedName("price")
    private String price;

    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private int id;

    @SerializedName("date")
    private int date;

    @SerializedName("people")
    private List<Pessoa> people;

    public Eventos(String description,String image, String price, String title, int id, int date, List<Pessoa> people) {
        this.description = description;
        this.image = image;
        this.price = price;
        this.title = title;
        this.id = id;
        this.date = date;
        this.people = people;
    }

    public Eventos() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public List<Pessoa> getPeople() {
        return people;
    }

    public void setPeople(List<Pessoa> people) {
        this.people = people;
    }
}

package com.example.eventos.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pessoa implements Serializable {
    @SerializedName("picture")
    private String picture;

    @SerializedName("name")
    private String name;

    @SerializedName("eventId")
    private int eventId;

    @SerializedName("id")
    private int id;

    public Pessoa() {
    }

    public Pessoa(String picture, String name, int eventId, int id) {
        this.picture = picture;
        this.name = name;
        this.eventId = eventId;
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

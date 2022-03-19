package com.revature.mtg;

public class Card {
    private int typeId;
    private String cost;
    private String name;
    private String artist;
    private long multiverse;

    public Card(int typeId, String cost, String name, String artist, long multiverse) {
        this.typeId = typeId;
        this.cost = cost;
        this.name = name;
        this.artist = artist;
        this.multiverse = multiverse;
    }

    @Override
    public String toString() {
        return "Card{" +
                "typeId=" + typeId +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", multiverse=" + multiverse +
                '}';
    }

    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public long getMultiverse() {
        return multiverse;
    }
    public void setMultiverse(long multiverse) {
        this.multiverse = multiverse;
    }
    public Card() {
    }
}
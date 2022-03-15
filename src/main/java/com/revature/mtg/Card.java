package com.revature.mtg;

public class Card {
    private int typeId;
    private int cost;
    private String name;

    public Card(int typeId, int cost, String name) {
        this.typeId = typeId;
        this.cost = cost;
        this.name = name;
    }
    public Card(int typeId, String name){
        this.typeId = typeId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                ", typeId=" + typeId +
                ", cost=" + cost +
                "name='" + name + '\'' +
                '}' + "\n";
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Card() {
    }
}
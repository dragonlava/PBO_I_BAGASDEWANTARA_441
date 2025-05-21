package com.praktikum.actions;

public class Item {
    private String itemName;
    private String description;
    private String location;
    private String status;

    public Item(String itemName, String description, String location, String status){
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getLocation(){
        return location;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}

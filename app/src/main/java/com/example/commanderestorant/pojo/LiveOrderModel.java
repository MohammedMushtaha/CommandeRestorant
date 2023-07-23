package com.example.commanderestorant.pojo;

public class LiveOrderModel {


    private int id;
    private String name;
    private String itemCount;
    private String assigned;
    private int timer;

    public LiveOrderModel(int id, String name, String itemCount, String assigned, int timer) {
        this.id = id;
        this.name = name;
        this.itemCount = itemCount;
        this.assigned = assigned;
        this.timer = timer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
        return "LiveDataMode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemCount='" + itemCount + '\'' +
                ", assigned='" + assigned + '\'' +
                ", timer=" + timer +
                '}';
    }
}

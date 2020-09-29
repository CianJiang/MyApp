package com.example.myapp;

public class meet {
    String name;
    String zht;
    String meet;
    String next;

    public meet(String name, String zht, String meet, String next) {
        this.name = name;
        this.zht = zht;
        this.meet = meet;
        this.next = next;
    }

    public meet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZht() {
        return zht;
    }

    public void setZht(String zht) {
        this.zht = zht;
    }

    public String getMeet() {
        return meet;
    }

    public void setMeet(String meet) {
        this.meet = meet;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "meet{" +
                "name='" + name + '\'' +
                ", zht='" + zht + '\'' +
                ", meet='" + meet + '\'' +
                ", next='" + next + '\'' +
                '}';
    }
}

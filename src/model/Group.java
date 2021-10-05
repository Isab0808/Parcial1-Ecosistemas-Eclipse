package model;


public class Group {

    private String name;
    private  int color;
    private int number,x,y;

    public Group(){


    }
    public Group(String name,int color, int number, int x, int y) {
        this.name = name;
        this.number = number;
        this.x = x;
        this.y = y;
        this.color=color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

package model;

import processing.core.PApplet;

public class Particle {

    private String nameGroup;
    private PApplet app;
    private int color;
    private float speedX,speedY;
    private int posX,posY;
    private boolean canMove;

    public Particle(PApplet app,String nameGroup,int color,int posX,int posY){

        this.app=app;
        this.nameGroup = nameGroup;
        this.posX = posX;
        this.posY = posY;
        this.color=color;
        speedX = app.random(-8,8);
        speedY = app.random(-8,8);
        canMove= true;

    }

    public void draw(){

        switch (this.color){

            case 1:

                app.fill(255,0,0);
                break;
            case 2:

                app.fill(117,209,11);
                break;
            case 3:

                app.fill(33,150,243);
                break;
        }
        if(speedX==0||speedY==0){
            SetRandomPos();
        }

        app.ellipse(posX,posY,30,30);

        if(canMove){
            move();
        }
        else{
            displayInfo();
        }

    }

    private void displayInfo() {

        app.fill(255);
        app.text(nameGroup,posX,posY-10,100,200);
    }

    public void move(){
        posX+=speedX;
        posY-=speedY;

        if(posX>=app.width||posX<=0){

            speedX*=-1;
        }

        if(posY>=app.height||posY<=0){

            speedY*=-1;
        }
    }

    public void SetRandomPos(){
        speedX = app.random(-5,5);
        speedY = app.random(-8,8);
    }
    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public float getSpeedX() {
        return speedX;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
}

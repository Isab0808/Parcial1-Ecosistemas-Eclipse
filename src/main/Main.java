package main;

import com.google.gson.Gson;
import communication.OnMessageListener;
import communication.TCP_Singleton;
import model.Generic;
import model.Group;
import model.Particle;
import processing.core.PApplet;

import java.util.ArrayList;

public class Main  extends PApplet implements OnMessageListener {

    private TCP_Singleton tcp;
    private ArrayList<Particle> particles;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PApplet.main("main.Main");
    }

    public void settings(){

        size(800,600);

    }

    public void setup(){

        background(0);
        tcp=TCP_Singleton.getInstance();
        tcp.SetObserver(this);
        particles = new ArrayList<>();

    }
    public void draw(){
        background(0);
        particles.forEach(particle -> {

            particle.draw();
            if(dist(mouseX,mouseY,particle.getPosX(),particle.getPosY())<20){

                particle.setCanMove(false);
            }
            else{

                particle.setCanMove(true);
            }

        });

    }


    @Override
    public void OnMessage(String msg) {

        Gson gson = new Gson();

        Generic generic = gson.fromJson(msg, Generic.class);

        switch(generic.getType()) {

            case "Group":

                Group temp = gson.fromJson(msg, Group.class);

                for(int i =0;i< temp.getNumber();i++){

                    Particle tempParticle = new Particle(this, temp.getName(), temp.getColor(), temp.getX(), temp.getY());
                    particles.add(tempParticle);

                }
                break;

            case "Delete" :

                particles.clear();
                break;

        }

    }
}

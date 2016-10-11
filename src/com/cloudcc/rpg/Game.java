package com.cloudcc.rpg;

import com.cloudcc.rpg.display.Display;
import com.cloudcc.rpg.gfx.Assets;
import com.cloudcc.rpg.gfx.GameCamera;
import com.cloudcc.rpg.gfx.ImageLoader;
import com.cloudcc.rpg.gfx.SpriteSheet;
import com.cloudcc.rpg.input.KeyManager;
import com.cloudcc.rpg.state.GameState;
import com.cloudcc.rpg.state.MenuState;
import com.cloudcc.rpg.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by hi112 on 09.10.2016.
 */
public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;


    //Input
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;



    public Game(String title, int width, int height){

        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();

    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        gameCamera = new GameCamera(this, 0, 0);

        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setState(gameState);
    }



    private void tick(){
        keyManager.tick();

        if(State.getState() != null){
            State.getState().tick();
        }


    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0,0, width, height);
        //Draw Here

        if(State.getState() != null){
            State.getState().render(g);
        }

        //End Drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();

        int fps = 60    ;
        double timePerTicK = 1000000000 / fps; //max Time in ns
        double delta = 0; //amount of time
        long now;           // current time
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;



        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTicK;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public synchronized void start(){

        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){

        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}

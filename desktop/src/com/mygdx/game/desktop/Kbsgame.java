package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.*;
import java.util.Iterator;

public class Kbsgame extends ApplicationAdapter {
    private Texture enemyImage;
    private Sprite heroImage;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture bullet;
    private Rectangle heroBody;
    private float angle;
    private Array<Rectangle> bullets;
    private boolean north = false;
    private boolean east = false;
    private boolean west = false;
    private boolean south = false;

    @Override

    public void create() {

        // camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 900);
        batch = new SpriteBatch();
        bullet = new Texture(Gdx.files.internal("droplet.png"));
        heroBody = new Rectangle();
        heroBody.x = 550;
        heroBody.y = 500;
        heroImage = new Sprite(new Texture(Gdx.files.internal("droplet.png")));
        bullets = new Array<Rectangle>();


        //hero

        //enemy


    }


    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.x = 800;
        raindrop.y = 480;
        raindrop.width = 64;
        raindrop.height = 64;
        bullets.add(raindrop);
    }


    @Override
    public void render() {
        // achtergrond kleur
        ScreenUtils.clear(0, 0, 128, 0);
        //camera
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        while (west){
            shootWest();
            //draw();

        }

        while (north){
            shootDown();
            draw();
        }

        draw();
        shootDown();
    }

    public void draw() {
        batch.begin();
        heroImage .setPosition(heroBody.x, heroBody.y);

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            angle = 360;
            spawnRaindrop();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            angle = 180;

            spawnRaindrop();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            angle = 270;
            spawnRaindrop();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            angle = 90;
            spawnRaindrop();
        }

        heroImage.setRotation(angle);

        for (Rectangle raindrop : bullets) {
            batch.draw(bullet, raindrop.x, raindrop.y);
        }
        heroImage.draw(batch);
        batch.end();
    }

    public void shootDown(){
        for (Iterator<Rectangle> iter = bullets.iterator(); iter.hasNext(); ) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + 64 < 0) iter.remove();
        }
    }

    public void shootWest(){
        for (Iterator<Rectangle> iter = bullets.iterator(); iter.hasNext(); ) {
            Rectangle raindrop = iter.next();
            raindrop.x -= 200 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + 64 < 0) iter.remove();
        }
    }



        public void dispose (){
            batch.dispose();
        }
    }


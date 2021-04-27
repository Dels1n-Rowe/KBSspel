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
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class Kbsgame extends ApplicationAdapter {
    private Texture enemyImage;
    private Texture heroImage;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture bullet;
    private Rectangle heroBody;
    private Sprite test1;
    private float angle;
    //ShapeRenderer shapeRenderer;

    @Override

    public void create(){

        // camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 900);
        batch = new SpriteBatch();
        bullet = new Texture(Gdx.files.internal("droplet.png"));
        heroImage = new Texture(Gdx.files.internal("bucket.png"));
        heroBody = new Rectangle();
        heroBody.x = 550;
        heroBody.y = 500;
        heroBody.width =64;
        heroBody. height = 64;
        test1 = new Sprite(new Texture(Gdx.files.internal("droplet.png")));





        //hero

        //enemy

       // shapeRenderer = new ShapeRenderer();




    }







    @Override
    public void render(){
        // achtergrond kleur
        ScreenUtils.clear(0,0,128,0);
        //camera
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        draw();



    }

    public void draw(){
        batch.begin();
        test1.setPosition(heroBody.x,heroBody.y);

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            angle = 360;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
            angle = 180;


        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){
            angle = 270;

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)){
            angle = 0;


        }

        test1.setRotation(angle);

        test1.draw(batch);
        batch.end();
    }






    public void dispose () {
        batch.dispose();
    }
    }


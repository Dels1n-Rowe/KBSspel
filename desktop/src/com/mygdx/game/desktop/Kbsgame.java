package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class Kbsgame extends ApplicationAdapter {
    private Texture enemyImage;
    private Texture heroImage;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture bullet;
    private Rectangle heroBody;
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



        //hero

        //enemy




    }

    @Override
    public void render(){
        // achtergrond kleur
        ScreenUtils.clear(0,0,128,0);
        //camera
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(heroImage, heroBody.x, heroBody.y);
        batch.end();

    }
}

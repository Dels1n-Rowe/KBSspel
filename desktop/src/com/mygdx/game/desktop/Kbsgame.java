package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Kbsgame extends ApplicationAdapter {
    private Texture enemyImage;
    private Texture heroImage;
    private SpriteBatch batch;
    private OrthographicCamera camera;

    @Override
    public void create(){

        // camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 900);
        batch = new SpriteBatch();

        //hero

        //enemy




    }

    @Override
    public void render(){
        // achtergrond kleur
        ScreenUtils.clear(1,1,0,1);

        //camera
        camera.update();
    }
}

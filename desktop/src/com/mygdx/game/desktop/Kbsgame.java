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
    private Sprite enemyImage;
    private Sprite heroImage;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Texture bullet;
    private Rectangle heroBody;
    private float angle;
    private Array<Rectangle> bulletsS;
    private Array<Rectangle> bulletsN;
    private Array<Rectangle> bulletsW;
    private Array<Rectangle> bulletsE;
    private Array<Rectangle> enemys;
    private boolean north = false;
    private boolean east = false;
    private boolean west = false;
    private boolean south = false;
    private long laatsteEnemy;
    private int test = 1;

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
        bulletsS = new Array<Rectangle>();
        bulletsE = new Array<Rectangle>();
        bulletsW = new Array<Rectangle>();
        bulletsN = new Array<Rectangle>();
        enemys = new Array<Rectangle>();
        enemyImage = new Sprite(new Texture(Gdx.files.internal("droplet.png")));


        //hero

        //enemy


    }

    private void spawnenemy() {
        Rectangle enemy = new Rectangle();
        int randomGetal = MathUtils.random(1,4);
        if(randomGetal == 1) {
            enemy.x = 50;
            enemy.y = 50;
        }
        if(randomGetal == 2) {
            enemy.x = 1100;
            enemy.y = 800;
        }
        if(randomGetal == 3) {
            enemy.x = 50;
            enemy.y = 800;
        }
        if(randomGetal == 4) {
            enemy.x = 1100;
            enemy.y = 50;
        }
        enemy.width = 64;
        enemy.height = 64;
        enemys.add(enemy);
        laatsteEnemy = TimeUtils.nanoTime();
    }

    private void spawnNorthRaindrop() {
        Rectangle raindropN = new Rectangle();
        raindropN.x = 550;
        raindropN.y = 500;
        raindropN.width = 64;
        raindropN.height = 64;
        bulletsN.add(raindropN);
    }
    private void spawnWestRaindrop() {
        Rectangle raindropW = new Rectangle();
        raindropW.x = 550;
        raindropW.y = 500;
        raindropW.width = 64;
        raindropW.height = 64;
        bulletsW.add(raindropW);
    }
    private void spawnEastRaindrop() {
        Rectangle raindropE = new Rectangle();
        raindropE.x = 550;
        raindropE.y = 500;
        raindropE.width = 64;
        raindropE.height = 64;
        bulletsE.add(raindropE);
    }
    private void spawnSouthRaindrop() {
        Rectangle raindropS = new Rectangle();
        raindropS.x = 550;
        raindropS.y = 500;
        raindropS.width = 64;
        raindropS.height = 64;
        bulletsS.add(raindropS);
    }


    @Override
    public void render() {
        // achtergrond kleur
        ScreenUtils.clear(0, 0, 128, 0);
        //camera
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        shootWest();
        shootEast();
        shootNorth();
        shootDown();
        draw();
    }

    public void draw() {
        batch.begin();
        if (test ==1) {
            spawnenemy();
            test =2;
        }

        if(TimeUtils.nanoTime() - laatsteEnemy > 1000000000) spawnenemy();

        for (Rectangle enemy: enemys){
            batch.draw(enemyImage, enemy.x,  enemy.y);
        }

        heroImage .setPosition(heroBody.x, heroBody.y);

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            angle = 360;
            north = false;
            west = true;
            east = false;
            south = false;
            spawnWestRaindrop();

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            angle = 180;
            north = true;
            west = false;
            east = false;
            south = false;
            spawnNorthRaindrop();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            angle = 270;
            north = false;
            west = false;
            east = false;
            south = true;
            spawnSouthRaindrop();
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            angle = 90;
            north = false;
            west =false;
            east = true;
            south = false;
            spawnEastRaindrop();
        }

        heroImage.setRotation(angle);

        for (Rectangle raindrop : bulletsS) {
            batch.draw(bullet, raindrop.x, raindrop.y);
        }
        for (Rectangle raindrop : bulletsN) {
            batch.draw(bullet, raindrop.x, raindrop.y);
        }
        for (Rectangle raindrop : bulletsW) {
            batch.draw(bullet, raindrop.x, raindrop.y);
        }
        for (Rectangle raindrop : bulletsE) {
            batch.draw(bullet, raindrop.x, raindrop.y);
        }
        heroImage.draw(batch);
        batch.end();
    }

    public void shootDown(){
        for (Iterator<Rectangle> iter = bulletsS.iterator(); iter.hasNext(); ) {
            Rectangle raindropS = iter.next();
            raindropS.y -= 200 * Gdx.graphics.getDeltaTime();
            if (raindropS.y + 64 < 0) iter.remove();
        }
    }

    public void shootWest(){
        for (Iterator<Rectangle> iter = bulletsW.iterator(); iter.hasNext(); ) {
            Rectangle raindropW = iter.next();
            raindropW.x -= 200 * Gdx.graphics.getDeltaTime();
            if (raindropW.y + 64 < 0) iter.remove();
        }
    }
    public void shootEast(){
        for (Iterator<Rectangle> iter = bulletsE.iterator(); iter.hasNext(); ) {
            Rectangle raindropE = iter.next();
            raindropE.x += 200 * Gdx.graphics.getDeltaTime();
            if (raindropE.y + 64 < 0) iter.remove();
        }
    }
    public void shootNorth(){
        for (Iterator<Rectangle> iter = bulletsN.iterator(); iter.hasNext(); ) {
            Rectangle raindropN = iter.next();
            raindropN.y += 200 * Gdx.graphics.getDeltaTime();
            if (raindropN.y + 64 < 0) iter.remove();
        }
    }



        public void dispose (){
            batch.dispose();
        }
    }


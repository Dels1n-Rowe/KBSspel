package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private Array<Rectangle> enemysLeft;
    private Array<Rectangle> enemysDown;
    private Array<Rectangle> enemysUp;
    private Array<Rectangle> enemysRight;
    private BitmapFont font;
    private int kogels;
    private int levens;

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
        heroImage = new Sprite(new Texture(Gdx.files.internal("bucket.png")));
        bulletsS = new Array<Rectangle>();
        bulletsE = new Array<Rectangle>();
        bulletsW = new Array<Rectangle>();
        bulletsN = new Array<Rectangle>();
        enemysLeft = new Array<Rectangle>();
        enemysUp = new Array<Rectangle>();
        enemysRight = new Array<Rectangle>();
        enemysDown = new Array<Rectangle>();
        enemyImage = new Sprite(new Texture(Gdx.files.internal("droplet.png")));
        font = new BitmapFont();
        kogels = 6;
        levens = 6;


        //hero

        //enemy


    }

    public void spawnenemy(){
        int randomGetal = MathUtils.random(1,4);
        if (randomGetal ==1) {
            spawnEnemyLeft();
        }
        if (randomGetal == 2){
            spawnEnemyDown();
        }
        if (randomGetal == 3){
            spawnEnemyUp();
        }
        if (randomGetal == 4){
            spawnEnemyRight();
        }
    }

    private void spawnEnemyLeft() {
        Rectangle enemyL = new Rectangle();
        enemyL.x = 50;
        enemyL.y = 500;
        enemyL.width = 64;
        enemyL.height = 64;
        enemysLeft.add(enemyL);
        laatsteEnemy = TimeUtils.nanoTime();
    }
    private void spawnEnemyUp() {
        Rectangle enemyU = new Rectangle();
        enemyU.x = 550;
        enemyU.y = 800;
        enemyU.width = 64;
        enemyU.height = 64;
        enemysUp.add(enemyU);
        laatsteEnemy = TimeUtils.nanoTime();
    }
    private void spawnEnemyDown() {
        Rectangle enemyD = new Rectangle();
        enemyD.x = 550;
        enemyD.y = 50;
        enemyD.width = 64;
        enemyD.height = 64;
        enemysDown.add(enemyD);
        laatsteEnemy = TimeUtils.nanoTime();
    }

    private void spawnEnemyRight() {
        Rectangle enemyR = new Rectangle();
        enemyR.x = 1100;
        enemyR.y = 500;
        enemyR.width = 64;
        enemyR.height = 64;
        enemysRight.add(enemyR);
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
        walkDown();
        walkLeft();
        walRight();
        walkUp();
        draw();
    }

    public void draw() {
        batch.begin();

        font.draw(batch,"0" + String.valueOf(kogels), 1100, 50);

        font.draw(batch, "levens 0" + String.valueOf(levens),50,50);

        if(test == 1){
        int randomGetal = MathUtils.random(1,4);
        if (randomGetal ==1) {
            spawnEnemyLeft();
        }
        if (randomGetal == 2){
            spawnEnemyDown();
        }
        if (randomGetal == 3){
            spawnEnemyUp();
        }
        if (randomGetal == 4){
            spawnEnemyRight();
        }
            test =2;
        }

        if(TimeUtils.nanoTime() - laatsteEnemy > 1000000000) spawnenemy();

        for (Rectangle enemy: enemysLeft){
            batch.draw(enemyImage, enemy.x,  enemy.y);
        }
        for (Rectangle enemy: enemysUp){
            batch.draw(enemyImage, enemy.x,  enemy.y);
        }
        for (Rectangle enemy: enemysDown){
            batch.draw(enemyImage, enemy.x,  enemy.y);
        }
        for (Rectangle enemy: enemysRight){
            batch.draw(enemyImage, enemy.x,  enemy.y);
        }

        heroImage .setPosition(heroBody.x, heroBody.y);

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            angle = 360;
            if (kogels >= 1) {
                spawnWestRaindrop();
                kogels--;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            angle = 180;
            if (kogels >= 1) {
                spawnNorthRaindrop();
                kogels--;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            angle = 270;
            if (kogels >= 1) {
                spawnSouthRaindrop();
                kogels--;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            angle = 90;
            if (kogels >= 1) {
                spawnEastRaindrop();
                kogels--;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)){
            kogels = 6;
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

    public void walkDown(){
        for (Iterator<Rectangle> iter = enemysUp.iterator(); iter.hasNext(); ) {
            Rectangle enemyU = iter.next();
            enemyU.y -= 100 * Gdx.graphics.getDeltaTime();
            if (enemyU.y + 64 < 0) iter.remove();
            if (enemyU.y <= 500){
                iter.remove();
                if (levens >= 1) {
                    levens--;
                }
            }
        }
    }
    public void walkUp(){
        for (Iterator<Rectangle> iter = enemysDown.iterator(); iter.hasNext(); ) {
            Rectangle enemyD = iter.next();
            enemyD.y += 150 * Gdx.graphics.getDeltaTime();
            if (enemyD.y + 64 < 0) iter.remove();
            if (enemyD.y >= 500){
                iter.remove();
                if (levens >= 1) {
                    levens--;
                }
            }
        }
    }
    public void walkLeft(){
        for (Iterator<Rectangle> iter = enemysRight.iterator(); iter.hasNext(); ) {
            Rectangle enemyR = iter.next();
            enemyR.x -= 100 * Gdx.graphics.getDeltaTime();
            if (enemyR.y + 64 < 0) iter.remove();
            if (enemyR.x <= 550){
                iter.remove();
                if (levens >= 1) {
                    levens--;
                }
            }
        }
    }
    public void walRight(){
        for (Iterator<Rectangle> iter = enemysLeft.iterator(); iter.hasNext(); ) {
            Rectangle enemyL = iter.next();
            enemyL.x += 150 * Gdx.graphics.getDeltaTime();
            if (enemyL.y + 64 < 0) iter.remove();
            if (enemyL.x >= 550){
                iter.remove();
                if (levens >= 1) {
                    levens--;
                }
            }
        }
    }

        public void dispose (){
            batch.dispose();
        }
    }


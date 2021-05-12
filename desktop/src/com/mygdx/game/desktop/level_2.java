package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class level_2 implements Screen {
        private Sprite enemyImageOmhoog;
        private Sprite enemyImageOmlaag;
        private Sprite enemyImageRechts;
        private Sprite enemyImageLinks;
        private Sprite heroImage;
        private SpriteBatch batch;
        private OrthographicCamera camera;
        private Texture imageBulletRechts;
        private Texture imageBulletLinks;
        private Texture imageBulletOmhoog;
        private Texture imageBulletOmlaag;
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
        private Rectangle enemyR;
        private BitmapFont font;
        private int kogels;
        private int levens;
        private int score;
        private Game game;

        private long laatsteEnemy;
        private int test = 1;
        private PlayerData Data;

        private Texture achtergrond;

        public level_2(Game game,PlayerData data) {
            this.game = game;
            this.Data = data;
            // camera
            camera = new OrthographicCamera();
            camera.setToOrtho(false, 1200, 900);
            batch = new SpriteBatch();
            imageBulletRechts = new Texture(Gdx.files.internal("kogelRechts.png"));
            imageBulletOmhoog = new Texture(Gdx.files.internal("kogelOmhoog.png"));
            imageBulletLinks = new Texture(Gdx.files.internal("kogelLinks.png"));
            imageBulletOmlaag = new Texture(Gdx.files.internal("kogelOmlaag.png"));
            heroBody = new Rectangle();
            heroBody.x = 550;
            heroBody.y = 500;
            heroImage = new Sprite(new Texture(Gdx.files.internal("bovenAanzichtHero.png")));
            bulletsS = new Array<Rectangle>();
            bulletsE = new Array<Rectangle>();
            bulletsW = new Array<Rectangle>();
            bulletsN = new Array<Rectangle>();
            enemysLeft = new Array<Rectangle>();
            enemysUp = new Array<Rectangle>();
            enemysRight = new Array<Rectangle>();
            enemysDown = new Array<Rectangle>();
            enemyImageOmhoog = new Sprite(new Texture(Gdx.files.internal("jaguarOmhoog.png")));
            enemyImageOmlaag = new Sprite(new Texture(Gdx.files.internal("jaguarOmlaag.png")));
            enemyImageLinks = new Sprite(new Texture(Gdx.files.internal("jaguarLinks.png")));
            enemyImageRechts = new Sprite(new Texture(Gdx.files.internal("jaguarRechts.png")));
            font = new BitmapFont();
            kogels = 6;
            levens = 6;
            score = 0;
            achtergrond = new Texture(Gdx.files.internal("achtergrondLevel2.png"));

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
        //
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
            enemyR = new Rectangle();
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
        ///dd

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


        public void render(float delta) {
            // achtergrond kleur
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
            if(score == 15){
                game.setScreen(new Victory(game, score,Data));
            }

            if (levens == 0){
                game.setScreen(new Gameoverscherm(game, score, Data));
            }
        }

        public void draw() {
            batch.begin();

            batch.draw(achtergrond,0,0);

            font.draw(batch, "kogels 0" + String.valueOf(kogels), 1100, 50);

            font.draw(batch, "levens 0" + String.valueOf(levens), 50, 50);

            font.draw(batch, "score " + String.valueOf(score),50 , 850);

            if (test == 1) {
                int randomGetal = MathUtils.random(1, 4);
                if (randomGetal == 1) {
                    spawnEnemyLeft();
                }
                if (randomGetal == 2) {
                    spawnEnemyDown();
                }
                if (randomGetal == 3) {
                    spawnEnemyUp();
                }
                if (randomGetal == 4) {
                    spawnEnemyRight();
                }
                test = 2;
            }

            if (TimeUtils.nanoTime() - laatsteEnemy > 1000000000) spawnenemy();

            for (Rectangle enemy : enemysLeft) {
                batch.draw(enemyImageRechts, enemy.x, enemy.y);
            }
            for (Rectangle enemy : enemysUp) {
                batch.draw(enemyImageOmlaag, enemy.x, enemy.y);
            }
            for (Rectangle enemy : enemysDown) {
                batch.draw(enemyImageOmhoog, enemy.x, enemy.y);
            }
            for (Rectangle enemy : enemysRight) {
                batch.draw(enemyImageLinks, enemy.x, enemy.y);
            }

            heroImage.setPosition(heroBody.x, heroBody.y);

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

            if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                kogels = 6;
            }

            heroImage.setRotation(angle);

            for (Rectangle raindrop : bulletsS) {
                batch.draw(imageBulletOmlaag, raindrop.x, raindrop.y);
            }
            for (Rectangle raindrop : bulletsN) {
                batch.draw(imageBulletOmhoog, raindrop.x, raindrop.y);
            }
            for (Rectangle raindrop : bulletsW) {
                batch.draw(imageBulletLinks, raindrop.x, raindrop.y);
            }
            for (Rectangle raindrop : bulletsE) {
                batch.draw(imageBulletRechts, raindrop.x, raindrop.y);
            }
            heroImage.draw(batch);
            batch.end();
        }

        public void shootDown() {
            for (Iterator<Rectangle> M = bulletsS.iterator(); M.hasNext(); ) {
                Rectangle raindropS = M.next();
                raindropS.y -= 200 * Gdx.graphics.getDeltaTime();
                if (raindropS.y + 64 < 0) M.remove();
                for (Iterator<Rectangle> N = enemysDown.iterator(); N.hasNext(); ) {
                    Rectangle enemyS = N.next();
                    if (raindropS.overlaps(enemyS)){
                        M.remove();
                        N.remove();
                        score++;
                    }

                }
            }
        }

        public void shootWest() {
            for (Iterator<Rectangle> N = bulletsW.iterator(); N.hasNext(); ) {
                Rectangle raindropW = N.next();
                raindropW.x -= 200 * Gdx.graphics.getDeltaTime();
                if (raindropW.y + 64 < 0)  N.remove();
                for (Iterator<Rectangle> L = enemysLeft.iterator(); L.hasNext(); ) {
                    Rectangle enemyL = L.next();
                    if (raindropW.overlaps(enemyL)) {
                        L.remove();
                        N.remove();
                        score++;
                    }

                }
            }
        }



        public void shootEast(){
            for (Iterator<Rectangle> iter = bulletsE.iterator(); iter.hasNext(); ) {
                Rectangle raindropE = iter.next();
                raindropE.x += 200 * Gdx.graphics.getDeltaTime();
                if (raindropE.y + 64 < 0) iter.remove();
                for (Iterator<Rectangle> k = enemysRight.iterator(); k.hasNext(); ) {
                    Rectangle enemyR = k.next();
                    if(raindropE.overlaps(enemyR)) {
                        iter.remove();
                        k.remove();
                        score++;
                    }

                }
            }
        }


        public void shootNorth () {
            for (Iterator<Rectangle> O = bulletsN.iterator(); O.hasNext(); ) {
                Rectangle raindropN = O.next();
                raindropN.y += 200 * Gdx.graphics.getDeltaTime();
                if (raindropN.y + 64 < 0) O.remove();
                for (Iterator<Rectangle> A = enemysUp.iterator(); A.hasNext(); ) {
                    Rectangle enemyI = A.next();
                    if (raindropN.overlaps(enemyI)) {
                        A.remove();
                        O.remove();
                        score++;
                    }

                }
            }
        }

        public void walkDown () {
            for (Iterator<Rectangle> iter = enemysUp.iterator(); iter.hasNext(); ) {
                Rectangle enemyU = iter.next();
                enemyU.y -= 150 * Gdx.graphics.getDeltaTime();
                if (enemyU.y + 64 < 0) iter.remove();
                if (enemyU.y <= 500) {
                    iter.remove();
                    if (levens >= 1) {
                        levens--;
                    }
                }
            }
        }
        public void walkUp () {
            for (Iterator<Rectangle> iter = enemysDown.iterator(); iter.hasNext(); ) {
                Rectangle enemyD = iter.next();
                enemyD.y += 170 * Gdx.graphics.getDeltaTime();
                if (enemyD.y + 64 < 0) iter.remove();
                if (enemyD.y >= 500) {
                    iter.remove();
                    if (levens >= 1) {
                        levens--;
                    }
                }
            }
        }
        public void walkLeft () {
            for (Iterator<Rectangle> iter = enemysRight.iterator(); iter.hasNext(); ) {
                Rectangle enemyR = iter.next();
                enemyR.x -= 500 * Gdx.graphics.getDeltaTime();
                if (enemyR.y + 64 < 0) iter.remove();
                if (enemyR.x <= 550) {
                    iter.remove();
                    if (levens >= 1) {
                        levens--;
                    }
                }
            }
        }
        public void walRight () {
            for (Iterator<Rectangle> iter = enemysLeft.iterator(); iter.hasNext(); ) {
                Rectangle enemyL = iter.next();
                enemyL.x += 50 * Gdx.graphics.getDeltaTime();
                if (enemyL.y + 64 < 0) iter.remove();
                if (enemyL.x >= 550) {
                    iter.remove();
                    if (levens >= 1) {
                        levens--;
                    }
                }
            }
        }

        @Override
        public void show() {

        }


        @Override
        public void resize(int width, int height) {

        }

        @Override
        public void pause() {

        }

        @Override
        public void resume() {

        }

        @Override
        public void hide() {

        }

        public void dispose () {
            batch.dispose();
        }
    }






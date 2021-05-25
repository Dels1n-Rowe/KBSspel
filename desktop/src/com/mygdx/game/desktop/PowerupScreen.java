package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PowerupScreen  implements Screen {
        private SpriteBatch sprite;
        private OrthographicCamera cam;
        private BitmapFont font;
        private Skin skin;
        private TextButton buttonPiercing;
        private TextButton backbutton;
        private TextButton  buttonDualshot;
        private PlayerData Data;
        private Texture achtergrond;
        private SpriteBatch batch;
        private Stage stage;
        private Game game;
        private TextButton leechButton;
        private TextButton leechAan;
        private TextButton leechUit;
        private TextButton piercingAan;
        private TextButton piercingUit;
        private TextButton dualshotAan;
        private TextButton dualshotUit;

        public PowerupScreen(final Game game, final PlayerData data){
            this.game = game;
            this.Data = data;
            stage = new Stage(new ScreenViewport());
            batch = new SpriteBatch();

            cam = new OrthographicCamera();
            cam.setToOrtho(false, 1200, 900);
            sprite = new SpriteBatch();

            font = new BitmapFont();
            font.setColor(Color.BLUE);

            skin = new Skin(Gdx.files.internal("flat-earth-ui.json"));

            // knoppen dualshot

            buttonDualshot = new TextButton("dualshot, 10 credits", skin);
            buttonDualshot.setHeight(100);
            buttonDualshot.setWidth(500);
            buttonDualshot.setPosition(350, 750);

            dualshotAan = new TextButton("dualshot staat aan", skin);
            dualshotAan.setHeight(100);
            dualshotAan.setWidth(500);
            dualshotAan.setPosition(-1000,-1000);

            dualshotUit = new TextButton("dualshot staat uit", skin);
            dualshotUit.setHeight(100);
            dualshotUit.setWidth(500);
            dualshotUit.setPosition(-1000,-1000);

            // knoppen leech

            leechButton = new TextButton("leech, 10 credits", skin);
            leechButton.setHeight(100);
            leechButton.setWidth(500);
            leechButton.setPosition(350,600);

            leechAan = new TextButton("leech staat aan", skin);
            leechAan.setHeight(100);
            leechAan.setWidth(500);
            leechAan.setPosition(-1000,-1000);

            leechUit = new TextButton("leech staat uit",skin);
            leechUit.setHeight(100);
            leechUit.setWidth(500);
            leechUit.setPosition(-1000,-1000);

            // knoppen piercing

            buttonPiercing = new TextButton("piercing, 10 credits", skin);
            buttonPiercing.setWidth(500);
            buttonPiercing.setHeight(100);
            buttonPiercing.setPosition(350,450);

            piercingAan = new TextButton("piercing staat aan", skin);
            piercingAan.setHeight(100);
            piercingAan.setWidth(500);
            piercingAan.setPosition(-1000,-1000);

            piercingUit = new TextButton("piercing staat uit", skin);
            piercingUit.setHeight(100);
            piercingUit.setWidth(500);
            piercingUit.setPosition(-1000,-1000);

            backbutton = new TextButton("back", skin);
            backbutton.setWidth(500);
            backbutton.setHeight(100);
            backbutton.setPosition(350, 300);

            // opnieuw naar het scherm toe en dus het goed zetten van de knoppen

            if (data.isDualshotGekocht()){
                buttonDualshot.setPosition(-1000,-1000);
                if (Data.isDualshot_1()){
                    dualshotAan.setPosition(350, 750);
                }
                if (Data.isDualshotGekocht() && Data.isDualshot_1() == false){
                    dualshotUit.setPosition(350,750);
                }
            }

            if (data.isLeechGekocht()){
                leechButton.setPosition(-1000,-1000);
                if (Data.getLeech()){
                    leechAan.setPosition(350, 600);
                }
                if (Data.isLeechGekocht() && Data.getLeech() == false){
                    leechUit.setPosition(350,600);
                }
            }

            if (data.isPiercingGekocht()){
                buttonPiercing.setPosition(-1000,-1000);
                if (Data.isPiercing()){
                    piercingAan.setPosition(350, 450);
                }
                if (Data.isPiercingGekocht() && Data.isPiercing() == false){
                    piercingUit.setPosition(350,450);
                }
            }

            backbutton.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(new Menuscherm(game, Data));

                }
            });

            // piercing kopen en bij behorende knoppen

            buttonPiercing.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    if (Data.getScore() > 9) {
                        Data.setPiercing(true);
                        Data.addScore(-10);
                        buttonPiercing.setPosition(-1000, -1000);
                        data.setPiercingGekocht(true);
                        piercingAan.setPosition(350,450);
                        if (data.isDualshotGekocht()){
                            dualshotAan.setPosition(-1000,-1000);
                            dualshotUit.setPosition(350,750);
                            data.setDualshot_1(false);
                        }
                        if(data.isLeechGekocht()){
                            leechAan.setPosition(-1000,-1000);
                            leechUit.setPosition(350,600);
                            data.setLeech(false);
                        }
                    }
                }
            });

            piercingAan.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    Data.setPiercing(false);
                    piercingAan.setPosition(-1000,-1000);
                    piercingUit.setPosition(350, 450);
                }
            });

            piercingUit.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    piercingAan.setPosition(350, 450);
                    piercingUit.setPosition(-1000,-1000);
                    data.setPiercing(true);
                    if (data.isDualshotGekocht()){
                        dualshotAan.setPosition(-1000,-1000);
                        dualshotUit.setPosition(350,750);
                        data.setDualshot_1(false);
                    }
                    if(data.isLeechGekocht()){
                        leechAan.setPosition(-1000,-1000);
                        leechUit.setPosition(350,600);
                        data.setLeech(false);
                    }
                }
            });

            // leech kopen en bij behorende knoppen

            leechButton.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    if (Data.getScore() > 9) {
                        Data.setLeech(true);
                        Data.addScore(-10);
                        leechButton.setPosition(-1000, -1000);
                        data.setLeechGekocht(true);
                        leechAan.setPosition(350, 600);
                        if (data.isDualshotGekocht()){
                            dualshotAan.setPosition(-1000,-1000);
                            dualshotUit.setPosition(350,750);
                            data.setDualshot_1(false);
                        }
                        if (data.isPiercingGekocht()){
                            piercingAan.setPosition(-1000,-1000);
                            piercingUit.setPosition(350,450);
                            data.setPiercing(false);
                        }
                    }
                }
            });

            leechAan.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    Data.setLeech(false);
                    leechAan.setPosition(-1000,-1000);
                    leechUit.setPosition(350, 600);
                }
            });

            leechUit.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    leechAan.setPosition(350, 600);
                    leechUit.setPosition(-1000,-1000);
                    data.setLeech(true);
                    if (data.isDualshotGekocht()){
                        dualshotAan.setPosition(-1000,-1000);
                        dualshotUit.setPosition(350,750);
                        data.setDualshot_1(false);
                    }
                    if (data.isPiercingGekocht()){
                        piercingAan.setPosition(-1000,-1000);
                        piercingUit.setPosition(350,450);
                        data.setPiercing(false);
                    }
                }
            });

            // dualshot kopen en bijbehorende knoppen

            buttonDualshot.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    if (Data.getScore() > 0) {
                        Data.setDualshot_1(true);
                        Data.addScore(-10);
                        buttonDualshot.setPosition(-1000, -1000);
                        data.setDualshotGekocht(true);
                        dualshotAan.setPosition(350,750);
                        if (data.isPiercingGekocht()){
                            piercingAan.setPosition(-1000,-1000);
                            piercingUit.setPosition(350,450);
                            data.setPiercing(false);
                        }
                        if(data.isLeechGekocht()){
                            leechAan.setPosition(-1000,-1000);
                            leechUit.setPosition(350,600);
                            data.setLeech(false);
                        }
                    }
                }
            });

            dualshotAan.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    Data.setDualshot_1(false);
                    dualshotAan.setPosition(-1000,-1000);
                    dualshotUit.setPosition(350, 750);
                }
            });

            dualshotUit.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    dualshotAan.setPosition(350, 750);
                    dualshotUit.setPosition(-1000,-1000);
                    data.setDualshot_1(true);
                    if (data.isPiercingGekocht()){
                        piercingAan.setPosition(-1000,-1000);
                        piercingUit.setPosition(350,450);
                        data.setPiercing(false);
                    }
                    if(data.isLeechGekocht()){
                        leechAan.setPosition(-1000,-1000);
                        leechUit.setPosition(350,600);
                        data.setLeech(false);
                    }
                }
            });

            // alle knoppen neer zetten op het scherm

            stage.addActor(buttonDualshot);
            stage.addActor(buttonPiercing);
            stage.addActor(leechButton);
            stage.addActor(backbutton);
            stage.addActor(leechAan);
            stage.addActor(leechUit);
            stage.addActor(piercingAan);
            stage.addActor(piercingUit);
            stage.addActor(dualshotAan);
            stage.addActor(dualshotUit);
            Gdx.input.setInputProcessor(stage);
            achtergrond = new Texture(Gdx.files.internal("ratAchtergrond.png"));

        }

        public void render(float delta){
            batch.begin();
            batch.draw(achtergrond,0,0);
            font.getData().setScale(2,2);
            font.draw(batch, "credits " + String.valueOf(Data.getScore()),50 , 850);
            font.draw(batch,"squeeek!, what can i get for you?", 100, 100);
            batch.end();
            sprite.begin();
            sprite.end();
            stage.draw();

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

        @Override
        public void dispose(){
            sprite.dispose();
            font.dispose();
        }



    }


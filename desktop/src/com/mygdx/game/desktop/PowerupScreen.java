package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
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
        private Table tabel;
        private Game game;
        private TextButton piercechoice;
        private TextButton dualshotchoice;
        private TextButton leechButton;

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

            tabel = new Table();
            tabel.setWidth(stage.getWidth());
            tabel.align(Align.center| Align.top);
            tabel.setPosition(0, Gdx.graphics.getHeight());

            skin = new Skin(Gdx.files.internal("flat-earth-ui.json"));

            buttonDualshot = new TextButton("dualshot, 10 credits", skin);
            buttonDualshot.setHeight(100);
            buttonDualshot.setWidth(500);

            piercechoice = new TextButton("pierce, on", skin);
            piercechoice.setHeight(100);
            piercechoice.setWidth(500);

            dualshotchoice = new TextButton("dualshot, on", skin);
            dualshotchoice.setHeight(100);
            dualshotchoice.setWidth(500);

            leechButton = new TextButton("leech, 10", skin);
            leechButton.setHeight(100);
            leechButton.setWidth(500);

            buttonPiercing = new TextButton("piercing, 10 credits", skin);
            buttonPiercing.setWidth(500);
            buttonPiercing.setHeight(100);
            backbutton = new TextButton("back", skin);
            backbutton.setWidth(500);
            backbutton.setHeight(100);


            backbutton.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(new Menuscherm(game, Data));

                }
            });

            buttonPiercing.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    if (Data.getScore() > 9) {
                        Data.setPiercing(true);
                        Data.addScore(-10);
                        buttonPiercing.setPosition(-1000, -1000);
                    }
                }
            });

            leechButton.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    if (Data.getScore() > 9) {
                        Data.setLeech(true);
                        Data.addScore(-10);
                        leechButton.setPosition(-1000, -1000);
                    }
                }
            });

            buttonDualshot.addListener(new ClickListener(){
                public void clicked(InputEvent event, float x, float y) {
                    if (Data.getScore() > 0) {
                        Data.setDualshot_1(true);
                        Data.addScore(-10);
                        buttonDualshot.setPosition(-1000, -1000);

                    }
                }
            });

            tabel.padTop(30);
            tabel.add(buttonDualshot).padBottom(30);
            tabel.row();
            tabel.add(buttonPiercing).padBottom(30);
            tabel.add(leechButton).padBottom(30);
            tabel.add(backbutton);
            stage.addActor(tabel);
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


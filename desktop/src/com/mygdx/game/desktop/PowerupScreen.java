package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
        private TextButton buttonSpelen;
        private TextButton backbutton;
        private TextButton buttonLevel2;
        private PlayerData Data;

        private Stage stage;
        private Table tabel;
        private Game game;

        public PowerupScreen(final Game game, final PlayerData data){
            this.game = game;
            this.Data = data;
            stage = new Stage(new ScreenViewport());

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

            buttonLevel2 = new TextButton("dualshot", skin);
            buttonLevel2.setHeight(100);
            buttonLevel2.setWidth(500);

            buttonSpelen = new TextButton("piercing", skin);
            buttonSpelen.setWidth(500);
            buttonSpelen.setHeight(100);
            backbutton = new TextButton("back", skin);
            backbutton.setWidth(500);
            backbutton.setHeight(100);

            backbutton.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(new Menuscherm(game, Data));

                }
            });


            buttonSpelen.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Data.setPiercing(true);

                }
            });
            buttonLevel2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Data.setDualshot_1(true);

                }
            });
            tabel.padTop(30);
            tabel.add(buttonSpelen).padBottom(30);
            tabel.row();
            tabel.add(buttonLevel2).padBottom(30);
            tabel.add(backbutton);

            stage.addActor(tabel);


            Gdx.input.setInputProcessor(stage);



        }

        public void render(float delta){
            Gdx.gl.glClearColor(0, 0, 255,0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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


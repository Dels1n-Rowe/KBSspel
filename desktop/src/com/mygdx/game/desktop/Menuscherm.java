package com.mygdx.game.desktop;

import com.badlogic.gdx.*;
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

public class Menuscherm implements Screen {
    private SpriteBatch sprite;
    private CharSequence ingameTitel = "KBS laser game";
    private OrthographicCamera cam;
    private BitmapFont font;
    private Skin skin;
    private TextButton buttonSpelen;
    private TextButton buttonInstellingen;
    private TextButton powerups;
    private Stage stage;
    private Table tabel;
    private Game game;
    private PlayerData data;


    public Menuscherm(final Game game, PlayerData Data){
        this.game = game;
        this.data = Data;
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

        buttonInstellingen = new TextButton("instellingen", skin);
        buttonInstellingen.setHeight(100);
        buttonInstellingen.setWidth(500);

        buttonSpelen = new TextButton("spelen", skin);
        buttonSpelen.setWidth(500);
        buttonSpelen.setHeight(100);
        buttonSpelen.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Gdx.app.log("Clicked", "spelen");
                game.setScreen(new levelchoicescreen(game, data));
            }
        });
        buttonInstellingen.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("Clicked", "instellingen");
            }
        });
        tabel.padTop(30);
        tabel.add(buttonSpelen).padBottom(30);
        tabel.row();
        tabel.add(buttonInstellingen).padBottom(30);
        tabel.row();
        powerups = new TextButton("powerups", skin);
        powerups.setHeight(100);
        powerups.setWidth(500);
        tabel.add(powerups);
        powerups.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PowerupScreen(game,data));
            }
        });


        stage.addActor(tabel);


        Gdx.input.setInputProcessor(stage);


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


    public void render( float delta){
        Gdx.gl.glClearColor(1,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sprite.begin();
        font.draw(sprite, ingameTitel, 450, 600);
        sprite.end();
        stage.draw();

    }




}

package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
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

public class levelchoicescreen extends ApplicationAdapter {
    private SpriteBatch sprite;
    private CharSequence ingameTitel = "KBS laser game";
    private OrthographicCamera cam;
    private BitmapFont font;
    private Skin skin;
    private TextButton buttonSpelen;
    private TextButton buttonInstellingen;
    private Stage stage;
    private Table tabel;

    public void create(){
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

        buttonSpelen = new TextButton("level 1", skin);
        buttonSpelen.setWidth(500);
        buttonSpelen.setHeight(100);
        buttonSpelen.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                LwjglApplicationConfiguration m = new LwjglApplicationConfiguration();
                m.title = "KBSgame";
                m.width = 1200;
                m.height = 900;
                new LwjglApplication(new Kbsgame(), m);

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
        tabel.add(buttonInstellingen);

        stage.addActor(tabel);


        Gdx.input.setInputProcessor(stage);



    }

    public void render(){
        Gdx.gl.glClearColor(0, 0, 255,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        sprite.begin();
        font.draw(sprite, ingameTitel, 450, 600);
        sprite.end();
        stage.draw();

    }

    @Override
    public void dispose(){
        sprite.dispose();
        font.dispose();
    }



}

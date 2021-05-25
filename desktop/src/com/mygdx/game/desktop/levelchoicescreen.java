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

public class levelchoicescreen implements Screen {
    private SpriteBatch sprite;
    private OrthographicCamera cam;
    private BitmapFont font;
    private Skin skin;
    private TextButton buttonSpelen;
    private TextButton buttonLevel2;
    private TextButton buttonLevel3;
    private SpriteBatch batch;

    private Stage stage;
    private Game game;
    private PlayerData data;
    private Texture achtergrond;
    private TextButton backbutton;

    public levelchoicescreen(final Game game, final PlayerData Data) {
        this.game = game;
        this.data = Data;
        stage = new Stage(new ScreenViewport());

        cam = new OrthographicCamera();
        cam.setToOrtho(false, 1200, 900);
        sprite = new SpriteBatch();

        font = new BitmapFont();
        font.setColor(Color.BLUE);

        batch = new SpriteBatch();
        achtergrond = new Texture(Gdx.files.internal("levelKeuzeAchtergrond.png"));

        skin = new Skin(Gdx.files.internal("flat-earth-ui.json"));

        //knop level 2

        buttonLevel2 = new TextButton("level 2", skin);
        buttonLevel2.setHeight(100);
        buttonLevel2.setWidth(500);

        // knop level 3

        buttonLevel3 = new TextButton("level 3", skin);
        buttonLevel3.setHeight(100);
        buttonLevel3.setWidth(500);

        // het unlocken van level 2

        if (data.isLevel2Unlocked()) {
            buttonLevel2.setPosition(350, 600);
        } else {
            buttonLevel2.setPosition(1000, 1000);
        }

        // het unlocken van level 3

        if (data.isLevel3Unlocked()) {
            buttonLevel3.setPosition(350, 450);
        }else{
            buttonLevel3.setPosition(100,1000);
        }


        // knop level1

        buttonSpelen = new TextButton("level 1", skin);
        buttonSpelen.setWidth(500);
        buttonSpelen.setHeight(100);
        buttonSpelen.setPosition(350,750);
        buttonSpelen.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Kbsgame(game, data));

            }
        });

        // klikken op knop twee(level3)

        buttonLevel2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new level_2(game, data));
            }
        });

        // klikken op knop drie(level3)
        buttonLevel3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new level_3(game, data));
            }
        });

        // knop om terug te gaan

        backbutton = new TextButton("back", skin);
        backbutton.setWidth(500);
        backbutton.setHeight(100);


        backbutton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Menuscherm(game, Data));

            }
        });
        backbutton.setPosition(350,250);

        // het teken van de knoppen op het scherm

        stage.addActor(buttonLevel2);
        stage.addActor(buttonLevel3);
        stage.addActor(buttonSpelen);
        stage.addActor(backbutton);

        Gdx.input.setInputProcessor(stage);

    }

    public void render(float delta){
        batch.begin();
        batch.draw(achtergrond, 0 ,0);
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

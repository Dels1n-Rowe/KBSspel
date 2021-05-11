package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class Gameoverscherm  implements Screen {

    private Game game;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private SpriteBatch sprite;
    private Stage stage;
    private Sprite gameover;
    private BitmapFont font;
    private int score;
    private TextButton opnieuw;
    private TextButton menu;
    private Skin skin;

    public Gameoverscherm(final Game game, int score){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 900);
        batch = new SpriteBatch();
        gameover = new Sprite(new Texture(Gdx.files.internal("GameOver.png")));
        stage = new Stage();
        font = new BitmapFont();
        this.score = score;
        skin = new Skin(Gdx.files.internal("flat-earth-ui.json"));

        opnieuw = new TextButton("opnieuw", skin);
        opnieuw.setHeight(100);
        opnieuw.setWidth(500);
        opnieuw.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Gdx.app.log("Clicked", "spelen");
                game.setScreen(new Kbsgame(game));
            }
        });

        menu = new TextButton("naar het menu", skin);
        menu.setHeight(100);
        menu.setWidth(500);
        menu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //Gdx.app.log("Clicked", "spelen");
                game.setScreen(new Menuscherm(game));
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        draw();
    }

    public void draw(){
        batch.begin();

        font.getData().setScale(2,2);
        font.draw(batch, "Behaalde score = " + String.valueOf(score), 475, 600);

        gameover.setPosition(350, 700);
        gameover.draw(batch);

        opnieuw.setPosition(350, 350);
        menu.setPosition(350, 200);
        stage.addActor(opnieuw);
        stage.addActor(menu);
        stage.draw();

        batch.end();
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
    public void dispose() {
        batch.dispose();
    }
}

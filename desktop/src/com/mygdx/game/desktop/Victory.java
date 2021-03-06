package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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

public class Victory  implements Screen {

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
    private TextButton volgende;
    private Skin skin;
    private PlayerData data;
    private int level;

    public Victory(final Game game, int score, PlayerData DAta, final int level){
        this.game = game;
        this.data = DAta;
        this.level = level;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 900);
        batch = new SpriteBatch();
        gameover = new Sprite(new Texture(Gdx.files.internal("Victory.png")));
        stage = new Stage();
        data.addScore(score);
        font = new BitmapFont();
        this.score = score;
        skin = new Skin(Gdx.files.internal("flat-earth-ui.json"));

        // knop om opnieuw te gaan

        opnieuw = new TextButton("opnieuw", skin);
        opnieuw.setHeight(100);
        opnieuw.setWidth(500);
        opnieuw.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (level == 1 ) {
                    game.setScreen(new Kbsgame(game, data));
                }
                if (level == 2){
                    game.setScreen(new level_2(game, data));
                }
            }
        });


        // knop om eht volgende level te spelen

        volgende = new TextButton("volgende", skin);
        if (level == 3){
            volgende.setPosition(-1000,-1000);
        } else {
            volgende.setPosition(350,350);
        }
        volgende.setHeight(100);
        volgende.setWidth(500);
        volgende.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (level == 1) {
                    game.setScreen(new level_2(game, data));
                }
                if (level == 2){
                    game.setScreen(new level_3(game, data));
                }
            }
        });

        // menu knop

        menu = new TextButton("naar het menu", skin);
        menu.setHeight(100);
        menu.setWidth(500);
        menu.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Menuscherm(game, data));
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GREEN);
        draw();
    }

    public void draw(){
        batch.begin();

        font.getData().setScale(2,2);
        font.draw(batch, "Behaalde score = " + String.valueOf(score), 475, 600);

        gameover.setPosition(350, 700);
        gameover.draw(batch);

        opnieuw.setPosition(350, 200);
        menu.setPosition(350, 50);
        stage.addActor(volgende);
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

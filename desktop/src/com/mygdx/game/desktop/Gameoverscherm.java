package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;


public class Gameoverscherm  implements Screen {

    private Game game;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private SpriteBatch sprite;
    private Stage stage;
    private Sprite gameover;

    public Gameoverscherm(Game game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 900);
        batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
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

    }
}

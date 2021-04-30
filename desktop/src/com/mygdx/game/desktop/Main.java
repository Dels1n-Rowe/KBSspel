package com.mygdx.game.desktop;

import com.badlogic.gdx.Game;

public class Main extends Game {


    @Override
    public void create() {
        this.setScreen(new Menuscherm(this));

    }


    public void render () {
        super.render();
    }

    public void dispose () {
    }
}




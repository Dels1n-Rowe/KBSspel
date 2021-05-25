package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class PlayerData {

    private boolean piercing;
    private boolean dualshot_1;
    private boolean leech;
    private int score;
    private boolean leechGekocht = false;
    private boolean dualshotGekocht = false;
    private boolean piercingGekocht = false;
    private boolean level2Unlocked = false;
    private boolean level3Unlocked = false;

    private Music soundtrack;

    private boolean muziek = true;

//
    public PlayerData() {
        soundtrack = Gdx.audio.newMusic(Gdx.files.internal("Among Us Drip Theme Song Original (Among Us Trap RemixAmogus Meme Music).mp3"));
        soundtrack.setLooping(true);
       soundtrack.play();
    }

    public boolean isLevel3Unlocked() {
        return level3Unlocked;
    }

    public void setLevel3Unlocked(boolean level3Unlocked) {
        this.level3Unlocked = level3Unlocked;
    }

    public boolean isLevel2Unlocked() {
        return level2Unlocked;
    }

    public void setLevel2Unlocked(boolean level2Unlocked) {
        this.level2Unlocked = level2Unlocked;
    }

    public boolean isPiercing() {
        return piercing;
    }

    public boolean isDualshot_1() {
        return dualshot_1;
    }

    public void setPiercing(boolean piercing) {
        this.piercing = piercing;
    }

    public void setDualshot_1(boolean dualshot_1) {
        this.dualshot_1 = dualshot_1;
    }

    public boolean getLeech() {
        return leech;
    }

    public void setLeech(boolean leech) {
        this.leech = leech;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int amount) {
        this.score = amount + score;
    }

    public boolean isLeech() {
        return leech;
    }

    public boolean isLeechGekocht() {
        return leechGekocht;
    }

    public void setLeechGekocht(boolean leechGekocht) {
        this.leechGekocht = leechGekocht;
    }

    public boolean isDualshotGekocht() {
        return dualshotGekocht;
    }

    public void setDualshotGekocht(boolean dualshotGekocht) {
        this.dualshotGekocht = dualshotGekocht;
    }

    public boolean isPiercingGekocht() {
        return piercingGekocht;
    }

    public void setPiercingGekocht(boolean piercingGekocht) {
        this.piercingGekocht = piercingGekocht;
    }

    public boolean getMuziek() {
        return muziek;
    }

    public void muziekAan(){
        muziek = true;
        soundtrack.setLooping(true);
        soundtrack.play();
    }

    public void MuziekUit(){
        muziek = false;
        soundtrack.stop();
    }
}

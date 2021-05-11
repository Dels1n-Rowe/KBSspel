package com.mygdx.game.desktop;

public class PlayerData {

    private boolean piercing;
    private boolean unlimited_ammo;
    private boolean dualshot_1;
    private boolean leech;
    private boolean warping;
    private int score;


    public PlayerData() {
        //dualshot_1 = true;
        //leech = true;
       //piercing = true;

    }

    public boolean isPiercing() {
        return piercing;
    }

    public boolean isUnlimited_ammo() {
        return unlimited_ammo;
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

    public void setUnlimited_ammo(boolean unlimited_ammo) {
        this.unlimited_ammo = unlimited_ammo;
    }
    //UwU this is a comment


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

    public boolean isWarping() {
        return warping;
    }

    public void setWarping(boolean warping) {
        this.warping = warping;
    }



}

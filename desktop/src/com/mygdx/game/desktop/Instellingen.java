package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Instellingen {
    private static final String PREF_MUZIEK_VOLUME = "volume";
    private static final String PREF_MUZIEK_ENABLED = "Muziek.aan";
    private static final String PREF_GELUID_ENABLED = "Geluid.aan";
    private static final String PREF_GELUID_VOLUME = "Geluid";
    private static final String PREF_NAAM = "naam";

    protected Preferences getPrefs() {
        return Gdx.app.getPreferences(PREF_NAAM);
    }

    public boolean isSoundEffectsEnabled() {
        return getPrefs().getBoolean(PREF_GELUID_ENABLED, true);
    }

    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        getPrefs().putBoolean(PREF_GELUID_ENABLED, soundEffectsEnabled);
        getPrefs().flush();
    }
    public boolean isMusicEnabled() {
        return getPrefs().getBoolean(PREF_MUZIEK_ENABLED, true);
    }

    public void setMusicEnabled(boolean musicEnabled) {
        getPrefs().putBoolean(PREF_MUZIEK_ENABLED, musicEnabled);
        getPrefs().flush();
    }

    public float getMusicVolume() {
        return getPrefs().getFloat(PREF_MUZIEK_VOLUME, 0.5F);
    }

    public void setMusicVolume(float volume) {
        getPrefs().putFloat(PREF_MUZIEK_VOLUME, volume);
        getPrefs().flush();
    }

    public float getSoundVolune() {
        return getPrefs().getFloat(PREF_GELUID_VOLUME, 0.5F);
    }

    public void setSoundVolume(float volume) {
        getPrefs().putFloat(PREF_GELUID_VOLUME, volume);
        getPrefs().flush();
    }

}
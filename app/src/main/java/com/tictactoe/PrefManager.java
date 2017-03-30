package com.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tictactoe.model.CellItem;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divya on 3/30/2017.
 */

public class PrefManager {

    static SharedPreferences pref;
    static SharedPreferences.Editor editor;
    static Context _context;

    static int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "TicTacPref";

    private static final String KEY_PLAYER_X = "playerX";
    private static final String KEY_PLAYER_Y = "playerY";
    private static final String KEY_GAME_STATE = "gameState";


    public static void create(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static void setXWins(Integer wins) {
        editor.putInt(KEY_PLAYER_X, wins);
        editor.commit();
    }

    public static Integer getXWins() {
        return pref.getInt(KEY_PLAYER_X, 0);
    }

    public static void setYWins(Integer wins) {
        editor.putInt(KEY_PLAYER_Y, wins);
        editor.commit();
    }

    public static Integer getYWins() {
        return pref.getInt(KEY_PLAYER_Y, 0);
    }

    public static void saveGameState(ArrayList<CellItem> cellItems) {
        Gson gson = new Gson();
        String json = gson.toJson(cellItems);
        editor.putString(KEY_GAME_STATE, json);
        editor.commit();
    }

    public static ArrayList<CellItem> getGameState() {
        Gson gson = new Gson();
        String json = pref.getString(KEY_GAME_STATE, "");
        Type type = new TypeToken<List<CellItem>>() {
        }.getType();
        ArrayList<CellItem> cellItems = gson.fromJson(json, type);
        return cellItems;
    }

}


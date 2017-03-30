package com.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;

import com.tictactoe.model.CellItem;

import java.util.ArrayList;

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

    public void setGameState(ArrayList<CellItem> cellItems) {
        editor.putInt("cellItem" +"_size", cellItems.size());
        for(int i=0;i<cellItems.size();i++)
            editor.putString("cellItem" + "_" + i, cellItems.get(i).getValue());
        editor.commit();
    }

  /*  public ArrayList<CellItem> getGameState() {
        int size = pref.getInt("cellItem" + "_size", 0);
        ArrayList<CellItem> cellItems = new ArrayList<>()
        for(int i=0;i<size;i++)
            array[i] = prefs.getString(arrayName + "_" + i, null);
        return array;
    }*/



    public static Integer getGameState(ArrayList<CellItem> cellItems) {
        return pref.getInt(KEY_PLAYER_Y, 0);
    }

}


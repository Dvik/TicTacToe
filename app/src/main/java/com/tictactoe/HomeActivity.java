package com.tictactoe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.tictactoe.adapter.TicTacAdapter;
import com.tictactoe.model.CellItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements ClickOnCellListener {

    @BindView(R.id.recycler_game)
    RecyclerView recyclerGame;
    @BindView(R.id.player1)
    TextView player1Text;
    @BindView(R.id.player2)
    TextView player2Text;


    private ArrayList<CellItem> cellItems;
    private TicTacAdapter tictacAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        PrefManager.create(this);
        PrefManager.setXWins(PrefManager.getXWins());
        PrefManager.setYWins(PrefManager.getYWins());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setWinnerTexts();

        cellItems = new ArrayList<>();

        initializeCells();

        recyclerGame.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        tictacAdapter = new TicTacAdapter(cellItems, this, this);
        recyclerGame.setAdapter(new TicTacAdapter(cellItems, this, this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellItems.add(new CellItem(i + 1, j + 1, "P"));
            }
        }
    }

    @Override
    public void onCellClicked(String winner) {
        Toast.makeText(this, "Winner is " + winner, Toast.LENGTH_SHORT).show();

        if (winner.equals("X")) {
            PrefManager.setXWins(PrefManager.getXWins() + 1);
        } else {
            PrefManager.setYWins(PrefManager.getYWins() + 1);
        }

        setWinnerTexts();

        cellItems.clear();
        initializeCells();
        tictacAdapter.notifyDataSetChanged();
        Utils.winner = null;

    }

    private void setWinnerTexts() {
        player1Text.setText("Player X  " + String.valueOf(PrefManager.getXWins()));
        player2Text.setText("Player Y  " + String.valueOf(PrefManager.getYWins()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        new AlertDialog.Builder(this)
                .setTitle("Save Game")
                .setMessage("Do you want to save the game??")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }
}
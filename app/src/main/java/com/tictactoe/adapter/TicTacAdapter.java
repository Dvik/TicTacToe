package com.tictactoe.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tictactoe.ClickOnCellListener;
import com.tictactoe.PrefManager;
import com.tictactoe.R;
import com.tictactoe.Utils;
import com.tictactoe.model.CellItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Divya on 3/30/2017.
 */

public class TicTacAdapter extends RecyclerView.Adapter<TicTacAdapter.TicTacViewHolder> {

    private ArrayList<CellItem> cellItems;
    private ClickOnCellListener listener;
    private PrefManager prefManager;
    private Context context;

    public class TicTacViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cell_container)
        CardView cellContainer;

        @BindView(R.id.item_text)
        TextView itemText;

        public TicTacViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cell_container)
        void itemClicked() {
            if (cellItems.get(getAdapterPosition()).getValue().equals("P")) {

                if (Utils.getShouldShowX()) {
                    Utils.setShouldShowX(false);
                    cellItems.get(getAdapterPosition()).setValue("X");
                } else {
                    Utils.setShouldShowX(true);
                    cellItems.get(getAdapterPosition()).setValue("O");
                }

                if (Utils.checkWinner(cellItems)) {
                    cellItems.clear();
                    listener.onCellClicked(Utils.winner);
                }

                if (Utils.checkIfGameOver(cellItems)) {
                    listener.gameOver();
                }

                notifyDataSetChanged();
            }
        }

    }

    public TicTacAdapter(ArrayList<CellItem> cellItems, ClickOnCellListener listener, Context context) {
        this.cellItems = cellItems;
        this.listener = listener;
        PrefManager.create(context);
    }

    @Override
    public TicTacViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_game, parent, false);
        return new TicTacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TicTacViewHolder holder, int position) {
            holder.itemText.setText(cellItems.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return cellItems.size();
    }


}

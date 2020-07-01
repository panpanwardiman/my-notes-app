package com.example.myapplication.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Note;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<Note> notes;
    private ItemClicklistener itemClicklistener;

    public MainAdapter(Context context, List<Note> notes, ItemClicklistener itemClicklistener) {
        this.context = context;
        this.notes = notes;
        this.itemClicklistener = itemClicklistener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false);
        return new RecyclerViewAdapter(view, itemClicklistener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
        Note note = notes.get(position);
        holder.tv_title.setText(note.getTitle());
        holder.tv_note.setText(note.getNote());
        holder.tv_date.setText(note.getDate());
        holder.cardView.setCardBackgroundColor(note.getColor());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_title, tv_note, tv_date;
        CardView cardView;
        ItemClicklistener itemClicklistener;

        RecyclerViewAdapter(@NonNull View itemView, ItemClicklistener itemClicklistener) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.title);
            tv_note = itemView.findViewById(R.id.note);
            tv_date = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.card_item);

            this.itemClicklistener = itemClicklistener;
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClicklistener.onItemClick(view, getAdapterPosition());
        }
    }

    public interface ItemClicklistener {
        void onItemClick(View view, int position);
    }
}

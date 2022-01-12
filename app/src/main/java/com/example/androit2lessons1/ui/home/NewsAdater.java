package com.example.androit2lessons1.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androit2lessons1.databinding.ItemNewsListBinding;
import com.example.androit2lessons1.ui.models.News;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NewsAdater extends RecyclerView.Adapter<NewsAdater.ViewHolder> {
    private ArrayList<News>list;
    private OnClick onClick;

    public NewsAdater() {
        list = new ArrayList<>();
//        list.add(new News("akjol",System.currentTimeMillis()));
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public NewsAdater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemNewsListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void aadItem(News news) {
        list.add(0,news);
        notifyItemInserted(0);
    }
    public void removeItem(News news,int pos){
        list.remove(news);
        notifyItemRemoved(pos);
    }
    public News getItem(int news){
        return list.get(news);
    }

    public void aadItems(List<News> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNewsListBinding binding;
        public ViewHolder(ItemNewsListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        public void bind(News news) {
            SimpleDateFormat timeList = new SimpleDateFormat("HH:mm");
            String infotime = timeList.format(news.getCreatedata());
            binding.datatitle.setText(infotime);
            binding.textTitle.setText(news.getTitle());
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onClick.onClick(getAdapterPosition());
                    return true;
                }
            });
        }
    }
    interface OnClick{
        void onClick(int position);
    }
}

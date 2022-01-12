package com.example.androit2lessons1.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androit2lessons1.R;
import com.example.androit2lessons1.databinding.ItemListBoartBinding;
import com.example.androit2lessons1.ui.OnStartClickListener;

public class AdabterBoard extends RecyclerView.Adapter<AdabterBoard.ViewHolder> {
    private String[] titles = new String[]{"тестовый програма студента гиктек ", "в исползвание программы все данныйы будет зашишаны", "если согдасны условя исползование тогда нажимите кнопку start"};
    private String testprogram = "1";
    private String secyrity = "2";
    private String agreente = "3";
    private String[] info = new String[]{testprogram, secyrity,agreente};
    private int[] image = new int[]{
            R.raw.test,
            R.raw.security,
            R.raw.agreement};
    private OnStartClickListener clikListener;

    @NonNull
    @Override
    public AdabterBoard.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemListBoartBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdabterBoard.ViewHolder holder, int position) {
        holder.bind(position);

    }


    @Override
    public int getItemCount() {
        return titles.length;
    }

    public void setClikListener(OnStartClickListener clikListener) {
        this.clikListener = clikListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemListBoartBinding binding;

        public ViewHolder(ItemListBoartBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
            binding.btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clikListener.onClick();
                }
            });
        }

        public void bind(int position) {
            binding.helperText.setText(titles[position]);
            binding.animationView.setAnimation(image[position]);
            binding.textTitle.setText(info[position]);
            if (position == titles.length - 1 && position == image.length - 1) {
                binding.btnStart.setVisibility(View.VISIBLE);
            } else {
                binding.btnStart.setVisibility(View.INVISIBLE);
            }
        }
    }
}

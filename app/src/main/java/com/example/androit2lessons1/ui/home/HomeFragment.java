package com.example.androit2lessons1.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.androit2lessons1.R;
import com.example.androit2lessons1.databinding.FragmentHomeBinding;
import com.example.androit2lessons1.ui.App;
import com.example.androit2lessons1.ui.models.News;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private NewsAdater newsAdater;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsAdater = new NewsAdater();
        newsAdater.aadItems(App.getInstance().getAppDataBase().newsdawn().getAll());
        setHasOptionsMenu(true);
        newsAdater.setOnClick(position -> {
            News news = newsAdater.getItem(position);
            newsAdater.removeItem(news,position);
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.add.setOnClickListener(view -> {
            openFragment();
        });
        getParentFragmentManager().setFragmentResultListener("rk_news", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                News news = (News) result.getSerializable("news");
                {
                    Log.e("Home", "text=" + news.getTitle());
                    newsAdater.aadItem(news);
                }
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initlisener();
    }

    private void initlisener() {
        binding.reysiklerView.setAdapter(newsAdater);
    }

    private void openFragment() {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.newsFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.btn_sort, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btn_sort) {
            getSortedList();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getSortedList() {
        List<News> list = App.getInstance().getAppDataBase().newsdawn().getAllSortedtitle();
        newsAdater.aadItems(list);
    }
}
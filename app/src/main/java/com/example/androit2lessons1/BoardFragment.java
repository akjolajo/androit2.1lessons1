package com.example.androit2lessons1;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.androit2lessons1.databinding.FragmentBoardBinding;
import com.example.androit2lessons1.ui.OnStartClickListener;
import com.example.androit2lessons1.ui.Prefs;
import com.example.androit2lessons1.ui.board.AdabterBoard;

public class BoardFragment extends Fragment {
    private FragmentBoardBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AdabterBoard adabterBoard = new AdabterBoard();
        binding.viewpager.setAdapter(adabterBoard);
        binding.viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 2)
                    binding.skip.setVisibility(View.GONE);
                else
                    binding.skip.setVisibility(View.VISIBLE);
            }
        });
        adabterBoard.setClikListener(new OnStartClickListener() {
            @Override
            public void onClick() {
                close();
            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                requireActivity().finish();
            }
        });
        binding.dotsid.setViewPager2(binding.viewpager);
        skiplistener(view);

    }

    private void skiplistener(View view) {
        binding.skip.setOnClickListener(view1 -> {
            close();
        });
    }

    private void close() {
        Prefs prefs = new Prefs(requireContext());
        prefs.saveBoardState();
        NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_activity_main);
        navController.navigateUp();
    }
}
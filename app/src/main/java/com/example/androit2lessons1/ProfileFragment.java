package com.example.androit2lessons1;

import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.androit2lessons1.databinding.FragmentProfileBinding;
import com.example.androit2lessons1.ui.Prefs;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private Prefs prefs;
    private ActivityResultLauncher<String> mGetContent = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    if (result != null) {
                        prefs = new Prefs(requireContext());
                        Glide
                                .with(requireActivity())
                                .load(result)
                                .circleCrop()
                                .into(binding.imageprofil);
                        prefs.sevaImageState(result);
                    }
                }
            });

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saver();
        binding.nameofContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                prefs = new Prefs(requireContext());
                prefs.sevaTextState(editable.toString());
            }
        });

        binding.editingimage.setOnClickListener(view1 -> {
            selectionImageprofil();
        });
        binding.imageprofil.setOnClickListener(view1 -> {
          openImage();
        });
    }

    private void openImage() {
        prefs = new Prefs(requireContext());
        Bundle bundle = new Bundle();
        bundle.putString("image",prefs.isImageSown());
        NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_activity_main);
        navController.navigate(R.id.avatarFragment,bundle);
    }

    private void saver() {
        prefs = new Prefs(requireContext());
        String image = prefs.isImageSown();
        Glide.with(requireContext()).load(image).circleCrop().into(binding.imageprofil);
        String text = prefs.isTextSown();
        binding.nameofContact.setText(text);
    }

    private void selectionImageprofil() {
        mGetContent.launch("image/*");
    }
}

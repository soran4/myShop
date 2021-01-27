package com.soran.nutshop.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.soran.nutshop.fragments.BasketFragment;
import com.soran.nutshop.fragments.CategoryFragment;
import com.soran.nutshop.fragments.HomeFragment;
import com.soran.nutshop.fragments.ProfileFragment;

public class FragmentsAdapter extends FragmentStateAdapter {
    public FragmentsAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new CategoryFragment();
            case 2:
                return new BasketFragment();
            case 3:
                return new ProfileFragment();
        }



        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}

package com.food.delivery.eleven_am.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.food.delivery.eleven_am.R;


public class HomeFragment extends Fragment {

    RecyclerView restaurantList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        restaurantList = view.findViewById(R.id.restaurant_list);
//        restaurantList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
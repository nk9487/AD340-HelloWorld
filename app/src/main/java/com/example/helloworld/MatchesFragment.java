package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        List<Matches> matchesList = new ArrayList<>();
        matchesList.add(new Matches("Alex1", "Funny", false,"https://i.imgur.com/GuAB8OE.jpeg"));
        matchesList.add(new Matches("Alex2", "Funny", false,"https://i.imgur.com/GuAB8OE.jpeg"));
        matchesList.add(new Matches("Alex3", "Funny", false,"https://i.imgur.com/GuAB8OE.jpeg"));
        matchesList.add(new Matches("Alex4", "Funny", false,"https://i.imgur.com/GuAB8OE.jpeg"));
            // Set up the RecyclerView
        View view =inflater.inflate(R.layout.fragment_matches, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
            MatchesRecyclerViewAdapter adapter = new MatchesRecyclerViewAdapter(matchesList);

            int largePadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
            int smallPadding = getResources().getDimensionPixelSize(R.dimen.small_grid_spacing);
            recyclerView.addItemDecoration(new MatchesItemDecoration(largePadding, smallPadding));
            recyclerView.setAdapter(adapter);


            return view;
        }
}
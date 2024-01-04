package com.example.news2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private GetDataHelper service;
    private Call<NewsResponse> call_news;
    private RecyclerView rvNews;
    private NewsRecyclerAdapter rvNewsAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);

        rvNews = view.findViewById(R.id.rec_news);
        service = RetrofitHelper.getRetrofitInstance().create(GetDataHelper.class);
        call_news = service.getdatalist();
        call_news.enqueue(new Callback<NewsResponse>() {

            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.body().getNews()!= null)
                generate_news_data(response.body().getNews());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("API Error", "Error Body: " + t.getMessage());
                Toast.makeText(getActivity(), "API Call error", Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }

    private void generate_news_data(ArrayList<NewsModel> body) {
        for (NewsModel news : body){
            Log.d("News", "News "+news.getTitle());
        }


        rvNewsAdapter = new NewsRecyclerAdapter(body, getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvNews.setLayoutManager(layoutManager);
        rvNews.setAdapter(rvNewsAdapter);
    }

}

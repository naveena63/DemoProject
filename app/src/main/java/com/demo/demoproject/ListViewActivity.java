package com.demo.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.demo.demoproject.Adapter.ListItemadapter;
import com.demo.demoproject.ApiCalls.DemoServicesInterface;
import com.demo.demoproject.ApiCalls.MyRetrofitInstance;
import com.demo.demoproject.model.ListItemsResponseDataItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewActivity extends AppCompatActivity {
    RecyclerView cardRecyclerview;
    List<ListItemsResponseDataItem> listItemsResponseDataItems;
ImageView refreshIV;
    ListItemadapter listItemadapter;
    ContentLoadingProgressBar loading_bar;
    public static final String LIMIT = "20";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        cardRecyclerview = findViewById(R.id.card_recyclerview);
        refreshIV=findViewById(R.id.refresh_button);
        loading_bar=findViewById(R.id.loading_bar);
        listItemsResponseDataItems = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        cardRecyclerview.setLayoutManager(layoutManager);
        listItemadapter = new ListItemadapter(getApplicationContext(), listItemsResponseDataItems);
        cardRecyclerview.setAdapter(listItemadapter);
        loadData(2);
refreshIV.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        listItemadapter.notifyDataSetChanged();
        loadData(2);
        loading_bar.setVisibility(View.VISIBLE);
    }
});
    }

    private void loadData(int page)
    {

        DemoServicesInterface apiService = MyRetrofitInstance.getRetrofitInstance().create(DemoServicesInterface.class);
        Call<List<ListItemsResponseDataItem>> call = apiService.getListItems(String.valueOf(page),LIMIT);
        call.enqueue(new Callback<List<ListItemsResponseDataItem>>() {
            @Override
            public void onResponse(Call<List<ListItemsResponseDataItem>> call, Response<List<ListItemsResponseDataItem>> response) {
                listItemsResponseDataItems = response.body();
                Log.d("TAG", "Response = " + response);
                listItemadapter.setMovieList(listItemsResponseDataItems);
            }

            @Override
            public void onFailure(Call<List<ListItemsResponseDataItem>> call, Throwable t) {
                // Log.d("TAG", "Response = " + t.toString());
            }
        });
    }

}
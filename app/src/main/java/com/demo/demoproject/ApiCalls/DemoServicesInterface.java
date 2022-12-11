package com.demo.demoproject.ApiCalls;

import com.demo.demoproject.model.ListItemsResponseDataItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface DemoServicesInterface {



    @GET("/v2/list?")
     Call<List<ListItemsResponseDataItem>> getListItems(@Query("page") String page,
                                                        @Query("limit") String limit);

    // ToDo Change ResponseBody
}

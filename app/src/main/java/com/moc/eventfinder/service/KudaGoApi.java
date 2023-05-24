package com.moc.eventfinder.service;

import com.moc.eventfinder.model.DTO.City;
import com.moc.eventfinder.model.DTO.event.EventResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KudaGoApi {
    @GET("locations/")
    Call<List<City>> getCities();


    @GET("events/")
    Call<EventResponse> getEvents(@Query("location") String location,
                                  @Query("actual_since") String actual_since,
                                  @Query("fields") String fields,
                                  @Query("page") int page);
}

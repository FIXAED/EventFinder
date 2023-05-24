package com.moc.eventfinder.controller.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.moc.eventfinder.R;
import com.moc.eventfinder.controller.adapter.EventAdapter;
import com.moc.eventfinder.model.DTO.event.Event;
import com.moc.eventfinder.model.DTO.event.EventResponse;
import com.moc.eventfinder.service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment1 extends Fragment {

    private ListView eventList;
    private List<Event> events;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main1, container, false);
        eventList = (ListView) view.findViewById(R.id.eventList);


        NetworkService.getInstance()
                .getJSONApi()
                .getEvents("spb", "2023-05-10",
                        "id,title,place,images,categories,price", 1)
                .enqueue(new Callback<EventResponse>() {
                    @Override
                    public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                        if (response.isSuccessful()) {
                            EventResponse eventsResponse = response.body();
                            events = eventsResponse.getResults();
                            EventAdapter adapter = new EventAdapter(getContext(), R.layout.event_item, events);
                            eventList.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<EventResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        return view;
    }
}
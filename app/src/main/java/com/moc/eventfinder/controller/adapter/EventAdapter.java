package com.moc.eventfinder.controller.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.moc.eventfinder.R;
import com.moc.eventfinder.model.DTO.event.Event;
import com.moc.eventfinder.model.DTO.image.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventAdapter extends ArrayAdapter<Event> {
    private final LayoutInflater inflater;
    private List<Event> events;

    public EventAdapter(Context context, int resource, List<Event> events) {
        super(context, resource, events);
        this.events = events;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.event_item, parent, false);
        Event event = events.get(position);

        TextView titleTextView = convertView.findViewById(R.id.title);
        TextView category = convertView.findViewById(R.id.category);
        String listString = TextUtils.join(", ", event.getCategories());
        TextView date = convertView.findViewById(R.id.date);
        TextView price = convertView.findViewById(R.id.price);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        titleTextView.setText(event.getTitle());
        titleTextView.setText(listString);
        date.setText(event.getDates().get(0).toString());
        price.setText(event.getPrice());

        if (event.getImages() != null && !event.getImages().isEmpty()) {
            Image image = event.getImages().get(0);
            Picasso.get()
                    .load(image.getImage())
                    .into(imageView);
        } else {
            imageView.setImageResource(R.drawable.placeholder);
        }

        return view;
    }
}
package com.moc.eventfinder.model.DTO.event;

import com.moc.eventfinder.model.DTO.Date;
import com.moc.eventfinder.model.DTO.image.Image;

import java.util.List;

public class Event {

    private int id;
    private String title;
    private List<Date> dates;
    private String price;
    private Place place;
    private List<Image> images;
    private List<String> categories;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Place getPlace() {
        return place;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Date> getDates() {
        return dates;
    }

    public String getPrice() {
        return price;
    }

    public List<String> getCategories() {
        return categories;
    }

}

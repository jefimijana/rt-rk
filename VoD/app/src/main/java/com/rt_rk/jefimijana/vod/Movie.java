/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.rt_rk.jefimijana.vod;

import android.util.Log;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/*
 * Movie class represents video entity with title, description, image thumbs and video url.
 *
 */
public class Movie implements Serializable {
    static final long serialVersionUID = 727566175075960653L;
    private static long count = 0;
    private long id;
    private String title;
    private String description;
    private String movieBackgroundImgUrl;
    private String movieCardImgUrl;
    private String movieTrailerUrl;

    //Additional properites
    private String duration;
    private String genre;
    private String rating;
    private String price;
    private String director;
    private String stars; //TODO: Use lists

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public static long getCount() {
        return count;
    }

    public static void incCount() {
        count++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return movieTrailerUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.movieTrailerUrl = videoUrl;
    }

    public String getBackgroundImageUrl() {
        return movieBackgroundImgUrl;
    }

    public void setBackgroundImageUrl(String bgImageUrl) {
        this.movieBackgroundImgUrl = bgImageUrl;
    }

    public String getCardImageUrl() {
        return movieCardImgUrl;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.movieCardImgUrl = cardImageUrl;
    }


    public URI getBackgroundImageURI() {
        try {
            Log.d("BACK MOVIE: ", movieBackgroundImgUrl);
            return new URI(getBackgroundImageUrl());
        } catch (URISyntaxException e) {
            Log.d("URI exception: ", movieCardImgUrl);
            return null;
        }
    }

    public URI getCardImageURI() {
        try {
            return new URI(getCardImageUrl());
        } catch (URISyntaxException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", videoUrl='" + movieTrailerUrl + '\'' +
                ", backgroundImageUrl='" + movieBackgroundImgUrl + '\'' +
                ", backgroundImageURI='" + getBackgroundImageURI().toString() + '\'' +
                ", cardImageUrl='" + movieCardImgUrl + '\'' +
                '}';
    }
}

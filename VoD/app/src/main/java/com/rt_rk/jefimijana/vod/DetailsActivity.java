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

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DetailsActivity extends Activity {

    private Context context;
    public static final String MOVIE = "Movie";

    private Movie mSelectedMovie;
    private ImageView ivMainImage;
    private TextView mTvTitle, mTvGenre, mTvDirector, mTvStars, mTvRating, mTvDescription, mTvPrice;
    private Button mBtnImdb, mBtnPlay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_details);
        setContentView(R.layout.activity_details_custom);

        context = this;

        mSelectedMovie = (Movie) getIntent().getSerializableExtra(DetailsActivity.MOVIE);

        if (mSelectedMovie == null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        InitializeViews();

        FillMovieInfo();

        HandleEvents();
    }

    private void InitializeViews() {

        ivMainImage = (ImageView) findViewById(R.id.ivDetailsMainImage);

        mTvTitle = (TextView) findViewById(R.id.tvDetailsTitle);
        mTvGenre = (TextView) findViewById(R.id.tvDetailsGenre);
        mTvDirector = (TextView) findViewById(R.id.tvDetailsDirector);
        mTvStars = (TextView) findViewById(R.id.tvDetailsStars);
        mTvRating = (TextView) findViewById(R.id.tvDetailsRating);
        mTvDescription = (TextView) findViewById(R.id.tvDetailsDescription);
        mTvPrice = (TextView) findViewById(R.id.tvDetailsPrice);

        //Buttons
        //TODO: Previous, Next Buttons
        mBtnImdb = (Button) findViewById(R.id.btnDetailsImdb);
        mBtnPlay = (Button) findViewById(R.id.btnDetailsPlay);
    }

    private void FillMovieInfo() {
        //Set movie image
        new Thread() {
            public void run() {
                try {
                    //TODO: Consider saving image to local storage for efficiency, passing from main activity look like bad approach
                    //Convert url string to url
                    URL imageUrl = new URL(mSelectedMovie.getCardImageUrl());

                    //Get bitmap from the stream
                    Bitmap bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());

                    //Create ImageItem with downloaded image
                    ivMainImage.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        mTvTitle.setText(mSelectedMovie.getTitle());
        mTvGenre.setText(mSelectedMovie.getGenre());
        mTvDirector.setText(mSelectedMovie.getDirector());
        mTvStars.setText(mSelectedMovie.getStars());
        mTvRating.setText(mSelectedMovie.getRating());
        mTvDescription.setText(mSelectedMovie.getDescription());
        mTvPrice.setText(mSelectedMovie.getPrice());
    }

    private void HandleEvents() {

        //In case that user clicked on imdb, open browser
        mBtnImdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Open chooser if necessary
                //Intent chooserIntent;

                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                //chooserIntent = browserIntent.createChooser(browserIntent, getString(R.string.choose_browser));

                //Prepare url
                String strUrl = ("http://www.imdb.com/find?q=" + mSelectedMovie.getTitle()).toLowerCase();
                strUrl = strUrl.replaceAll("\\s", "");

                browserIntent.setData(Uri.parse(strUrl));

                PackageManager packageManager = context.getPackageManager();
                List activities = packageManager.queryIntentActivities(browserIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;

                //If browser is available
                if (isIntentSafe)
                    startActivity(browserIntent);
                else
                    Toast.makeText(context, "Please visit Google Play and install browser", Toast.LENGTH_LONG).show();

            }
        });

        //In case that user clicked on play, open playback activity
        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlaybackOverlayActivity.class);
                intent.putExtra(DetailsActivity.MOVIE, mSelectedMovie);
                startActivity(intent);
            }
        });

    }

}

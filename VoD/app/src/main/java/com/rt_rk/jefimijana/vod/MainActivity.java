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
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static Context context; //Keeps reference to current context
    private List<Movie> mMovies; //List of available movies
    //private NavigationView mNavigationView; //Side navigation view with categories
    private DrawerLayout mDrawer;
    private GridView mGridView;
    private TextView mTvTitle, mTvDuration, mTvGenre, mTvRating, mTvPrice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.menuToolbar);
        setSupportActionBar(toolbar);

        InitializeViews();

        LoadData();

        HandleEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //TODO: Clear panel info data, or keep reference to last selected item after returning to this activity
        PanelClearInfo();
    }

    /* Used for initialization of views references */
    private void InitializeViews() {
        //mNavigationView = (NavigationView) findViewById(R.id.menuDrawer);
        //mNavigationView.inflateMenu(R.menu.navigation_items);
        //mNavigationView.bringToFront();

        mDrawer = (DrawerLayout) findViewById(R.id.overviewLayout);
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN); //Always keep side navigation displayed
        mGridView = (GridView) findViewById(R.id.gridView);

        //Navigation panel views
        mTvTitle = (TextView) findViewById(R.id.navPanelTitle);
        mTvDuration = (TextView) findViewById(R.id.navPanelDuration);
        mTvGenre = (TextView) findViewById(R.id.navPanelGenre);
        mTvRating = (TextView) findViewById(R.id.navPanelRating);
        mTvPrice = (TextView) findViewById(R.id.navPanelPrice);
    }

    /* Used for handling listeners and actions of views */
    private void HandleEvents() {

        mGridView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                    PanelFillInfo(mMovies.get(0)); //TODO: Because side menu is not connected with rows from grid (easier with third party like leanback)
                else
                    PanelClearInfo();
            }
        });


        //GridItem selection
        mGridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Movie selectedMovie = mMovies.get(position);
                PanelFillInfo(selectedMovie);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //GridItem click
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie clickedMovie = mMovies.get(position);
                PanelFillInfo(clickedMovie);

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(DetailsActivity.MOVIE, clickedMovie);
                startActivity(intent);
            }

        });

    }

    private void PanelFillInfo(Movie movie) {
        //Fill side navigation panel with selected/clicked movie
        //TODO: Better approach - Fragment?
        mTvTitle.setText(movie.getTitle().toString());
        mTvDuration.setText(movie.getDuration());
        mTvGenre.setText(movie.getGenre());
        mTvRating.setText(movie.getRating());
        mTvPrice.setText(movie.getPrice());
    }

    private void PanelClearInfo() {
        mTvTitle.setText("");
        mTvDuration.setText("");
        mTvGenre.setText("");
        mTvRating.setText("");
        mTvPrice.setText("");
    }

    /* Used to load movies data */
    private void LoadData() {

        //Initialize currently static movies list
        mMovies = MovieList.setupMovies();

        //Load and display movies in a grid in background
        new LoadImagesAsync().execute(mMovies);
    }

    public class GridViewAdapter extends ArrayAdapter {
        private Context context;
        private int layoutResourceId;
        private ArrayList data = new ArrayList();

        public GridViewAdapter(Context context, int layoutResourceId, ArrayList data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder = null;

            if (row == null) {
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new ViewHolder();
                holder.image = (ImageView) row.findViewById(R.id.image);
                row.setTag(holder);
            } else {
                holder = (ViewHolder) row.getTag();
            }

            ImageItem item = (ImageItem) data.get(position);
            holder.image.setImageBitmap(item.getImage());

            return row;
        }


    }

    /* Classes used for customization of gridview items, currently: image view only */
    static class ViewHolder {
        ImageView image;
    }

    public class ImageItem {
        private Bitmap image;

        public ImageItem(Bitmap image) {
            super();
            this.image = image;
        }

        public Bitmap getImage() {
            return image;
        }

        public void setImage(Bitmap image) {
            this.image = image;
        }
    }

    /* Used for loading images from the web withoud blocking the main thread */
    public class LoadImagesAsync extends AsyncTask<Object, Object, ArrayList<ImageItem>> {

        private ArrayList<ImageItem> imageItems;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Clean
            imageItems = new ArrayList<ImageItem>();
        }

        @Override
        protected ArrayList<ImageItem> doInBackground(Object... params) {
            List<Movie> movies = (List<Movie>) params[0];
            for (int i = 0; i < movies.size(); i++) {
                String stringUri = movies.get(i).getCardImageUrl();
                try {
                    //Convert url string to url
                    URL imageUrl = new URL(stringUri);

                    //Get bitmap from the stream
                    Bitmap bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());

                    //Create ImageItem with downloaded image
                    imageItems.add(new ImageItem(bitmap));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return imageItems;
        }

        @Override
        protected void onPostExecute(ArrayList<ImageItem> images) {
            super.onPostExecute(images);

            //Once images are loaded, fill grid view items with data
            GridViewAdapter gridViewAdapter = new GridViewAdapter(context, R.layout.custom_grid_item_layout, images);
            mGridView.setAdapter(gridViewAdapter);

            //Select first item as default selection
            //mGridView.setSelection(0);
            //mGridView.getSelectedView().setSelected(true);
            PanelClearInfo();
        }
    }

}

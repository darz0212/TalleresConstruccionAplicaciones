/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            // Es necesario definir una información dummy para la prueba, por favor agregue
            String[] data = {
                    getString(R.string.monday)+" 2018/03/05 - "+getString(R.string.rainy)+" - 18/11",
                    getString(R.string.tuesday)+" 2018/03/06 - "+getString(R.string.mists)+" - 21/8",
                    getString(R.string.wednesday)+" 2018/03/07 - "+getString(R.string.cloudy)+" - 22/17",
                    getString(R.string.thursday)+" 2018/03/08 - "+getString(R.string.rainy)+" - 18/11",
                    getString(R.string.friday)+" 2018/03/09 - "+getString(R.string.mists)+" - 21/10",
                    getString(R.string.saturday)+" 2018/03/10 - "+getString(R.string.no_data)+" - 23/18",
                    getString(R.string.sunday)+" 2018/03/11 - "+getString(R.string.cloudy)+" - 20/7",
                    getString(R.string.monday)+" 2018/03/12 - "+getString(R.string.mists)+" - 21/10",
                    getString(R.string.tuesday)+" 2018/03/13 - "+getString(R.string.mists)+" - 21/8",
                    getString(R.string.wednesday)+" 2018/03/14 - "+getString(R.string.rainy)+" - 18/11",
                    getString(R.string.thursday)+" 2018/03/15 - "+getString(R.string.rainy)+" - 18/11",
                    getString(R.string.friday)+" 2018/03/16 - "+getString(R.string.mists)+" - 21/10",
                    getString(R.string.saturday)+" 2018/03/17 - "+getString(R.string.no_data)+" - 23/18",
                    getString(R.string.sunday)+" 2018/03/18 - "+getString(R.string.mists)+" - 21/10",
                    getString(R.string.monday)+" 2018/03/19 - "+getString(R.string.sunny)+" - 24/17",
                    getString(R.string.tuesday)+" 2018/03/20 - "+getString(R.string.mists)+" - 21/8",
                    getString(R.string.wednesday)+" 2018/03/21 - "+getString(R.string.cloudy)+" - 22/17",
                    getString(R.string.thursday)+" 2018/03/22 - "+getString(R.string.rainy)+" - 18/11",
                    getString(R.string.friday)+" 2018/03/23 - "+getString(R.string.mists)+" - 21/10",
                    getString(R.string.saturday)+" 2018/03/24 - "+getString(R.string.rainy)+" - 18/11",
                    getString(R.string.sunday)+" 2018/03/25 - "+getString(R.string.rainy)+" - 20/7",
                    getString(R.string.monday)+" 2018/03/26 - "+getString(R.string.sunny)+" - 24/17",
                    getString(R.string.tuesday)+" 2018/03/27 - "+getString(R.string.mists)+" - 21/8",
                    getString(R.string.wednesday)+" 2018/03/28 - "+getString(R.string.mists)+" - 21/10",
                    getString(R.string.thursday)+" 2018/03/29 - "+getString(R.string.rainy)+" - 18/11",
                    getString(R.string.friday)+" 2018/03/30 - "+getString(R.string.cloudy)+" - 21/10",
                    getString(R.string.saturday)+" 2018/03/31 - "+getString(R.string.no_data)+" - 23/18",
                    getString(R.string.sunday)+" 2018/03/01 - "+getString(R.string.mists)+" - 21/10",
                    getString(R.string.monday)+" 2018/03/02 - "+getString(R.string.sunny)+" - 24/17",
                    getString(R.string.tuesday)+" 2018/03/03 - "+getString(R.string.cloudy)+" - 21/8"
            };
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));


            // Now that we have some dummy forecast data, create an ArrayAdapter.
            // The ArrayAdapter will take data from a source (like our dummy forecast) and
            // use it to populate the ListView it's attached to.
            mForecastAdapter =
                new ArrayAdapter<String>(
                    getActivity(), // The current context (this activity)
                    R.layout.list_item_forecast, // The name of the layout ID.
                    R.id.list_item_forecast_textview, // The ID of the textview to populate.
                    weekForecast);

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            // Get a reference to the ListView, and attach this adapter to it.
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}

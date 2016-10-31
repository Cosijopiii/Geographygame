package com.unistmo.geographygame;

import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by COSI on 30/10/2016.
 */

public class ControlActivity {

    ScrollingActivity scrollingActivity;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    public ControlActivity(ScrollingActivity scrollingActivity) {
        this.scrollingActivity = scrollingActivity;
    }

    public void create(){

        expandableListView = (ExpandableListView) scrollingActivity.findViewById(R.id.expandibleList);
        expandableListDetail=DataExpandible.getData();
        expandableListTitle=new ArrayList<>(expandableListDetail.keySet());
        expandableListAdapter=new AdapterExpandibleList(scrollingActivity,expandableListTitle,expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnChildClickListener(this::childListener);

    }

    private boolean childListener(ExpandableListView expandableListView, View view, int i, int i1, long l) {
        Toast.makeText(
                scrollingActivity.getApplicationContext(),
                expandableListTitle.get(i)
                        + " -> "
                        + expandableListDetail.get(
                        expandableListTitle.get(i)).get(
                        i1), Toast.LENGTH_SHORT
        ).show();
        return false;
    }


}



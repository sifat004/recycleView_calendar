package com.creativeapps.calendar_app;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
public class MonthActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);


        ArrayList<Month_of_Year>  months = new ArrayList<>();

        for (int i=0;i<=11;i++){
            Month_of_Year month= new Month_of_Year(i,2018);
            months.add(month);


        }


        RecyclerView calendarView = (RecyclerView) findViewById(R.id.calendar_view);


        SingleMonthRecycleAdapter adapter = new SingleMonthRecycleAdapter(this, months);
        calendarView.setAdapter(adapter);



        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        layoutManager.scrollToPosition(0);
        calendarView.setLayoutManager(layoutManager);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        calendarView.setItemAnimator(itemAnimator);
       // SnapHelper helper = new LinearSnapHelper();

        LinearSnapHelper snapHelper = new LinearSnapHelper() {
            @Override
            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                View centerView = findSnapView(layoutManager);
                if (centerView == null)
                    return RecyclerView.NO_POSITION;

                int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                if (layoutManager.canScrollVertically()) {
                    if (velocityY < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }

                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                return targetPosition;
            }
        };



        snapHelper.attachToRecyclerView(calendarView);


       // Log.e("calendar","setLayoutManager");

    }
}

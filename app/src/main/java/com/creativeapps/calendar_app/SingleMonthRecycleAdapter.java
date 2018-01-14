package com.creativeapps.calendar_app;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Sifat on 1/11/2018.
 */
public class SingleMonthRecycleAdapter extends
        RecyclerView.Adapter<SingleMonthRecycleAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Month_of_Year> months;
    private ArrayList<LinearLayout> cells;
    private ArrayList<LinearLayout> days ;
    TextView month_name;





    public SingleMonthRecycleAdapter(Context context,ArrayList<Month_of_Year> months) {
        Log.e("calendar","SingleMonthRecycleAdapter");

//        num_of_days=month_of_year.getNumber_of_days();
//        first_day= month_of_year.getFirst_day();

        this.months=months;
        mContext = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public SingleMonthRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        Log.e("calendar","onCreateViewHolder");

        cells=new ArrayList<>();
        days=new ArrayList<>();

        // Inflate the custom layout
        View monthView = inflater.inflate(R.layout.month, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(monthView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SingleMonthRecycleAdapter.ViewHolder holder, int position) {


        Month_of_Year month = months.get(position);
        int first_day = month.getFirst_day();
        int num_of_days = month.getNumber_of_days();

        Log.e("calendar","onBindViewHolder");


        int n=0;







        for (int i=first_day;i<=(month.getNumber_of_days()+first_day-1);i++){


            cells.get(i).removeAllViews();

            View cell_info = LayoutInflater.from(mContext).inflate(R.layout.cell, null, false);
            TextView EngDate= (TextView) cell_info.findViewById(R.id.eng_date);
            TextView BEngDate= (TextView) cell_info.findViewById(R.id.beng_date);
            TextView ArbDate= (TextView) cell_info.findViewById(R.id.arb_date);

            n++;



            EngDate.setText(String.valueOf(n));
//            BEngDate.setText("1");
//            ArbDate.setText("1");
            cells.get(i).addView(cell_info);

        }


        for (int i=0;i<7;i++){

            days.get(i).removeAllViews();


            View day_info = LayoutInflater.from(mContext).inflate(R.layout.cell, null, false);
            TextView EngDay= (TextView) day_info.findViewById(R.id.eng_date);
            TextView BEngDay= (TextView) day_info.findViewById(R.id.beng_date);
            //  TextView ArbDate= (TextView) cell_info.findViewById(R.id.arb_date);


            EngDay.setText(getDayInfo(i+1));
            days.get(i).addView(day_info);


        }



        month_name.setText(month.get_month_name());





    }

    private String getDayInfo(int i) {

        switch (i){

            case 1: return "Sat";
            case 2: return "Sun";
            case 3: return "Mon";
            case 4: return "Tue";
            case 5: return "Wed";
            case 6: return "Thu";
            case 7: return "Fri";

            default: return  "";


        }
    }

    @Override
    public int getItemCount() {

        return months.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row




        LinearLayout cell;
        LinearLayout day;


        public ViewHolder(View itemView) {



            super(itemView);
           // Log.e("calendar","ViewHolder");

            month_name=(TextView) itemView.findViewById(R.id.month_name);


            for (int i=0;i<42;i++){
                cell = (LinearLayout) itemView.findViewById(getCellId(i+1));


                cell.setBackgroundResource(R.drawable.rectangular_border);
                cell.setGravity(Gravity.CENTER);
                cells.add(cell);



            }

            for (int i=0;i<7;i++){

                day  = (LinearLayout) itemView.findViewById(getDayId(i+1));
                days.add(day);

            }









        }

        private int getCellId(int i) {

            Log.e("calendar","getID");

            switch (i) {


                case 1: return R.id.cell_1;
                case 2: return R.id.cell_2;
                case 3: return R.id.cell_3;
                case 4: return R.id.cell_4;
                case 5: return R.id.cell_5;
                case 6: return R.id.cell_6;
                case 7: return R.id.cell_7;
                case 8: return R.id.cell_8;
                case 9: return R.id.cell_9;
                case 10: return R.id.cell_10;
                case 11: return R.id.cell_11;
                case 12: return R.id.cell_12;
                case 13: return R.id.cell_13;
                case 14: return R.id.cell_14;
                case 15: return R.id.cell_15;
                case 16: return R.id.cell_16;
                case 17: return R.id.cell_17;
                case 18: return R.id.cell_18;
                case 19: return R.id.cell_19;
                case 20: return R.id.cell_20;
                case 21: return R.id.cell_21;
                case 22: return R.id.cell_22;
                case 23: return R.id.cell_23;
                case 24: return R.id.cell_24;
                case 25: return R.id.cell_25;
                case 26: return R.id.cell_26;
                case 27: return R.id.cell_27;
                case 28: return R.id.cell_28;
                case 29: return R.id.cell_29;
                case 30: return R.id.cell_30;
                case 31: return R.id.cell_31;
                case 32: return R.id.cell_32;
                case 33: return R.id.cell_33;
                case 34: return R.id.cell_34;
                case 35: return R.id.cell_35;
                case 36: return R.id.cell_36;
                case 37: return R.id.cell_37;
                case 38: return R.id.cell_38;
                case 39: return R.id.cell_39;
                case 40: return R.id.cell_40;
                case 41: return R.id.cell_41;
                case 42: return R.id.cell_42;

               default: return  0;


            }

        }

        private int getDayId(int i) {



            switch (i) {


                case 1: return R.id.day1;
                case 2: return R.id.day2;
                case 3: return R.id.day3;
                case 4: return R.id.day4;
                case 5: return R.id.day5;
                case 6: return R.id.day6;
                case 7: return R.id.day7;

                default: return  0;


            }

        }
        // Pass in the contact array into the constructor


        // Easy access to the context object in the recyclerview
        private Context getContext() {
            return mContext;
        }
    }
}


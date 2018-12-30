package com.example.ronig.myapplication.Tabs.Case;

import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.TextView;

import com.example.ronig.myapplication.Database.DataBaseHelper;
import com.example.ronig.myapplication.R;

import java.util.ArrayList;

public class Case_Main_Tab extends AppCompatActivity {

    public static DataBaseHelper db;
    protected static ArrayList<String> array = new ArrayList<>();

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case__main__tab);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        buildArrayDB();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case__main__tab, menu);
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
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    Case_Tab_1 tab1 = new Case_Tab_1();
                    return tab1;

                case 1:
                    Case_Tab_2 tab2 = new Case_Tab_2();
                    return tab2;

                case 2:
                    Case_Tab_3 tab3 = new Case_Tab_3();
                    return tab3;

                case 3:
                    Case_Tab_4 tab4 = new Case_Tab_4();
                    return tab4;

                default:
                    return null;

            }


        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }

    public void buildArrayDB(){
        db = new DataBaseHelper(this);
        array = db.fetch("case_");
    }

    public static void Insert(TextView text, TextView price, int tab) {

        text.setText(array.get(tab*2-2));
        price.setText(array.get(tab*2-1));


    }
}

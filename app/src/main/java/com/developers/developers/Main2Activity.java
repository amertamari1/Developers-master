package com.developers.developers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private ArrayList<TeamName> teamNames;
    private NameAdapter nameAdapter;
    private ListView listView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ProgrammerTeam();
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    xmlTeam();
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    designerTeam();
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listItem);
//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        int check = getIntent().getIntExtra("id",0);
        if (check == 0){
            ProgrammerTeam();
        }else if(check==1){
            xmlTeam();
        }else {
            designerTeam();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TeamName link = teamNames.get(position);
                Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                intent.putExtra("url", link.getmLink());
                startActivity(intent);
            }
        });

    }

    private void ProgrammerTeam(){
        teamNames = new ArrayList<TeamName>();
        teamNames.add(new TeamName("Programmer","https://www.google.com",R.drawable.image1));
        showList();
    }
    private void xmlTeam(){
        teamNames = new ArrayList<TeamName>();
        teamNames.add(new TeamName("XML","https://www.yahoo.com",R.drawable.image1));
        showList();
    }
    private void designerTeam(){
        teamNames = new ArrayList<TeamName>();
        teamNames.add(new TeamName("Designer","https://www.linkedin.com",R.drawable.image1));
        showList();
    }

    private void showList(){
        nameAdapter = new NameAdapter(getApplicationContext(), teamNames);

        listView.setAdapter(nameAdapter);
    }

}

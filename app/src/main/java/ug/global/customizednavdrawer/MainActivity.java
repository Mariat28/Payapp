package ug.global.customizednavdrawer;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    RelativeLayout appbarlayout;
    ArrayList<ProfileObject>profileObjectArrayList=new ArrayList<>();
    Fragment fragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
       /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        ImageView ivNavMenu=findViewById(R.id.ivNavMenu);
        appbarlayout=(RelativeLayout) findViewById(R.id.drawerMenu);
        final ImageView creditcard=appbarlayout.findViewById(R.id.creditimage);
        // set on click listener to left navigation icon
        ivNavMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(findViewById(R.id.drawerMenu))) {
                    creditcard.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // drawer.closeDrawer(GravityCompat.START);
                            Fragment fragment=new fragmentone();
                            show(fragment);
                            Toast.makeText(MainActivity.this, "creditcard", Toast.LENGTH_SHORT).show();
                        }
                    });
                    drawer.closeDrawer(findViewById(R.id.drawerMenu));
                } else {
                    drawer.openDrawer(findViewById(R.id.drawerMenu));
                }
            }
        });
        RecyclerView recyclerView=findViewById(R.id.mainrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerviewAdapter recyclerviewAdapter=new RecyclerviewAdapter(profileObjectArrayList,this);
        for (int i = 0; i <10 ; i++) {
            ProfileObject profileObject=new ProfileObject("Utim Benjamin","Phd","University Of Kawempe");
            profileObjectArrayList.add(profileObject);
            recyclerView.setAdapter(recyclerviewAdapter);
        }




   /*     FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });*/}
        private void show(Fragment fragment){
        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
            FragmentManager fragmentManager=getSupportFragmentManager();
            //fragmentManager.beginTransaction().replace(R.id.main,fragment).commit();
            drawerLayout.closeDrawer(GravityCompat.START);
        }

}

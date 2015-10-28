package com.renarosantos.secompp.view.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.renarosantos.secompp.R;
import com.renarosantos.secompp.view.product.AddProductFragment;
import com.renarosantos.secompp.view.product.ProductFragment;

/**
 * Created by renarosantos on 26/10/15.
 */
public class HomeActivity extends AppCompatActivity {

    private int[] tabIcons = {android.R.drawable.ic_menu_search,
            android.R.drawable.ic_menu_agenda};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }

    }

    private void setupViewPager(final ViewPager viewPager) {

        ProductFragment productFragment = new ProductFragment();

        AddProductFragment addProductFragment = new AddProductFragment();


        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(productFragment, "Buscar Produtos");
        adapter.addFragment(addProductFragment, "Adicionar Produtos");
        viewPager.setAdapter(adapter);
    }


}
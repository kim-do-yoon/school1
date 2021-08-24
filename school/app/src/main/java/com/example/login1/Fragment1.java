package com.example.login1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class Fragment1 extends Fragment {
    Fragment cf_manage1,cf_manage2,cf_manage3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1, container, false);

        //처음 childfragment 지정
        getFragmentManager().beginTransaction().add(R.id.child_fragment_manage, new CF_manage1()).commit();

        //하위버튼
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        //LinearLayout cf_manage1 = (LinearLayout) view.findViewById(R.id.child_fragment_manage1);
        //LinearLayout cf_manage2 = (LinearLayout) view.findViewById(R.id.child_fragment_manage2);
        cf_manage1 = new CF_manage1();
        cf_manage2 = new CF_manage2();
        cf_manage3 = new CF_manage3();


        //클릭 이벤트
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){

                    selected = cf_manage1;

                }else if (position == 1){

                    selected = cf_manage2;

                }else if (position == 2){

                    selected = cf_manage3;

                }

                getFragmentManager().beginTransaction().replace(R.id.child_fragment_manage, selected).commit();
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        return view;
    }
}
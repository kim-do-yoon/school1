package com.example.login1;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment3, container, false);

        //처음 childfragment 지정
        //getFragmentManager().beginTransaction().add(R.id.child_fragment2, new Fragment4()).commit();

        //하위버튼
        Button btn1 = (Button) v.findViewById(R.id.btn1);
        Button btn2 = (Button) v.findViewById(R.id.btn2);
        Button btn3 = (Button) v.findViewById(R.id.btn3);
        Button btn4 = (Button) v.findViewById(R.id.btn4);
        Button btn5 = (Button) v.findViewById(R.id.btn5);
        Button btn6 = (Button) v.findViewById(R.id.btn6);



        //클릭 이벤트
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment2, new CF_write1()).commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getChildFragmentManager().beginTransaction().replace(R.id.child_fragment2, new CF_write2()).commit();
            }
        });
        return v;
    }
}

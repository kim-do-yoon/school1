package com.example.login1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class AgreementActivity extends AppCompatActivity {

    Button nextButton;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;

    TextView button1, button2, button3;

    // 체크 박스 여부
    public int check1 =0;  // false =0, true =1
    public int check2 =0;
    public int check3 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("약관동의");
        //actionBar.setDisplayHomeAsUpEnabled(true);   //업버튼

        // 체크박스
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        final CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        // 이용약관 내용 확인
        button1 = (TextView)findViewById(R.id.Button1);
        button2 = (TextView)findViewById(R.id.Button2);
        button3 = (TextView)findViewById(R.id.Button3);

        // 서비스 이용약관 체크 여부
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    check1 = 1;
                } else {
                    check1 = 0;
                }
            }
        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(checkBox4.isChecked()){  // 전체 클릭 true면 false로 변경
                        checkBox4.setChecked(false);
                    // 각 체크박스 체크 여부 확인해서 전체동의 체크박스 변경
                    } else if(checkBox1.isChecked()&&checkBox2.isChecked()&&checkBox3.isChecked()){
                        checkBox4.setChecked(true);
                    }
                }
        });

        // 이용약관 내용
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AgreementActivity.this);
                builder.setTitle("서비스 이용약관");
                builder.setMessage(R.string.text1);

                builder.setNegativeButton("닫기",
                        new DialogInterface.OnClickListener() {
                            private Object Tag;

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.out.println(Tag + "이용약관 닫기");
                            }
                        });
                //다이얼로그 보여주기
                builder.show();
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    check2 = 1;
                } else {
                    check2 = 0;
                }
            }
        });

        // 개인정보 체크 여부
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox4.isChecked()){
                    checkBox4.setChecked(false);
                } else if(checkBox1.isChecked()&&checkBox2.isChecked()&&checkBox3.isChecked()){
                    checkBox4.setChecked(true);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AgreementActivity.this);
                builder.setTitle("개인정보 취급방침");
                builder.setMessage(R.string.text2);

                builder.setNegativeButton("닫기",
                        new DialogInterface.OnClickListener() {
                            private Object Tag;

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.out.println(Tag + "이용약관 닫기");
                            }
                        });
                //다이얼로그 보여주기
                builder.show();
            }
        });

        // 위치 정보 이용동의 체크 여부
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox4.isChecked()){
                    checkBox4.setChecked(false);
                } else if(checkBox1.isChecked()&&checkBox2.isChecked()&&checkBox3.isChecked()){
                    checkBox4.setChecked(true);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AgreementActivity.this);
                builder.setTitle("위치정보 이용 약관");
                builder.setMessage(R.string.text3);

                builder.setNegativeButton("닫기",
                        new DialogInterface.OnClickListener() {
                            private Object Tag;

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                System.out.println(Tag + "이용약관 닫기");
                            }
                        });
                //다이얼로그 보여주기
                builder.show();
            }
        });

        // 전체 동의 체크여부
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    check3 = 1;
                } else {
                    check3 = 0;
                }
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(checkBox4.isChecked()) {
                        checkBox1.setChecked(true);
                        checkBox2.setChecked(true);
                        checkBox3.setChecked(true);
                    } else {
                        checkBox1.setChecked(false);
                        checkBox2.setChecked(false);
                        checkBox3.setChecked(false);
                    }
                }
        });

        // 다음 화면 버튼
        nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 전체 동의 체크
                if (check3 != 1) {
                    // 개인정보 체크
                    if (check2 == 1) {
                        // 서비스 이용 체크
                        if (check1 == 1) {
                            startActivity(new Intent(AgreementActivity.this, RegisterActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "약관을 체크해주세요.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "약관을 체크해주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    // 전체 약관 체크
                } else {
                    Intent intent = new Intent(AgreementActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
            }
        });

        // 이전 화면 버튼
    }
}


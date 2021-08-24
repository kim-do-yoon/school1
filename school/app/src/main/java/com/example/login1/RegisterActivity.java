package com.example.login1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText idText, pwText, pwText1, nameText, phoneText, schoolText;
    private Button RegisterButton, validateButton;
    private AlertDialog dialog;
    private boolean validate=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("회원가입");
        actionBar.setDisplayHomeAsUpEnabled(true);   //업버튼

        // 값들
        idText = (EditText)findViewById(R.id.idText);
        pwText = (EditText)findViewById(R.id.pwText);
        pwText1 = (EditText)findViewById(R.id.pwText1);
        nameText = (EditText)findViewById(R.id.nameText);
        phoneText = (EditText)findViewById(R.id.phoneText);
        schoolText = (EditText)findViewById(R.id.schoolText);

        // 아이디 중복검사
        validateButton = (Button)findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = idText.getText().toString();
                if(validate)
                {
                    return;
                }
                if(id.equals("")) {
                    AlertDialog.Builder builder=new AlertDialog.Builder( RegisterActivity.this );
                    dialog = builder.setMessage("아이디를 입력해주세요.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            if (success) {
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("확인", null)
                                        .create();
                                dialog.show();
                                idText.setEnabled(false);
                                validate = true;
                                validateButton.setText("확인");
                            }
                            else {
                                dialog = builder.setMessage("사용할 수 없는 아이디입니다.")
                                        .setNegativeButton("확인", null)
                                        .create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ValidateRequest validateRequest=new ValidateRequest(id,responseListener);
                RequestQueue queue= Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);
            }
        });

        // 전화번호 중복검사 / 본인인증(구현중)


        // 회원가입 버튼
        RegisterButton = (Button)findViewById(R.id.RegisterButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 현재 입력되어있는 값을 가져온다
                String id = idText.getText().toString();
                final String password = pwText.getText().toString();
                String name = nameText.getText().toString();
                String tel = phoneText.getText().toString();
                final String school = schoolText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                                if (success) {  // 회원가입 성공
                                    Toast.makeText(getApplicationContext(), "회원 가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else { // 회원가입 실패
                                Toast.makeText(getApplicationContext(),"회원 가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(id, password, name, tel, school, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

                // 입력 값 만족하지 않았을 때
                if (idText.getText().toString().length() < 4 ) {
                    Toast.makeText(RegisterActivity.this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                    idText.requestFocus();
                    return;
                }

                if (pwText.getText().toString().length() < 8 ) {
                    Toast.makeText(RegisterActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    pwText.requestFocus();
                    return;
                }
                if (!pwText1.getText().toString().equals(pwText.getText().toString())) {
                    Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    pwText1.setText("");
                    pwText1.requestFocus();
                    return;
                }
                if (nameText.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "이름을 입력하세요.", Toast.LENGTH_SHORT).show();
                    nameText.requestFocus();
                    return;
                }
                if (phoneText.getText().toString().length() < 8 ) {
                    Toast.makeText(RegisterActivity.this, "전화번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    phoneText.requestFocus();
                    return;
                }
                if (schoolText.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "학교를 입력하세요.", Toast.LENGTH_SHORT).show();
                    schoolText.requestFocus();
                    return;
                }

            }
        });
    }
}

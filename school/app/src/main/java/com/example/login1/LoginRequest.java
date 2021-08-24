package com.example.login1;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    // 서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://vbxk123.dothome.co.kr/login.php";
    private Map<String, String> map;

    public LoginRequest(String id, String password, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("id", id);
        map.put("password", password);
    }

    @Override
    protected  Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

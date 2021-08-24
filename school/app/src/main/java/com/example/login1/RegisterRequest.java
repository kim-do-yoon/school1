package com.example.login1;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    // 서버 URL 설정(PHP 파일 연동)
    final static private String URL = "http://vbxk123.dothome.co.kr/Register.php";
    private Map<String, String> map;

    public  RegisterRequest(String id, String password, String name, String tel, String school, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("id", id);
        map.put("password", password);
        map.put("name", name);
        map.put("tel", tel);
        map.put("school", school);
    }

    @Override
    protected  Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

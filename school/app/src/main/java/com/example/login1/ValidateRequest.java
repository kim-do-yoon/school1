package com.example.login1;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest {

    final static private String URL = "http://vbxk123.dothome.co.kr/Validate.php";
    private Map<String, String> map;

    public ValidateRequest(String id, Response.Listener<String>listener) {
        super(Request.Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("id", id);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

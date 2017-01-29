package isfaaghyth.app.dilomakassar.presenter;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import isfaaghyth.app.dilomakassar.interfaces.ApiCallBack;

/**
 * Created by isfaaghyth on 28/1/17.
 */

public class NetworkPresenter {

    private Context context;
    private ApiCallBack callBack;

    private String nama;

    public NetworkPresenter(Context context, ApiCallBack callBack) {
        this.context = context;
        this.callBack = callBack;
    }

    public void setParamNama(String nama) {
        this.nama = nama;
    }

    public void getData(int method, String URL) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(method, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.onError(error.getMessage());
            }
        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> param = new HashMap<>();
//                param.put("nama_lengkap", nama);
//                return super.getParams();
//            }
        };
        queue.add(request);
    }
}

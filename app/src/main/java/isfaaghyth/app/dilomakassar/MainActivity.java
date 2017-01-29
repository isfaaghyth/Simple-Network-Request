package isfaaghyth.app.dilomakassar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import isfaaghyth.app.dilomakassar.adapter.PlanetAdapter;
import isfaaghyth.app.dilomakassar.interfaces.ApiCallBack;
import isfaaghyth.app.dilomakassar.models.PlanetModel;
import isfaaghyth.app.dilomakassar.presenter.NetworkPresenter;
import isfaaghyth.app.dilomakassar.utils.URLs;

public class MainActivity extends AppCompatActivity implements ApiCallBack {

    @BindView(R.id.lst_item_planet) RecyclerView lstPlanet;

    NetworkPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new NetworkPresenter(this, this);
        lstPlanet.setLayoutManager(new LinearLayoutManager(this));

        requestData();
    }

    private void requestData() {
        presenter.getData(Request.Method.GET, URLs.getData());
    }

    @Override
    public void onSuccess(String response) {
        Gson gson = new GsonBuilder().create();
        PlanetModel item = gson.fromJson(response, PlanetModel.class);
        lstPlanet.setAdapter(new PlanetAdapter(item.getPlanets()));
    }

    @Override
    public void onError(String err) {
        Log.d("DILO MAKASSAR", "Error");
    }
}

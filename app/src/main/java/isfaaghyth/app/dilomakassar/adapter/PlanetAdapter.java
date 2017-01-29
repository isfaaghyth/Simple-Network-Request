package isfaaghyth.app.dilomakassar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import isfaaghyth.app.dilomakassar.R;
import isfaaghyth.app.dilomakassar.models.PlanetModel;

/**
 * Created by isfaaghyth on 28/1/17.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {

    List<PlanetModel.Planet> planets;

    public PlanetAdapter(List<PlanetModel.Planet> planets) {
        this.planets = planets;
    }

    @Override
    public PlanetHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlanetHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false));
    }

    @Override
    public void onBindViewHolder(PlanetHolder holder, int position) {
        holder.txtJudul.setText(planets.get(position).getPlanetName());
        holder.txtDesc.setText(planets.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    class PlanetHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_judul)
        TextView txtJudul;

        @BindView(R.id.txt_desc)
        TextView txtDesc;

        PlanetHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

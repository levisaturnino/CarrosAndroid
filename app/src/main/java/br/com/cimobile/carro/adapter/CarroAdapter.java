package br.com.cimobile.carro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.cimobile.carro.R;
import br.com.cimobile.carro.domain.Carro;

/**
 * Created by saturnino on 29/05/2016.
 */
public class CarroAdapter extends RecyclerView.Adapter<CarroAdapter.CarroViewHolder> {

    private Context context;
    private List<Carro> carros;
    private OnClickListener mListener;

    public CarroAdapter(Context context, List<Carro> carros) {
        this.context = context;
        this.carros = carros;
    }

    public void setOnClickListener(OnClickListener l){
        mListener = l;
    }

    @Override
    public CarroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.carro_item,parent,false);

       CarroViewHolder vh = new CarroViewHolder(itemView);

        itemView.setTag(vh);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    CarroViewHolder vh = (CarroViewHolder)view.getTag();
                    int position = vh.getLayoutPosition();
                    mListener.onClick(view, position, carros.get(position));
                }
            }
        });
        return vh;
    }
    public interface OnClickListener {
        void onClick(View v, int position, Carro carro);
    }
    @Override
    public void onBindViewHolder(CarroViewHolder holder, int position) {

        Carro carro = carros.get(position);
        holder.tNome.setText(carro.nome);
        Picasso.with(context).load(carro.urlFoto).into(holder.imgFoto);

    }

    @Override
    public int getItemCount() {
        return carros != null ? carros.size() : 0;
    }

    public class CarroViewHolder extends RecyclerView.ViewHolder {
        private final TextView tNome;
        private final ImageView imgFoto;
      //  private final ProgressBar progress;

        public CarroViewHolder(View itemView) {
            super(itemView);

            tNome = (TextView) itemView.findViewById(R.id.tNome);
            imgFoto = (ImageView) itemView.findViewById(R.id.img);
          //  progress = (ProgressBar) itemView.findViewById(R.id.progress);

        }
    }
}

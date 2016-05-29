package br.com.cimobile.carro.carros;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.com.cimobile.androidutils.Transacao;
import br.com.cimobile.carro.R;
import br.com.cimobile.carro.adapter.CarroAdapter;
import br.com.cimobile.carro.domain.Carro;
import br.com.cimobile.carro.service.CarroService;

/**
 * Created by saturnino on 28/05/2016.
 */
public class TelaListaCarros extends LivroAndroidActivity implements Transacao,CarroAdapter.OnClickListener{

    private static final String TAG = "TelaListaCarros";
    private ProgressDialog progresso;
    private String tipo;
    private RecyclerView recyclerView;
    private CarroAdapter mAdapter;
    private List<Carro> carros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        startTransacao(this);
    }

    @Override
    public void executar() throws Exception {

        tipo = getIntent().getStringExtra(Carro.TIPO);
        carros = CarroService.getCarros(this,tipo);
    }

    @Override
    public void atualizarView() {
        if(carros != null){
            mAdapter = new CarroAdapter(TelaListaCarros.this,carros);
            mAdapter.setOnClickListener(TelaListaCarros.this);
            recyclerView.setAdapter(mAdapter);
        }

    }

    @Override
    public void onClick(View v, int position, Carro carro) {
        Intent it = new Intent(this,TelaDetalhesCarro.class);
        it.putExtra(Carro.KEY,carro);
        startActivity(it);
    }

   /* class BuscaCarrosTask extends AsyncTask<Void, Void, List<Carro>> {


        private static final String TAG = "BuscaCarroTask";
        private Context context;
        private final String tipo;
        private ProgressDialog progresso;


        public BuscaCarrosTask(Context context, String tipo){

            this.context = context;
            this.tipo = tipo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progresso = ProgressDialog.show(context,context.getString(R.string.app_name),context.getString(R.string.aguarde));
        }

        @Override
        protected List<Carro> doInBackground(Void... params) {

            try{
                List<Carro> carros = CarroService.getCarros(context,tipo);

                return carros;
            }catch (IOException e){
                Log.e(TAG,e.getMessage(),e);
                AndroidUtils.alertDialog(context, getString(R.string.erro_conexao_indisponivel));
            }finally {

                progresso.dismiss();
            }

            return null;
        }


        @Override
        protected void onPostExecute(List<Carro> carros) {
            super.onPostExecute(carros);

        }
    }

    @Override
    public void run() {
        try{
            final List<Carro> carros = CarroService.getCarros(this,tipo);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    for (Carro c : carros) {
                        Log.i(TAG, "Carro: " + c.nome);
                    }
                }
            });
        }catch (IOException e){
            Log.e(TAG,e.getMessage(),e);
            AndroidUtils.alertDialog(this, getString(R.string.erro_conexao_indisponivel));
        }finally {
            progresso.dismiss();
        }
    }*/
}

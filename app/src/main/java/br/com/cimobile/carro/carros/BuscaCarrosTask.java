package br.com.cimobile.carro.carros;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import br.com.cimobile.carro.R;
import br.com.cimobile.carro.domain.Carro;
import br.com.cimobile.carro.service.CarroService;
import br.com.cimobile.androidutils.AndroidUtils;

/**
 * Created by saturnino on 29/05/2016.
 */
public class BuscaCarrosTask extends AsyncTask<Void, Void, List<Carro>> {


    private static final String TAG = "BuscaCarroTask";
    private  Context context;
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
        AndroidUtils.alertDialog(context, context.getString(R.string.erro_conexao_indisponivel));
    }finally {
             progresso.dismiss();
    }
        return null;
    }


    @Override
    protected void onPostExecute(List<Carro> carros) {
        super.onPostExecute(carros);
        for (Carro c : carros) {
            Log.i(TAG, "Carro: " + c.nome);
        }
    }
}

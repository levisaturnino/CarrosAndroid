package br.com.cimobile.carro.carros;

import android.support.v7.app.AppCompatActivity;

import br.com.cimobile.androidutils.AndroidUtils;
import br.com.cimobile.androidutils.Transacao;
import br.com.cimobile.androidutils.TransacaoTask;
import br.com.cimobile.carro.R;


public class LivroAndroidActivity extends AppCompatActivity {


	protected void alert(String mensagem){
		AndroidUtils.alertDialog(this, mensagem);
	}
	// Inicia a thread


	public void startTransacao(Transacao transacao) {
		boolean redeOk = AndroidUtils.isNetworkAvailable(this);
        if(redeOk) {
        	// Inicia a trans��o
    		TransacaoTask task = new TransacaoTask(this, transacao ,getString(R.string.aguarde));
    		task.execute();        	
        } else {
        	// N�o existe conex�o
			AndroidUtils.alertDialog(this, getString(R.string.erro_conexao_indisponivel));
        }
	}
}

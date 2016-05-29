package br.com.cimobile.carro.carros;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.cimobile.carro.R;
import br.com.cimobile.carro.domain.Carro;
import br.com.cimobile.androidutils.AndroidUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btEsportivos,btClassisos,btLuxos,btSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEsportivos = (Button) findViewById(R.id.btEsportivos);
        btClassisos  = (Button) findViewById(R.id.btClassicos);
        btLuxos      = (Button) findViewById(R.id.btLuxo);
        btSobre      = (Button) findViewById(R.id.btSobre);

        btEsportivos.setOnClickListener(this);
        btClassisos.setOnClickListener(this);
        btLuxos.setOnClickListener(this);
        btSobre.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,TelaListaCarros.class);

        boolean redeOk = AndroidUtils.isNetworkAvailable(this);

        if (redeOk) {
            if(v == btEsportivos){
                intent.putExtra(Carro.TIPO,Carro.TIPO_ESPORTIVOS);
                startActivity(intent);
            }else if(v == btClassisos){
                intent.putExtra(Carro.TIPO,Carro.TIPO_CLASSICOS);
                startActivity(intent);
            }else if(v == btLuxos){
                intent.putExtra(Carro.TIPO,Carro.TIPO_LUXOS);
                startActivity(intent);
            }else if(v == btSobre){
                startActivity(new Intent(this, TelaSobre.class));
            }
        }else{
            AndroidUtils.alertDialog(this, getString(R.string.erro_conexao_indisponivel));
        }
    }
}

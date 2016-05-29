package br.com.cimobile.carro.carros;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.cimobile.carro.R;
import br.com.cimobile.carro.domain.Carro;


public class TelaDetalhesCarro extends Activity implements OnClickListener {
	private static final String TAG = "livroandroid";
	private Carro carro;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.carro_detalhes);

		carro = (Carro) getIntent().getSerializableExtra(Carro.KEY);
		Log.i(TAG, "Exibindo carro: " + carro.nome);
		TextView tTitulo = (TextView) findViewById(R.id.tHeader);
		TextView tDesc = (TextView) findViewById(R.id.tDesc);
		tTitulo.setText(carro.nome);

		tDesc.setText(carro.desc);
		// L� a imagem do cache
		// DownloadImagemUtil possui um HashMap interno. Chave=URL
		ImageView img = (ImageView) findViewById(R.id.img);
		Picasso.with(this).load(carro.urlFoto).into(img);
		// Site
		Button btSite = (Button) findViewById(R.id.btAbrirSite);
		btSite.setOnClickListener(this);
	}
	@Override
	public void onClick(View view) {
		String url = carro.urlInfo;
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
	}
}

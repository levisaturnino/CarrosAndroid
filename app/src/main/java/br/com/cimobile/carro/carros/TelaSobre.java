package br.com.cimobile.carro.carros;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import br.com.cimobile.carro.R;

/**
 * Created by saturnino on 28/05/2016.
 */
public class TelaSobre extends AppCompatActivity {
    private static final String TAG = "livroandroid";
    private static final String URL_SOBRE = "http://www.livroandroid.com.br/livro/carros/sobre.htm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre);
        WebView webview = (WebView) findViewById(R.id.webview);
        WebSettings settings = webview.getSettings();
        // Ativa o javascript na página
        settings.setJavaScriptEnabled(true);
        // Publica a interface para o javascript
        webview.addJavascriptInterface(this, "LivroAndroid");
        // Abre a página
        webview.loadUrl(URL_SOBRE);
        monitoraWebView(webview);
    }
    private void monitoraWebView(WebView webview) {
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i(TAG, "onPageStarted");
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i(TAG, "onPageFinished");
                ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
                progress.setVisibility(View.INVISIBLE);
            }
        });
    }
    // Método chamado pela página html no webview
    public void voltar() {
        Log.i(TAG, "voltar()");
        // Então encerramos a activity para demonstrar
        finish();
    }
}

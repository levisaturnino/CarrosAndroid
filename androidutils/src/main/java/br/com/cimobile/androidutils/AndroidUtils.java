package br.com.cimobile.androidutils;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by saturnino on 29/05/2016.
 */
public class AndroidUtils {

    protected static final String TAG = "AndrodiUtils";

    /**
     * Checking for all possible internet providers
     * **/
    public static boolean isNetworkAvailable(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] networks = connectivityManager.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network mNetwork : networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork);
                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }
        }else {
            if (connectivityManager != null) {
                //noinspection deprecation
                NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
                if (info != null) {
                    for (NetworkInfo anInfo : info) {
                        if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                            Log.d("Network","NETWORKNAME: " + anInfo.getTypeName());
                            return true;
                        }
                    }
                }
            }
        }
      //  Toast.makeText(mContext,mContext.getString(R.string.erro_conexao_indisponivel),Toast.LENGTH_SHORT).show();
        return false;
    }

    public static void alertDialog(final Context context, final String mensagem){

        try{
            AlertDialog.Builder dialog = new AlertDialog.Builder(context)
                    .setTitle(context.getString(R.string.app_name)
                    ).setMessage(mensagem)
                     .setPositiveButton("OK",new DialogInterface.OnClickListener(){
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              return;
                          }
                      });
            dialog.show();
        }catch (Exception e){
            Log.e(TAG,e.getMessage(),e);
        }
    }

}




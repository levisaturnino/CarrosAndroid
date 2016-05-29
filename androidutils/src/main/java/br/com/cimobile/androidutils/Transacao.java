package br.com.cimobile.androidutils;

/**
 * Created by saturnino on 29/05/2016.
 */
public interface Transacao {
     void executar() throws Exception;

     void atualizarView();
}

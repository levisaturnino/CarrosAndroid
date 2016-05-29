package br.com.cimobile.carro.domain;

import java.io.Serializable;

public class Carro implements Serializable {
	private static final long serialVersionUID = 6601006766832473959L;
	public static final String KEY = "carro";
	public static final String TIPO = "tipo";
	public static final String TIPO_CLASSICOS = "classicos";
	public static final String TIPO_ESPORTIVOS = "esportivos";
	public static final String TIPO_LUXOS = "luxo";
	public String nome;
	public String desc;
	public String urlFoto;
	public String urlInfo;
}


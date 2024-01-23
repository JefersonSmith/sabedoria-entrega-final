package br.com.sabedoria.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Senha {

	public static String encoder(String senha) {
		BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();
		return encoderSenha.encode(senha);
	}
}

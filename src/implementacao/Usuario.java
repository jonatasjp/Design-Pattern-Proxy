package implementacao;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nome;
	private List<String> autorizados;

	public Usuario(String nome) {
		this.nome = nome;
		this.autorizados = new ArrayList<>();
	}

	public void autorizaAcesso(String classe, String metodo) {
		this.autorizados.add(classe+":"+metodo);
	}
	
	public void removerAcesso(String classe, String metodo) {
		String permissao = classe+":"+metodo;
		if(this.autorizados.contains(permissao)) {
			this.autorizados.remove(permissao);
		}
	}
	
	public boolean estaAutorizado(String classe, String metodo) {
		return this.autorizados.contains(classe+":"+metodo);
	}
}

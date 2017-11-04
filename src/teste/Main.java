package teste;

import implementacao.InterfaceNegocio;
import implementacao.NegocioMock;
import implementacao.SegurancaNegocio;
import implementacao.Usuario;

public class Main {
	
	public static void main(String[] args) {
		
		//informando a permiss�o do usu�rio
		Usuario usuario = new Usuario("jonatas");
		usuario.autorizaAcesso("SegurancaNegocio", "executarTransacao");
		usuario.autorizaAcesso("SegurancaNegocio", "cancelarTransacao");
		
		//instanciando o objeto que ser� encapsulado pelo proxy
		NegocioMock mock = new NegocioMock();
		
		//instanciando o proxy e informando o objeto a ser encapsulado e o usuario
		InterfaceNegocio interfaceNegocio = new SegurancaNegocio(mock, usuario);
		
		//Deve passar pois tem a autoriza��o para usar os m�todo
		interfaceNegocio.executarTransacao();
		interfaceNegocio.cancelarTransacao();
		
		//Removendo a permissao de cancelarTransacao
		usuario.removerAcesso("SegurancaNegocio", "cancelarTransacao");
		
		//Deve lan�ar uma excess�o pois a permiss�o a esse m�todo foi removida
		interfaceNegocio.cancelarTransacao();
		
	}
	
}

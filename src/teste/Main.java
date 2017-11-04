package teste;

import implementacao.InterfaceNegocio;
import implementacao.NegocioMock;
import implementacao.SegurancaNegocio;
import implementacao.Usuario;

public class Main {
	
	public static void main(String[] args) {
		
		//informando a permissão do usuário
		Usuario usuario = new Usuario("jonatas");
		usuario.autorizaAcesso("SegurancaNegocio", "executarTransacao");
		usuario.autorizaAcesso("SegurancaNegocio", "cancelarTransacao");
		
		//instanciando o objeto que será encapsulado pelo proxy
		NegocioMock mock = new NegocioMock();
		
		//instanciando o proxy e informando o objeto a ser encapsulado e o usuario
		InterfaceNegocio interfaceNegocio = new SegurancaNegocio(mock, usuario);
		
		//FALSE
		System.out.println(mock.isFoiAcessado());
		
		//Deve passar pois tem a autorização para usar os método
		interfaceNegocio.executarTransacao();
		interfaceNegocio.cancelarTransacao();
		
		//TRUE
		System.out.println(mock.isFoiAcessado());
		
		//Removendo a permissao de cancelarTransacao
		usuario.removerAcesso("SegurancaNegocio", "cancelarTransacao");
		
		//Deve lançar uma excessão pois a permissão a esse método foi removida
		interfaceNegocio.cancelarTransacao();
		
	}
	
}

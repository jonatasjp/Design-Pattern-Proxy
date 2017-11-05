package implementacao;

public class ValidacaoNegocio implements InterfaceNegocio {

	private InterfaceNegocio encapsulado;
	private Usuario usuario;
	
	public ValidacaoNegocio(InterfaceNegocio encapsulado, Usuario usuario) {
		this.encapsulado = encapsulado;
		this.usuario = usuario;
	}
	
	@Override
	public void executarTransacao() {
		if(this.usuario.getNome() != null &&
				!this.usuario.getNome().isEmpty()) {
			encapsulado.executarTransacao();
		} else {
			lancarException();
		}
	}

	@Override
	public void cancelarTransacao() {
		encapsulado.cancelarTransacao();
	}

	private void lancarException() {
		throw new RuntimeException("Usuário inválido");
	}

}

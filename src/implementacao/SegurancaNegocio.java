package implementacao;

public class SegurancaNegocio implements InterfaceNegocio {

	private InterfaceNegocio encapsulado;
	private Usuario usuario;
	
	public SegurancaNegocio(InterfaceNegocio encapsulado, Usuario usuario) {
		this.encapsulado = encapsulado;
		this.usuario = usuario;
	}

	@Override
	public void executarTransacao() {
		if(this.usuario.estaAutorizado("SegurancaNegocio", "executarTransacao")) {
			encapsulado.executarTransacao();
		} else {
			throw new RuntimeException("Não autorizado");
		}
	}

	@Override
	public void cancelarTransacao() {
		if(this.usuario.estaAutorizado("SegurancaNegocio", "cancelarTransacao")) {
			encapsulado.cancelarTransacao();
		} else {
			throw new RuntimeException("Não autorizado");
		}
	}

}

package implementacao;

public class NegocioMock implements InterfaceNegocio{

	private boolean foiAcessado = false;
	
	@Override
	public void executarTransacao() {
		foiAcessado = true;
	}

	@Override
	public void cancelarTransacao() {
		foiAcessado = true;
	}

	public boolean isFoiAcessado() {
		return foiAcessado;
	}

}
package app;

import exceptions.DadosTurmaIncompletosException;

public class Turma {

	private char codigo;
	private int numVagas;
	private String descricao;

	public Turma(char codigo, int numVagas, String descricao) throws DadosTurmaIncompletosException {
		informarTurma(codigo, numVagas);
		this.codigo = codigo; 
		this.numVagas = numVagas;
		this.descricao = descricao;
	}

	public void informarTurma(char codigo, int numVagas) throws DadosTurmaIncompletosException {
		if (errosPreenchimento(codigo, numVagas)) {
			StringBuilder builder = new StringBuilder(); 
			builder.append("Dados informados para turma estao incompletos. ");
			builder.append(codigo == 0 ? "Codigo: " + codigo : "");
			builder.append(numVagas <=0 ? "Numero de vagas: " + numVagas : "");
			throw new DadosTurmaIncompletosException( builder.toString() );
		}
	}

	public boolean errosPreenchimento(char codigo, int numVagas) {
		return codigo == 0 || numVagas <= 0;
	}

	public static Turma obterTurma(char codigo, int numVagas, String descricao) throws DadosTurmaIncompletosException {
		Turma resposta = null;
		try {
			resposta = new Turma(codigo, numVagas, descricao);
		} catch (DadosTurmaIncompletosException e) {
			throw e;
		}
		return resposta;
	}

	public char getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getNumVagas() {
		return numVagas;
	}

}

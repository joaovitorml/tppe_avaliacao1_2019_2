package app;

import exceptions.DadosDisciplinaIncompletosException;

public class Disciplina {

	private String nome;
	private String departamento;
	private String codigo;
	private int creditosTeoria;
	private int creditosPratica;
	private int creditosExtensao;
	private int creditosEstudos;

	public Disciplina(String nome, String departamento, String codigo, int creditosTeoria, int creditosPratica,
			int creditosExtensao, int creditosEstudos) throws DadosDisciplinaIncompletosException {
		informarDisciplina(nome, codigo, creditosTeoria, creditosPratica, creditosExtensao, creditosEstudos);
		this.nome = nome; 
		this.departamento = departamento; 
		this.codigo = codigo; 
		this.creditosTeoria = creditosTeoria; 
		this.creditosPratica = creditosPratica; 
		this.creditosExtensao = creditosExtensao; 
		this.creditosEstudos = creditosEstudos;
	}

	public void informarDisciplina(String nome, String codigo, int creditosTeoria, int creditosPratica,
			int creditosExtensao, int creditosEstudos) throws DadosDisciplinaIncompletosException {
		if (errosPreenchimento(nome, codigo, creditosTeoria, creditosPratica, creditosExtensao, creditosEstudos)) {
			StringBuilder builder = new StringBuilder(); 
			builder.append("Dados informados para Disciplinas estão inválidos. ");
			builder.append((nome == null || nome.equalsIgnoreCase("")) ? "Nome: " + nome : null);
			builder.append((codigo == null || codigo.equalsIgnoreCase("")) ? "Codigo: " + nome : null);
			builder.append((creditosTeoria < 0 ) ? "Creditos teoria: " + creditosTeoria : null);
			builder.append((creditosPratica < 0) ? "Creditos pratica: " + creditosPratica : null);
			builder.append((creditosExtensao < 0) ? "Creditos extensao: " + creditosExtensao : null);
			builder.append((creditosEstudos < 0) ? "Creditos estudos: " + creditosEstudos : null);
			throw new DadosDisciplinaIncompletosException(builder.toString());
		}
	}

	public boolean errosPreenchimento(String nome, String codigo, int creditosTeoria, int creditosPratica,
			int creditosExtensao, int creditosEstudos) {
		return nome == null || codigo == null || creditosTeoria < 0 || creditosPratica < 0 || creditosExtensao < 0 || creditosEstudos < 0 ||
			nome.equalsIgnoreCase("") || codigo.equalsIgnoreCase("");
	}

	public static Disciplina obterDisciplina(String nome, String departamento, String codigo, int creditosTeoria,
			int creditosPratica, int creditosExtensao, int creditosEstudos) throws DadosDisciplinaIncompletosException {
		Disciplina d = new Disciplina(nome, departamento, codigo, creditosTeoria, creditosPratica, creditosExtensao, creditosEstudos);
		return d;
	}

	public String getNome() {
		return nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getCreditosTeoria() {
		return creditosTeoria;
	}

	public int getCreditosPratica() {
		return creditosPratica;
	}

	public int getCreditosExtensao() {
		return creditosExtensao;
	}

	public int getCreditosEstudos() {
		return creditosEstudos;
	}

}

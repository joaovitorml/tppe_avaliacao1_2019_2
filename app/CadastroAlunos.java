package app;

public class CadastroAlunos {

	private static CadastroAlunos instancia = null;
	Aluno[] alunos;
	
	public CadastroAlunos() {
		alunos = new Aluno[0];
	}
	
	public static CadastroAlunos obterCadastroAlunos() {
//		if (instancia == null) {
			instancia = new CadastroAlunos();
//		}
		return instancia;
	}

	public boolean adicionarAluno(Aluno a) {
		boolean resposta = false; 
		int novaQtdeAlunos = alunos.length + 1; 
		Aluno temp[] = new Aluno[novaQtdeAlunos]; 
		//verificar se o aluno já está cadastrado.
		for (int i=0; i < alunos.length; i++ ) {
			Aluno t = alunos[i]; 
			if (a.getPrefixoMatricula().equalsIgnoreCase(t.getPrefixoMatricula()) && 
					a.getSufixoMatricula().equalsIgnoreCase(t.getSufixoMatricula())) {
				resposta = false; 
				return resposta; 
			}
		}
		
		//copiar os alunos atuais para o vetor temporario
		for (int i=0; i < alunos.length; i++) {
			temp[i] = alunos[i]; 
		}
		//adicionar novo aluno na ultima posicao do vetor
		int posicaoInsercao = alunos.length;
		temp[posicaoInsercao] = a; 
		
		//atualizacao dos vetores
		alunos = temp; 
		//verificacao da adicao
		resposta = (alunos[posicaoInsercao] == a ? true : false);
		
		return resposta;
	}

	public Aluno pesquisarAluno(String prefixoMatricula, String sufixoMatricula) {
		Aluno resposta = null; 
		
		//verificar se o aluno já está cadastrado.
		for (int i=0; i < alunos.length; i++ ) {
			Aluno t = alunos[i]; 
			if (t.getPrefixoMatricula().equalsIgnoreCase(prefixoMatricula) && 
					t.getSufixoMatricula().equalsIgnoreCase(sufixoMatricula)) {
				resposta = t; 
				return resposta; 
			}
		}
		
		return resposta;
	}

	public Aluno[] ordenarAlunos() {
		return new OrdenarAlunos(this).computar();
	}

	public String retornaMatricula(Aluno[] resposta, int j) {
		String matricula2 = resposta[j].getPrefixoMatricula() + "/" + resposta[j].getSufixoMatricula();
		return matricula2;
	}

}

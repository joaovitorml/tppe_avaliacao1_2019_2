package app;

public class OrdenarAlunos {
	public CadastroAlunos source;
	public Aluno resposta[];
	public String matricula1;
	public String matricula2;
	
	public OrdenarAlunos(CadastroAlunos source) {
		this.source = source;
	}
	
	Aluno[] computar() {
		resposta = new Aluno[source.alunos.length];
		for (int i=0; i < source.alunos.length; i++) {
			resposta[i] = source.alunos[i]; 
		}
		
		for (int i = 0; i < resposta.length - 1; i++) {
			for (int j = i; j < resposta.length; j++) {
				matricula1 = source.retornaMatricula(resposta, i);
				matricula2 = source.retornaMatricula(resposta, j);
				if (matricula1.compareTo(matricula2) > 0) {
					Aluno t = resposta[i]; 
					resposta[i] = resposta[j];
					resposta[j] = t;
				}
			}
		}
		return resposta;
	}
	

}

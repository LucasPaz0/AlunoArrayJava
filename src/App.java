public class App {
   public static void main(String[] args) {
       iAlunoRepository alunoRepository = new ArrayListAlunoRepository();

       alunoRepository.adicionar(new Aluno("Lucas", "111"));
       alunoRepository.adicionar(new Aluno("Maria", "222"));
       alunoRepository.adicionar(new Aluno("Joao", "333"));
       alunoRepository.adicionar(new Aluno("Carol", "444"));
       alunoRepository.adicionar(new Aluno("Eduardo", "555"));

       System.out.println("Alunos:");
       for (Aluno aluno : alunoRepository.listar()) {
           System.out.println(aluno.getNome());
       }

       Aluno alunoBuscado = alunoRepository.buscar("Lucas");
       System.out.println("\nAluno buscado: " + alunoBuscado.getNome());

       alunoRepository.remover(alunoBuscado);

       System.out.println("\nAlunos após remoção:");
       for (Aluno aluno : alunoRepository.listar()) {
           System.out.println(aluno.getNome());
       }
   }
}

import java.util.List;

public class App {
 public static void main(String[] args) {
   iAlunoRepository alunoRepository = new ArrayListAlunoRepository();

   alunoRepository.adicionar(new Aluno("Lucas", "1234567890"));
   alunoRepository.adicionar(new Aluno("Hugo", "2345678901"));
   alunoRepository.adicionar(new Aluno("Carol", "3456789012"));
   alunoRepository.adicionar(new Aluno("Manoel", "4567890123"));
   alunoRepository.adicionar(new Aluno("Victoria", "5678901234"));

   System.out.println("Lista de Alunos:");
   List<Aluno> alunos = alunoRepository.listar();
   for (Aluno aluno : alunos) {
       System.out.println(aluno);
   }

   System.out.println();

   Aluno alunoBuscado = alunoRepository.buscar("Lucas");
   if (alunoBuscado == null) {
       System.out.println("Aluno não encontrado");
       return;
   }

   if (alunoBuscado.getMatricula().length() != 10) {
       System.out.println("Matricula invalida: " + alunoBuscado);
       return;
   }

   System.out.println("Aluno buscado e removido: " + alunoBuscado);
   alunoRepository.remover(alunoBuscado);

   System.out.println(); 

   System.out.println("Lista de Alunos após remoção:");
   alunos = alunoRepository.listar();
   for (Aluno aluno : alunos) {
       System.out.println(aluno);
   }
 }
}
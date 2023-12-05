import java.util.ArrayList;
import java.util.List;

public class ArrayListAlunoRepository implements iAlunoRepository {
   private List<Aluno> alunos;

   public ArrayListAlunoRepository() {
       this.alunos = new ArrayList<>();
   }

   @Override
   public void adicionar(Aluno aluno) {
       this.alunos.add(aluno);
   }

   @Override
   public void remover(Aluno aluno) {
       this.alunos.remove(aluno);
   }

   @Override
   public Aluno buscar(String nome) {
       for (Aluno aluno : this.alunos) {
           if (aluno.getNome().equals(nome)) {
               return aluno;
           }
       }
       return null;
   }

   @Override
   public List<Aluno> listar() {
       return this.alunos;
   }
}
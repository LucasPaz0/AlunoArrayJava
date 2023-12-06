import java.util.List;

import contracts.iAlunoRepository;
import exceptions.AlunoNaoEncontradoException;
import exceptions.MatriculaInvalidaException;
import models.Aluno;
import repositories.ArrayListAlunoRepository;

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

        try {

            for (Aluno aluno : alunos) {
                if (aluno.getMatricula().length() != 10) {
                    throw new MatriculaInvalidaException(
                            "Matricula invalida: " + aluno.getNome() + ", " + aluno.getMatricula());
                }
            }

            Aluno alunoBuscado = alunoRepository.buscar("cas");
            

            System.out.println("Aluno buscado e removido: " + alunoBuscado);
            alunoRepository.remover(alunoBuscado);
        } catch (AlunoNaoEncontradoException e) {
            System.out.println(e.getMessage());
            return;
        } catch (MatriculaInvalidaException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println();

        System.out.println("Lista de Alunos após remoção:");
        alunos = alunoRepository.listar();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}

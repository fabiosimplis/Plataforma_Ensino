package br.com.dev.teste;

import br.com.dev.entity.Lesson;
import br.com.dev.entity.Task;
import br.com.dev.entity.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Lesson> lessons = new ArrayList<>();
        int i = 1 ;
        System.out.print("Quantas aulas tem o curso? ");
        int qdtAulas = sc.nextInt();

        while ( i <= qdtAulas ){
            System.out.printf("\nDados da %da aula:", i);
            System.out.print("\nConteúdo ou tarefa (c/t)?");
            char tipoCurso = sc.next().charAt(0);

            if (tipoCurso == 'c'){
                lessons.add(createVideo(sc));
            } else if (tipoCurso == 't') {
                lessons.add(createTask(sc));
            } else {
                System.out.println("Tipo de curso errado, por favor digite 'c' para conteúdo ou 't' para tarefa");
                continue;
            }

            i++;
        }

        sc.close();

        showDuracaoTotal(lessons);
    }

    private static void showDuracaoTotal(List<Lesson> lessons) {

        int duracaoTotal = 0;

        for(Lesson lesson : lessons){
            duracaoTotal += lesson.duration();
        }
        System.out.printf("\n DURAÇÃO TOTAL DO CURSO = %d segundos", duracaoTotal);

    }

    public static Video createVideo(Scanner sc){
        System.out.print("Título: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        System.out.print("URL do vídeo: ");
        String url = sc.nextLine();
        System.out.print("Duração em segundos: ");
        int duracao = sc.nextInt();

        return new Video(titulo, url, duracao);
    }

    public static Task createTask(Scanner sc){
        System.out.print("Título: ");
        sc.nextLine();
        String titulo = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Quantidade de questões: ");
        int quantidadeQuestao = sc.nextInt();
        return new Task(titulo, descricao, quantidadeQuestao);
    }
}

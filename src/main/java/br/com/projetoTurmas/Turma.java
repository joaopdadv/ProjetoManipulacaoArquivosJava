package br.com.projetoTurmas;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Turma {
    private String nome;
    private List<String> alunos;
}

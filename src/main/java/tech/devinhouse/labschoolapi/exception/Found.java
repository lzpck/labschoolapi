package tech.devinhouse.labschoolapi.exception;

public class Found extends RuntimeException{

    public Found(String nomePessoa, Integer codigo) {
        super(nomePessoa + " já cadastrada!");
    }


    public Found(String nomePessoa, Long codigo) {
        this(nomePessoa, Integer.valueOf(Math.toIntExact(codigo)));
    }

    public Found(String aluno) {
        super(aluno + " já cadastrado!");
    }
}

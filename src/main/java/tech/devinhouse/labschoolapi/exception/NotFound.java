package tech.devinhouse.labschoolapi.exception;

public class NotFound extends RuntimeException{

    public NotFound(String nomePessoa, String id) {
        super(nomePessoa + " com código " + id + " não foi encontrado!");
    }

    public NotFound(String nomePessoa, Integer id) {
        this(nomePessoa, String.valueOf(id));
    }

}

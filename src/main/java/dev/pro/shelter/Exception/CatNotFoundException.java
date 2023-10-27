package dev.pro.shelter.Exception;

public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(String massage) {
        super(massage);
    }
}

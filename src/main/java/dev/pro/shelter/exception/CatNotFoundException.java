package dev.pro.shelter.exception;

public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(String massage) {
        super(massage);
    }
}

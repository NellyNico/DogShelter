package crud.dogShelter.exceptions;

public class AdoptionNotFoundException extends RuntimeException{

    public AdoptionNotFoundException(String message) {
        super(message);
    }
}

package crud.dogShelter.exceptions;

public class DogNotFoundException extends RuntimeException{

    public DogNotFoundException(String message) {
        super(message);
    }
}

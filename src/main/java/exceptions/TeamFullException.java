package exceptions;

public class TeamFullException extends Exception {

    public TeamFullException(String message) {

        super(message);
    }
}

//Object
//   │
//Throwable
//   │
//Exception
//   │
//TeamFullException
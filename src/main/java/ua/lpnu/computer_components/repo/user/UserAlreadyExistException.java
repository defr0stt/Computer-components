package ua.lpnu.computer_components.repo.user;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String message) {
        super(message);
    }
    public UserAlreadyExistException(String message, Throwable cause){
        super(message, cause);
    }
    public UserAlreadyExistException(Throwable cause) {
        super(cause);
    }
    public UserAlreadyExistException(){}
}

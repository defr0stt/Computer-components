package ua.lpnu.computer_components.repo.user;

public interface UserService {
    void register(final UserData user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
}

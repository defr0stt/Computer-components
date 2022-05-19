package ua.lpnu.computer_components.repo.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lpnu.computer_components.models.UserEntity;
import ua.lpnu.computer_components.security.SecurityConfig;

import java.time.LocalDateTime;
import java.util.List;

@Service("userService")
public class DefaultUserService implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultUserService(UserRepository userRepository,
                              PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserData user) throws UserAlreadyExistException {
        if(checkIfUserExist(user.getEmail()) || user.getPassword().length() < 6 || user.getUsername().length() < 3){
            throw new UserAlreadyExistException("User already exists for this username or too short password, username");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userEntity.setRegisterDate(LocalDateTime.now());
        userRepository.save(userEntity);
//        new SecurityConfig(passwordEncoder,this).getInMemoryUserDetailsManager();
    }

    @Override
    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    public UserEntity getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    private void encodePassword(UserEntity userEntity, UserData user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}

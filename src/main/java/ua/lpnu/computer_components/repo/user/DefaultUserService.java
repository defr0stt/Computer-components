package ua.lpnu.computer_components.repo.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lpnu.computer_components.models.UserEntity;
import ua.lpnu.computer_components.security.SecurityConfig;

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
        if(checkIfUserExist(user.getUsername()) || user.getPassword().length() < 6 || user.getUsername().length() < 3){
            throw new UserAlreadyExistException("User already exists for this username or too short password, username");
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        encodePassword(userEntity, user);
        userRepository.save(userEntity);
//        new SecurityConfig(passwordEncoder,this).getInMemoryUserDetailsManager();
    }

    @Override
    public boolean checkIfUserExist(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    private void encodePassword(UserEntity userEntity, UserData user){
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}

package faheem.microservices.springcustomvalidations.service;

import faheem.microservices.springcustomvalidations.dto.UserDto;
import faheem.microservices.springcustomvalidations.entity.User;
import faheem.microservices.springcustomvalidations.exceptions.UserNotFoundException;
import faheem.microservices.springcustomvalidations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .firstName(userDto.getFirstName())
                .mobile(userDto.getMobile())
                .nationality(userDto.getNationality())
                .gender(userDto.getGender())
                .build();
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(Integer userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else{
            throw new UserNotFoundException("user not found in database!");
        }
    }
}

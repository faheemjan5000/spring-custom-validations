package faheem.microservices.springcustomvalidations.controller;

import faheem.microservices.springcustomvalidations.dto.UserDto;
import faheem.microservices.springcustomvalidations.entity.User;
import faheem.microservices.springcustomvalidations.exceptions.UserNotFoundException;
import faheem.microservices.springcustomvalidations.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserDto userdto){
        log.info("UserController.addUser() method is called...");
        log.info("input user is : {}" , userdto);
        User user = userService.saveUser(userdto);
        log.info("user added successfully ! {}" , user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public User getUser(@PathVariable Integer id) throws UserNotFoundException {
        log.info("UserController.getUser() method is called... with user id : {}",id);
        User user = userService.getUser(id);
        if(user!=null) {
            log.info("user found : {}",user );
        }
        else{
            log.info("user not found for id : {}",id);
        }

        return user;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        log.info("UserController.getAllUsers() method is called...");
        List<User> allUsers = userService.getAllUsers();
        log.info("all users are : {}",allUsers);
        return allUsers;
    }
}

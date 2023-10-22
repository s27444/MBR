package org.user.service;

import lombok.RequiredArgsConstructor;
import org.user.exception.UserNotFoundException;
import org.user.exception.ValidationException;
import org.user.model.User;
import org.user.model.UserStatus;
import org.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        if (user.getFirstName().isBlank()){
            throw new ValidationException("cannot be blank", "FirstName");
        }

        userRepository.create(user);

        return user;
    }

    public User getById(Integer id) {
        Optional<User> user = userRepository.getById(id);

        return user.orElseThrow(() -> new UserNotFoundException("User does not exist"));
    }
    public List<User> getActiveUsers(){
        return userRepository.getByStatus(UserStatus.ACTIVE);
    }

    public User updateFirstName(Integer id, String newFirstName){
        if (newFirstName.isBlank()){
            throw new ValidationException("cannot be blank", "newFirstName");
        }

       return userRepository.updateModel(id, newFirstName).orElseThrow(() -> new UserNotFoundException("user does not exist"));
    }

    public void removeById(Integer id){
        userRepository.removeById(id);
    }

    public void removeallUser() {
        userRepository.removeAll();
    }

    public List<User> getAll(){
       return userRepository.getAll();
    }


}

package org.user.repository;

import org.user.model.User;
import org.user.model.UserStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository {
    List<User> userList = new ArrayList<>();
    public User create(User user) {
        user.setId(userList.size());

        userList.add(user);

        return user;
    }

    public Optional<User> getById(Integer id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public List<User> getByStatus(UserStatus userStatus){
        return userList.stream()
                .filter(user -> user.getStatus().equals(userStatus))
                .collect(Collectors.toList());
    }

    public  List<User> getAll(){
        return userList;
    }

    public void removeAll(){userList = new ArrayList<>();
    }

    public void removeById(Integer id){
        Optional<User> optionalUser = getById(id);

        optionalUser.ifPresent(it -> userList.remove(it));
    }

    public Optional<User> updateModel(Integer id, String newFirstName){
        Optional<User> optionalCar = getById(id);

        return optionalCar.map( car -> {
            car.setFirstName(newFirstName);
            return car;
        });
    }
}

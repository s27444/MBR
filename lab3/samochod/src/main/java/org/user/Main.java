package org.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.user.model.User;
import org.user.model.UserClass;
import org.user.model.UserStatus;
import org.user.repository.UserRepository;
import org.user.service.UserService;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Logger logger = LogManager.getLogger(org.carrental.Main.class);
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        User user = new User(null, "Adrian", "Kemski", "123456789", UserClass.MALE, UserStatus.ACTIVE);

        User user2 = new User(null, "Test", "Test", "123456789", UserClass.MALE, UserStatus.UNACTIVE);

        User user3 = new User(null, "Test2", "Test2", "123456789", UserClass.FEMALE, UserStatus.ACTIVE);

        User createdUser = userService.createUser(user);

        userService.createUser(user2);

        userService.createUser(user3);

        logger.info(createdUser);

        userService.updateFirstName(2, "Test3");

        User userById = userService.getById(0);

        logger.info(userById);

        List<User> activeUser = userService.getActiveUsers();

        logger.info(activeUser);

        userService.removeById(1);

        List<User> allUser = userService.getAll();

        logger.info(allUser);

        userService.removeallUser();







//        user invaliduser = new user(null, "volkswagen", "golf", "1234", userClass.STANDARD, userStatus.AVAILABLE);
//
//        userService.createuser(invaliduser);


    }
}
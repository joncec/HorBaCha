package terminal.services;

import java.util.ArrayList;
import java.util.List;

import terminal.entities.User;

public class UserService {
    private List<User> userList = new ArrayList<>();
    private int nextUserId = 1;

    // Create a new user
    public User createUser(String name, String phoneNumber, String cpf) {
        User newUser = new User(nextUserId++, name, phoneNumber, cpf);
        userList.add(newUser);
        return newUser;
    }

    // Get a user by ID
    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // User not found
    }

    // Update user information
    public User updateUser(int userId, String name, String phoneNumber, String cpf) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                user.setName(name);
                user.setPhoneNumber(phoneNumber);
                user.setCpf(cpf);
                return user;
            }
        }
        return null; // User not found
    }

    // Delete a user by ID
    public boolean deleteUser(int userId) {
        User userToRemove = null;
        for (User user : userList) {
            if (user.getUserId() == userId) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            userList.remove(userToRemove);
            return true; // User deleted successfully
        }
        return false; // User not found
    }
}

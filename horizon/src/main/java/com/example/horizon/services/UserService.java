package com.example.horizon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.horizon.entities.User;
import com.example.horizon.exceptions.ResourceNotFoundException;
import com.example.horizon.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService 
{
	@Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
    	Optional<User> userOptional = userRepository.findById(id);
		return userOptional.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
    	try {
    		User targetUser = userRepository.getReferenceById(id);
    		updateData(targetUser, updatedUser);
    		return userRepository.save(targetUser);
    		
    		}catch(EntityNotFoundException e) {
    			throw new  ResourceNotFoundException(id);
    		}
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true; // User deleted successfully
        }
        return false; // User not found
    }
    
    private void updateData(User targetUser, User updatedUser) {
		targetUser.setName(updatedUser.getName());
		targetUser.setCpf(updatedUser.getCpf());
		targetUser.setPhone(updatedUser.getPhone());
	}
}

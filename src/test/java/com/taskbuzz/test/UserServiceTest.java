package com.taskbuzz.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.taskbuzz.entities.Role;
import com.taskbuzz.entities.User;
import com.taskbuzz.repository.UserRepository;
import com.taskbuzz.services.UserService;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        // You can set up additional configurations if needed
    }

	@Test
	public void testGetUsers() {

		List<User> expectedUsers = Arrays.asList(
				new User(1L, "John", "john@example.com", "password123", new ArrayList<>(), Role.USER,"8976543217"),
				new User(2L, "Elena", "elena@example.com", "password456", new ArrayList<>(), Role.ADMIN,"8976543217"));
		when(userRepository.findAll()).thenReturn(expectedUsers);

		List<User> actualUsers = userService.getUsers();

		assertEquals(expectedUsers, actualUsers);

	}

    @Test
    public void testCreateUser() {

        User userToSave = new User(1L, "John", "john@example.com", "password123", new ArrayList<>(), Role.USER, "8976543217");
        User savedUser = new User(1L, "John", "john@example.com", "encodedPassword", new ArrayList<>(), Role.USER, "8976543217");
        when(passwordEncoder.encode(any())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        User actualUser = userService.createUser(userToSave);

        assertEquals(savedUser, actualUser);
    }

    @Test
    public void testGetUserById() {

        Long userId = 1L;
        User expectedUser = new User(1L, "John", "john@example.com", "password123", new ArrayList<>(), Role.USER,"8976543217");

        when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.getUserById(userId);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testGetUserByIdThrowsNoSuchElementException() {

        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getUserById(userId));
    }
}

package com.hnt.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.hnt.UserRepository;
import com.hnt.entity.User;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	UserRepository repos;

	@InjectMocks
	UserService service;

	@Test
	void testSave() {

		User user = new User();
		user.setId(1);
		user.setName("john");
		when(repos.save(user)).thenReturn(user);
		service.save(user);
		assertEquals(1, user.getId());

	}

	@Test
	void testSaveForException() {
		assertThrows(IllegalArgumentException.class, () -> {
			User user = new User();
			user.setName("Ram");
			service.save(user);
		});

	}
	@Test
	void testGetUser() {
		User user = new User();
		List<User> users = new ArrayList<>();
		users.add(user);
		
		when(repos.findAll()).thenReturn(users);
		service.getUser();
		assertEquals(1,users.size());
		
		
		
	}
}

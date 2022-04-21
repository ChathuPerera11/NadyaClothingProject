package com.nadyaclothing.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.nadyaclothing.common.entity.Role;
import com.nadyaclothing.common.entity.User;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User user = new User("chathuperera11@gmail.com", "admin", "Chathuri", "Perera");
		user.addRole(roleAdmin);
		
		User savedUser = repo.save(user);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWithTwoRoles() {
		User user = new User("mudari@gmail.com", "assistant", "Mudari", "Marasinghe");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		
		user.addRole(roleEditor);
		user.addRole(roleAssistant);
		
		User savedUser = repo.save(user);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void testGetUserById() {
		User user = repo.findById(1).get();
		System.out.println(user);
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testGetUserByEmail() {
		String email = "chathuperera11@gmail.com";
		User user = repo.getUserByEmail(email);
		
		assertThat(user).isNotNull();
	}

	
	@Test
	public void testCountById() {
		Integer id = 4;
		Long countById = repo.countById(id);
		
		assertThat(countById).isNotNull().isGreaterThan(0);
	}

	
	@Test
	public void testDisableUser() {
		Integer id = 2;
		repo.updateEnabledStatus(id, true);
		
	}
	
	@Test
	public void testEnableUser() {
		Integer id = 4;
		repo.updateEnabledStatus(id, false);
		
	}	
	
	


//	@Test
//	public void testUpdateUserDetails() {
//		User user = repo.findById(2).get();
//		user.setEnabled(true);
//		user.setEmail("mudari23@gmail.com");
//		
//		repo.save(user);
//	}
//	
//	@Test
//	public void testUpdateUserRoles() {
//		User user = repo.findById(2).get();
//		Role roleEditor = new Role(3);
//		Role roleSalesperson = new Role(2);
//		
//		user.getRoles().remove(roleEditor);
//		user.addRole(roleSalesperson);
//		
//		repo.save(user);
//	}
//	
//	@Test
//	public void testDeleteUser() {
//		Integer userId = 2;
//		repo.deleteById(userId);
//		
//	}
}
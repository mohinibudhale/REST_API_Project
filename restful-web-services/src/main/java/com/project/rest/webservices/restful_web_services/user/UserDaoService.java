package com.project.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int userCounts=0;
	
	static {
		users.add(new User(++userCounts,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++userCounts,"Mona",LocalDate.now().minusYears(27)));
		users.add(new User(++userCounts,"Sean",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User findById(int id)
	{
		
		Predicate<? super User> predicate = user -> user.getId()==id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User save(User user)
	{
		user.setId(++userCounts);
		users.add(user);		
		return user;
	}
	
	public void deleteById(int id)
	{
		
		Predicate<? super User> predicate = user -> user.getId()==id;
		users.removeIf(predicate);
	}
}

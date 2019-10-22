package com.hcl.SpringBootJPADemo.Service;

import java.util.List;
import java.util.Optional;

import com.hcl.SpringBootJPADemo.Model.User;

public interface UserService {
	public List<User> findAll();

	public long count();

	public void delete(User arg0);

	public void deleteAll();

	public void deleteById(Integer arg0);

	public boolean existsById(Integer arg0);

	public Optional<User> findById(Integer id);

	public User findByUserIdAndPassword(Integer id, String password);

	public List<User> findByUserIdOrPassword(Integer id, String password);

	public User createUser(User user);

	public User updateUser(User user);

	public List<User> queryFetching();

	public List<User> nativeQueryFetching();

	public User findUserByIdQuery(Integer userid);

	public List<User> nativeQuerySearching( int id);

}

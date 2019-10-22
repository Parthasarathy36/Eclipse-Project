package com.hcl.SpringBootJPADemo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.SpringBootJPADemo.Model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

	public User findByUserIdAndPassword(int id, String password);

	public List<User> findByUserIdOrPassword(int id, String password);

	@Query("SELECT u FROM User u")
	public List<User> queryFetching();

	@Query(value = "SELECT * FROM user ", nativeQuery = true)
	public List<User> nativeQueryFetching();
	
	@Query(value = "SELECT * FROM user where userid=:id ", nativeQuery = true)
	public List<User> nativeQuerySearching(@Param("id") int id);

	@Query("SELECT u FROM User u WHERE u.userId = ?1")
	public User findUserByIdQuery(Integer userId);

}

package com.hcl.SpringBootJPADemo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.SpringBootJPADemo.DAO.UserDAO;
import com.hcl.SpringBootJPADemo.Model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	@Override
	public List<User> findAll() {
		return (List<User>) userDAO.findAll();
	}

	@Transactional
	@Override
	public long count() {
		return userDAO.count();
	}

	@Transactional
	@Override
	public void delete(User arg0) {

		userDAO.delete(arg0);

	}

	@Transactional
	@Override
	public void deleteAll() {
		userDAO.deleteAll();

	}

	@Transactional
	@Override
	public void deleteById(Integer arg0) {
		userDAO.deleteById(arg0);

	}

	@Transactional
	@Override
	public boolean existsById(Integer arg0) {
		return userDAO.existsById(arg0);
	}

	@Transactional
	@Override
	public Optional<User> findById(Integer id) {
		return userDAO.findById(id);
	}

	@Transactional
	@Override
	public User findByUserIdAndPassword(Integer id, String password) {
		return (userDAO).findByUserIdAndPassword(id, password);
	}

	@Transactional
	@Override
	public List<User> findByUserIdOrPassword(Integer id, String password) {
		return userDAO.findByUserIdOrPassword(id, password);
	}

	@Transactional
	@Override
	public User createUser(User user) {
		return userDAO.save(user);
	}

	@Transactional
	@Override
	public User updateUser(User user) {
		return userDAO.save(user);
	}

	@Transactional
	@Override
    public List<User> queryFetching(){
    	return userDAO.queryFetching();
    }

	@Override
	public List<User> nativeQueryFetching() {
		return userDAO.nativeQueryFetching();
	}

	@Override
	public User findUserByIdQuery(Integer userid) {
		return userDAO.findUserByIdQuery(userid);
	}

	@Override
	public List<User> nativeQuerySearching(int id) {
		return userDAO.nativeQuerySearching(id);
	}

}

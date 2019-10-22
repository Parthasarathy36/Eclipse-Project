package com.hcl.SpringBootJPADemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.SpringBootJPADemo.Model.User;
import com.hcl.SpringBootJPADemo.Service.UserService;

@RestController
public class MainController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getAll")
	public List<User> ReadAll() {
		return userService.findAll();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, headers = "Accept=application/json")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@RequestMapping(value = "/count")
	public long count() {
		return userService.count();
	}

	@RequestMapping(value = "/queryFetching")
	public List<User> queryFetching() {
		return userService.queryFetching();
	}

	@RequestMapping(value = "/nativeQueryFetching")
	public List<User> nativeQueryFetching() {
		return userService.nativeQueryFetching();
	}

	@RequestMapping(value = "/nativeQuerySearching/{id}")
	public List<User> nativeQuerySearching(@PathVariable("id") int id) {
		return userService.nativeQuerySearching(id);
	}
	@DeleteMapping(value = "/deleteSingleUser/{id}")
	public void delete(@PathVariable("id") User arg0) {
		userService.delete(arg0);

	}

	@RequestMapping(value = "/deleteAll")
	public void deleteAll() {
		userService.deleteAll();

	}

	@RequestMapping(value = "/deleteById")
	public void deleteById(Integer arg0) {
		userService.deleteById(arg0);

	}

	@RequestMapping(value = "/exist")
	public boolean existsById(Integer arg0) {
		return userService.existsById(arg0);
	}

	@RequestMapping(value = "/findById/{id}")
	public Optional<User> findById(@PathVariable("id") Integer arg0) {
		return userService.findById(arg0);
	}

	@RequestMapping(value = "/findByIdQuery/{id}")
	public User findByIdQuery(@PathVariable("id") Integer userid) {
		return userService.findUserByIdQuery(userid);
	}

	@RequestMapping(value = "/findByParameters/{id}/{password}", method = RequestMethod.POST, headers = "Accept=application/json")
	public User findByUserIdAndPassword(@PathVariable("id") int id, @PathVariable("password") String password) {

		return userService.findByUserIdAndPassword(id, password);
	}

	@RequestMapping(value = "/findByOrParameters/{id}/{password}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<User> findByUserOrAndPassword(@PathVariable("id") int id, @PathVariable("password") String password) {

		return userService.findByUserIdOrPassword(id, password);
	}

}

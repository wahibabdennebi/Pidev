package tp.spring.boot.piedvdari.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.spring.boot.piedvdari.entities.User;

import tp.spring.boot.piedvdari.service.IUserService;

@RestController
@RequestMapping("User")
class UserController {
	@Autowired
	IUserService iuserService;
	//http://localhost:8084/User/user
	@PostMapping("/user")
	public ResponseEntity <User> ajouterUser(@RequestBody User bb){
		User newuser = iuserService.ajouterUser(bb);
		return new ResponseEntity<>(newuser,HttpStatus.CREATED);
		 }
	//http://localhost:8084/all/user
	@GetMapping("/all/user")
	 public ResponseEntity <List<User>> FindallUser(){
		 List<User> useruser=iuserService.FindallUser();
		 return new ResponseEntity<>(useruser,HttpStatus.OK);
	 }
	
}

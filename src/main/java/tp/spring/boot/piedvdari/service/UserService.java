package tp.spring.boot.piedvdari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.spring.boot.piedvdari.entities.User;
import tp.spring.boot.piedvdari.repositary.IRepsitaryUser;

@Service
public class UserService implements IUserService {
	@Autowired
	IRepsitaryUser irepositaryuser;

	@Override
	public User ajouterUser(User b) {
		// TODO Auto-generated method stub
		return irepositaryuser.save(b);
	}

	@Override
	public List<User> FindallUser() {
		// TODO Auto-generated method stub
		return irepositaryuser.findAll();
	}
	

}

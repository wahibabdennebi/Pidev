package tp.spring.boot.piedvdari.service;

import java.util.List;

import tp.spring.boot.piedvdari.entities.User;

public interface IUserService {
	public User ajouterUser(User b);
	public List<User> FindallUser();

}

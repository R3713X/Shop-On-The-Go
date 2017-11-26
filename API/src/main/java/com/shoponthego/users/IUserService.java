package com.shoponthego.users;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {

	public List<IUser> getUsers();
	public IUser getUser(String userId);
	public void deleteUser(String userId);
	public void addUser(IUser user);
	public void updateUser(String userId, IUser user);
}

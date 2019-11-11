package com.softtron.pinmaozx.services;

import java.util.Iterator;
import java.util.Set;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Service;
import com.softtron.pinmaozx.daos.UserDao;
import com.softtron.pinmaozx.domains.TUser;

@Service
public class UserService {
	@Autowried
	UserDao userDao;
	public TUser valid(TUser user) {
		Set set = userDao.findUserByUsername(user);
		Iterator it = set.iterator();
		while (it.hasNext()) {
			return (TUser) it.next();
		}
		throw new NullPointerException();

	}
	public TUser login(TUser user) {
		Set set = userDao.findUser(user);
		Iterator it = set.iterator();
		while (it.hasNext()) {
			return (TUser) it.next();
		}
		throw new NullPointerException();

	}
	public void updateUser(TUser user) {
		userDao.update(user);
	}
	
	public TUser findUserByToken(String token) {
		Set set = userDao.findUserByToken(token);
		Iterator<TUser> it =set.iterator();
		while(it.hasNext()){
			return it.next();
		}
		return null;
	}
	
	
}

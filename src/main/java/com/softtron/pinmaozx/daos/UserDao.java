package com.softtron.pinmaozx.daos;

import java.util.Set;

import com.softtron.pinmaozx.domains.TUser;

public interface UserDao {
	public Set<TUser> findUser(TUser user);

	public Set<TUser> findUserByUsername(TUser user);

	public void update(TUser user);

	public Set<TUser> findUserByToken(String token);
}

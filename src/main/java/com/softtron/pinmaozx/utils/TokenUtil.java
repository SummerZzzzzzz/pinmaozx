package com.softtron.pinmaozx.utils;

import java.util.HashMap;
import java.util.Map;

import com.softtron.pinmaoserver.controllers.CommonController;
import com.softtron.pinmaozx.domains.TUser;
import com.softtron.pinmaozx.services.UserService;

public class TokenUtil {
  static UserService userService;
  private static Map<String,TUser> tokenMap = new HashMap<>();	
  public static void saveToken(String token,TUser user) {
	  tokenMap.put(token,user);
  }
  public static TUser findUser(String token) {
	  if(token==""||token==null) {
		  return null;
	  }
	  userService = (UserService) CommonController.serviceMap.get(UserService.class.getName());
	  TUser user = null;
	  user = tokenMap.get(token);
	  if(user==null) {
		  return userService.findUserByToken(token);
	  }else {
		  return user;
	  }

  }
}

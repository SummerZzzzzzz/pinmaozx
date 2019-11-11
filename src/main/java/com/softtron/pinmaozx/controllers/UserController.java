package com.softtron.pinmaozx.controllers;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Controller;
import com.softtron.pinmaoserver.annotations.NotNull;
import com.softtron.pinmaoserver.annotations.RequestBody;
import com.softtron.pinmaoserver.annotations.RequestMapping;
import com.softtron.pinmaoserver.annotations.Result;
import com.softtron.pinmaozx.domains.TUser;
import com.softtron.pinmaozx.services.UserService;
import com.softtron.pinmaozx.utils.TokenUtil;

@Controller(url = "/user")
public class UserController {
	@Autowried
	UserService uservice;

	@RequestMapping(url = "/login.htm")
	public Map login(@Result Map resultMap, @RequestBody @NotNull(message = "用户信息不能为空", state = "500") TUser user,HttpServletRequest re)
			throws Exception {
		resultMap.put("message", "操作成功");
		// 验证用户名是否存在
		try {
			uservice.valid(user);
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				throw new Exception("用户名不存在");
			}
			throw e;
		}
		try {
			TUser iuser = uservice.login(user);
			resultMap.put("ob", iuser);
			//re.getSession().setAttribute("user", iuser);
			String token = UUID.randomUUID().toString();//钥匙
			iuser.setToken(token);
			iuser.setPassword(null);
			iuser.setLoginTime(new Date());
			TokenUtil.saveToken(token, iuser);
			uservice.updateUser(iuser);
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				throw new Exception("用户名或密码错误");
			}
			throw e;

		}
		resultMap.put("state", "200");
		return resultMap;
	}
}

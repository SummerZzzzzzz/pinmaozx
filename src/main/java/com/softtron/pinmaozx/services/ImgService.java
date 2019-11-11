package com.softtron.pinmaozx.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.softtron.pinmaoserver.annotations.Autowried;
import com.softtron.pinmaoserver.annotations.Service;
import com.softtron.pinmaoserver.utils.FileUtil;
import com.softtron.pinmaozx.daos.ImgDao;
import com.softtron.pinmaozx.domains.TImg;
@Service
public class ImgService {
	@Autowried
	ImgDao imgDao;
    public Set insert(HttpServletRequest request) throws IllegalStateException, IOException, ServletException, URISyntaxException {
    	Set<String>sets = FileUtil.uploadFiles(request);
    	String folder = FileUtil.uploadFolder;
    	for(String url:sets){
    		//插入数据库
    		TImg img = new TImg();
    		img.setImgPath(url.substring(url.indexOf(folder)));
    	    imgDao.insert(img);
    	}
    	return sets;
    }
}

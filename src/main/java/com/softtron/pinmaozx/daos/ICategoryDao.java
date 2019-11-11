package com.softtron.pinmaozx.daos;

import java.sql.SQLException;
import java.util.Set;

import com.softtron.pinmaozx.domains.TCategory;

public interface ICategoryDao {
	public Integer insertCategory(TCategory category) throws ClassNotFoundException, SQLException;
	public void updateCategory(TCategory category) throws Exception;
	public Set<TCategory> findAllCategory() throws Exception;
	public void deleteCategory(int categoryId) throws Exception;
}

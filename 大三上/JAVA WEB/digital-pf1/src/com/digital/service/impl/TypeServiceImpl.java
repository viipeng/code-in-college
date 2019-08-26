package com.digital.service.impl;

import java.util.List;

import com.digital.dao.TypeDAO;
import com.digital.entity.Type;
import com.digital.service.TypeService;

public class TypeServiceImpl implements TypeService {

	private TypeDAO typeDAO;
	
	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	@Override
	public List<Type> getAll() {
		return typeDAO.getAll();
	}

}

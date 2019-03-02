package com.smoothstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.Idao.ILibraryBranchDao;
import com.smoothstack.entity.LibraryBranch;

@Service
@Transactional
public class LibraryBranchService {

	@Autowired
	private ILibraryBranchDao branchDao;

	public LibraryBranch getById(long id) {
		return branchDao.getOne(id);
	}

	public List<LibraryBranch> getAll() {
		return branchDao.findAll();
	}

	public void create(LibraryBranch libraryBranch) {
		branchDao.save(libraryBranch);
	}

	public void update(LibraryBranch libraryBranch) {
		branchDao.save(libraryBranch);
	}

	public void delete(long id) {
		branchDao.deleteById(id);
	}

}

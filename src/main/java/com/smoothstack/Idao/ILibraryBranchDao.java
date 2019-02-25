package com.smoothstack.Idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.entity.LibraryBranch;

public interface ILibraryBranchDao extends JpaRepository<LibraryBranch, Long> {

}

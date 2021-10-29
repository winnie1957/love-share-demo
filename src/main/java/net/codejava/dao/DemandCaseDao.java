package net.codejava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.DemandCase;

public interface DemandCaseDao extends JpaRepository<DemandCase, Long> {

}

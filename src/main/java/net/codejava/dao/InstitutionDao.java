package net.codejava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.Institution;

public interface InstitutionDao extends JpaRepository<Institution, Long> {

}

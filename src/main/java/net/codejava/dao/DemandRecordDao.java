package net.codejava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.entity.DemandRecord;

public interface DemandRecordDao extends JpaRepository<DemandRecord, Long> {

}

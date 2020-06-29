package com.yhoyos.bill.infrastructure.repository.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhoyos.bill.infrastructure.repository.entity.BillEntity;

public interface BillRepositoryJpa extends JpaRepository<BillEntity, Long>{

}

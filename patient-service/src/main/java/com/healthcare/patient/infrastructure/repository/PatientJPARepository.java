package com.healthcare.patient.infrastructure.repository;

import com.healthcare.patient.infrastructure.out.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientJPARepository extends JpaRepository<PatientEntity, String> {

    Optional<PatientEntity> findById(String id);

    @Override
    boolean existsById(String s);

    @Override
    PatientEntity save(PatientEntity entity);

    @Override
    List<PatientEntity> findAll();

    @Override
    void deleteById(String s);
}

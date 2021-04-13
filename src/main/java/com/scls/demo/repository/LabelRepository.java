package com.scls.demo.repository;

import com.scls.demo.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * LabelRepository extends the class JpaRepository thus inheriting its methods. It is an interface for the
 * Label entity.
 * This class doesn't need to be implemented by the programmer because Spring will automatically implement
 * it during runtime.
 */
@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
}

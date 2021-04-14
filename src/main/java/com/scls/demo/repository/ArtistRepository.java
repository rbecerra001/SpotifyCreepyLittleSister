package com.scls.demo.repository;

import com.scls.demo.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * ArtistRepository extends the class JpaRepository thus inheriting its methods. It is an interface for the
 * Artist entity.
 * This class doesn't need to be implemented by the programmer because Spring will automatically implement
 * it during runtime.
 */
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByUserId(Long userId);
    Optional<Artist> findByIdAndUserId(Long artistId, Long userId);
}

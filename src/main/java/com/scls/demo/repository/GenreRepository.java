package com.scls.demo.repository;

import com.scls.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * GenreRepository extends the class JpaRepository thus inheriting its methods. It is an interface for the
 * Genre entity.
 * This class doesn't need to be implemented by the programmer because Spring will automatically implement
 * it during runtime.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findByUserId(Long userId);
    Genre findByIdAndUserId(Long genreId, Long userId);
    Genre findByUserIdAndName(Long userId, String genreName);
}

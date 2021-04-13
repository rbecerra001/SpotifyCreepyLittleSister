package com.scls.demo.repository;

import com.scls.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * SongRepository extends the class JpaRepository thus inheriting its methods. It is an interface for the
 * Song entity.
 * This class doesn't need to be implemented by the programmer because Spring will automatically implement
 * it during runtime.
 */
@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}

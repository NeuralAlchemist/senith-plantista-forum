package se.kth.sda.skeleton.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    @TODO extend the appropriate JpaRepository to get common database operations for Post
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

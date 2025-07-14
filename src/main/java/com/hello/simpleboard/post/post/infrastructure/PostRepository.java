package com.hello.simpleboard.post.post.infrastructure;

import com.hello.simpleboard.post.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

package br.com.lhamello.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lhamello.codeblog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}

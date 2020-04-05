package br.com.lhamello.codeblog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lhamello.codeblog.model.Post;
import br.com.lhamello.codeblog.repository.PostRepository;
import br.com.lhamello.codeblog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(final PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  @Override
  public Post findById(final long id) {
    return postRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Não encontrado post com id = %d.", id)));
  }

  @Override
  public Post save(final Post post) {
    return postRepository.save(post);
  }
}

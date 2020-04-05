package br.com.lhamello.codeblog.service;

import java.util.List;

import br.com.lhamello.codeblog.model.Post;

public interface PostService {

  List<Post> finalAll();

  Post findById(final long id);

  Post save(final Post post);
}

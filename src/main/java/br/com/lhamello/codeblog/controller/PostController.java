package br.com.lhamello.codeblog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.lhamello.codeblog.model.Post;
import br.com.lhamello.codeblog.service.PostService;

@Controller
public class PostController {

  private final PostService postService;

  public PostController(final PostService postService) {
    this.postService = postService;
  }

  @RequestMapping(value = "/posts", method = RequestMethod.GET)
  public ModelAndView getPosts() {
    ModelAndView modelView = new ModelAndView("posts");
    List<Post> posts = postService.findAll();
    modelView.addObject("posts", posts);
    return modelView;
  }
}

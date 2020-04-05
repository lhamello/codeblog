package br.com.lhamello.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

  @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
  public ModelAndView getPostDetails(@PathVariable("id") final long id) {
    ModelAndView modelView = new ModelAndView("postDetails");
    Post post = postService.findById(id);
    modelView.addObject("post", post);
    return modelView;
  }

  @RequestMapping(value = "/newpost", method = RequestMethod.GET)
  public String getPostForm() {
    return "postForm";
  }

  @RequestMapping(value = "/newpost", method = RequestMethod.POST)
  public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
    if (result.hasErrors()) {
      return "redirect:/newpost";
    }

    post.setData(LocalDate.now());
    postService.save(post);

    return "redirect:/posts";
  }
}

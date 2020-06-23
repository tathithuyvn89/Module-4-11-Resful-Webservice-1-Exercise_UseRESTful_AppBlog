package myapp.controller;

import myapp.model.Blog;
import myapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @ModelAttribute("blogs")
    public List<Blog> getBlogList(){
        return blogService.findAll();
    }
    @GetMapping("/create-blog")
    private ModelAndView showCreateBlogForm(){
        ModelAndView modelAndView = new ModelAndView("blogs/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
    @PostMapping("/create-blog")
    private ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog){
        blogService.saveBlog(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/create-blog");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message","New Blog create successfully");
        return modelAndView;
    }
    @GetMapping("/create-blog/{id}/delete")
    private String deleteBlog(@PathVariable long id){
        blogService.deleteBlog(id);
        return "redirect:/create-blog";
    }
    @GetMapping("/create-blog/{id}/edit")
    private String editBlog(@PathVariable long id, Model model){
        Blog blog = blogService.findBlog(id);
        model.addAttribute("blog",blog);
        return "blogs/edit";
    }
    @PostMapping("/edit")
    private String edit(Blog blog , RedirectAttributes redirect){
        blogService.updateBlog(blog);
        redirect.addFlashAttribute("success","Updatesuccess");
        return "redirect:/create-blog";
    }
    @GetMapping("/create-blog/{id}/view")
    private String viewBlog(@PathVariable long id, Model model){
        Blog blog = blogService.findBlog(id);
        model.addAttribute("blog",blog);
        return "blogs/view";
    }

}

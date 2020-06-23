package myapp.service;

import myapp.model.Blog;

import java.util.List;

public interface BlogService {
    void saveBlog( Blog model);
    Blog findBlog(long id);
    List<Blog> findAll();
    void updateBlog(Blog blog);
    void deleteBlog(long id);
}

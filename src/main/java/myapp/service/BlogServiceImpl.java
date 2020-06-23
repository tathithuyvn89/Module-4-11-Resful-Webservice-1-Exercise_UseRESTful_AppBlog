package myapp.service;

import myapp.model.Blog;
import myapp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public void saveBlog(Blog model) {
        blogRepository.saveBlog(model);

    }

    @Override
    public Blog findBlog(long id) {
       Blog blog= blogRepository.findBlog(id);
       return blog;
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.updateBlog(blog);

    }

    @Override
    public void deleteBlog(long id) {
        blogRepository.deleteBlog(id);

    }
}

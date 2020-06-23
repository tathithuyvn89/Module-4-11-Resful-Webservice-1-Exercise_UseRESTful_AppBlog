package myapp.repository;

import java.util.List;

public interface Repository<T> {
    void saveBlog(T model);
    T findBlog(long id);
    List<T> findAll();
    void updateBlog(T model);
    void deleteBlog(long id);

}

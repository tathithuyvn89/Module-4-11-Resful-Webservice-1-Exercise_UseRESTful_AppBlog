package myapp.repository;

import myapp.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
   @PersistenceContext
   private EntityManager em;


    @Override
    public void saveBlog(Blog model) {
        em.persist(model);
    }

    @Override
    public Blog findBlog(long id) {
        TypedQuery<Blog> query= em.createQuery("select c from Blog c where c.id=:id",Blog.class);
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }

    }

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select c from Blog c",Blog.class);
        return query.getResultList();
    }

    @Override
    public void updateBlog(Blog blog) {
           em.merge(blog);
    }

    @Override
    public void deleteBlog(long id) {
        Blog blog= findBlog(id);
        if(blog!=null){
            em.remove(blog);
        }
    }
}

package SpringDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class BlogDaoImpl implements BlogDao {
    @Override
    public Blog getBlogById(int id) {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Blog theBlog=session.get(Blog.class, id);
        return theBlog;
    }

    @Override
    public String addThis(Blog blogModel) {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(blogModel);
        transaction.commit();
        return "Blog Submitted Sucessfully";
    }

    @Override
    public List<Blog> getBlogs() {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Query resultQuery=session.createQuery("from Blog order by id");
        List<Blog> blogModelArrayList= ((org.hibernate.query.Query) resultQuery).list();
        return  blogModelArrayList;
    }

    @Override
    public String updateBlog(Blog theblog) {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();

        Blog currentBlog=session.find(Blog.class, theblog.getId());
        currentBlog.setContent(theblog.getContent());
        currentBlog.setTitle(theblog.getTitle());
        session.update(currentBlog);
        transaction.commit();
        return "update successfully";
    }

    @Override
    public String deleteBlog(Blog theblog) {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();

        Blog currentBlog=session.find(Blog.class, theblog.getId());
        session.remove(currentBlog);
        transaction.commit();
        return "delete successfully";
    }
}

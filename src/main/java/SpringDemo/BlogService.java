package SpringDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.List;
@Service
public class   BlogService {


    public  Blog getBlogById(int id) {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();
        Blog theBlog=session.get(Blog.class, id);
        return theBlog;
    }

    public String addThis(Blog blogModel)
    {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(blogModel);
        transaction.commit();
        return "Blog Submitted Sucessfully";
    }


    public List<Blog> getBlogs()
    {
        Configuration configuration= new Configuration().configure().addAnnotatedClass(Blog.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        Query resultQuery=session.createQuery("from Blog order by id");
        List<Blog> blogModelArrayList= ((org.hibernate.query.Query) resultQuery).list();
        return  blogModelArrayList;
    }

    public  String updateBlog(Blog theblog){
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

    public  String deleteBlog(Blog theblog){
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
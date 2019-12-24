package SpringDemo;

import java.util.List;

public interface BlogService1 {
    public  Blog getBlogById(int id);

    public String addThis(Blog blogModel);

    public List<Blog> getBlogs();

    public  String updateBlog(Blog theblog);

    public  String deleteBlog(Blog theblog);
}

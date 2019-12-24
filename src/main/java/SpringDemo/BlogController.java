package SpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Component
@RequestMapping("/blog")
public class BlogController {

    @RequestMapping(value = "/create",method = RequestMethod.GET)

    public String processBlog(Model theModel) {
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        Blog theBlog=context.getBean("blogObj",Blog.class);
        theModel.addAttribute("BlogModel",theBlog);
        return "blog-home";

    }
    @RequestMapping(value = "/allBlog", method = RequestMethod.GET)
    public ModelAndView displayAllUser() {
        System.out.println("User Page Requested : All Users");
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        BlogService obj = context.getBean("blogServiceObj", BlogService.class);
        ModelAndView mv = new ModelAndView();
        List userList = obj.getBlogs();
        mv.addObject("userList", userList);
        mv.setViewName("list-blogs");
        return mv;
    }

    @RequestMapping(value = "/createConfirm",method = RequestMethod.POST)
    public ModelAndView processBlog(@ModelAttribute("BlogModel") Blog blogModel) {

        ModelAndView modelAndView = new ModelAndView();
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        BlogService obj = context.getBean("blogServiceObj",BlogService.class);
        String result = obj.addThis(blogModel);
        modelAndView.setViewName("BlogConfirmation");
        modelAndView.addObject("processResult",result);
        return modelAndView;
    }

    @RequestMapping(value = "/editConfirm",method = RequestMethod.POST)
    public ModelAndView editConfirm(@ModelAttribute("blog") Blog blogModel) {

        ModelAndView modelAndView = new ModelAndView();
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        BlogService obj = context.getBean("blogServiceObj",BlogService.class);
        String result = obj.updateBlog(blogModel);
        modelAndView.setViewName("BlogConfirmation");
        modelAndView.addObject("processResult",result);
        return modelAndView;
    }

    @RequestMapping (value = "/showBlogForUpdate/{id}")
    public ModelAndView displayEditBlog(@PathVariable("id") int id){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        BlogService obj = context.getBean("blogServiceObj",BlogService.class);

        Blog theBlog=obj.getBlogById(id);
        ModelAndView mv=new ModelAndView();
       mv.addObject("blog",theBlog);
       mv.setViewName("updateblog");
        return mv;

    }

    @RequestMapping (value = "/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable("id") int id){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        BlogService obj = context.getBean("blogServiceObj",BlogService.class);
        Blog theBlog=obj.getBlogById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("blog",theBlog);
        mv.setViewName("deleteConfirm");
        return mv;

    }
    @RequestMapping(value = "/showById/{id}")
    public ModelAndView showById(@PathVariable("id") int id){
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        BlogService obj = context.getBean("blogServiceObj",BlogService.class);
        Blog theBlog=obj.getBlogById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("blog",theBlog);
        mv.setViewName("showBlogById");
        return mv;
    }

    @RequestMapping(value = "/deleteOk",method = RequestMethod.POST)
    public ModelAndView deleteFianl(@ModelAttribute("blog") Blog blogModel) {

        ModelAndView modelAndView = new ModelAndView();
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext1.xml");
        BlogService obj = context.getBean("blogServiceObj",BlogService.class);
        String result = obj.deleteBlog(blogModel);
        modelAndView.setViewName("BlogConfirmation");
        modelAndView.addObject("processResult",result);
        return modelAndView;
    }

//    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
//    public ModelAndView displayEditUserForm(@PathVariable int id) {
//        ModelAndView mv = new ModelAndView("/editUser");
//        Blog theBlog = BlogService.getBlogById(Math.toIntExact(id));
//        mv.addObject("headerMessage", "Edit User Details");
//        mv.addObject("user", theBlog);
//        return mv;
//    }


}



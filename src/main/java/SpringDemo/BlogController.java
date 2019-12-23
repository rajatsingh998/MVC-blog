package SpringDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String processBlog(Model theModel) {
        Blog theBlog=new Blog();
        theModel.addAttribute("BlogModel",theBlog);
        return "blog-home";

    }

    @RequestMapping(value = "/createConfirm",method = RequestMethod.POST)
    public ModelAndView processBlog(@ModelAttribute("BlogModel") Blog blogModel) {

        ModelAndView modelAndView = new ModelAndView();
        BlogService obj = new BlogService();
        String result = obj.addThis(blogModel);
        modelAndView.setViewName("BlogConfirmation");
        modelAndView.addObject("processResult",result);
        return modelAndView;
    }
    @RequestMapping(value = "/allBlog", method = RequestMethod.GET)
    public ModelAndView displayAllUser() {
        System.out.println("User Page Requested : All Users");
        BlogService obj = new BlogService();
        ModelAndView mv = new ModelAndView();
        List userList = obj.getBlogs();
        mv.addObject("userList", userList);
        mv.setViewName("list-blogs");
        return mv;
    }
    @RequestMapping(value = "/editConfirm",method = RequestMethod.POST)
    public ModelAndView editConfirm(@ModelAttribute("blog") Blog blogModel) {

        ModelAndView modelAndView = new ModelAndView();
        BlogService obj = new BlogService();

        String result = obj.updateBlog(blogModel);
        modelAndView.setViewName("BlogConfirmation");
        modelAndView.addObject("processResult",result);
        return modelAndView;
    }

    @RequestMapping (value = "/showBlogForUpdate/{id}")
    public ModelAndView displayEditBlog(@PathVariable("id") int id){
        BlogService obj = new BlogService();
        Blog theBlog=obj.getBlogById(id);
        ModelAndView mv=new ModelAndView();
       mv.addObject("blog",theBlog);
       mv.setViewName("updateblog");
        return mv;

    }

    @RequestMapping (value = "/delete/{id}")
    public ModelAndView deleteBlog(@PathVariable("id") int id){
        BlogService obj = new BlogService();
        Blog theBlog=obj.getBlogById(id);
        ModelAndView mv=new ModelAndView();
        mv.addObject("blog",theBlog);
        mv.setViewName("deleteConfirm");
        return mv;

    }
    @RequestMapping(value = "/deleteOk",method = RequestMethod.POST)
    public ModelAndView deleteFianl(@ModelAttribute("blog") Blog blogModel) {

        ModelAndView modelAndView = new ModelAndView();
        BlogService obj = new BlogService();

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



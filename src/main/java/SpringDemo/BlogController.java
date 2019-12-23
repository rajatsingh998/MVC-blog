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

    @GetMapping(value = "/showBlogForUpdate")
    public String displayEditBlog(@RequestParam("blogId") int id, Model theModel){
        BlogService obj = new BlogService();
        Blog theBlog=obj.getBlogById(id);

        theModel.addAttribute("blog",theBlog);

        return"list-blogs";

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



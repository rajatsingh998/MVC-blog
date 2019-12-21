package SpringDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class BlogController {
    @RequestMapping("/blogshow")
public String showblog(Model theModel){
    Blog theBlogger= new Blog();

    theModel.addAttribute("blogger", theBlogger);
    return "blog-home";
}

 @RequestMapping("/processForm")
 public String processFormm(){

        return "blog-confirmation";
 }
}



package demo.controller;

import demo.model.Blog;
import demo.model.Category;
import demo.service.BlogService;
import demo.service.ITFBlogService;
import demo.service.ITFCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    ITFBlogService blogService;
    @Autowired
    ITFCategoryService categoryService;

    @GetMapping("")
    public String showList(Model model) throws SQLException {
        List<Blog> blogList = blogService.printAll();
        List<Category> categoryList = allCategory(blogList);
        model.addAttribute("blogs", blogList);
        model.addAttribute("categorys", categoryList);
        return "/index";
    }

    @GetMapping("create")
    public String showCreate() {
        return "/create";
    }

    @PostMapping("create")
    public String createBlog(Blog blog) throws SQLException {
        blogService.add(blog);
        return "redirect:/blogs";
    }

    public List<Category> allCategory(List<Blog> blogs) throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        for (Blog blog : blogs) {
            Category category = categoryService.findById(blog.getIdCategory());
            categoryList.add(category);
        }
        return categoryList;
    }

    @GetMapping("edit")
    public String showEdit(Model model,  int id) throws SQLException {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/edit";
    }
    @PostMapping("edit")
    public String edit(Blog blog,int id) throws SQLException {
        blogService.edit(id,blog);
        return "redirect:/blogs";
    }
    @GetMapping("delete")
    public String delete(int id) throws SQLException {
        blogService.delete(id);
        return "redirect:/blogs";
    }

}

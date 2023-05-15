package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Company;
import peaksoft.entities.Course;
import peaksoft.service.CompanyService;
import peaksoft.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final CourseService courseService;
    @Autowired
    public CompanyController(CompanyService companyService, CourseService courseService) {
        this.companyService = companyService;
        this.courseService = courseService;
    }
@GetMapping()
    public String getAllCompanies(Model model){
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "company/companies";
    }


//    new code third may
    @GetMapping("addCompany")
    public String addCompany(Model model){
        model.addAttribute("company", new Company());
        return "company/addCompany";
    }
    @PostMapping("saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.addCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/update/{id}")
    public String updateCompany(@PathVariable("id") Long id, Model model){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("updateCompany", company);
        return "company/updateCompany";
    }
    @PatchMapping("{id}")
    public String saveUpdateCompany(@PathVariable("id")Long id, @ModelAttribute("company") Company company){
        companyService.updateCompany(id, company);
        return "redirect:/companies";
    }
    @DeleteMapping("/delete")
    public String deleteCompany(@RequestParam("id") Long id){
        Company company = companyService.getCompanyById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/courses/{companyId}")
    public String getCourseByCompanyId(@PathVariable("companyId")Long companyId, Model model){
        List<Course> courseList = courseService.getCourseByCompany(companyId);
        model.addAttribute("courseList", courseList);
        model.addAttribute("count", courseList.size());
        return "company/courses";
    }
    @GetMapping("/search")
    public String getCourseByName(Model model, String name){
        List<Course> courses = courseService.getCourseByName(name);
        List<Course> courseList = courseService.getAllCourses();
        if (name != null){
            model.addAttribute("courses", courses);
        }else {
            model.addAttribute("courses", courseList);
        }
        return "company/getCourses";
    }
}

/**
 * Created by Dawid Stankiewicz on 19.07.2016
 */
package edu.adrianKozlowski.forum.controller;

import edu.adrianKozlowski.forum.service.SectionService;
import javax.validation.Valid;

import edu.adrianKozlowski.forum.controller.form.NewSectionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.adrianKozlowski.forum.entity.Role;
import edu.adrianKozlowski.forum.entity.Section;
import edu.adrianKozlowski.forum.entity.User;
import edu.adrianKozlowski.forum.service.RoleService;
import edu.adrianKozlowski.forum.service.TopicService;
import edu.adrianKozlowski.forum.service.UserService;


@Controller
@RequestMapping("/section/")
public class SectionController {
    
    @Autowired
    private SectionService sectionService;
    
    @Autowired
    private TopicService topicService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @RequestMapping("{id}")
    public String getTopicsFromSection(@PathVariable int id,
                                       Model model) {
        model.addAttribute("section", sectionService.findOne(id));
        model.addAttribute("topics", topicService.findBySection(id));
        return "section";
    }
    
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String getNewSectionForm(Model model) {
        model.addAttribute("newSection", new NewSectionForm());
        return "new_section_form";
    }
    
    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String processAndAddNewSection(
                                          @Valid @ModelAttribute("newSection") NewSectionForm newSection,
                                          BindingResult result) {
        
        if (result.hasErrors()) {
            return "new_section_form";
        }
        
        Section section = new Section();
        section.setName(newSection.getName());
        section.setDescription(newSection.getDescription());
        section = sectionService.save(section);
        return "redirect:/section/" + section.getId();
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id,
                         Authentication authentication,
                         RedirectAttributes model) {
        User user = userService.findByUsername(authentication.getName());
        Role adminRole = roleService.findByName("ADMIN");
        if (!user.getRoles().contains(adminRole)) {
            return "redirect:/section/" + id;
        }
        sectionService.delete(id);
        
        model.addFlashAttribute("message", "section.successfully.deleted");
        return "redirect:/home";
    }
    
}

package com.lalo104lucky.CVDEJF.controller;

import com.lalo104lucky.CVDEJF.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillsController {

    private final List<Skill> skills = new ArrayList<>();

    /*@GetMapping({"/", ""})
    public String skills(Model model) {
        List<String> skills = List.of("Jave", "Spring Boot", "Thymeleaf", "HTML", "CSS");
        List<String> list = new ArrayList<>();

        model.addAttribute("skills", list);

        return "skills";
    }*/

//    @GetMapping({"/", ""})
//    public String showSkills(Model model) {
//        model.addAttribute("skills", skills);
//        return "skills";
//    }

//    @GetMapping({"/", ""})
//    public String showSkills(Model model) {
//        model.addAttribute("skills", skills);
//        return "skills";
//    }

    @GetMapping({"/", ""})
    public String showSkills(@RequestParam(defaultValue = "", required = false) String filter, Model model) {
        List<Skill> skillsFilter = skills.stream()
                        .filter(skill -> skill.getName().toLowerCase().contains(filter.toLowerCase()))
                                .toList();
        model.addAttribute("skills", skillsFilter);
        model.addAttribute("filter", filter);
        return "skills";
    }

    @GetMapping("/id/{index}")
    public String showSkillDetail(@PathVariable int index, Model model) {
        if(index>=0 && index< skills.size()) {
            Skill skill = skills.get(index);
            model.addAttribute("skill", skill);
            return "skill-detail";
        }
        return "redirect:/skills";
    }

    @GetMapping("/filter/{name}/{level}")
    public String showFilteredSkill(@PathVariable String name, @PathVariable String level, Model model) {
        List<Skill> skillFilter = skills.stream()
                .filter(skill -> skill.getName().equalsIgnoreCase(name)
                && skill.getLevel().equalsIgnoreCase(level))
                .toList();
        model.addAttribute("skills", skillFilter);

        model.addAttribute("filterMessage", "Filtro: " + name + " - " + level);
        return "skills";
    }

//    @GetMapping("/name/{name}")
//    public String showFilteredSkillName(@PathVariable String name, Model model) {
//        List<Skill> skillFilter = skills.stream()
//                .filter(skill -> skill.getName().equalsIgnoreCase(name))
//                .toList();
//        if(skillFilter.isEmpty()) {
//            model.addAttribute("filterMeesage", "No se encontraron resultados para: " + name);
//            return "forward:/skills";
//        }
//        model.addAttribute("skills", skillFilter);
//        model.addAttribute("filterMessage", "Filtro: " + name);
//        return "skills";
//    }

//    @GetMapping("/name/{name}")
//    public String showFilteredSkillName(@PathVariable String name, RedirectAttributes redirectAttributes) {
//        List<Skill> skillFilter = skills.stream()
//                .filter(skill -> skill.getName().equalsIgnoreCase(name))
//                .toList();
//        if(skillFilter.isEmpty()) {
//            redirectAttributes.addFlashAttribute("filterMeesage", "No se encontraron resultados para: " + name);
//            return "redirect:/skills?filter="+name;
//        }
//        redirectAttributes.addFlashAttribute("skills", skillFilter);
//        redirectAttributes.addFlashAttribute("filterMeesage", "Filtro: " + name);
//        return "redirect:/skills?filter="+name;
//    }

    @GetMapping("/name/{name}")
    public String showFilteredSkillName(@PathVariable String name, RedirectAttributes redirectAttributes) {
        boolean hasResults = skills.stream().anyMatch(skill -> skill.getName().equalsIgnoreCase(name));
        if(!hasResults) {
            redirectAttributes.addFlashAttribute("filterMessage", "No se encontraron resultados para: " + name);
        } else {
            redirectAttributes.addFlashAttribute("filterMessage", "Filtro: " + name);
        }
        return "redirect:/skills?filter="+name;
    }

//    @ModelAttribute(name = "skills2")
//    public List<Skill> getSkills() {
//        return skills;
//    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "add-skills";
    }

    @PostMapping("/add")
    public String addSkill(@ModelAttribute Skill skill) {
        skills.add(skill);
        return "redirect:/skills/";
    }

}

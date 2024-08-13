package com.tarun.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tarun.demo.entity.Laptop;
import com.tarun.demo.repository.LaptopRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@Autowired
	LaptopRepository lapp;
	
	
	@GetMapping("/")
	private String home() {
		
		return "index";
		

	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
//	@PostMapping("/submitLaptopDetails")
//	@ResponseBody
//	public String saveData(@RequestParam("id") int id,@RequestParam("brand") String brand, @RequestParam("price") String price) {
//		//TODO: process POST request
//		Laptop lap = new Laptop(id,brand,price);
//		Laptop la = lapp.save(lap);
//		System.out.println(la);
//		return "data saved";
//	}
	
	@PostMapping("/submitLaptopDetails")
	@ResponseBody
	public String saveData(Laptop lap) {
		lapp.save(lap);
		return "data save";
	}
	
	@GetMapping("/allLaptops")
	public String getAllLaptops(Model model) {
	    List<Laptop> laptops = lapp.findAll();
	    model.addAttribute("laptops", laptops);
	    return "Showall"; // Assuming your JSP file is named allLaptops.jsp
	}
	
	
	@GetMapping("/deleteLaptop")
    public String deleteLaptop(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        // Check if the laptop with the given id exists
        if (lapp.existsById(id)) {
        	lapp.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Laptop deleted successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Laptop not found!");
        }
        
        // Redirect back to the list of all laptops
        return "redirect:/allLaptops";
    }
	
	
	@GetMapping("/updateLaptop")
	public String showUpdateForm(@RequestParam("id") int id, Model model) {
	    Laptop laptop = lapp.findById(id).orElse(null);
	    model.addAttribute("laptop", laptop);
	    return "Update";
	}

	@PostMapping("/updateLaptop")
	public String updateLaptop(@ModelAttribute("laptop") Laptop laptop) {
	    lapp.save(laptop);
	    return "redirect:/allLaptops";
	}


	
	
	

}

package edu.mum.client.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.mum.client.model.Catagory;
import edu.mum.client.services.UserService;
import edu.mum.client.services.WishListService;

@Controller
@RequestMapping("/wishlist")
public class WishListController {
	 
	 @Autowired
	 	private WishListService wlService;
	 
	@RequestMapping("/showWishlist")
	public String showWishList() {
		
		return "wishlist";
	}
	
	@PostMapping("/catagory")
	public String catagoryWish(@ModelAttribute(value="catagory") Catagory catagory, Model model) {
		Object[] a = wlService.getCatagories(catagory);
		System.out.println(Arrays.toString(a));
		model.addAttribute("catagoryWL",a);
		return "wishlist";
	}
	
}

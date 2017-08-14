package edu.mum.client.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.mum.client.model.Catagory;
import edu.mum.client.model.WishList;
import edu.mum.client.services.UserService;
import edu.mum.client.services.WishListService;

@Controller
@RequestMapping("/wishlist")
public class WishListController {
	 
	 @Autowired
	 	private WishListService wlService;
	 
	@RequestMapping("/showCataWishlist")
	public String showCataWishList(Model model) {
		Object[] a = wlService.getCatagories();
		System.out.println("new test panda"+Arrays.toString(a));
		model.addAttribute("catagoryList",a);
		return "wishlist";
	}
	
	@PostMapping("/catagoryList")
	public String catagoryWish(@ModelAttribute(value="catagory") Catagory catagory, Model model) {
		Object[] a = wlService.postCatagories(catagory);
		System.out.println(Arrays.toString(a));
		model.addAttribute("catagoryPostWL",a);
		return "wishlist";
	}
	
	@RequestMapping("/showWishList")
	public String showWishList(Model model) {
		Object[] a = wlService.getWishList();
		System.out.println("new test panda WishList"+Arrays.toString(a));
		model.addAttribute("wishlists", a);
		return "wishlist";
	}
	
	@PostMapping("/postWishList")
	public String postNShowWishlist(@ModelAttribute(value="wishlist") WishList wishlist, Model model) {
		Object[] a = wlService.postWishlists(wishlist);
		System.out.println(Arrays.toString(a));
		model.addAttribute("wishlists",a);
		return "wishlist";
	}
	
}

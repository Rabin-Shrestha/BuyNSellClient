package edu.mum.client.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.mum.client.model.Catagory;
import edu.mum.client.model.WishList;
import edu.mum.client.services.WishListService;


@Controller
@RequestMapping("/wishlist")
public class WishListController {
	 
	 @Autowired
	 	private WishListService wlService;
	 
	 
	@RequestMapping(value ="/showCataWishlist",method = RequestMethod.GET)
	public String showCataWishList(@RequestParam(value= "wishId", required=false) String wishId, @RequestParam(value= "cataId", required = false) String cataId, Model model) {
		
		Object[] a = wlService.getCatagories();
		Object[] b;
		
if(wishId!=null) {
			
			wlService.delete(wishId);
			
		}
		
		if(cataId==null) {
		 b = wlService.getWishList();
		 
		// return "wishlist";
		}
		else{
			b = wlService.getWLByCata(cataId);
			
		}
		
		List<Object> awl = Arrays.asList(a);
		List<Object> bwl = Arrays.asList(b);
		Collections.reverse(awl);
		Collections.reverse(bwl);
		model.addAttribute("catagoryList",awl);
		model.addAttribute("wishlists",bwl);
		
		
		return "wishlist";
	}
//	 @GetMapping("/showCataWishlist/{cataId}")
//		public String showCataWishList(@PathVariable(value= "cataId") String cataId, Model model) {
//			Object[] a = wlService.getCatagories();
//			Object[] b;
//			if(cataId==null) {
//			 b = wlService.getWishList();
//			}
//			else{
//				b = wlService.getWLByCata(cataId);
//			}
//			List<Object> awl = Arrays.asList(a);
//			List<Object> bwl = Arrays.asList(b);
//			Collections.reverse(awl);
//			Collections.reverse(bwl);
//			model.addAttribute("catagoryList",awl);
//			model.addAttribute("wishlists",bwl);
//			
//			
//			return "wishlist";
//		}
	@PostMapping("/showCataWishlist")
	public String catagoryWish(@ModelAttribute(value="catagory") Catagory catagory, WishList wishlist, Model model) {
		Object[] a = wlService.postCatagories(catagory);
		List<Object> al = Arrays.asList(a);
		Collections.reverse(al);
		model.addAttribute("catagoryList",al);
		
		Object[] b = wlService.postWishlists(wishlist);
		List<Object> bl = Arrays.asList(b);
		Collections.reverse(bl);
		model.addAttribute("wishlists",bl);
		
		return "wishlist";
	}
	
	@RequestMapping("/showWishlist")
	public String showWishList(Model model) {
		Object[] a = wlService.getWishList();
		
		model.addAttribute("wishlists", a);
		return "wishlist";
	}
	
	@PostMapping("/postWishlist")
	public String postNShowWishlist(@ModelAttribute(value="wishlist") WishList wishlist, Model model) {
		Object[] a = wlService.postWishlists(wishlist);
		System.out.println("new test panda WishList " + Arrays.toString(a));
		model.addAttribute("wishlists",a);
		return "wishlist";
	}
	
	@PostMapping("/postWLByCata")
	public String postWLByCata(@ModelAttribute(value="catagory") Catagory catagory, Model model) {
		Object[] a = wlService.postWLByCata(catagory);
		System.out.println("123 panda:" + Arrays.toString(a));
		model.addAttribute("wishlists", a);
		
		return "";
	}
	
	
}

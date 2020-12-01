package org.cap.wishlistmanagementsystem.controller;

import java.util.*;


import org.cap.wishlistmanagementsystem.entities.WishListItem;

import org.cap.wishlistmanagementsystem.service.IWishListService;
import org.cap.wishlistmanagementsystem.util.WishlistUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/wisheditems")
public class WishListController {

  

    @Autowired
    private IWishListService wishListService;

    
  //To add items into Wish List
    /**
     * url for add is http://localhost:5678/wisheditems/add
     */
    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody Map<String, Object> requestData) {
        WishListItem wishlist = WishlistUtil.convertToWishlistDto(requestData);
        wishListService.addProductToWishlist(wishlist);
        String ProductId=wishListService.addProductToWishlist(wishlist);
        String msg="Product ID : "+ProductId+" is Successfully Added";
        ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.OK);
        return response;
    }

    
  //To view items from Wish List
    /**
     * url is http://localhost:5678/wisheditems/users/userIdVal
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<WishListItem>> getWishlistByUserId(@PathVariable("userId") String userId) {
        List<WishListItem> wishlistItems = wishListService.getViewWishlist(userId);
        ResponseEntity<List<WishListItem>> response = new ResponseEntity<>(wishlistItems, HttpStatus.OK);
        return response;
      }

   
	
  
}

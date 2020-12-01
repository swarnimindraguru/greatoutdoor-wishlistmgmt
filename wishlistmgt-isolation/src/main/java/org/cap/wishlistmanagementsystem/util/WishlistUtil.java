package org.cap.wishlistmanagementsystem.util;

import java.util.Map;

import org.cap.wishlistmanagementsystem.entities.WishListItem;
import org.cap.wishlistmanagementsystem.exception.IncorrectProductException;
import org.cap.wishlistmanagementsystem.exception.IncorrectUserException;




public class WishlistUtil {
	public static WishListItem convertToWishlistDto(Map<String,Object > map) {
		WishListItem wishlist= new WishListItem();
		String productId=(String)map.get("productId");
		String productName=(String)map.get("productName");
		String userId=(String)map.get("userId");
		wishlist.setProductId(productId);
		wishlist.setProductName(productName);
		wishlist.setUserId(userId);
		return wishlist;
	}

	
	//To validate UserID
	public static void validateUserID(WishListItem wishListItem) {

        if (wishListItem.getUserId().isEmpty() || wishListItem.getUserId() == null) {
            throw new IncorrectUserException("Please fill User Id");
        }
        
        if(!(wishListItem.getUserId().matches("\\w+"))) {
        	throw new IncorrectUserException("Incorrect UserId");
        }
	}
	
	
	
	// To validate product details
	public static void validateProduct(WishListItem wishListItem) {

        if (wishListItem.getProductId().isEmpty() || wishListItem.getProductId() == null) {
            throw new IncorrectProductException("Please fill Product ID");
        }
        if(!(wishListItem.getProductId().matches("\\w+"))) {
        	throw new IncorrectProductException("Incorrect ProductId");
        }
	
        if (wishListItem.getProductName().isEmpty() || wishListItem.getProductName() == null) {
            throw new IncorrectProductException("Please fill Product Product Name");
        }
        
        if(!(wishListItem.getProductName().matches("\\w+"))) {
        	throw new IncorrectProductException("Incorrect ProductName");
        }
	
	}
	
}

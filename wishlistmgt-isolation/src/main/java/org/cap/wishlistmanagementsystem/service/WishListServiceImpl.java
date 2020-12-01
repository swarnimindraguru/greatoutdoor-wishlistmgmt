package org.cap.wishlistmanagementsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.cap.wishlistmanagementsystem.dao.IWishListDao;
import org.cap.wishlistmanagementsystem.entities.WishListItem;
import org.cap.wishlistmanagementsystem.exception.IncorrectUserException;
import org.cap.wishlistmanagementsystem.util.WishlistUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WishListServiceImpl implements IWishListService {

    @Autowired
    private IWishListDao wishlistDao;

    public WishListServiceImpl(IWishListDao dao) {
        this.wishlistDao = dao;
    }

    
    //To add items into Wish List
    @Override
    public String addProductToWishlist(WishListItem wishListItem) {
    	WishlistUtil.validateUserID(wishListItem);
    	WishlistUtil.validateProduct(wishListItem);
        wishListItem = wishlistDao.save(wishListItem);
        String productId=wishListItem.getProductId();
		return productId;
    }

    
    //To view items from Wish List
    @Override
    public List<WishListItem> getViewWishlist(String userId) throws IncorrectUserException {
    	List<WishListItem> wishlist;

    //Validating userId
    if(userId == null || userId.isEmpty()) {
  	throw new IncorrectUserException("valid userId needed..!!");
    	}
    	else {
    		wishlist = wishlistDao.findByUserId(userId);
    		if(wishlist.isEmpty()) {
    		throw new IncorrectUserException("valid userId needed..!!");
    		}
    	else {
        List<WishListItem> list = wishlistDao.findByUserId(userId);
        return list;
    }

    }
    }
}
    	

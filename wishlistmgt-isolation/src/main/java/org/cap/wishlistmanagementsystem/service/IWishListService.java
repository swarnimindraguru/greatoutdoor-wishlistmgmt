package org.cap.wishlistmanagementsystem.service;

import java.util.*;

import org.cap.wishlistmanagementsystem.entities.WishListItem;

public interface IWishListService {

	String addProductToWishlist(WishListItem dto);

	List<WishListItem> getViewWishlist(String userId);
}

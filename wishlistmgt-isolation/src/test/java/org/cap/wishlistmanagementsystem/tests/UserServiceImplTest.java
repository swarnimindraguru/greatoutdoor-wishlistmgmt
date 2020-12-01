package org.cap.wishlistmanagementsystem.tests;

import org.cap.wishlistmanagementsystem.entities.WishListItem;
import org.cap.wishlistmanagementsystem.exception.IncorrectProductException;
import org.cap.wishlistmanagementsystem.exception.IncorrectUserException;
import org.cap.wishlistmanagementsystem.service.IWishListService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {
	@Autowired
	private IWishListService service;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddProductToWishlist_01() throws IncorrectProductException {
		WishListItem wishlist = new WishListItem();
		wishlist.setId(1);
		wishlist.setProductId("001");
		wishlist.setProductName("Suit");
		wishlist.setUserId("Swarnim");
		String s1 = service.addProductToWishlist(wishlist);
		String string2 = "001";
		Assertions.assertEquals(s1, string2);
	}

	@Test
	void testAddProductToWishlist_02() throws IncorrectProductException {
		WishListItem wishlist = new WishListItem();
		wishlist.setId(2);
		wishlist.setProductId("002");
		wishlist.setProductName("Shirt");
		wishlist.setUserId("Swarnim");
		String string1 = service.addProductToWishlist(wishlist);
		String string2 = "002";
		Assertions.assertEquals(string1, string2);
	}

	@Test
	void testAddProductToWishlist_03() throws IncorrectUserException {
		WishListItem wishlist = new WishListItem();
		wishlist.setId(3);
		wishlist.setProductId("005");
		wishlist.setProductName("shoes");
		wishlist.setUserId(null);
		String string1 = service.addProductToWishlist(wishlist);
		String string2 = "005";
		Assertions.assertEquals(string1, string2);
	}

	@Test
	void testAddProductToWishlist_04() throws IncorrectUserException {
		WishListItem wishlist = new WishListItem();
		wishlist.setId(4);
		wishlist.setProductId("005");
		wishlist.setProductName("Phone");
		wishlist.setUserId("Ram");
		String string1 = service.addProductToWishlist(wishlist);
		String string2 = "005";
		Assertions.assertEquals(string1, string2);
	}
	
	@Test
	void testAddProductToWishlist_05() throws IncorrectUserException {
		WishListItem wishlist = new WishListItem();
		wishlist.setId(5);
		wishlist.setProductId("005");
		wishlist.setProductName("TV");
		wishlist.setUserId("");
		String string1 = service.addProductToWishlist(wishlist);
		String string2 = "005";
		Assertions.assertEquals(string1, string2);
	}
	
	@Test
	void testAddProductToWishlist_06() throws IncorrectProductException {
		WishListItem wishlist = new WishListItem();
		wishlist.setId(6);
		wishlist.setProductId("#$%1");
		wishlist.setProductName("Shirt");
		wishlist.setUserId("Swarnim");
		String string1 = service.addProductToWishlist(wishlist);
		String string2 = "#$%1";
		Assertions.assertEquals(string1, string2);
	}
}

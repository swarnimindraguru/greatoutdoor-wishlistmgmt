package org.cap.wishlistmanagementsystem.tests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.cap.wishlistmanagementsystem.controller.WishListController;
import org.cap.wishlistmanagementsystem.entities.WishListItem;
import org.cap.wishlistmanagementsystem.service.IWishListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(WishListController.class)
public class WishListApplicationHttpStatusCodeTests {
	
		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private IWishListService service;

		@Test
		void addItem() throws Exception {
			WishListItem items = new WishListItem();
			when(service.addProductToWishlist(items)).thenReturn("");
			mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:5678/wisheditems/add",items).contentType("application/json").content(new ObjectMapper().writeValueAsString(items))).andDo(print()).andExpect(status().isOk());
		}
		
		
	}


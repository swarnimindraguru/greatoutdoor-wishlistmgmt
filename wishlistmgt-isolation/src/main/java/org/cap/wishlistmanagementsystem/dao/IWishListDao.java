package org.cap.wishlistmanagementsystem.dao;

import org.cap.wishlistmanagementsystem.entities.WishListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWishListDao extends JpaRepository<WishListItem, Integer> {

	@Query("select wishList from WishListItem wishList where userId=?1")
    List<WishListItem> findByUserId(String userId);
}
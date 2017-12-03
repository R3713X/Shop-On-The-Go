package com.shoponthego.shops.discounts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class DiscountService {

	private List<Discount> discounts = new ArrayList<>(Arrays.asList(
			new Discount("Playstation 4","30% OFF","A","Active")));
	
	public List<Discount> getAllDiscounts() {
		return discounts;
	}

	public Discount getDiscountById(String id) {
		for (Discount discount : discounts) {
			if(discount.getId().equalsIgnoreCase(id)) {
				return discount;
			}
		}
		return null;
	}

	public void addOffer(Discount discount) {
		discounts.add(discount);
	}

	public void updateOffer(String id, Discount newDiscount) {
		for(int i=0; i<discounts.size(); i++) {
			Discount discount = discounts.get(i);
			if(discount.getId().equalsIgnoreCase(id)) {
				discounts.set(i, newDiscount);
				return;
			}
		}		
	}

	public void deleteOffer(String id) {
		for(int i=0; i<discounts.size(); i++) {
			Discount discount = discounts.get(i);
			if(discount.getId().equalsIgnoreCase(id)) {
				discounts.remove(discount);
				return;
			}
		}		
	}
}

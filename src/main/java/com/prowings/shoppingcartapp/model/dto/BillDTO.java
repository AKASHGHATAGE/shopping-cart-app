package com.prowings.shoppingcartapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BillDTO {

	private double totalAmount;
	private double taxAmount;
	private double finalAmount;

}
package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PROD_ID")
	private long prodId;
	@Column(name = "PROD_NAME")
	private String prodName;
	@Column(name = "PROD_VENDOR")
	private String prodVendor;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private ProductDetails prodDetails;

	public Product() {
	}

}
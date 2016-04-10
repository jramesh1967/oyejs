package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalog database table.
 * 
 */
@Entity
@Table(name="catalog")
@NamedQuery(name="Catalog.findAll", query="SELECT c FROM Catalog c")
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idcatalog;

	//bi-directional many-to-one association to CatalogItem
	@OneToMany(mappedBy="catalog")
	private List<CatalogItem> catalogItems;

	//bi-directional many-to-one association to VendorHasServicePoint
	@OneToMany(mappedBy="catalog")
	private List<VendorHasServicePoint> vendorHasServicePoints;

	public Catalog() {
	}

	public int getIdcatalog() {
		return this.idcatalog;
	}

	public void setIdcatalog(int idcatalog) {
		this.idcatalog = idcatalog;
	}

	public List<CatalogItem> getCatalogItems() {
		return this.catalogItems;
	}

	public void setCatalogItems(List<CatalogItem> catalogItems) {
		this.catalogItems = catalogItems;
	}

	public CatalogItem addCatalogItem(CatalogItem catalogItem) {
		getCatalogItems().add(catalogItem);
		catalogItem.setCatalog(this);

		return catalogItem;
	}

	public CatalogItem removeCatalogItem(CatalogItem catalogItem) {
		getCatalogItems().remove(catalogItem);
		catalogItem.setCatalog(null);

		return catalogItem;
	}

	public List<VendorHasServicePoint> getVendorHasServicePoints() {
		return this.vendorHasServicePoints;
	}

	public void setVendorHasServicePoints(List<VendorHasServicePoint> vendorHasServicePoints) {
		this.vendorHasServicePoints = vendorHasServicePoints;
	}

	public VendorHasServicePoint addVendorHasServicePoint(VendorHasServicePoint vendorHasServicePoint) {
		getVendorHasServicePoints().add(vendorHasServicePoint);
		vendorHasServicePoint.setCatalog(this);

		return vendorHasServicePoint;
	}

	public VendorHasServicePoint removeVendorHasServicePoint(VendorHasServicePoint vendorHasServicePoint) {
		getVendorHasServicePoints().remove(vendorHasServicePoint);
		vendorHasServicePoint.setCatalog(null);

		return vendorHasServicePoint;
	}

}
package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the catalog_item database table.
 * 
 */
@Embeddable
public class CatalogItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idcatalog_item", unique=true, nullable=false)
	private int idcatalogItem;

	@Column(name="catalog_idcatalog", insertable=false, updatable=false, unique=true, nullable=false)
	private int catalogIdcatalog;

	public CatalogItemPK() {
	}
	public int getIdcatalogItem() {
		return this.idcatalogItem;
	}
	public void setIdcatalogItem(int idcatalogItem) {
		this.idcatalogItem = idcatalogItem;
	}
	public int getCatalogIdcatalog() {
		return this.catalogIdcatalog;
	}
	public void setCatalogIdcatalog(int catalogIdcatalog) {
		this.catalogIdcatalog = catalogIdcatalog;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CatalogItemPK)) {
			return false;
		}
		CatalogItemPK castOther = (CatalogItemPK)other;
		return 
			(this.idcatalogItem == castOther.idcatalogItem)
			&& (this.catalogIdcatalog == castOther.catalogIdcatalog);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcatalogItem;
		hash = hash * prime + this.catalogIdcatalog;
		
		return hash;
	}
}
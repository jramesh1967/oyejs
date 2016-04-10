package com.oyeseva.entity.generated;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the catalog_item database table.
 * 
 */
@Entity
@Table(name="catalog_item")
@NamedQuery(name="CatalogItem.findAll", query="SELECT c FROM CatalogItem c")
public class CatalogItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CatalogItemPK id;

	//bi-directional many-to-one association to Catalog
	@ManyToOne
	@JoinColumn(name="catalog_idcatalog", nullable=false, insertable=false, updatable=false)
	private Catalog catalog;

	public CatalogItem() {
	}

	public CatalogItemPK getId() {
		return this.id;
	}

	public void setId(CatalogItemPK id) {
		this.id = id;
	}

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

}
package com.ftgo.orderservice.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ftgo.common.exception.NotYetImplementedException;
import com.ftgo.kitchenservice.api.model.TicketDetails;
import com.ftgo.orderservice.api.event.OrderDomainEvent;
import com.ftgo.restaurantservice.api.model.MenuItem;
import com.ftgo.restaurantservice.api.model.RestaurantMenu;

import java.util.List;
import java.util.Optional;

/**
 * The entity class for restaurants.
 * 
 * @author  Wuyi Chen
 * @date    05/12/2020
 * @version 1.0
 * @since   1.0
 */
@Entity
@Table(name = "order_service_restaurants")
@Access(AccessType.FIELD)
public class Restaurant {
	@Id
	private Long id;

	@Embedded
	@ElementCollection
	@CollectionTable(name = "order_service_restaurant_menu_items")
	private List<MenuItem> menuItems;
	private String name;
	
	public Restaurant() {}     // Keep default constructor for Hibernate

	public Restaurant(long id, String name, List<MenuItem> menuItems) {
		this.id        = id;
		this.name      = name;
		this.menuItems = menuItems;
	}
	
	public Long           getId()        { return id;        }
	public String         getName()      { return name;      }
	public List<MenuItem> getMenuItems() { return menuItems; }

	public List<OrderDomainEvent> reviseMenu(RestaurantMenu revisedMenu) {
		// TODO
		throw new NotYetImplementedException();
	}

	public void verifyRestaurantDetails(TicketDetails ticketDetails) {
		// TODO
		throw new NotYetImplementedException();
	}

	public Optional<MenuItem> findMenuItem(String menuItemId) {
		return menuItems.stream().filter(mi -> mi.getId().equals(menuItemId)).findFirst();
	}
}

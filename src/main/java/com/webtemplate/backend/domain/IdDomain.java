package com.webtemplate.backend.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class IdDomain<E extends IdDomain<E>> extends BaseDomain<E> {
    @Column(name = "rest_id")
    String restaurantId;

    public String getRestaurantId() {
        return this.restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public E restaurantId(String restaurantId) {
        setRestaurantId(restaurantId);
        @SuppressWarnings("unchecked") E that = (E) this;
        return that;
    }

}

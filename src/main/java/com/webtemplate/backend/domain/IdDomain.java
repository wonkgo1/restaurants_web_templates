package com.webtemplate.backend.domain;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class IdDomain<E extends IdDomain<E>> extends BaseDomain<E> {
    @ManyToOne(fetch = FetchType.LAZY)
    Restaurant restaurant;

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public E restaurant(Restaurant restaurant) {
        setRestaurant(restaurant);
        @SuppressWarnings("unchecked")
        E that = (E) this;
        return that;
    }

}

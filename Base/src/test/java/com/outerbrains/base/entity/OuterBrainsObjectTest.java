package com.outerbrains.base.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

class OuterBrainsObjectTest {

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
        OuterBrainsObject outerBrainsObject = new OuterBrainsObject();
        System.out.println(outerBrainsObject);
    }
}
package com.rishmi5h.microservices.order.dto;

import java.math.BigDecimal;

public record OrderLineItemsDto(Long id, String skucode, BigDecimal price, Integer quantity) {
}

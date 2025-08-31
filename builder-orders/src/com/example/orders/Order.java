package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private String id;
    private String customerEmail;
    private final List<OrderLine> lines = new ArrayList<>();
    private Integer discountPercent; // 0..100 expected, but not enforced
    private boolean expedited;
    private String notes;

    public static class OrderBuilder {
        String id;
        String customerEmail;
        final List<OrderLine> lines = new ArrayList<>();
        Integer discountPercent; // 0..100 expected, but not enforced
        boolean expedited;
        String notes;
    
        public OrderBuilder setId(String id){
            this.id = id;
            return this;
        }

        public OrderBuilder setCustomerEmail(String customerEmail){
            this.customerEmail = customerEmail;
            return this;
        }

        public OrderBuilder addLine(OrderLine line){
            this.lines.add(new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents()));
            return this;
        }

        public OrderBuilder addAllOrderLine(List<OrderLine> lines){
            for (OrderLine line : lines) {
                this.lines.add(new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents()));
            }
            return this;
        }

        public OrderBuilder setDiscountPercent(Integer discountPercent){
            this.discountPercent = discountPercent;
            return this;
        }

        public OrderBuilder setExpedited(boolean expedited){
            this.expedited = expedited;
            return this;
        }

        public OrderBuilder setNotes(String notes){
            this.notes = notes;
            return this;
        }

        public Order build(){
            Validation.requireEmail(this.customerEmail);
            Validation.requireNumberInRange(this.discountPercent, 0, 100, "discountPercent");
            Validation.requireNonEmptyOrderLines(this.lines);
            return new Order(this);
        }
    }

    public Order(OrderBuilder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines.addAll(builder.lines); // defensive copy
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    // public Order(String id, String customerEmail) {
    //     this.id = id;
    //     this.customerEmail = customerEmail;
    // }

    // public Order(String id, String customerEmail, Integer discountPercent) {
    //     this(id, customerEmail);
    //     this.discountPercent = discountPercent;
    // }

    // public void addLine(OrderLine line) { lines.add(line); }
    // public void setDiscountPercent(Integer discountPercent) { this.discountPercent = discountPercent; }
    // public void setExpedited(boolean expedited) { this.expedited = expedited; }
    // public void setNotes(String notes) { this.notes = notes; }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { 
        List<OrderLine> copy = new ArrayList<>();
        for (OrderLine line : lines) {
            copy.add(new OrderLine(line.getSku(), line.getQuantity(), line.getUnitPriceCents()));
        }
        return copy;
    } // leaks internal list
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}

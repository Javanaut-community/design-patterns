package com.javadesignpatterns.creational.builder.solution;

// Product class
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product [partA=" + partA + ", partB=" + partB + ", partC=" + partC + "]";
    }
}

// Builder interface
interface Builder {
    Builder buildPartA();
    Builder buildPartB();
    Builder buildPartC();
    Product getResult();
}

// ConcreteBuilder class
class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    @Override
    public Builder buildPartA() {
        product.setPartA("Part A");
        return this;
    }

    @Override
    public Builder buildPartB() {
        product.setPartB("Part B");
        return this;
    }

    @Override
    public Builder buildPartC() {
        product.setPartC("Part C");
        return this;
    }

    @Override
    public Product getResult() {
        return product;
    }
}

// Director class
class Director {
    public void construct(Builder builder) {
        builder.buildPartA().buildPartB().buildPartC();
    }
}

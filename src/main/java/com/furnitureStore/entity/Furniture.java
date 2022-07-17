package com.furnitureStore.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Furniture {
    @Id
    private long furnitureId;
    private String furnitureName;
    private String furnitureColor;
    private String furnitureModel;
    private double price;


    public Furniture() {
    }

    public Furniture(long furnitureId, String furnitureName, String furnitureColor, String furnitureModel, double price) {
        this.furnitureId = furnitureId;
        this.furnitureName = furnitureName;
        this.furnitureColor = furnitureColor;
        this.furnitureModel = furnitureModel;
        this.price = price;
    }

    public long getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(long furnitureId) {
        this.furnitureId = furnitureId;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public String getFurnitureColor() {
        return furnitureColor;
    }

    public void setFurnitureColor(String furnitureColor) {
        this.furnitureColor = furnitureColor;
    }

    public String getFurnitureModel() {
        return furnitureModel;
    }

    public void setFurnitureModel(String furnitureModel) {
        this.furnitureModel = furnitureModel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furnitureId=" + furnitureId +
                ", furnitureName='" + furnitureName + '\'' +
                ", furnitureColor='" + furnitureColor + '\'' +
                ", furnitureModel='" + furnitureModel + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return furnitureId == furniture.furnitureId && Double.compare(furniture.price, price) == 0 && Objects.equals(furnitureName, furniture.furnitureName) && Objects.equals(furnitureColor, furniture.furnitureColor) && Objects.equals(furnitureModel, furniture.furnitureModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(furnitureId, furnitureName, furnitureColor, furnitureModel, price);
    }
}


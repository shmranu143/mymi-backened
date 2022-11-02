package com.mymi.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
public class MyProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skuId;
    @Column
    private int price;
    @Column
    private String modelName;
    @Column
    private String type;
    @Column(name = "ram")
    private int ramStorage;
    @Column(name = "internal")
    private int internalStorage;
    @Column(name = "camera")
    private int cameraPixel;
    @Column
    private String processor;
    @Column
    private String imageUrl;

    public MyProducts(){

    }

    public MyProducts(int price, String modelName, String type, int ramStorage, int internalStorage, int cameraPixel, String processor, String imageUrl) {
        this.price = price;
        this.modelName = modelName;
        this.type = type;
        this.ramStorage = ramStorage;
        this.internalStorage = internalStorage;
        this.cameraPixel = cameraPixel;
        this.processor = processor;
        this.imageUrl = imageUrl;
    }

}

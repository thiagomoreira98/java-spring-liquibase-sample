package com.sample.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "product")
@ApiModel(value = "Product", description = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 100, message = "the property 'name' must be a maximum of 100 characters.")
    @ApiModelProperty(name = "name", value = "product name")
    private String name;

    @ApiModelProperty(name = "description", value = "product description")
    @Size(max = 300, message = "the property 'description' must be a maximum of 300 characters.")
    private String description;

    @NotNull
    @ApiModelProperty(name = "price", value = "product price")
    private float price;
}

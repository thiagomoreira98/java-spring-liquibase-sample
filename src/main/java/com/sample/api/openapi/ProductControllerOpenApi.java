package com.sample.api.openapi;

import com.sample.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Product")
public interface ProductControllerOpenApi {

    @ApiOperation(value = "List products")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    List<Product> list();

    @ApiOperation(value = "Find one product by ID")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 404, message ="Not found"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    ResponseEntity<Product> findById(Long id);

    @ApiOperation(value = "Insert or update one product")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    ResponseEntity<Object> insertOrUpdate(Product product);

    @ApiOperation(value = "Delete one product by ID")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    ResponseEntity<Object> delete(Long id);
}

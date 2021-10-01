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

    @ApiOperation(value = "Listar os produtos")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    List<Product> list();

    @ApiOperation(value = "Buscar um produto pelo ID")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 404, message ="Not found"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    ResponseEntity<Product> findById(Long id);

    @ApiOperation(value = "Cadastrar ou atualizar um produto")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    ResponseEntity<Object> insertOrUpdate(Product product);

    @ApiOperation(value = "Deletar um produto pelo ID")
    @ApiResponses({
        @ApiResponse(code = 200, message ="Ok"),
        @ApiResponse(code = 500, message ="Internal server error")
    })
    ResponseEntity<Object> delete(Long id);
}

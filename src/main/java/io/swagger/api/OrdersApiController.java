package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.Order;
import io.swagger.service.OrderService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-23T09:58:42.026149969Z[GMT]")
@RestController
public class OrdersApiController implements OrdersApi {

    private static final Logger log = LoggerFactory.getLogger(OrdersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final OrderService orderService;

    @org.springframework.beans.factory.annotation.Autowired
    public OrdersApiController(ObjectMapper objectMapper, HttpServletRequest request, OrderService orderService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.orderService = orderService;
    }

    public ResponseEntity<Order> ordersDelete(
            @NotNull @Parameter(in = ParameterIn.QUERY, description = "", required = true, schema = @Schema()) @Valid @RequestParam(value = "id", required = true) String id) {
        // String accept = request.getHeader("Accept");
        // if (accept != null && accept.contains("application/json")) {
        // try {
        // return new ResponseEntity<Order>(objectMapper.readValue("{\n \"totalAmount\"
        // : 14.5,\n \"orderId\" : \"order001\",\n \"userId\" : \"user001\",\n
        // \"orderDate\" : \"2025-10-07T20:50:00+02:00\",\n \"items\" : [ {\n
        // \"unitPrice\" : 20,\n \"quantity\" : 2,\n \"productId\" : \"item001\",\n
        // \"type\" : \"album\",\n \"productName\" : \"Camiseta\"\n }, {\n \"unitPrice\"
        // : 20,\n \"quantity\" : 2,\n \"productId\" : \"item001\",\n \"type\" :
        // \"album\",\n \"productName\" : \"Camiseta\"\n } ]\n}", Order.class),
        // HttpStatus.NOT_IMPLEMENTED);
        // } catch (IOException e) {
        // log.error("Couldn't serialize response for content type application/json",
        // e);
        // return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
        // }

        // return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
        try {
            orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Error deleting order", e);
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<List<Order>> ordersGet() {
        // String accept = request.getHeader("Accept");
        // if (accept != null && accept.contains("application/json")) {
        // try {
        // return new ResponseEntity<Order>(objectMapper.readValue(
        // "{\n \"totalAmount\" : 14.5,\n \"orderId\" : \"order001\",\n \"userId\" :
        // \"user001\",\n \"orderDate\" : \"2025-10-07T20:50:00+02:00\",\n \"items\" : [
        // {\n \"unitPrice\" : 20,\n \"quantity\" : 2,\n \"productId\" : \"item001\",\n
        // \"type\" : \"album\",\n \"productName\" : \"Camiseta\"\n }, {\n \"unitPrice\"
        // : 20,\n \"quantity\" : 2,\n \"productId\" : \"item001\",\n \"type\" :
        // \"album\",\n \"productName\" : \"Camiseta\"\n } ]\n}",
        // Order.class), HttpStatus.OK);
        // } catch (IOException e) {
        // log.error("Couldn't serialize response for content type application/json",
        // e);
        // return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
        // }

        // return new ResponseEntity<Order>(HttpStatus.OK);
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    public ResponseEntity<Order> ordersIdGet(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Order>(objectMapper.readValue(
                        "{\n  \"totalAmount\" : 14.5,\n  \"orderId\" : \"order001\",\n  \"userId\" : \"user001\",\n  \"orderDate\" : \"2025-10-07T20:50:00+02:00\",\n  \"items\" : [ {\n    \"unitPrice\" : 20,\n    \"quantity\" : 2,\n    \"productId\" : \"item001\",\n    \"type\" : \"album\",\n    \"productName\" : \"Camiseta\"\n  }, {\n    \"unitPrice\" : 20,\n    \"quantity\" : 2,\n    \"productId\" : \"item001\",\n    \"type\" : \"album\",\n    \"productName\" : \"Camiseta\"\n  } ]\n}",
                        Order.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Order> ordersPost(
            @Parameter(in = ParameterIn.DEFAULT, description = "Create a new order", required = true, schema = @Schema()) @Valid @RequestBody Order body) {
        String accept = request.getHeader("Accept");
        // if (accept != null && accept.contains("application/json")) {
        // try {
        // return new ResponseEntity<Order>(objectMapper.readValue(
        // "{\n \"totalAmount\" : 14.5,\n \"orderId\" : \"order001\",\n \"userId\" :
        // \"user001\",\n \"orderDate\" : \"2025-10-07T20:50:00+02:00\",\n \"items\" : [
        // {\n \"unitPrice\" : 20,\n \"quantity\" : 2,\n \"productId\" : \"item001\",\n
        // \"type\" : \"album\",\n \"productName\" : \"Camiseta\"\n }, {\n \"unitPrice\"
        // : 20,\n \"quantity\" : 2,\n \"productId\" : \"item001\",\n \"type\" :
        // \"album\",\n \"productName\" : \"Camiseta\"\n } ]\n}",
        // Order.class), HttpStatus.NOT_IMPLEMENTED);
        // } catch (IOException e) {
        // log.error("Couldn't serialize response for content type application/json",
        // e);
        // return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }
        // }

        // return new ResponseEntity<Order>(HttpStatus.NOT_IMPLEMENTED);
        try {
            Order createdOrder = orderService.createOrder(body);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error creating order", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Order>> ordersUserIdGet(
            @Parameter(in = ParameterIn.PATH, description = "", required = true, schema = @Schema()) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Order>>(objectMapper.readValue(
                        "[ {\n  \"totalAmount\" : 14.5,\n  \"orderId\" : \"order001\",\n  \"userId\" : \"user001\",\n  \"orderDate\" : \"2025-10-07T20:50:00+02:00\",\n  \"items\" : [ {\n    \"unitPrice\" : 20,\n    \"quantity\" : 2,\n    \"productId\" : \"item001\",\n    \"type\" : \"album\",\n    \"productName\" : \"Camiseta\"\n  }, {\n    \"unitPrice\" : 20,\n    \"quantity\" : 2,\n    \"productId\" : \"item001\",\n    \"type\" : \"album\",\n    \"productName\" : \"Camiseta\"\n  } ]\n}, {\n  \"totalAmount\" : 14.5,\n  \"orderId\" : \"order001\",\n  \"userId\" : \"user001\",\n  \"orderDate\" : \"2025-10-07T20:50:00+02:00\",\n  \"items\" : [ {\n    \"unitPrice\" : 20,\n    \"quantity\" : 2,\n    \"productId\" : \"item001\",\n    \"type\" : \"album\",\n    \"productName\" : \"Camiseta\"\n  }, {\n    \"unitPrice\" : 20,\n    \"quantity\" : 2,\n    \"productId\" : \"item001\",\n    \"type\" : \"album\",\n    \"productName\" : \"Camiseta\"\n  } ]\n} ]",
                        List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Order>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Order>>(HttpStatus.NOT_IMPLEMENTED);
    }

}

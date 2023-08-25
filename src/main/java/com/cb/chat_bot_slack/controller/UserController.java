package com.cb.chat_bot_slack.controller;


import com.cb.chat_bot_slack.entity.User;
import com.cb.chat_bot_slack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080")
public class UserController {

    /**
     * this method for all existing users
     * @return all users
     */

    @Autowired
    private UserService userService;


    @GetMapping("/user_details")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUser();
    }

//    @PostMapping("/order_detail")
//    public ResponseEntity<OrderDetails> createOrderDetails(@RequestBody OrderDetails orderDetails) {
//        System.out.println("OrderDetailsDTO = [" + orderDetails + "]");
//
//        if(orderDetails.getPaymentMethod().equals(PaymentMethodType.PAY_ONLINE)){
//            orderDetails.setPaymentMethod(PaymentMethodType.PAY_ONLINE);
//        }
//        if(orderDetails.getPaymentMethod().equals(PaymentMethodType.CASH_ON_DELIVERY)){
//            orderDetails.setPaymentMethod(PaymentMethodType.CASH_ON_DELIVERY);
//        }
//        return orderDetailService.createOrderDetails(orderDetails);
//    }
//
//    @PutMapping("/order_detail/{orderDetailID}")
//    public ResponseEntity<OrderDetails> updateOrderDetail(@PathVariable("orderDetailID") Long orderDetailID,
//                                                          @RequestBody OrderDetails orderDetailDTO) {
//        System.out.println("OrderDetailsDTO = [" + orderDetailDTO + "]");
//        return orderDetailService.updateOrderDetails(orderDetailID, orderDetailDTO);
//    }
//
//    @DeleteMapping("order_detail/{orderDetailID}")
//    public Map<String, Boolean> deleteOrderDetail(@PathVariable("orderDetailID") Long orderDetailID) {
//        return orderDetailService.deleteOrderDetails(orderDetailID);
//    }
//
//    @GetMapping("/order_detail/{orderDetailID}")
//    public ResponseEntity<OrderDetails> searchOrderDetail(@PathVariable("orderDetailID") Long orderDetailID) {
//        return orderDetailService.searchOrderDetails(orderDetailID);
//    }
}

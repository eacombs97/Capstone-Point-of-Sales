
//
//  OrderModel.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//
import Foundation

class Order: Identifiable{
    let id: UUID
    let items: [Product]
    let shippingAddress: String
    let paymentMethod: String
    let orderID: Int
    let userID: Int
    let discountID: Int
    let shippingDetailsID: Int
    let taxID: Int
    let paymentID: Int
    let guestID: Int
    let totalQuantity: Int
    let total: Float
    
    init(id: UUID = UUID(),
         items: [Product],
         shippingAddress: String,
         paymentMethod: String,
         orderID: Int = 0,
         userID: Int = 0,
         discountID: Int = 0,
         shippingDetailsID: Int = 0,
         taxID: Int = 0,
         paymentID: Int,
         guestID: Int = 0,
         totalQuantity: Int,
         total: Float) {
        
        self.id = id
        self.items = items
        self.shippingAddress = shippingAddress
        self.paymentMethod = paymentMethod
        self.orderID = orderID
        self.userID = userID
        self.discountID = discountID
        self.shippingDetailsID = shippingDetailsID
        self.taxID = taxID
        self.paymentID = paymentID
        self.guestID = guestID
        self.totalQuantity = totalQuantity
        self.total = total
    }
    
    var formattedTotal: String {
            String(format: "%.2f", total)
        }
}

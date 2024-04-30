//
//  Order Manager.swift
//  BitBuggyShop
//
//  Created by Emily Combs on 4/29/24.
//

import Foundation

class OrderManager: ObservableObject {
    static let shared = OrderManager() // Singleton instance
    
    @Published var orders: [Order] = [] // Array to hold orders
    
    // Function to add an order to the orders array
    func addOrder(_ order: Order) {
        orders.append(order)
    }
}

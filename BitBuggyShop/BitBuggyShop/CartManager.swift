//
//  CartManager.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import Foundation

class CartManager: ObservableObject { //use ObservableObject so changes are updated instantly in the UI
    @Published private(set) var products: [Product] = [] //private set so variable can only be set within this class
    @Published private(set) var total: Float = 0.00
    
    func addToCart(product: Product) {
        products.append(product)
        total += product.productPrice
    }
    
    func removedFromCart(product: Product) {
        products = products.filter { $0.id != product.id } //check if this is id
        total -= product.productPrice
    }
}

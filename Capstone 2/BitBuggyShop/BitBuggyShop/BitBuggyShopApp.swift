//
//  BitBuggyShopApp.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

@main
struct BitBuggyShopApp: App {
    @StateObject var cartManager = CartManager()
    @StateObject var orderManager = OrderManager()
    
    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(CartManager())
                .environmentObject(OrderManager())            
        }
    }
}

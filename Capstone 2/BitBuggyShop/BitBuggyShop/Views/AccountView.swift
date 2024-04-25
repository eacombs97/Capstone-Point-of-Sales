//
//  AccountView.swift
//  BitBuggyShop
//
//  Created by Emily Combs on 4/25/24.
//

import SwiftUI

struct AccountView: View {
    var body: some View {
        NavigationView {
            VStack(alignment: .leading) {
                Text("My Account")
                    .font(.title)
                    .padding(.bottom, 10)
                
                Section(header: Text("Orders")) {
                    // Display list of orders
                    Text("Order 1")
                    Text("Order 2")
                    Text("Order 3")
                    // Add more order details as needed
                }
                .padding(.bottom, 20)
                
                Section(header: Text("Stored Addresses")) {
                    // Display list of stored addresses
                    Text("Address 1")
                    Text("Address 2")
                    Text("Address 3")
                    // Add more address details as needed
                }
                .padding(.bottom, 20)
                
                Section(header: Text("Stored Card Information")) {
                    // Display list of stored card information
                    Text("Card ending in 1234")
                    Text("Card ending in 5678")
                    // Add more card details as needed
                }
                
                Spacer()
            }
            .padding()

        }
    }
}

struct AccountView_Previews: PreviewProvider {
    static var previews: some View {
        AccountView()
    }
}

//
//  LoginView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct LoginView: View {
    @EnvironmentObject var cartManager : CartManager
    @EnvironmentObject var orderManager : OrderManager
    
    @State private var username: String = ""
    @State private var password: String = ""
    @State private var isLoggedIn: Bool = false//authentication stuff for here
    
    var body: some View {
        VStack {
            HStack {
              
                    Image("logo")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 30, height: 30)
                        .padding()
               
                
                Spacer()
                
                
                    Text("BitBuggy")
                        .font(.title)
                        .bold()
                        .foregroundColor(Color("Dark Gold"))
                        .padding()
                        .frame(maxWidth: .infinity, alignment: .center) // Center the title
                
                
                Spacer() // Pushes the buttons to the right
                
                NavigationLink(destination: CartView()){
                    CartButton(numberOfProducts: cartManager.products.count)
                }
                
                
                    AccountButton() // Use the AccountButton to navigate to AccountView
                
            }
            .frame(maxWidth: .infinity, alignment: .topLeading)
            .background(Color("Dark Green"))
            .padding(.top, UIApplication
                                .shared
                                .connectedScenes
                                .flatMap { ($0 as? UIWindowScene)?.windows ?? [] }
                                .first { $0.isKeyWindow }?.safeAreaInsets.top)
            
            Spacer(minLength: 66)
            VStack{
                Image(systemName: "person.circle")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 100, height: 100)
                    .padding(.bottom, 30)
                    .foregroundColor(Color("Light Gold"))
                
                Spacer(minLength: 30)
                
                TextField("Username", text: $username)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
                    .padding(.bottom, 20)
                
                SecureField("Password", text: $password)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
                    .padding(.bottom, 20)
                
                Button(action: {
                    // implement your authentication logic
                    
                    if !username.isEmpty && !password.isEmpty {
                        isLoggedIn = true
                    }
                }) {
                    Text("Login")
                        .padding()
                        .frame(maxWidth: .infinity)
                        .background(Color("Dark Gold"))
                        .cornerRadius(8)
                        .foregroundColor(Color("Dark Green"))

                     .alert(isPresented: $isLoggedIn) {
                     Alert(title: Text("Success"), message: Text("You are logged in!"), dismissButton: .default(Text("OK")))}
                }
            }
            .padding(30)
            
            //These are for proper spacing DO NOT MOVE
            Spacer(minLength: 251)
        }
        .background(Color("Green"))
        .edgesIgnoringSafeArea(.top)
    }

}


struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
            .environmentObject(CartManager())
    }
}

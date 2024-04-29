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
    @State private var isLoggedIn: Bool = false
    @State private var showAlert: Bool = false
    @State private var alertTitle: String = ""
    @State private var alertMessage: String = ""
    @State private var isNavigationActive = false
    
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
                    .autocapitalization(.none)
                
                SecureField("Password", text: $password)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
                    .padding(.bottom, 20)
                
                Button(action: {
                    authenticate()
                }) {
                    Text("Login")
                        .padding()
                        .frame(maxWidth: .infinity)
                        .background(Color("Dark Gold"))
                        .cornerRadius(8)
                        .foregroundColor(Color("Dark Green"))

                        .alert(isPresented: $showAlert) {
                            Alert(
                                title: Text(alertTitle),
                                message: Text(alertMessage),
                                dismissButton: .default(Text("OK")) {
                                    // switch view
                                    if isLoggedIn {
                                        isNavigationActive = true
                                    }
                                }
                            )
                        }
                }
                .fullScreenCover(isPresented: $isNavigationActive) {
                    ContentView()
                }
            }
            .padding(30)
            
            //These are for proper spacing DO NOT MOVE
            Spacer(minLength: 251)
        }
        .background(Color("Green"))
        .edgesIgnoringSafeArea(.top)
    }
    
    func authenticate() {
            // Regular expressions for email and password validation
            let emailRegex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}"
            let passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$" // At least 8 characters, one letter, and one digit
            if username.isEmpty && password.isEmpty {
                alertMessage = "You must enter an email and password."
                showAlert = true
                return
            }
            // Check if the username (email) matches the email regex
            guard let emailRange = username.range(of: emailRegex, options: .regularExpression) else {
                alertTitle = "Error"
                alertMessage = "Invalid email format. Please enter a valid email address."
                showAlert = true
                return
            }
            
            // Check if the password matches the password regex
            guard password.range(of: passwordRegex, options: .regularExpression) != nil else {
                alertTitle = "Error"
                alertMessage = "Invalid password format. Please enter a valid password"
                showAlert = true
                return
            }
            
            // Authentication check passed
            if validEmails.contains(username) && validPasswords.contains(password){
                    isLoggedIn = true
                    alertTitle = "Success"
                    alertMessage = "You are logged in!"
                    showAlert = true
            } else if !validEmails.contains(username){
                    alertTitle = "Error"
                    alertMessage = "This email is not in our records. Please enter a valid email."
                    showAlert = true
            } else if !validPasswords.contains(password) {
                alertTitle = "Error"
                alertMessage = "This password is not valid. Please enter your password."
                showAlert = true
            }
        }
        
        let validEmails = [
            "irelands3139@gmail.com",
            "combse3146@gmail.com",
            "gainesk0220@gmail.com"
        ]
        
        let validPasswords = [
            "Newuser123",
            "Olduser123",
            "Strangeuser123"
        ]
    
    func didTapButton() {
        print("DEBUG PRINT:", "Button Pressed")
    }

}


struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
            .environmentObject(CartManager())
    }
}

# BankApplication



# Create User

Http method - Post 

URL-localhost:9090/user/createUser

{

  "email": "jeevan9948@gmail.com",
  
  "firstName": "jeevan",
  
  "lastName" : "B",
  
  "contact": "7418529632",
  
  "password": "136547890",
  
  "userType" : "CUSTOMER",
  
  "status" : "ACTIVE"   
  
}


# Delete User

Http Method - Delete

Url - localhost:9090/user/deleteUser/1

# Deposite Amount

Http Method - Post

Url -  localhost:9090/transaction/deposite

{

    "amount": 1000,
    
    "applicationUsed":"APP",
    
    "toBankAccNum":"1610507530749",
    
    "fromBankAccNum":"1610507594211"
    
}

# With draw Amount 

Http Method - Post

Url - localhost:9090/transaction/withdraw

{

    "amount": 1000,
    
    "applicationUsed":"APP",
    
    "fromBankAccNum":"1610507530749"   
    
}

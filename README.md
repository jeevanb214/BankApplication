# BankApplication


post localhost:9090/user/createUser

{
  "email": "jeevan9948@gmail.com",
  "firstName": "jeevan",
  "lastName" : "B",
  "contact": "7418529632",
  "password": "136547890",
  "userType" : "CUSTOMER",
  "status" : "ACTIVE"    
}

delete localhost:9090/user/deleteUser/1

post localhost:9090/transaction/deposite
{
    "amount": 1000,
    "applicationUsed":"APP",
    "toBankAccNum":"1610507530749",
    "fromBankAccNum":"1610507594211"
    
}

localhost:9090/transaction/withdraw

{
    "amount": 1000,
    "applicationUsed":"APP",
    "fromBankAccNum":"1610507530749"    
}

This is a simple rest app for creating user accounts and the transactions, And fetching the corresponding details

Not included the test ( planned to use rest assured for this) due to time contrains

This application can be tested with below steps

1. Import this project into Intellij Idea or Similar IDE
2. Ensure all the maven dependencies are downloaded
3. Run the application

Alternatively you can use the jar from below dropbox location and execute the application using 
https://www.dropbox.com/sh/1350jya0yjmzop4/AACwVSAvTNg7Wxya5QzP0USOa?dl=0
java -jar bankaccountapp.jar.

In-Memory database :

This app use an in memory database for simplicity. 

Rest Object Model :

This application assumes three entities viz., User / Account / Transaction

The objects can be CURD using the respective HTTP methods

Validation : The validation is only to check for the availability of the parent Object, this we cannot get/add account
for non available user. Similarly for the transactions.


POST http://localhost:8080/user will create an user with a specific name
The Json object for user creation can be 
{
	"userName": "bob"
}
GET http://localhost:8080/user retrieves all the available user
POST http://localhost:8080/user/{userId}/account can be used to create an account for the given userid
The Json object to be passed for account creation can be 

{
	"accountNumber": 23233232552,
	"currency" : "AUD",
	"accountName" : "Swami",
	"accountType" : "Savings",
	"balanceDate" : "10-02-2016",
	"openingAvailableBalance" : 23232.34
}

GET http://localhost:8080/user/1/account will return all the account for userid 1 ( This is for solution 1)

The response will be like 

[
    {
        "id": 4,
        "accountNumber": 2323323232,
        "currency": "SGD",
        "accountName": "Swami",
        "accountType": "Savings",
        "balanceDate": "10-02-2016",
        "openingAvailableBalance": 23232.34,
        "user": {
            "userName": "krish",
            "userId": 1
        }
    },
    {
        "id": 5,
        "accountNumber": 23233232552,
        "currency": "AUD",
        "accountName": "Swami",
        "accountType": "Savings",
        "balanceDate": "10-02-2016",
        "openingAvailableBalance": 23232.34,
        "user": {
            "userName": "krish",
            "userId": 1
        }
    }
]


POST http://localhost:8080/user/1/account/4/transaction will add transaction for the User 1 and account 4. 
The Json Object to be sent will be 

{
	"transactionType" : "DEBIT",
	"valueDate" : "11-02-2016",
	"amount" : 132.34,
	"transactionDetail" : "bonus credit"
}

GET http://localhost:8080/user/1/account/4/transaction provides all the transaction as JSON

[
    {
        "id": 9,
        "valueDate": "10-02-2016",
        "transactionType": "CREDIT",
        "transactionDetail": "bonus credit",
        "amount": 12.34,
        "account": {
            "id": 4,
            "accountNumber": 2323323232,
            "currency": "SGD",
            "accountName": "Swami",
            "accountType": "Savings",
            "balanceDate": "10-02-2016",
            "openingAvailableBalance": 23232.34,
            "user": {
                "userName": "krish",
                "userId": 1
            }
        },
        "openingAvailableBalance": 12.34
    },
    {
        "id": 10,
        "valueDate": "11-02-2016",
        "transactionType": "CREDIT",
        "transactionDetail": "bonus credit",
        "amount": 132.34,
        "account": {
            "id": 4,
            "accountNumber": 2323323232,
            "currency": "SGD",
            "accountName": "Swami",
            "accountType": "Savings",
            "balanceDate": "10-02-2016",
            "openingAvailableBalance": 23232.34,
            "user": {
                "userName": "krish",
                "userId": 1
            }
        },
        "openingAvailableBalance": 132.34
    },
    {
        "id": 11,
        "valueDate": "11-02-2016",
        "transactionType": "DEBIT",
        "transactionDetail": "bonus credit",
        "amount": 132.34,
        "account": {
            "id": 4,
            "accountNumber": 2323323232,
            "currency": "SGD",
            "accountName": "Swami",
            "accountType": "Savings",
            "balanceDate": "10-02-2016",
            "openingAvailableBalance": 23232.34,
            "user": {
                "userName": "krish",
                "userId": 1
            }
        },
        "openingAvailableBalance": 132.34
    }
]




# Warehouse

## About Warehouse Management Project
This project need to have a Warehouse Management System to organize and structure our inventory, and as developer i can help us develop that system. The development manager has designed the test so that it will give us a better sense of your skills as a developer and what approaches and work methodologies you do use to solve problems and prioritize requirements without providing  with detailed instruction.


## Introduction

Aim is to Create a Warehouse Inventory-Management application for our hardware store. 
### Points to create the application
The application will be used by three different role’s authorizations, cashier, manager and the admin. Each one of these users must have access to different interfaces in the application depending on their role. The inventory has different entries for each product, and there are different amounts of items of each product.

As the application will be large and complex, i used a design pattern, like MVC, breaking the application down to separate classes and packages, instead of having many functions in the same class. I.e it’s important to that your application follows a highly structured design that offers the object-oriented principles such as low coupling, high cohesion, abstraction, interfaces and multiple layers.
A cashier must be able to, after they’ve sold an item, remove that item from the inventory. Cashiers must also have access to the inventory to check if an item is about to run out of stock, and in that case place an order on that item. A sold item can be returned to the store only if the customer has the receipt number, so that the cashier can search for the transaction and delete it from the system, after that the item will be placed back into the inventory. There must always be one display item of each product that can not get sold.
Manager must be able to see the order list (made by the cashier), and review the inventory, to decide whether to order the items.A copy of the order details and all transactions must be saved after an order has been made. 
Cashiers and managers are hired by the admin, who has access to everything in the system. The admin is also responsible to pay salaries to the employees, and review the transactions, cash flow, profits and costs and everything else for the last year. The application provides the admin with statistics about best selling items and profits of each product including retail and purchese prices.
There must be a discussion channel that only admin and managers can use to chat with each other. When a user sends a message to the group chat, a notice will be shown in the menu telling the others that someone has sent a message.
Users’ login, transactions, order lists, ordered items, returned items, receipts, statistics and chat conversations must be saved in separate text files.
The home menu allows users to choose the role they have to sign in with,  and depending on their role they will then get into a customized multiple-option menu.
All error exceptions (runtime exceptions) and cashier-made transactions will be handled by separate threads, so that only one user at a time can write into a specific file, and once the file is closed it’s available for other users to use.
Since your code will be huge and complex, and in order to follow a stable structure in your application testing different functionalities in different cases and scenarios, you must add a couple of automated tests to simulate every type of user. Don’t forget to think about worst cases and test them to guarantee that your application can handle any usage functionalities in all circumstances.
Fill the inventory with different types of items in different amounts, and there must be at least one Manager and two Cashiers.




## Usage
Application stores products by adding and saving in inventory and cashier will be responsible to do so and his role also have rights to update product count based on sellin the product by creating a transaction of the product details with customer details. if the customer ask more than the products in incentory he will place order list which was approved by manager.The user who enter as manger can view the order and also approve the order.Admin has the highest overall view of the application by viewing all list and also he can add users and also genereate payslips and much more but due to time constrains I developed cashier full optoins and admin to view all the list and manager to approve for this time. If time is available i would do or update more functionalities.



## Technologies
            -User Stories(Jira)
            -UML Usecase diagram(Lucidchart)
            -UML Class diagram (PlantUML)
            -Developed code in IntellliJ Idea Community version using Java 17.0.2

The above diagrams are find in Requirements folder .Step by step creation of how project requiremnt started with User Stories and task and also usecases and then  then class diagram and then to code is shown in screenshots.The entire process followed agile methodology.
## Launch
             To run the Jar file in commandprompt(cmd) using java -jar Warehouse.jar 
### How to test/work with the project ---Notes to the reviewer
The application starts with loginPage where based on user input and password we decide from data whether he is admin or manager or cashier.Based on the role their availble functionalities are listed and he choose which he prefer to do. For the time being with Json read and write issues(First time using Json)** knowlwdge .., I request the reviewer to use user roles which are in UserValidation to test with process for diff role and also have the data like how i set ,my code works and meet the requirement in adding updating and removing in arraylist but  while reading and updating in file that the information but add again and agian so , revire once done can go open file and edit/delete the old entry , sicen it will be uppdated correctly with new entry along with old entry . (which i dont know to fix this time) the code is correct but due to reading and writing from file in json it duplicate the new data with correct value and have old.
#####Inorder to test run in termianal , user roles from UserValidation 
cashier it load from file correctly then u can  add aproduct, view see order list and transaction list .(all json files now with currect data) 
admin can view all order, view, product lsit
manager can view and approve the orderlist

 once after making change by adding ort updating with return or selling  the corrected entry in stored along with old entry where the values remain there.. basically u can see two entry one b4 changes and one after changes also in the  new view ( which i find tough to fix) changing to other way of reading or writing at last minute will be tough.. pls consider ..


## Room for Improvements
The JSON object file writing and reading was working but i could not replace or append, i tried all possible way to fix this. may be with more time I might be able to deliver the application without thsese redudent data in files

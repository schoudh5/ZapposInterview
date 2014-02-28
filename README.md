ZapposInterview
===============
This is the project for Zappos Software Engineering College Intern position.

Problem Statement: test a simple application that allows a user to submit two inputs: N (desired # of products) and X (desired dollar amount). The application should take both inputs and leverage the Zappos API (http://developer.zappos.com/docs/api-documentation) to create a list of Zappos products whose combined values match as closely as possible to X dollars. For example, if a user entered 3 (# of products) and $150, the application would print combinations of 3 product items whose total value is closest to $150.

This is a console application build in java. Application requirements : JDK 1.7

Here is the description of the files of the Application
--
1. Src/zappos/ProductSelect.java - Implements an algorithm that selects the desired number of products whose price is closest to the specified amount.
2. Src/zappos/Product.java - Stores Basic information like related to product like price,original price, product name, brand  etc.
3. Src/zappos/ZapposSearchResult - Has a data structure that holds the data that is returned by the Zappos search API.
4. Src/zappos/Utility.java - Contains routines that calles the zapposAPI and various other helper methods.
5. Src/Program.java - Main driver program that takes input of various parameters.
6. config.properties- This file contains the URL of the zappos API used to retrieve a list of products using the Search API.
7. Libraries used in this project are included in the libraries folder.

--
Please note
===============
1. if you wan to test the application execute the ZapposInterview.jar file in ExecutableJarFile folder
2. If you want to make changes in the search API url you just need to modify the url in config.properties file in the ExecutableZarFile folder.
3. If you are making any changes in the source code then you may need to recompile or rebuild the application.

Instructions for executing the .jar File
===============
1. Make sure that you have JDK 1.7 or JVM 1.7 installed on you machine.
2. Download the executable jar and the config.properties file from ExecutableJarFile folder. If required, change the search API in the config.properties file.
3. Navigate using the command prompt of your system to the directory in which the jar file is located. Make sure that config.properties and jar for execution are residing in the same folder.
4. Use the command "java -jar ZapposInterview.jar" to execute the jar file. It will ask for the total amount you like to spend and the number of products.


  

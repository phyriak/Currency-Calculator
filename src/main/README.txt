 Simple currency calculator. Program is counting amount from Euro to another currency. The rate of currency is read from XML file.
 Rate of currency is located in resources.
 XMLParser take name of data from resources and read this file.
 The output of XMLParser is Map, result of file parsing and putting it into Map where key is String signature of currency
 and value is Double and it is rate of this currency.

 Calculator has method exchange. Input is double amount (in Euro) and String signature of currency which we have exchange the money.
 Program check correctness of amount. If Number of decimal places is greater then 2 or the number is negative value program throw exception.
 Program is reading file using XMLParser and method read. For loop is comparing signature of currency from map and from input to the method.
 When is equal program is counting value of amount for new currency. The result is rounded to floor to two decimal places.
 If after loop result is null and we don't have counted value it means that currency signature was incorrect and throw exception
 To start the program you need to Run Calculator main method and put your input to the method.

 Github: https://github.com/phyriak/Currency-Calculator.git

 C:\Java\currency_calculator\src\main\resources\rate.xml
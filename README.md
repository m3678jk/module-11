# module-11
Java Concurrency

Task 1
Write a program that displays data on the screen every second about the time 
that has elapsed since the beginning of the session (launch of the program).
Her other thread outputs the message "5 seconds have elapsed" every 5 seconds. 
Make sure that the thread that plays the message is alerted every second by the thread that is counting the time.

Task 2
Write a program that prints to the console a string consisting of numbers from 1 to n, but with some values replaced:
if the number is divisible by 3 - output "fizz"
if the number is divisible by 5 - output "buzz"
if the number is divisible by 3 and 5 - output "fizzbuzz"
For example, for n = 15, the expected result is: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.
The program must be multi-threaded, work with 4 threads:
Thread A calls fizz() to check divisibility by 3 and output fizz.
Thread B calls buzz() to check divisibility by 5 and output buzz.
Thread C calls fizzbuzz() to test divisibility by 3 and 5 and output fizzbuzz.
Thread D calls number() to print the number.

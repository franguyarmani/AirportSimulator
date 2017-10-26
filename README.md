# AirportSimulator
An object oriented program to simulate how an airport might manage planes landing 
and taking offI took an object oriented approach using the objects Plane, Runway, 
and Airport. I will explain them below in Classes/funcitons.

	=========================Input/Output=========================
An example of the input to the simulator is shown in Input.txt and was created by 
InputRandomizer.java. The first interger represents the relative time, to be 
converted into standard time notation later. The second two numbers are the 
number of planes try to land and take off respectively, the following numbers
depend on the values of the second and third, as they are the flight numbers of 
the planes. 

An example of the output of main.java is shown in the Output.txt file. It is easy 
for a person to read and there for needs little explanation. 


	=======================Classes/Functions======================
	

		--------------InputRandomizer.java------------
As mention earlier, this function generates the input. Takes no arguements.

		-------------------Main.java------------------
This class creates the objects and deals with the input reading and output writing.
Its most important parts are reading in the input values, calling DirectPlanes and
RecievePlanes, and writing the output in a human-readable manner. 

		------------------Airport.java----------------
This class makes the object airport. It also contains the main functions for 
operating the Queues and Runways. 

+EvaluateQueues
Compares the length of the linked lists representing each queue, returns 1 if the 
landing queue is to long compared to the take off queue, returns 0 if they are 
close enough (lengths less than for apart) and returns -1 if the take off queue
is too long.

+DirectPlanes
This functions takes the value from EvaluateQueues and then determines whether to 
land two planes, launch to planes, or one of each. 

+RecievePlanes
takes the input that was parsed by the Main.java class and uses it to make the new 
planes and add them to the queues in which they belong.
				 				
		------------------Runway.java-----------------
An object possessed by the Airport to land planes. Has a variable to indicate the 
last plane to use it. 
		-------------------Plane.java-----------------	
An object to represent the planes in the ques. Possess a flight number and Queue 
number.	

	===========================Assumptions=========================
I maintained the same assumptions outlined in the assignment. Specifically:
	-No more than three planes may request to land every 5 minutes
	-No more than three planes may request to take off every 5 minutes
	-The queues may differ in length slightly
	-There is an equal probability of any number of planes from 0 to 3 
	 arriving

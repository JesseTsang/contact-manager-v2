contact-manager-v2
==================

2nd assignment of COMP 249.


Requirements: 
The requirements team has given the following new requirements for the Contact Manager application: 
The application should support two different types of contacts, namely business contacts and personal contacts. Both types have exactly the same properties (i.e., attributes) with the Contact class in the original design, but additionally they provide some new properties. The business contact allows the storage of meetings (objects of Meeting class), while the personal contact allows the storage of some special events (objects of SpecialEvent class), such as birthdays and anniversaries.

Each Meeting has the following attributes: 
- start time (DateTime) 
- end time (DateTime) 
- location (String) 
- description (String) 

Note: You will have to use the Joda date and time API for creating and using DateTime objects. The library can be downloaded from http://joda-time.sourceforge.net/ and a quick start guide can be found here. Two meetings are considered equal if their start time, end time and location attributes are equal. 

Each SpecialEvent has the following attributes: 
- event type [Birthday, Anniversary, Other] (Hint: use Enum types) 
- date (DateTime) 
- recurring (boolean) 

Note: The attribute recurring is used to specify whether the event is recurring every year. Two special events are equal if their event type and date attributes are equal. 
The class BusinessContact will be used to store the meetings corresponding to a contact in an array of Meeting objects. The class PersonalContact will be used to store the special events corresponding to a contact in an array of SpecialEvent objects.
Both Meeting and SpecialEvent classes implement the interface Event which defines the method isWithinPeriod(DateTime start, DateTime end). This method takes a start date and an end date as arguments and returns a boolean value which is true only if the event takes place between the start and end dates. 

Task #1 
Design and implement the required classes (BusinessContact, PersonalContact, Meeting, SpecialEvent and Event). Make sure that you create the appropriate inheritance relationships between the classes. 

- For each class, create an appropriate constructor that initializes the values of the attributes. (Hint: attributes of array type should be initialized as empty arrays allowing to store 100 objects at maximum) 

- Create method addMeeting() for the addition of a meeting in class BusinessContact. The method should examine if the meeting passed as argument already exists in the array and add it only if it is not already present. (Hint: the check should be performed using the corresponding equals() method) 

- Create method addSpecialEvent() for the addition of a special event in class PersonalContact. The method should examine if the event passed as argument already exists in the array and add it only if it is not already present. (Hint: the check should be performed using the corresponding equals() method) 

- Implement method isWithinPeriod() in class Meeting. The method should return true if either the start time or end time of the meeting is within the specified period. (Hint: use methods isBefore() and isAfter() of DateTime class to compare the dates) 

- Implement method isWithinPeriod() in class SpecialEvent. The value of attribute “recurring” should be taken into account. (Hint: use methods isBefore() and isAfter() of DateTime class to compare the dates) 

- Modify the main() method in Driver class appropriately and add some meetings and special events to the contacts. 

Task #2 
Create method printEventsWithinPeriod() in ContactManager that takes a start date and an end date as arguments, iterates through the contacts stored in ContactManager and prints the meetings (if the contact is a business contact) and special events (if the contact is a personal contact) that are within the specified period. 
This method should make use of polymorphism by calling method getEventsWithinPeriod() defined in the Contact inheritance hierarchy. 
The latter method takes a start date and an end date as arguments, iterates through the events (meetings or special events) of each contact and returns an array of the events that take place within the specified period. If the returned array is not empty the method printEventsWithinPeriod() prints first the name of the corresponding contact and then the returned events. 
(Hint: you can check if the returned array is empty by examining if the object in the first position of the array is null. To print the event use a while loop that checks whether the current element in the array is not null)


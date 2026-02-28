## 🎬 Movie Booking System – Console Application
## 📖 Overview
The Movie Booking System Console App is a simple Java application that simulates a movie management and ticket booking system. It is designed for learning purposes and demonstrates how to build a modular console-based application using Java, with Lists as the in-memory storage (instead of a database).

The system supports three types of users:

Admin – manages movies and bookings

Staff – manages movie shows

Customer – browses movies/shows, books tickets, and manages their profile

## ⚙️ Features
👨‍💼 Admin

View all movies and shows

Add new movies

Update movie details

Delete movies

View all bookings

Filter bookings by:

Movie

Customer

Date

👩‍💻 Staff

Schedule a movie show

Update show details

Cancel shows

View all scheduled shows

👤 Customer

View and edit profile

Browse available movies and shows

Book tickets

View booking history

View active bookings / balance

## 🛠️ Technologies Used
Java SE (Core Java)

Collections Framework (List, ArrayList)

Scanner for console input

Modular Service Classes (AdminService, StaffService, CustomerService)

Entity Classes (Movie, Show, Customer, Booking)

## 📂 Project Structure
                        MovieBookingSystem-ConsoleApp/
                        │
                        ├── src/com/kce/entity/
                        │   ├── Movie.java
                        │   ├── Show.java
                        │   ├── Customer.java
                        │   └── Booking.java
                        │
                        ├── src/com/kce/service/
                        │   ├── AdminService.java
                        │   ├── StaffService.java
                        │   └── CustomerService.java
                        │
                        ├── src/
                        │   └── Main.java   # Entry point with console menu
                        │
                        └── README.md


▶️ How to Run
Clone the repository:

git clone https://github.com/nirmala1610/MovieBookingSystem-ConsoleApp.git
Navigate to the project folder and compile:


javac src/com/kce/entity/*.java src/com/kce/service/*.java src/Main.java
Run the application:


java Main
Follow the console menu to interact as Admin, Staff, or Customer.

## 📌 Notes
Data is stored in Lists (ArrayList) and will be lost once the program exits.

This project is intended for learning and demonstration purposes.

Future improvements could include:

Persistent storage (e.g., database integration)

Exception handling and input validation

Unit tests for service classes

## 👩‍🏫 Learning Outcomes
Understanding object-oriented design in Java

Practicing CRUD operations with in-memory collections

Building a console-based menu-driven application

Applying modular service architecture

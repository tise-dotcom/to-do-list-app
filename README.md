# Java Swing To-Do List App

A lightweight, desktop-based task management application built using Java and Java Swing. This project demonstrates the implementation of a Graphical User Interface (GUI) and adheres to the Model-View-Controller (MVC) architectural pattern to ensure a clean separation of concerns.

## Features

Add Tasks: Quickly input new tasks to keep track of your goals.

Save & Cancel: Dedicated controls to confirm task creation or clear the input field.

Delete Tasks: Easily remove items from your list once they are no longer needed.

Mark as Complete: A checkbox next to each task allows users to strike through the text, visually marking it as finished.

## Project Architecture

This application is structured using the MVC design pattern, divided into three core files:

 App.java File: Contains the `main` method. It initializes the application, links the View and the Controller, and triggers the UI display.

 ToDoListApp.java File: Handles all visual elements. It contains the Java Swing components (like `JFrame`, `JPanel`, `JButton`, `JLabel`, and `JCheckBox`), manages the layout, and updates the screen (e.g., applying the strikethrough effect when a task is checked).

 AppControls.java File: Acts as the brain of the application. It processes user input and tells the View how and when to update the display based on user actions.

## Prerequisites

To run this project, you will need to have the following installed on your machine:

[Java Development Kit (JDK)] https://www.oracle.com/java/technologies/downloads/ 
(Version 8 or higher is recommended)

## How to Run

Using an IDE:
1. Clone or download this repository to your local machine.
2. Open the project folder in your preferred Java IDE.
3. Locate the App.java file containing the `main` method.
4. Click Run or Debug.

Using the Command Line:
1. Open your terminal or command prompt.
2. Navigate to the `src` directory.
3. Compile the Java files.
4. Run the main application file.

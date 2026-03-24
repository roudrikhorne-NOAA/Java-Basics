# 🌴 Vice City Payroll & Intel System 🕶️

> *"More than just payroll. It's a fully persistent, satellite-connected squad management system."*

## 🎬 Project Synopsis
The **Vice City Payroll & Intel System** is a robust, console-based Java application designed to manage a police squad's payroll while keeping officers informed of live, real-world field conditions. 

Built as the capstone for an 8-week Java architecture roadmap, this system evolved from a simple calculator into a fully Object-Oriented, networked application with local data persistence.

## ✨ Blockbuster Features
* **📡 Live Satellite Intel (Networking):** Integrates the `java.net.http.HttpClient` to make real-time API calls to the Open-Meteo weather satellite. Parses live JSON data to deliver current temperatures (Celsius/Fahrenheit) and windspeeds for Miami, NYC, and Portland.
* **💾 The Vice Dossier (Data Persistence):** Utilizes Java File I/O (`FileWriter`, `Scanner`) to automatically load past sessions and append new employee data to a local `Payroll_Report.txt` database. No data is ever lost when the system powers down.
* **🧬 Object-Oriented Architecture:** Employs classes, inheritance, and polymorphism to handle different employee types seamlessly:
  * **Developers** (Standard rate)
  * **Contractors** (Straight time, no overtime)
  * **Managers** (Includes weekly bonuses)
* **🛡️ "Indestructible" Input Traps:** Features comprehensive `try-catch` exception handling and `while` loops to prevent application crashes from invalid user inputs or offline network connections.

## 🛠️ The Tech Stack
* **Language:** Java (JDK 11+)
* **Core Libraries:** `java.util`, `java.io`, `java.net.http`
* **API:** [Open-Meteo](https://open-meteo.com/) (No API key required)
* **Concepts Mastered:** OOP, ArrayLists, Exception Handling, File Reading/Writing, API Requests, JSON String Parsing, Geocoding Logic.

## 🚀 Ignition Sequence (How to Run)
1. Clone this repository to your local machine.
2. Ensure you have the Java JDK installed.
3. Compile and run `Main.java` from your terminal or IDE.
4. When prompted for a Target City, hit **Enter** for Miami, or type "Portland" or "NYC" to test the geocoding logic.
5. Follow the on-screen prompts to add new squad members to the dossier!

---
*Developed by Roudrik Horne. The Ferrari is waiting.* 🏎️💨

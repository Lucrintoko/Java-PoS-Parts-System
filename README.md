# Java-PoS-Parts-System

Here is a professional, modern, and structured README file for your GitHub repository.

-----

# 🖥️ Java Point of Sale (POS) System

> **A comprehensive Point of Sales System developed as a school project, utilizing Java Swing and AWT to simulate a computer hardware store interface.**

## 📖 Overview

The **Java-PoS-System** is a desktop application designed to manage transactions for computer hardware components (CPUs, GPUs, SSDs, and RAM). It features a dynamic inventory management system, real-time cart calculations, and a file-based receipt generation system. The interface is modular, divided into distinct panels for inventory tracking, product selection, and transaction processing.

-----

## 🚀 Key Features

### 📦 Inventory & Brand Management

  * **Dynamic Brand Selection:** Users can filter products by brand via the **Middle Panel (Top)**.
  * **Category Counters:** Real-time stock counters for specific product categories (CPU, GPU, SSD, RAM) displayed on the **Left Panel**.
  * **Stock Management:** Automatic stock deduction when items are added to the cart and stock restoration when the cart is cleared.

### 🛒 Cart & Transaction Processing

  * **Interactive Shopping Cart:** View selected items, adjust quantities, or remove items directly from the list on the **Right Panel (Top)**.
  * **Real-time Financials:** Automatic calculation of:
      * Sub-Total
      * Tax Amount
      * Grand Total
  * **Receipt Generation:** The **Checkout** feature exports the transaction details (items, prices, and totals) into a formatted `.txt` file.

### 📂 File System Integration

  * **Receipt History:** Built-in integration with `JFileChooser`, allowing users to browse and view previous transaction receipts directly within the application.

-----

## 🏗️ Application Structure

The application architecture is divided into modular panels:

| Component | File | Description |
| :--- | :--- | :--- |
| **Category Tracker** | `LeftPanel.java` | Tracks the inventory count for the selected brand's categories (CPU, GPU, SSD, RAM). |
| **Brand Selector** | `MiddlePanel.java` | **Top:** Buttons to select hardware brands.<br>**Bottom:** Displays available products for the selected brand with Add/Subtract controls. |
| **Transaction Hub** | `RightPanel.java` | **Top:** The Cart List and Financial Totals.<br>**Bottom:** Action buttons (Checkout, Clear Cart, View Receipts). |

-----

## 🛠️ Tech Stack

  * **Language:** Java
  * **GUI Frameworks:** Java Swing, Java AWT
  * **File I/O:** Standard Java I/O (for receipt generation and reading)

-----

## 📥 Installation

You can run the application either by compiling the source code manually or by downloading the pre-built executable.

### **Option 1: Run from Source Code**

If you wish to view the code or run it via the terminal:

1.  **Download:** Click the green **Code** button \> **Download ZIP**.
2.  **Extract:** Unzip the file to your desired folder location.
3.  **Compile & Run:** Open your terminal or command prompt, navigate to the project directory, and execute the following commands:

<!-- end list -->

```bash
javac PoSSystem.java
java PoSSystem.java
```

### **Option 2: Run via Executable (Releases)**

For a quick-start experience without compiling:

1.  **Download:** Navigate to the **[Releases](https://www.google.com/search?q=%23)** section on the right side of the repository and download the latest `.zip` file.

2.  **Extract:** Unzip the file to your desired folder location.

3.  **Run:** Open the extracted folder and launch the application by running:

    `SparksPOS\SparksPOS.exe`

-----

## 🕹️ Usage Guide

Follow these steps to operate the Point of Sale system:

1.  **Select a Brand:** Navigate to the **Middle Top Panel** and click on a brand button to load its products.
2.  **Manage Cart:**
      * In the **Middle Bottom Panel**, use the buttons to Add (+) or Subtract (-) products.
      * *Optional:* You can also remove items directly from the cart list in the **Right Top Panel**.
3.  **Checkout:**
      * Once satisfied with the selection, click the **Checkout** button.
      * This will generate a `.txt` receipt with your transaction details.
4.  **Reset:**
      * To start over, click the **Clear Cart** button. This returns all items in your cart back to the system stock.
5.  **View History:**
      * Click the **View Receipts** button to open the file explorer.
      * Select a previously generated receipt `.txt` file to view it within the app.

-----

### 👤 Author

  * **Sean Matthew Araneta** - *Main Programmer*
  * **Nash Khristianne Francisco** - *Layout Designer*
  * **Marius Parchamento** - *Minor Front-End Programmer*
  * **Bari Berham** - *Minor Front-End Programmer*

-----

*This project is for educational purposes demonstrating the capabilities of Java Swing and Object-Oriented Programming.*
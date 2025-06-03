
# Mylibrary - Java Data Analyzer 📊

This is a personal Java project developed in Eclipse. It reads book rating data from a CSV file, calculates basic statistics, and generates a histogram of the ratings.

## 📁 Project Structure

- `Book.java` - A simple class that stores the rating information of a book.
- `analysis.java` - Main program that:
  - Loads data from a file
  - Calculates total, average, median, and standard deviation
  - Constructs a histogram grouped by 0.1 rating intervals

## ▶️ How to Run

1. Open this project in Eclipse (or any Java IDE)
2. Run `analysis.java` as the main class
3. When prompted, enter the filename (e.g., `bestsellers.csv`) containing rating data (in the third column)

Example format of input file:

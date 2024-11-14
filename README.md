
# Library API

This project provides a set of RESTful API endpoints for managing books in a library. The API allows you to add, retrieve, and delete book records.

## Base URI

All endpoints are accessible via the following base URI:

```
http://216.10.245.166
```

## API Endpoints

### 1. Add a Book

- **Endpoint**: `/Library/Addbook.php`
- **Method**: `POST`
- **Description**: Adds a new book to the library.
- **Request Payload** (JSON):

  ```json
  {
      "name": "Learn Appium Automation with Java",
      "isbn": "bcd",
      "aisle": "227",
      "author": "John foe"
  }
  ```

- **Response** (JSON):

  ```json
  {
      "Msg": "successfully added",
      "ID": "bcd227"
  }
  ```

### 2. Get Book by Author

- **Endpoint**: `/Library/GetBook.php`
- **Method**: `GET`
- **Query Parameter**: `AuthorName`
- **Description**: Retrieves all books by a specific author.
- **Response** (JSON Array):

  ```json
  [
      {
          "Name": "bookname",
          "Isbn": "A2fdsf",
          "Aisle": 32
      }
  ]
  ```

### 3. Get Book by ID

- **Endpoint**: `/Library/GetBook.php`
- **Method**: `GET`
- **Query Parameter**: `ID`
- **Description**: Retrieves a book's details by its unique ID.
- **Response** (JSON):

  ```json
  {
      "book_name": "Selenium automation using Java",
      "isbn": "a23hd738",
      "aisle": "1223"
  }
  ```

### 4. Delete a Book

- **Endpoint**: `/Library/DeleteBook.php`
- **Method**: `POST`
- **Description**: Deletes a book from the library using its ID.
- **Request Payload** (JSON):

  ```json
  {
      "ID": "a23h345122332"
  }
  ```

- **Response** (JSON):

  ```json
  {
      "msg": "book is successfully deleted"
  }
  ```


## Test Execution Report

![TestNG result](https://github.com/rohitpunekar242/library-api-automation-rest-assured/blob/master/TestNG_Report.png)




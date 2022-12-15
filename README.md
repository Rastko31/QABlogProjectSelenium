# Website Testing

A Selenium-based QA testing suite for the web page "https://testblog.kurs-qa.cubes.edu.rs/admin".

## Technologies

- Java 8
- Selenium 4.5.0
- Eclipse 4.23.0

## Dependencies

- [ChromeDriver](https://chromedriver.chromium.org/)

## Setup

1. Install Java 8, Eclipse, and ChromeDriver.
2. Clone this repository.
3. In Eclipse, import the project directory as a new Java project.
4. In the project, run the `TestAddTag`, `TestDeleteTag`, `TestUpadeTag`, `TestCategories`, `TestPostsForm`, `TestPostsList` class to run the test suites.

## Test cases

- `TestAddTag`: tests adding a new tag to the "Tags" page.
- `TestDeleteTag`: tests deleting a tag from the "Tags" page.
- `TestUpadeTag`: tests updating a tag from the "Tags" page.
- `TestCategories`: tests adding, deleting and updating post category on the "Post Categories" page.
- `TestPostsForm`: tests adding on the "Add Post" page.
- `TestPostsList`: tests searching, editing, deleting on the "Posts" page.

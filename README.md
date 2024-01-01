# Quiz Applications

In the dynamic realm of digital interactions, our quiz application stands as a powerful tool for knowledge-sharing and engagement. 

## Question Management

- **Create:** Empower users to add new questions, enriching the quiz database for ongoing relevance.
- **Update:** Flexibility in modifying or editing questions ensures accurate content reflecting changes.
- **Delete:** Users control question quality, eliminating outdated content, preserving the quiz's integrity.

## Quiz Creation

User-friendly quiz creation is pivotal for engagement. Easily select and arrange questions, customizing quizzes based on specific themes or topics.

## Quiz Submission

Facilitate a smooth, intuitive submission process, allowing participants to finalize and submit answers effortlessly.

## Result Retrieval

Post-submission, users retrieve performance insights, providing valuable feedback for informative and motivational purposes.

## Java and Spring Boot

At the heart of our quiz application lies Java, a versatile language known for portability. Complementing Java is Spring Boot, simplifying development for scalability, maintainability, and efficiency.

## Usage

To use this quiz application, follow these steps:

1. Clone the repository to your local machine.
   ```
   git clone https://github.com/your-username/quiz.git
   ```

2. Install the necessary dependencies.

3. Run the application locally.

## Service Endpoints

### Create Questions

- **Add All Questions:**
  ```
  POST localhost:8080/question/all/save
  ```

- **Add Single Question:**
  ```
  POST localhost:8080/question/save
  ```

- **Get All Questions:**
  ```
  GET localhost:8080/question/all
  ```

- **Get Question by ID:**
  ```
  GET localhost:8080/question/:id
  ```

- **Update Question by ID:**
  ```
  PUT localhost:8080/question/update/:id
  ```

- **Delete Question by ID:**
  ```
  DELETE localhost:8080/question/delete/:id
  ```

- **Delete All Questions:**
  ```
  DELETE localhost:8080/question/delete/all
  ```

### Create Quiz 

- **Create a Quiz:**
  ```
  POST localhost:8080/quiz/create
  ```

- **Get Quiz by ID:**
  ```
  GET localhost:8080/quiz/:id
  ```

- **Submit Quiz and Get Answers:**
  ```
  POST localhost:8080/quiz/submit
  ```

- **Delete Quiz by ID:**
  ```
  DELETE localhost:8080/quiz/delete/:id
  ```

## Running the Application on IntelliJ IDEA or Any IDE

1. Open IntelliJ IDEA or your preferred IDE.

2. Import the project by selecting the root directory of the cloned repository.

3. Configure the application properties, ensuring correct port configurations for each service.

4. Run the `QuizApplication`.

5. Access the application via the provided endpoints.

Thank you for contributing to our quiz application! Let's make learning and engagement even more accessible together.

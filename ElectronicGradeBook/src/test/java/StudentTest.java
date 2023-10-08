import org.example.persons.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StudentTest {
    @Test
    public void shouldCreateStudentWithCorrectFirstAndLastName(){
        //given
        String firstName = "John";
        String lastName = "Wick";

        //when
        Student student = new Student(firstName, lastName);

        //then
        assertAll(
                () -> assertThat(student.firstName()).isEqualTo(firstName),
                () -> assertThat(student.lastName()).isEqualTo(lastName)
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfFirstNameIsEmpty(){
        //given
        String firstName = "";
        String lastName = "Test";

        //when
        Throwable throwable = catchThrowable(()->new Student(firstName, lastName));

        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("First or last name is empty");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfLastNameIsEmpty(){
        //given
        String firstName = "Test";
        String lastName = "";

        //when
        Throwable throwable = catchThrowable(()->new Student(firstName, lastName));

        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("First or last name is empty");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionIfNameContainsDigit(){
        //given
        String firstName = "Michael";
        String lastName = "Sc0ffield";

        //when
        Throwable throwable = catchThrowable(() -> new Student(firstName, lastName));

        //then
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name contains a digit");
    }

    @Test
    public void shouldCalculateCorrectGradesAverage(){
        //given
        int[] grades = {3,5,2,6};
        Student student = new Student("Adam", "Nowak", grades);

        //when
        double average = student.getAverageGrade();

        //then
        Assertions.assertEquals(4.0, average);
    }
}

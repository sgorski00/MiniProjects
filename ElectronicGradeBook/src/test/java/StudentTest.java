//import org.example.domain.Student;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertAll;
//
//public class StudentTest {
////    @Test
////    public void shouldCreateStudentWithCorrectFirstAndLastName(){
////        //given
////        String firstName = "John";
////        String lastName = "Wick";
////
////        //when
////        Student student = new Student(firstName, lastName, 0);
////
////        //then
////        assertAll(
////                () -> assertThat(student.firstName()).isEqualTo(firstName),
////                () -> assertThat(student.lastName()).isEqualTo(lastName)
////        );
////    }
//
//    @Test
//    public void shouldThrowIllegalArgumentExceptionIfFirstNameIsEmpty(){
//        //given
//        String firstName = "";
//        String lastName = "Test";
//
//        //when
//        Throwable throwable = catchThrowable(()->new Student(firstName, lastName));
//
//        //then
//        assertThat(throwable)
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("First or last name is empty");
//    }
//
//    @Test
//    public void shouldThrowIllegalArgumentExceptionIfLastNameIsEmpty(){
//        //given
//        String firstName = "Test";
//        String lastName = "";
//
//        //when
//        Throwable throwable = catchThrowable(()->new Student(firstName, lastName, 0));
//
//        //then
//        assertThat(throwable)
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("First or last name is empty");
//    }
//
//    @Test
//    public void shouldThrowIllegalArgumentExceptionIfNameContainsDigit(){
//        //given
//        String firstName = "Michael";
//        String lastName = "Sc0ffield";
//
//        //when
//        Throwable throwable = catchThrowable(() -> new Student(firstName, lastName, 0));
//
//        //then
//        assertThat(throwable)
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("Name contains a digit");
//    }
//}

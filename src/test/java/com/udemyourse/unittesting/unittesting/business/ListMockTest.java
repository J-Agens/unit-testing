package com.udemyourse.unittesting.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;

public class ListMockTest {
  
  List<String> mock = Mockito.mock(List.class);
  
  @Test
  public void size_basic() {
    when(mock.size()).thenReturn(5);
    assertEquals(5, mock.size());
  }
  
  @Test
  public void returnDifferentValues() {
    when(mock.size()).thenReturn(5).thenReturn(10);
    assertEquals(5, mock.size());
    assertEquals(10, mock.size());
  }
  
  @Test
  public void returnWithParameters() {
    when(mock.get(0)).thenReturn("in28Minutes");
    assertEquals("in28Minutes", mock.get(0));
    assertEquals(null, mock.get(1));
  }
  
  @Test
  public void returnWithGenericParameters() {
    when(mock.get(anyInt())).thenReturn("in28Minutes");
    assertEquals("in28Minutes", mock.get(0));
    assertEquals("in28Minutes", mock.get(1));
  }
  
  @Test
  public void verificationBasics() {
    // SUT (system under test)
    String value1 = mock.get(0);
    String value2 = mock.get(1);
    
    // Verify (that the get method is called on the mock)
    verify(mock).get(0);
    verify(mock, times(2)).get(anyInt()); // verify that it's called twice
    verify(mock, atLeast(1)).get(anyInt()); // verify that it's called at least once (can also use atLeastOnce())
    verify(mock, atMost(2)).get(anyInt()); // verify that it's called at most twice
    verify(mock, never()).get(2); // verify that .get(2) is never called on mock
  }
  
  @Test
  public void argumentCapturing() {
    
    // SUT (system under test)
    mock.add("SomeString");
    
    //Verification
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(mock).add(captor.capture()); //Verify add method is called and capture argument
    assertEquals("SomeString", captor.getValue());
  }
  
  @Test
  public void multipleArgumentCapturing() {
    
    // SUT (system under test)
    mock.add("SomeString1");
    mock.add("SomeString2");
    
    //Verification
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(mock, times(2)).add(captor.capture()); //Verify add method is called twice and capture argument
    List<String> allValues = captor.getAllValues();
    assertEquals("SomeString1", allValues.get(0));
    assertEquals("SomeString2", allValues.get(1));
  }
  
  @Test
  public void mocking() {
    ArrayList arrayListMock = Mockito.mock(ArrayList.class);
    System.out.println(arrayListMock.get(0));//null
    System.out.println(arrayListMock.size());//0
    arrayListMock.add("Test");
    arrayListMock.add("Test2");
    System.out.println(arrayListMock.size());//0 (A mock does not retain behavior of the original class)
    when(arrayListMock.size()).thenReturn(5);
    System.out.println(arrayListMock.size());//5
  }
  
  //A spy, by default, retains behavior(code) of the original class.
  // You can stub(override) and verify specific behavior(methods) on a Spy.
  @Test
  public void spying() {
    ArrayList arrayListSpy = Mockito.spy(ArrayList.class);
    arrayListSpy.add("Test0");
    System.out.println(arrayListSpy.get(0));//Test0
    System.out.println(arrayListSpy.size());//1
    arrayListSpy.add("Test");
    arrayListSpy.add("Test2");
    System.out.println(arrayListSpy.size());//3
    when(arrayListSpy.size()).thenReturn(5);
    System.out.println(arrayListSpy.size());//5
    arrayListSpy.add("Test4");
    System.out.println(arrayListSpy.size());//5
    
    verify(arrayListSpy).add("Test4");
  }
}

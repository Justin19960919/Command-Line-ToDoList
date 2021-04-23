package problem1.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.controller.Options;

public class OptionsTest {
  private Options options;

  @Before
  public void setUp() throws Exception {
    options = Options.getInstance();
  }

  @Test
  public void getOptions() {
    assertEquals(13, options.getOptions().size());
  }


  @Test
  public void testHashCode() {
    Options options1 = Options.getInstance();
    assertEquals(options.hashCode(), options1.hashCode());
  }

  @Test
  public void testToString() {
    String s = "Options{options=[Option{cmd='--csv-file', takeValue=true}, Option{cmd='--add-todo', takeValue=false}, Option{cmd='--todo-text', takeValue=true}, Option{cmd='--completed', takeValue=false}, Option{cmd='--due', takeValue=true}, Option{cmd='--priority', takeValue=true}, Option{cmd='--category', takeValue=true}, Option{cmd='--complete-todo', takeValue=true}, Option{cmd='--display', takeValue=false}, Option{cmd='--show-incomplete', takeValue=false}, Option{cmd='--show-category', takeValue=true}, Option{cmd='--sort-by-date', takeValue=false}, Option{cmd='--sort-by-priority', takeValue=false}]}";
    assertEquals(s, options.toString());
  }

}
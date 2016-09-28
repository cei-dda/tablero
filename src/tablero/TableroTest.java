package tablero;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

  @Test
  public void test() {
    Tablero<Integer> tablero = new Tablero<>();
    
    for(int i = 0; i < 5; i++) {
      tablero.add(new Integer(i));
    }
    
    Integer ii = new Integer(123);
    tablero.add(ii);
    
    for(int i = 0; i < 5; i++) {
      tablero.add(new Integer(i + 5));
    }
    
    tablero.forEach(item->System.out.println(item));
    
    System.out.println(tablero.contains(1));
    
    System.out.println("--------------");
    
    System.out.println(tablero.getValueFromNextPositionCell(ii, 2));
  }

}

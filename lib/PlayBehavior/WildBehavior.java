import java.util.Scanner;

public class WildBehavior implements PlayBehavior {
   public void play(Game game) {
      Color[] colors = new Color[]{ Color.Red, Color.Green, Color.Blue, Color.Yellow };
      displayCardColors(colors);
      int index = scanUserInput();

      game.discardCard(new Card(colors[index], new NoPlayBehavior(), null, null));
   }

   private void displayCardColors(Color[] colors) {
      System.out.println("Here are your available colors to play:");
      for (int i = 0; i < colors.length; i++) {
         System.out.println(i + ". " + colors[i].value);
      }

      System.out.println("Enter the number of the color you want to play");
   }

   private int scanUserInput() {
      Scanner scanner = new Scanner(System.in);
      return scanner.nextInt();
   }
}

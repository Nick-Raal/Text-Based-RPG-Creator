import java.io.*;
import java.util.Scanner;

class Main {
  
  static Scanner scan = new Scanner(System.in);
  static File f;
  
  public static void main(String[] args) {
    System.out.println("File Name?");
    f = new File(scan.nextLine());
    try{
      f.createNewFile();
    }catch(Exception e){
      System.out.println("useless catch");
    }
    
    
    String s = "";
    while(!s.equals("exit")){
      System.out.println("Do you want to create an enemy or an item?");
      s = scan.nextLine();
      try{
        FileWriter fw = new FileWriter(f, true);
        if(s.toLowerCase().equals("item")){
            fw.write(writeItem());
            fw.write("\n");
          }else if(s.toLowerCase().equals("enemy")){
            fw.write(writeEnemy());
            fw.write("\n");
        }
        fw.close();
      }catch(Exception e){
        System.out.println(e);
      }
  }
  }
  private static String writeEnemy(){
      String output = "";
      System.out.println("Name?");
      String name = scan.nextLine();
      System.out.println("Health?");
      double health = Double.parseDouble(scan.nextLine());
      System.out.println("Initiative?");
      double init = Double.parseDouble(scan.nextLine());
      System.out.println("Attack Modifier?");
      double atkMod = Double.parseDouble(scan.nextLine());
      output = name.replaceAll(" ", "_") + " " + health + " " + init + " " + atkMod;
      String next = "";
      while(true){
        System.out.println("weapons: (type exit to exit)");
        next = scan.nextLine();
        if(next.toLowerCase().equals("exit")){
          break;
        }
        output += " " + writeEnemyWeapon();
      }
      System.out.println("repeat?");
      boolean repeat = scan.nextLine().toLowerCase().equals("yes");
      for(int i = 0; i < 4; i++){
        System.out.println("Armor #" + i);
        String s = writeEnemyArmor();
        output += " " + s;
        if(repeat){
          for(int j = 0; j< 3; j++){
            output += " " + s;
          }
          break;
        }
      }
      System.out.println("Gold?");
      double gold = Double.parseDouble(scan.nextLine());
      System.out.println("Exp?");
      double exp = Double.parseDouble(scan.nextLine());
      output += " " + gold + " " + exp;
      System.out.println("item drops? (Y/N)");
      next = scan.nextLine();
      if(next.toUpperCase().equals("N")){
        return output;
      }
      next = "";
      int n = 0;
      while(!next.equals("exit")){
        System.out.println("EXIT?");
        next = scan.nextLine();
        output += " " + writeItem();
        n++;
      }
      System.out.println("drop chances:");
      for(int i = 0; i < n; i++){
        System.out.println("drop chances for item #" + (i+1));
        output += " " + Double.parseDouble(scan.nextLine());
      }
    return output;
  }
  private static String  writeItem(){
      System.out.println("What are you trying to create?");
      String s = scan.nextLine();
      if(s.toLowerCase().equals("potion")){
        return writePotion();
      }else if(s.toLowerCase().equals("weapon")){
        return writeWeapon();
      }else if (s.toLowerCase().equals("armor")){
        return writeArmor();
      }else if(s.toLowerCase().equals("book")){
        return writeBook();
      }
      return null;
  }

  private static String writeArmor(){
      System.out.println("Name?");
      String name = scan.nextLine();
      name = name.replaceAll(" ", "_");
      System.out.println("Value?");
      int value = Integer.parseInt(scan.nextLine());
      System.out.println("Rarity?");
      int rarity = Integer.parseInt(scan.nextLine());
      System.out.println("Armour?");
      double armor = Double.parseDouble(scan.nextLine());
      System.out.println("Type?");
      int type = Integer.parseInt(scan.nextLine());
      int slot = 0;
    
      System.out.println("Slot?");
      slot = Integer.parseInt(scan.nextLine());

      return "ä"+name + " " + armor + " " + type + " " + slot + " " + value + " " + rarity;
  }

  private static String writeEnemyArmor(){
    System.out.println("Name?");
    String name = scan.nextLine();
    name = name.replaceAll(" ", "_");
    System.out.println("Armour?");
    double armor = Double.parseDouble(scan.nextLine());
    System.out.println("Type?");
    int type = Integer.parseInt(scan.nextLine());
    return "ä"+name + " " + armor + " " + type;
  }

  private static String writeWeapon(){
      System.out.println("Name?");
      String name = scan.nextLine();
      name = name.replaceAll(" ", "_");
      System.out.println("Value?");
      int value = Integer.parseInt(scan.nextLine());
      System.out.println("Rarity?");
      int rarity = Integer.parseInt(scan.nextLine());
      System.out.println("Damage?");
      double damage = Double.parseDouble(scan.nextLine());
      System.out.println("Type?");
      int type = Integer.parseInt(scan.nextLine());
      System.out.println("Article?");
      String demo = scan.nextLine();
      return "ẅ" + name + " " + damage + " " + type + " " + rarity + " " + value + " " + demo;

    
  }

  private static String writeEnemyWeapon(){
    System.out.println("Name?");
    String name = scan.nextLine();
    name = name.replaceAll(" ", "_");
    System.out.println("Damage?");
    double damage = Double.parseDouble(scan.nextLine());
    System.out.println("Type?");
    int type = Integer.parseInt(scan.nextLine());
    System.out.println("Chance?");
    double chance = Double.parseDouble(scan.nextLine());
    return "ẅ" + name + " " + damage + " " + type + " " + chance;
  }

  private static String writePotion(){

      System.out.println("Name?");
      String name = scan.nextLine();
      System.out.println("Value?");
      int value = Integer.parseInt(scan.nextLine());
      System.out.println("Rarity?");
      int rarity = Integer.parseInt(scan.nextLine());
      System.out.println("Health Effect?");
      double healthE = Double.parseDouble(scan.nextLine());
      System.out.println("Strength Effect?");
      double strE = Double.parseDouble(scan.nextLine());
      System.out.println("Mana Effect?");
      double manaE = Double.parseDouble(scan.nextLine());
      return "Ṗ" + name.replaceAll(" ", "_") + " " + value + " " + rarity + " " + healthE + " " + strE + " " + manaE ;

  }

  private static String writeBook(){
      System.out.println("Name?");
      String name = scan.nextLine();
      name = name.replaceAll(" ", "_");
      System.out.println("Value?");
      int value = Integer.parseInt(scan.nextLine());
      System.out.println("Rarity?");
      int rarity = Integer.parseInt(scan.nextLine());
      System.out.println("Health Effect?");
      double healthE = Double.parseDouble(scan.nextLine());
      System.out.println("Strength Effect?");
      double strE = Double.parseDouble(scan.nextLine());
      System.out.println("Mana Effect?");
      double manaE = Double.parseDouble(scan.nextLine());
      System.out.println("Body?");
      String body = scan.nextLine();
      body = body.replaceAll(" ", "_");
      return "ḃ" + name +" " + value + " " + rarity + " " + healthE + " " + strE + " " + manaE +" " +body ;

  }
}
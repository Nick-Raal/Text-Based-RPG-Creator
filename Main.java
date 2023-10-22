import java.io.*;
import java.util.Scanner;

class Main {
  
  static Scanner scan = new Scanner(System.in);
  static File f;
  
  public static void main(String[] args) {
    System.out.println("File Name?");
    f = new File(scan.nextLine());
    f.createNewFile();

    String s = "";
    while(s != exit){
      System.out.println("Do you want to create an enemy or an item?");
      s = scan.nextLine();
      if(s.toLowerCase.equals("item")){
        writeItem();
      }else if(s.toLowerCase.equals("enemy")){
        
      }
    }
  }

  private static void writeEnemy(){
    try{
      
    }
  }
  private static void writeItem(){
      System.out.println("What are you trying to create?");
      String s = scan.nextLine();
      if(s.toLowerCase().equals("potion")){
        writePotion();
      }else if(s.toLowerCase().equals("weapon")){
        writeWeapon();
      }else if (s.toLowerCase().equals("armor")){
        writeArmor();
      }else if(s.toLowerCase().equals("book")){
        writeBook();
      }
  }

  private static void writeArmor(){
    try{
      FileWriter fw = new FileWriter(f);
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
      System.out.println("Slot?");
      int slot = Integer.parseInt(scan.nextLine());
      fw.write("ä"+name + " " + armor + " " + type + " " + slot + " " + value + " " + rarity);
      fw.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }

  private static void writeWeapon(){
    try{
      FileWriter fw = new FileWriter(f);
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
      fw.write("ẅ" + name + " " + damage + " " + type + " " rarity + " " value + " " + demo + "\n");
      fw.close();
    }catch(Exception e){
      System.out.println(e);
    }
    
  }

  private static void writePotion(){
    try{
      FileWriter fw = new FileWriter(f);
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
      fw.write("Ṗ" + name.replaceAll(" ", "_") + " " + value + " " + rarity + " " + healthE + " " + strE + " " + manaE + "\n");
      fw.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }

  private static void writeBook(){
    try{
      FileWriter fw = new FileWriter(f);
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
      fw.write("ḃ" + name +" " + value + " " + rarity + " " + healthE + " " + strE + " " + manaE +" " +body + "\n");
      fw.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
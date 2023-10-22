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
      if(s.toLowerCase().equals("item")){
        writeItem();
        try{
          FileWriter fw = new FileWriter(f);
          fw.write("\n");
          fw.close();
        }catch(Exception e){
          System.out.println(e);
        }
      }else if(s.toLowerCase().equals("enemy")){
        writeEnemy();
        try{
          FileWriter fw = new FileWriter(f);
          fw.write("\n");
          fw.close();
        }catch(Exception e){
          System.out.println(e);
        }
      }
    }
  }

  private static void writeEnemy(){
    try{
      FileWriter fw = new FileWriter(f);
      System.out.println("Name?");
      String name = scan.nextLine();
      System.out.println("Health?");
      double health = Double.parseDouble(scan.nextLine());
      System.out.println("Initiative?");
      double init = Double.parseDouble(scan.nextLine());
      System.out.println("Attack Modifier?");
      double atkMod = Double.parseDouble(scan.nextLine());
      fw.write(name + " " + health + " " + init + " " + atkMod + " ");
      String next = "";
      while(true){
        System.out.println("weapons: (type exit to exit)");
        next = scan.nextLine();
        if(next.toLowerCase().equals("exit")){
          break;
        }
        fw.write(" ");
        writeWeapon();
      }
      for(int i = 0; i < 4; i++){
        System.out.println("Armor #" + i);
        fw.write(" ");
        writeArmor();
      }
      System.out.println("Gold?");
      double gold = Double.parseDouble(scan.nextLine());
      System.out.println("Exp?");
      double exp = Double.parseDouble(scan.nextLine());
      fw.write(gold + " " + exp);
      System.out.println("item drops? (Y/N)");
      next = scan.nextLine();
      if(next.toUpperCase().equals("N")){
        return;
      }
      next = "";
      int n = 0;
      while(!next.equals("exit")){
        System.out.println("EXIT?");
        next = scan.nextLine();
        fw.write(" ");
        writeItem();
        n++;
      }
      System.out.println("drop chances:");
      for(int i = 0; i < n; i++){
        System.out.println("drop chances for item #" + (i+1));
        fw.write(" " + Double.parseDouble(scan.nextLine()));
      }
      fw.close();
    }catch(Exception e){
      System.out.println(e);
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
      fw.write("ẅ" + name + " " + damage + " " + type + " " + rarity + " " + value + " " + demo);
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
      fw.write("Ṗ" + name.replaceAll(" ", "_") + " " + value + " " + rarity + " " + healthE + " " + strE + " " + manaE );
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
      fw.write("ḃ" + name +" " + value + " " + rarity + " " + healthE + " " + strE + " " + manaE +" " +body );
      fw.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }
}